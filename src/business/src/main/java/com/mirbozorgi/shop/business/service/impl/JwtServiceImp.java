package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.exception.AccessDeniedException;
import com.mirbozorgi.shop.business.service.JwtService;
import com.mirbozorgi.shop.core.entity.UserSecurity;
import com.mirbozorgi.shop.core.enums.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImp implements JwtService {

  private Clock clock = DefaultClock.INSTANCE;
  @Autowired
  private Environment env;

  @Value("${jwt.server.secret}")
  private String secret;


  @Override
  public String createToken(
      String email,
      Role role) {

    Date createdDate = clock.now();
    Date expirationDate = calculateExpirationDate(createdDate,
        Integer.parseInt(env.getProperty("jwt.expiration")));
    return doGenerateToken(
        email,
        createdDate,
        expirationDate,
        secret,
        new JwtWrapper(
            new UserSecurity(email, role)).getMap()
    );


  }

  @Override
  public List<Object> parseToken(String token, String secretPass) {
    List<Object> objects = new ArrayList<>();
    if (!this.validateToken(token, secretPass)) {
      throw new AccessDeniedException();
    }
    Claims body = Jwts.parser()
        .setSigningKey(secretPass)
        .parseClaimsJws(token.replace(env.getProperty("token.prefix"), ""))
        .getBody();
    Object role = body.get("role");
    Object email = body.get("email");
    objects.add(role);
    objects.add(email);
    return objects;
  }

  @Override
  public boolean validateToken(String token, String secret) {
    Claims claims = null;
    try {
      claims = Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(token.replace(env.getProperty("token.prefix"), ""))
          .getBody();
    } catch (Exception e) {
      throw new AccessDeniedException();
    }
    return claims != null;
  }


  ////////private method ///////////////
  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }


  private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Date calculateExpirationDate(Date createdDate, int expiration) {
    return new Date(createdDate.getTime() + expiration * 1000);
  }

  private String doGenerateToken(
      String subject,
      Date createdDate,
      Date expirationDate,
      String secret,
      Map<String, Object> map) {
    JwtBuilder builder = Jwts.builder();
    if (subject != null) {
      builder.setSubject(subject);
    }
    if (createdDate != null) {
      builder.setIssuedAt(createdDate);
    }
    if (expirationDate != null) {
      builder.setExpiration(expirationDate);
    }
    if (map != null) {
      builder.setClaims(map);
    }
    return builder.setExpiration(expirationDate).setClaims(map)
        .signWith(SignatureAlgorithm.HS512, secret).compact();
  }


}

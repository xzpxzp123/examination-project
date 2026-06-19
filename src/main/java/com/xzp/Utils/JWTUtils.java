package com.xzp.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JWTUtils {
    //    有效期为
    public static final long JWT_TTL=60*60*1000L;
    //    设置秘钥明文
    public static final String JWT_KEY="sangeng";
    public static String createJWT(String id,String subject,Long ttlMillis){
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        long nowMillis=System.currentTimeMillis();
        Date now=new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis=JWT_TTL;
        }
        long expMillis=nowMillis+ttlMillis;
        Date expdate=new Date(expMillis);
        SecretKey secretKey=generalKey();
        JwtBuilder builder= Jwts.builder()
                .setId(id)  //唯一的ID
                .setSubject(subject) //主题 可以是JSON数据
                .setIssuer("sg") //签发者
                .signWith(signatureAlgorithm,secretKey) //使用HS256对称加密算法签名,第二个参数为秘钥
                .setExpiration(expdate); //设置过期时间
        return builder.compact();
    }
    public static SecretKey generalKey(){
        byte [] encodeKey= Base64.getDecoder().decode(JWT_KEY);
        SecretKey key=new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        return key;
    }
    public static Claims parseJWT(String jwt)throws Exception{
        SecretKey secretKey=generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}

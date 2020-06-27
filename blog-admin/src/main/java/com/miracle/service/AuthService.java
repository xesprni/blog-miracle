package com.miracle.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Miracle
 * @date 17:50 2020/6/27
 */
@Service
public class AuthService {

    private final Algorithm ALG = Algorithm.HMAC256("secret");

    private final JWTVerifier verifier = JWT.require(ALG).withIssuer("miracle").build();


    public String signToken() {
        try {
            String token = JWT.create()
                    .withIssuer("miracle")
                    .withIssuedAt(new Date(System.currentTimeMillis()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))
                    .sign(ALG);
            return token;
        } catch (Exception e) {
            return null;
        }
    }


    public Boolean verifyToken(String token) {
        try {
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

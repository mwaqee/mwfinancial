package com.mwaqee.accountservice.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class TokenUtil {

    private TokenUtil() {

    }

    public static String getTokenEmail(String token) {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jwt.getClaim("email");

    }

    public static String getTokenEmail() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jwt.getClaim("email");

    }

    public static String getUserIdFromToken() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jwt.getClaim("userId");

    }

    public static String getSignedUser(String token) {
        String arr[] = token.split("\\.");
        return arr[1];
    }
}

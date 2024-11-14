package com.example.tms.dto.exception.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

@WebFilter("/api/*")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String secretKey = "12341234123412341234";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String token = request.getParameter("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            try {
                // Создаем SecretKey
                SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String username = claims.getSubject();

                if (username != null) {
                    SecurityContextHolder.getContext().setAuthentication(new JwtAuthentication(username));
                }
            } catch (Exception e) {
                System.out.println("Invalid token: " + e.getMessage());
            }
        }

        chain.doFilter(request, response);
    }
}

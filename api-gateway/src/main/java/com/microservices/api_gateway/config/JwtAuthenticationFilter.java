package com.microservices.api_gateway.config;

import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter implements GlobalFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
        String path = exchange.getRequest().getPath().toString();

        System.out.println("🔍 Verificando solicitud a: " + path);

        // Permitir rutas públicas sin validación de token
        if (path.startsWith("/post/get") || path.startsWith("/comment/post") ||
                path.startsWith("/auth/signup") || path.startsWith("/auth/login")) {
            System.out.println("✅ Ruta pública, permitiendo acceso.");
            return chain.filter(exchange);
        }

        System.out.println("🔒 Ruta protegida, verificando token...");

        // Si no hay token o está mal formado, denegar acceso
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("❌ Token no proporcionado o inválido.");
            return unauthorizedResponse(exchange, "Token no proporcionado o inválido.");
        }

        String token = authHeader.substring(7);

        try {
            if (!jwtUtil.validateToken(token)) {
                System.out.println("❌ Token inválido o expirado.");
                return unauthorizedResponse(exchange, "Token inválido o expirado.");
            }

            Claims claims = jwtUtil.extractAllClaims(token);
            String username = claims.getSubject();
            List<String> roles = jwtUtil.extractRoles(token);

            System.out.println("✅ Token válido. Usuario: " + username + ", Roles: " + roles);

            List<SimpleGrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContext securityContext = new SecurityContextImpl(authentication);

            return chain.filter(exchange)
                    .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(securityContext)));

        } catch (Exception e) {
            System.out.println("❌ Error al validar el token: " + e.getMessage());
            return unauthorizedResponse(exchange, "Token inválido o expirado.");
        }
    }

    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange, String message) {
        System.out.println("⛔ Enviando respuesta 401: " + message);
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"error\": \"" + message + "\"}";
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }
}


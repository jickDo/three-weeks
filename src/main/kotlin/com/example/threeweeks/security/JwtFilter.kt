package com.example.threeweeks.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter(private val jwtUtils: JwtUtils) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        // 헤더에 Authorization이 있다면 가져온다.
        val authorizationHeader: String? = request.getHeader("Authorization") ?: return filterChain.doFilter(request, response)
        // Bearer타입 토큰이 있을 때 가져온다.
        val token = authorizationHeader?.substring("Bearer ".length) ?: return filterChain.doFilter(request, response)

        // 토큰 검증
        if (jwtUtils.validation(token)) {
            // 토큰에서 username 파싱
            val username = jwtUtils.parseUsername(token)
            // username으로 AuthenticationToken 생성
            val authentication: Authentication = jwtUtils.getAuthentication(username)
            // 생성된 AuthenticationToken을 SecurityContext가 관리하도록 설정
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}
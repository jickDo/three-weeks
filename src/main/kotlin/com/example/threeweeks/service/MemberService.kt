package com.example.threeweeks.service

import com.example.threeweeks.dto.MemberDto
import com.example.threeweeks.entity.Member
import com.example.threeweeks.repository.MemberRepository
import com.example.threeweeks.security.JwtUtils
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val jwtUtils: JwtUtils,
    private val authenticationManager: AuthenticationManager
)
{
    fun register(memberDto: MemberDto):Member{
        return memberRepository.save(memberDto.toMember())
    }

    fun findByUserId(userid: String):Member?{
        return this.memberRepository.findByUserid(userid)
    }

    @Transactional(readOnly = true)
    fun signin(memberDto: MemberDto): String {
        try {
            // 인증시도
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(memberDto.userid, memberDto.password, null)
            )
        } catch (e: BadCredentialsException) {
            throw BadCredentialsException("로그인 실패")
        }
        // 예외가 발생하지 않았다면 인증에 성공한 것.
        // 토큰 생성
        val token = jwtUtils.createToken(memberDto.userid)

        return token
    }

}
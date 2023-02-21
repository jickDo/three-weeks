package com.example.threeweeks.service

import com.example.threeweeks.entity.Member
import com.example.threeweeks.repository.MemberRepository
import com.example.threeweeks.security.UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val memberRepository: MemberRepository) : UserDetailsService {

    override fun loadUserByUsername( userid: String): UserDetails {
        val member: Member = memberRepository.findByUserid(userid) ?: throw UsernameNotFoundException("존재하지 않는 username 입니다.")

        return UserDetailsImpl(member)
    }
}
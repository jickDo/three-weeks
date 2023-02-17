package com.example.threeweeks.service

import com.example.threeweeks.dto.MemberDto
import com.example.threeweeks.entity.Member
import com.example.threeweeks.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
)
{
    fun register(memberDto: MemberDto):Member{
        return memberRepository.save(memberDto.toMember())
    }

    fun findByUserId(userid: String):Member?{
        return this.memberRepository.findByUserid(userid)
    }

}
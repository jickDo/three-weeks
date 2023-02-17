package com.example.threeweeks.dto

import com.example.threeweeks.entity.Member

data class MemberDto(
    var name:String,
    var userid:String,
    var password:String,
){
    fun toMember():Member{
        return Member(
            name,
        ).also {
            it.userid = userid
            it.password = password
        }
    }

    companion object {
        fun toMemberDto(member: Member): MemberDto {
            return MemberDto(
                member.name,
                member.userid,
                member.password,
            )
        }

    }
}

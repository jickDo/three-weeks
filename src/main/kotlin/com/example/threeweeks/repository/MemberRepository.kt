package com.example.threeweeks.repository

import com.example.threeweeks.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository:JpaRepository<Member,String> {
    fun findByUserid(userid:String):Member?
}
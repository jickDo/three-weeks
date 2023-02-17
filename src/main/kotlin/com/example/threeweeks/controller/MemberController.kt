package com.example.threeweeks.controller

import com.example.threeweeks.dto.LoginDto
import com.example.threeweeks.dto.MemberDto
import com.example.threeweeks.dto.Message
import com.example.threeweeks.entity.Member
import com.example.threeweeks.service.MemberService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*


@RestController
@RequestMapping("/api")

class MemberController(private val memberService: MemberService) {
    @PostMapping("/register")
    fun register(@RequestBody memberDto: MemberDto): ResponseEntity<Member>{

//        val user=MemberDto(memberDto.name,memberDto.userid,memberDto.password)//설명시급

        return ResponseEntity.ok(this.memberService.register(memberDto))
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<Any>{
        val member= this.memberService.findByUserId(loginDto.userid) ?: return ResponseEntity.badRequest().body(Message("user not found!"))


        if(!member.comparePassword(loginDto.password)){
            return ResponseEntity.badRequest().body(Message("invalid password!"))
        }

        val secretKey = "codingistooharduihhuihuihuihiuhuihuihuihuihuihuihuihuibjbhgyugg"
        val issuer=member.userid
        val key: Key = Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))
        val jwt= Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis()+60 * 24 * 1000)) //1 day
            .signWith(key, SignatureAlgorithm.HS256).compact()
        return ResponseEntity.ok(jwt)
    }
}
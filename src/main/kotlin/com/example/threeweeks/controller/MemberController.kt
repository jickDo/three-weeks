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
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
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
    fun register(@RequestBody memberDto: MemberDto): ResponseEntity<Member> {


        return ResponseEntity.ok(this.memberService.register(memberDto))
    }

    @PostMapping("/login")
    fun login(@RequestBody memberDto: MemberDto):ResponseEntity<String>{
        return ResponseEntity.ok(this.memberService.signin(memberDto))

    }
    @GetMapping("/test")
    fun test(@ModelAttribute("userId") userId:String): String {
        return userId
    }
}
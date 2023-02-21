package com.example.threeweeks

import com.example.threeweeks.security.JwtUtils
import io.jsonwebtoken.Jwts
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ThreeWeeksApplicationTests {

    @Autowired
    lateinit var jwtUtils:JwtUtils
    @Test
    fun test() {
        val accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFoIiwiZXhwIjoxNjc3MjMzNzkzfQ.niORKrccGt8FLKvcuAVeClWMB0gBV_5HTVS-KKPfxrc"
        println(jwtUtils.test(accessToken))
    }

}

package com.example.threeweeks.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
class Member(
    @Column
    val name:String,
)

{
    @Id
    var userid:String=""

    @Column
    var password=""
        get()=field
        set(value){
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password:String):Boolean{
        return BCryptPasswordEncoder().matches(password,this.password)
    }
}
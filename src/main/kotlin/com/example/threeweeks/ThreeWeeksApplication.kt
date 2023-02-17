package com.example.threeweeks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class]) //security설정
class ThreeWeeksApplication

fun main(args: Array<String>) {
    runApplication<ThreeWeeksApplication>(*args)
}

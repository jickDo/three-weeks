package com.example.threeweeks.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
class Board(

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=0L
}
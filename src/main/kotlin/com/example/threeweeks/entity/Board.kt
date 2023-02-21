package com.example.threeweeks.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
class Board(

    var headline:String,
    var content:String,
    @ManyToOne
    @JoinColumn(name = "userid")
    var member: Member


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0L
}
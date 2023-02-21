package com.example.threeweeks.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Comment(
    val nickname:String,
    var title:String,
    @ManyToOne
    @JoinColumn(name="board_id")
    var board: Board,

    @ManyToOne
    @JoinColumn(name="member_id")
    var member: Member


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0L

}
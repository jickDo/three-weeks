package com.example.threeweeks.repository

import com.example.threeweeks.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository:JpaRepository<Board,Long> {
    fun findByContent(content:String):Board
}
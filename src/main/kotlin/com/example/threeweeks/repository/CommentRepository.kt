package com.example.threeweeks.repository

import com.example.threeweeks.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository:JpaRepository<Comment,Long> {
}
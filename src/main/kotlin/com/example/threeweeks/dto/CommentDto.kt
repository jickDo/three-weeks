package com.example.threeweeks.dto

import com.example.threeweeks.entity.Board
import com.example.threeweeks.entity.Comment
import com.example.threeweeks.entity.Member

data class CommentDto(
    val nickname:String,
    val title:String,
){
    companion object{
        fun toBoardDto(comment: Comment):CommentDto{
            return CommentDto(
                comment.nickname,
                comment.title,
            )
        }
        fun toBoard(commentDto: CommentDto, board: Board,member: Member): Comment { //
            return Comment(
                commentDto.nickname,
                commentDto.title,
                board,
                member
            )
        }

}}

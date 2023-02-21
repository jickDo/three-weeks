package com.example.threeweeks.dto

import com.example.threeweeks.entity.Board
import com.example.threeweeks.entity.Member

data class BoardDto(
    val headline:String,
    val content:String,
    val userId: String?,
    val id:Long,
)
{
    companion object{
        fun toBoardDto(board: Board):BoardDto{
            return BoardDto(
                board.headline,
                board.content,
                board.member.userid,
                board.id,
            )
        }
        fun toBoard(boardDto: BoardDto,member: Member):Board{ //
            return Board(
                boardDto.headline,
                boardDto.content,
                member
            )
        }
    }
    }

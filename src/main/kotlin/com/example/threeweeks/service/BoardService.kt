package com.example.threeweeks.service

import com.example.threeweeks.dto.BoardDto
import com.example.threeweeks.dto.BorderUpdateDto
import com.example.threeweeks.entity.Board
import com.example.threeweeks.repository.BoardRepository
import com.example.threeweeks.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import java.lang.Exception

@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository

) {
    fun write(boardDto: BoardDto, userId: String):Board{
        return boardRepository.save(BoardDto.toBoard(boardDto,memberRepository.findByUserid(userId)?:throw Exception())) //email이랑 userid매핑
    }

    fun find(id:Long):Board{
        return boardRepository.findById(id).get()
    }

    fun modification(id: Long, userId:String ,boardUpdateDto: BorderUpdateDto):Board{
        val board = boardRepository.findById(id).get()
        if(userId == board.member.userid){
            board.headline = boardUpdateDto.headline
            board.content = boardUpdateDto.content
        }else{
            throw Exception()
        }
        return boardRepository.save(board)
   }

    fun delete(id: Long,userId: String):Unit{
        val board=boardRepository.findById(id).get()
        if(userId==board.member.userid){
            boardRepository.delete(boardRepository.findById(id).get())
        }
        else{
            throw Exception()
        }
    }
}


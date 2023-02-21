package com.example.threeweeks.service

import com.example.threeweeks.dto.CommentDto
import com.example.threeweeks.dto.UpdateCommentDto
import com.example.threeweeks.entity.Comment
import com.example.threeweeks.exception.BaseException
import com.example.threeweeks.exception.BaseResponseCode
import com.example.threeweeks.repository.BoardRepository
import com.example.threeweeks.repository.CommentRepository
import com.example.threeweeks.repository.MemberRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CommentService(
    private val memberRepository: MemberRepository,
    private val boardRepository: BoardRepository,
    private val commentRepository: CommentRepository
) {
    fun recomment(commentDto: CommentDto,id:Long,id2:String): Comment {
        return commentRepository.save(CommentDto.toBoard(commentDto,boardRepository.findById(id).get(),memberRepository.findByUserid(id2)))
    }
    fun searching(id:Long):Comment{
        return commentRepository.findById(id).get()
    }

    fun edition(userId:String,id:Long,updateCommentDto: UpdateCommentDto):Comment?{
        val comment= commentRepository.findById(id).get()
        if(userId == comment.member.userid){
            comment.title= updateCommentDto.title2
        }
        else{
            throw BaseException(BaseResponseCode.USER_NOT_FOUND)
        }
        return commentRepository.save(comment)
    }

    fun eraser(id:Long,userId: String):Unit{
        val comment=commentRepository.findById(id).get()
        if(userId==comment.member.userid){
            commentRepository.delete(comment)
        }
        else{
            throw Exception()
        }
    }
}


package com.example.threeweeks.controller

import com.example.threeweeks.dto.CommentDto
import com.example.threeweeks.dto.UpdateCommentDto
import com.example.threeweeks.entity.Board
import com.example.threeweeks.entity.Comment
import com.example.threeweeks.security.GetIdFromJwt
import com.example.threeweeks.service.BoardService
import com.example.threeweeks.service.CommentService
import com.example.threeweeks.service.MemberService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/comment")
class CommentController(
    private val memberService: MemberService,
    private val boardService: BoardService,
    private val commentService: CommentService
) {
    @PostMapping(path=["/{id}"])
    fun recomment(@RequestBody commentDto: CommentDto,@PathVariable("id") id:Long,@RequestParam id2:String): Comment?{
        return commentService.recomment(commentDto,id,id2)
    }

    @GetMapping(path=["/{id}"])
    fun searching(@PathVariable("id") id: Long):Comment?{
        return commentService.searching(id)
    }

    @PostMapping(path = ["/edition/{id}"])
    fun edition(@GetIdFromJwt userId:String,@PathVariable("id") id:Long, @RequestBody updateCommentDto: UpdateCommentDto):Comment?{
        return commentService.edition(userId,id,updateCommentDto)
    }

    @DeleteMapping(path=["{id}"])
    fun eraser(@PathVariable("id") id:Long,@GetIdFromJwt userId: String):Unit{
        commentService.eraser(id,userId)
    }


}
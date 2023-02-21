package com.example.threeweeks.controller

import com.example.threeweeks.dto.BoardDto
import com.example.threeweeks.dto.BorderUpdateDto
import com.example.threeweeks.dto.Message
import com.example.threeweeks.entity.Board
import com.example.threeweeks.security.GetIdFromJwt
import com.example.threeweeks.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/board")
class BoardController(private val boardService: BoardService)
{
    @PostMapping("")
    fun write(@RequestBody boardDto: BoardDto, @GetIdFromJwt userId:String): Board?{

        return boardService.write(boardDto, userId)
    }

    @GetMapping(path=["/{id}"])
    fun find(@PathVariable("id") id:Long):Board?{
        return boardService.find(id)
    }
    @PostMapping(path=["/{id}"])
    fun modification(@PathVariable("id") id: Long,@GetIdFromJwt userId:String,@RequestBody boardUpdateDto: BorderUpdateDto):ResponseEntity<Any>?{
     return ResponseEntity.ok(boardService.modification(id, userId, boardUpdateDto))
    }

    @DeleteMapping(path=["/{id}"])
    fun delete(@PathVariable("id") id:Long,@GetIdFromJwt userId:String):Unit{
        boardService.delete(id,userId)
    }

}
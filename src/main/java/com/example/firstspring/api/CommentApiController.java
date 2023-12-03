package com.example.firstspring.api;

import com.example.firstspring.dto.CommentDto;
import com.example.firstspring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    // 댓글 목록 조회
    @GetMapping("/api/articles/4/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId){
        // 서비스에게 위임해서 결과를 가져오고
        List<CommentDto> dtos = commentService.comments(articleId);

        // 가져온 결과에 응답한다.
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 댓글 생성

    // 댓글 수정

    // 댓글 삭제
}

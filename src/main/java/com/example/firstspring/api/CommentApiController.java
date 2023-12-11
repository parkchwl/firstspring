package com.example.firstspring.api;

import com.example.firstspring.dto.CommentDto;
import com.example.firstspring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    // 댓글 목록 조회
    @GetMapping("/api/articles/4/comments")
    public ResponseEntity<List> comments(@PathVariable Long articleId){
        // 서비스에게 위임해서 결과를 가져오고
        List<CommentDto> dtos = commentService.comments(articleId);

        // 가져온 결과에 응답한다.
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 댓글
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) throws IllegalAccessException {
        // 서비스에게 위임
        CommentDto createdDto= commentService.create(articleId, dto);
        // 결과 응답

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 댓글 수정
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto) {

        CommentDto updatedDto = commentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
    // 댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {

        CommentDto updatedDto = commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
}

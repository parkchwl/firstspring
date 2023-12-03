package com.example.firstspring.service;

import com.example.firstspring.controller.repository.ArticleRepository;
import com.example.firstspring.controller.repository.CommentRepository;
import com.example.firstspring.dto.CommentDto;
import com.example.firstspring.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDto> comments(Long articleId) {
        // 조회 : 댓글 목록
        List<Comment>comments = commentRepository.findByArticleId(articleId);

        // 변환 : Entity -> Dto

        // 반환
        return null;
    }
}

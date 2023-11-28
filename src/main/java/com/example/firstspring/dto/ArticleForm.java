package com.example.firstspring.dto;

import com.example.firstspring.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
@AllArgsConstructor
@ToString

public class ArticleForm {
    private Long id; // id 필드 추가
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}

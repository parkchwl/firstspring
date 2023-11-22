package com.example.firstspring.controller;

import com.example.firstspring.controller.repository.ArticleRepository;
import com.example.firstspring.dto.ArticleForm;
import com.example.firstspring.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired// 스프링부트가 미리 생성해놓은 객체를 가져다가 자동 연결해준다.
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());

        // 1. Dto를 Entity로 변환.
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2, Repository에 Entity를 Db안에 저장한다.
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return"";
    }
}

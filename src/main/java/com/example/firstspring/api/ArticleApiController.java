package com.example.firstspring.api;

import com.example.firstspring.controller.repository.ArticleRepository;
import com.example.firstspring.dto.ArticleForm;
import com.example.firstspring.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired // Dependency Injection
    private ArticleRepository articleRepository;

    // GET
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto){ //Resquset Body부분을 ArticleForm dto 로 오게 하는 Annotation
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }
    // PATCH

    //DELETE

}

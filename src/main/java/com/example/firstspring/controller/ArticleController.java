package com.example.firstspring.controller;

import com.example.firstspring.controller.repository.ArticleRepository;
import com.example.firstspring.dto.ArticleForm;
import com.example.firstspring.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {
    @Autowired// 스프링부트가 미리 생성해놓은 객체를 가져다가 자동 연결해준다.
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        //System.out.println(form.toString()); -> 로깅 기능을 사용해야 한다.

        // 1. Dto를 Entity로 변환.
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        // 2, Repository에 Entity를 Db안에 저장한다.
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return"";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id + = "+ id);

        // 1 : id를 데이터로 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2 : 가져온 데이터를 모델에 등록한다.
        model.addAttribute("article", articleEntity);

        // 3 : 보여줄 페이지를 설정 / 반환한다.
        return "articles/show"; // View 페이지에서 쓸 수 있다.
    }
}

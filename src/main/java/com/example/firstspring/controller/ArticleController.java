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

import java.util.List;
import java.util.Optional;

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

        return"redirect:/articles/" + saved.getId(); // redirect를 정의한다.
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
    @GetMapping("/articles")
    public String index(Model model) {
        // 1 : 모든 Article을 가져온다.
        List<Article> articleEntityList= articleRepository.findAll();

        // 2 : 가져온 Article 묶음을 뷰로 전달한다.
        model.addAttribute("articleList",articleEntityList);

        // 3 : 뷰 페이지를 설정한다.
        return "articles/index"; // articles/index.mustache
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){ //URL에 있는 Path경로를 통해서 가져온다 & 파라미터 설정
        //수정할 데이터를 가져오기 [DB에 있는 데이터를 가져온다.]
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //모델에 데이터를 등록 !
        model.addAttribute("article", articleEntity);

        // 뷰 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());

        // 1 : DTO를 Entity로 변환한다
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2 : Entity를 DB로 저장한다
        // 2-1 : DB에서 기존 데이터를 가져온다.
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2-2 : 기존 데이터가 있다면, 값을 갱신한다.
        if(target != null){
            articleRepository.save(articleEntity);// 엔티티가 DB로 갱신된다.
        }
        // 3 : 수정 결과 페이지를 리다이렉트 한다.
        return "redirect:/articles/" + articleEntity.getId();
    }
}

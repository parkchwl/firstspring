package com.example.firstspring.service;

import com.example.firstspring.controller.repository.ArticleRepository;
import com.example.firstspring.dto.ArticleForm;
import com.example.firstspring.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service // 해당 클래스를 서비스로 인식하여 스프링부트에 객체를 생성(등록)한다.
public class ArticleService {
    @Autowired // Dependency Injection
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        Article target = articleRepository.findById(id).orElse(null);

        if(target==null || id != article.getId()){
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null;
        }

        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        // 대상 창기
        Article target = articleRepository.findById(id).orElse(null);
        // 잘못된 요청 처리
        if (target == null){
            return null;
        }
        // 대상 삭제
        articleRepository.delete(target);
        return target;
    }
@Transactional // 해당 메소드를 트랜젝션으로 묶는다 ! -> 실패한다면 롤백
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // dto 묶음을 entity 묶음으로 변환한다.
        List<Article> articleList = dtos.stream().map
                (dto -> dto.toEntity()).collect(Collectors.toList());

        // Entity 묶음을 DB로 저장한다.
        articleList.stream().forEach(article -> articleRepository.save(article));

        // 저장된 상태에서 강제 예외 발생시켜보기
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결재 실패 !")
        );

        // 결과값 반환
        return articleList;

    }
}

package com.example.firstspring.service;

import com.example.firstspring.dto.ArticleForm;
import com.example.firstspring.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // 해당 클래스는 스프링 부트와 연동되어 테스팅된다.
class ArticleServiceTest {
    @Autowired ArticleService articleService;

    @Test
    void index() {

        //예상
        Article a = new Article(1L, "임시데이터1", "1111");
        Article b = new Article(2L, "임시데이터2", "2222");
        Article c = new Article(3L, "임시데이터3", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        //실제
        List<Article> articles = articleService.index();

        //비교
        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    void show_success() {
        //예상
        Long id  = 1L;
        Article expected = new Article(id, "임시데이터1", "1111");
        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_intendFail() {//예상
        Long id  = -1L;
        Article expected = null;
        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected, article); // null은 toString 불가능

    }

    @Test
    @Transactional
    void create_success() { // title과 content만 있는 dto 입력
        String title = "임시데이터4";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        //실제
        Article article = articleService.create(dto);
        //비교
        assertEquals(expected.toString(), article.toString()); // null은 toString 불가능

    }

    @Test
    @Transactional
    void create_intendFail() { // title과 content만 있는 dto 입력
        String title = "임시데이터4";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;
        //실제
        Article article = articleService.create(dto);
        //비교
        assertEquals(expected, article); // null은 toString 불가능

    }
}
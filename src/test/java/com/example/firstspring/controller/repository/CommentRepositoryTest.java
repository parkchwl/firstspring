package com.example.firstspring.controller.repository;

import com.example.firstspring.entity.Article;
import com.example.firstspring.entity.Comment;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest // JPA와 연동한 테스트
class CommentRepositoryTest {
    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        // Case 1 : 4번 게시글의 모든 댓글 조회
        // 입력 데이터 준비
        {Long articleId = 4L;

        // 실제 수행
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        // 예상하기
        Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 1"), "Park", "Inception");
        Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 2"), "Park", "Chicken");
        Comment c = new Comment(7L, new Article(6L, "당신의 취미는?", "댓글 3"), "Park", "Climbing");
        List <Comment> expected = Arrays.asList(a,b,c);


        // 검증
        assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력한다");
    }
    // Case 2 : 1번 게시글의 모든 댓글 조회
        {
            // 입력데이터 준비
            Long articleId = 1L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상하기
            Article article = new Article(1L, "임시데이터 1", "1111");
            List<Comment> expected = Arrays.asList();

            //검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없다.");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글을 조회")
    void findByNickname() {
        //Case 1 : Park의 모든 댓글을 조회한다.
        {
            // 입력 데이터를 준비
            String nickname = "Park";

            // 실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상하기
            Article article = new Article(1L, "당신의 인생 영화는?", "댓글1");
            Comment a = new Comment(1L, article, "Park", "Inception");
            Comment b = new Comment(2L, article, "Kim", "Interstellar");
            Comment c = new Comment(3L, article, "Choi", "TENET");
            List <Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력하기 !");

        }
    }
}
package com.example.firstspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne // 해당 댓글 엔티티 여러개가 -> 하나의 Article에 연관된다.
    @JoinColumn(name = "article_id") //테이블에서 연결된 대상을 가져야함 -> 대상 정보의 column을 article_id 로 설정함.
    private Article article;


    @Column
    private String nickname;

    @Column
    private String body;
}

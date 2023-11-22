package com.example.firstspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // @Entity를 해야 DB가 해당 객체를 인식 가능하다
public class Article {
    @Id // 대표값을 지정
    @GeneratedValue // 1, 2, 3, ... 자동 어노테이션
    private Long id; //대표값

    @Column //DB에서 이해할 수 있게 @Conlumn 어노테이션
    private String title;
    @Column //DB에서 이해할 수 있게 @Conlumn 어노테이션
    private String content;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article () {

    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

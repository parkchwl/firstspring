package com.example.firstspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // @Entity를 해야 DB가 해당 객체를 인식 가능하다
@AllArgsConstructor //id, title, content를 파라미터로 하는 생성자를 만들어준다.
@NoArgsConstructor // 디폴트 생성자 추가를 위한 어노테이션
@ToString
@Getter // 모든 게터를 추가.
public class Article {
    @Id // 대표값을 지정
    @GeneratedValue // 1, 2, 3, ... 자동 어노테이션
    private Long id; //대표값

    @Column //DB에서 이해할 수 있게 @Conlumn 어노테이션
    private String title;
    @Column //DB에서 이해할 수 있게 @Conlumn 어노테이션
    private String content;


}

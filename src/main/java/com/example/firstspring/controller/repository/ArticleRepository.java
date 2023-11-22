package com.example.firstspring.controller.repository;

import com.example.firstspring.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}

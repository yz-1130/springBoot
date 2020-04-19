package com.xinyan.repository;

import com.xinyan.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRespository extends JpaRepository<Article,String> {
}

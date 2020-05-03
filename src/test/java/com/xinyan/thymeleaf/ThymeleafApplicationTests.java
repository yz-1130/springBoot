package com.xinyan.thymeleaf;

import com.xinyan.pojo.Article;
import com.xinyan.repository.ArticleRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class ThymeleafApplicationTests {
    @Autowired
    private ArticleRespository articleRespository;
    @Test
    void contextLoads() {

        List<Article> created = articleRespository.findAll(Sort.by(Sort.Direction.DESC, "created"));
    }

}

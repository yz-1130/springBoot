package com.xinyan.service;

import com.xinyan.pojo.Article;
import org.springframework.data.domain.Page;

public interface ArticleService {


    Page<Article> getUserList(int pageNum, int pageSize);

}

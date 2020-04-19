package com.xinyan.serviceImpl;

import com.xinyan.pojo.Article;
import com.xinyan.repository.ArticleRespository;
import com.xinyan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author xinyan.xie
 * @description
 * @date 2020/4/19
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRespository articleRespository;
    @Override
    public Page<Article> getUserList(int pageNum, int pageSize) {
        Sort.Order order=new Sort.Order(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(order));
        Page<Article> articles = articleRespository.findAll(pageable);

        return articles;    }
}

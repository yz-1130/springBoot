package com.xinyan.controller;

import com.xinyan.pojo.Article;
import com.xinyan.repository.ArticleRespository;
import com.xinyan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Iterator;

/**
 * @author xinyan.xie
 * @description
 * @date 2020/4/19
 */
@Controller
public class LoginController {

    @Autowired
    private ArticleRespository articleRespository;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){

        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize){

        System.out.println("============================");
        Page<Article> articles=articleService.getUserList(pageNum, pageSize);
        System.out.println("总页数" + articles.getTotalPages());
        System.out.println("当前页是：" + pageNum);

        System.out.println("分页数据：");
        Iterator<Article> u = articles.iterator();
        while (u.hasNext()){

            System.out.println(u.next().toString());
        }

        model.addAttribute("articleList",articles);

        return "index";
    }
}

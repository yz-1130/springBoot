package com.xinyan.controller;

import com.xinyan.pojo.Article;
import com.xinyan.repository.ArticleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

/**
 * @author xinyan.xie
 * @description
 * @date 2020/4/19
 */
@Controller
public class LoginController {

    @Autowired
    private ArticleRespository articleRespository;

    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){

        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(Model model){

        List<Article> all = articleRespository.findAll();
        model.addAttribute("articleList",all);

        return "index";
    }
}

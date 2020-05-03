package com.xinyan.controller;

import com.xinyan.pojo.Article;
import com.xinyan.pojo.User;
import com.xinyan.repository.ArticleRespository;
import com.xinyan.repository.UserRespository;
import com.xinyan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private UserRespository userRespository;


    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws ServletException {
        HttpSession session = request.getSession();
        if (request.getSession().getAttribute("user")!=null){
            return "redirect:/toIndex";
        } else {
            return "login";
        }
    }

    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        session.setAttribute("user",user);
        session.setAttribute("url",request.getContextPath());
        session.setAttribute("port","请求端口:"+request.getServerPort());
        session.setAttribute("sid","sid:"+session.getId());

        session.setAttribute("local","请求地址是："+request.getRequestURL());

        session.setAttribute("tips","欢迎"+username+"回来博客");
        request.setAttribute("user",true);
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "redirect:/toIndex";
    }

//    @RequestMapping("/login")
//    public String toPage(Model model){
//
//        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
//        model.addAttribute("username","admin");
//        model.addAttribute("","");
//        return "toIndex";
//    }
    @RequestMapping("/toIndex")
    public String toIndex(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,HttpServletRequest request,HttpSession session){

        System.out.println("============================");
        Page<Article> articles=articleService.getUserList(pageNum, pageSize);
        System.out.println("总页数" + articles.getTotalPages());
        System.out.println("当前页是：" + pageNum);

        System.out.println("分页数据：");
        Iterator<Article> u = articles.iterator();
        while (u.hasNext()){

            System.out.println(u.next().toString());
        }

        String requestURI = request.getRequestURI();
        model.addAttribute("requestURI",requestURI);
        model.addAttribute("username","admin");
        model.addAttribute("articleList",articles);

        return "index";
    }
}

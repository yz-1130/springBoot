package com.xinyan.utli;

import com.xinyan.pojo.User;
import com.xinyan.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xinyan.xie
 * @description
 * @date 2020/5/3
 */
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRespository userRespository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user==null) {
                response.sendRedirect(request.getContextPath()+"/login");
            }
            if (!user.getUsername().equals("admin")){
                return false;
            }
               // response.sendRedirect(request.getContextPath()+"/index");


        } catch (Exception e){
            throw new Exception();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

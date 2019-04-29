package com.util.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class CustomHandleCustomHandleException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String  msg = "";
        if(e instanceof Myexception){
            //自定义异常
            msg = e.getMessage();
        }else{
            //非自定义异常
            Writer writer = new StringWriter();
            PrintWriter s = new PrintWriter(writer);
            e.printStackTrace(s);
            msg =writer.toString();
        }
        //跳转到失败页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

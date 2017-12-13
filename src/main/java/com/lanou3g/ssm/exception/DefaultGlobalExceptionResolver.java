package com.lanou3g.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

/**
 * Created by dllo on 17/12/1.
 */
public class DefaultGlobalExceptionResolver implements HandlerExceptionResolver {

//    当在controller中抛出的异常没有被处理时，该方法会被调用
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

//        提取出异常中的错误日志
//        方式一：
        StackTraceElement[] elements = e.getStackTrace();
        StringBuilder builder = new StringBuilder();
        builder.append(e.getMessage()+":"+"<br>");
        for (StackTraceElement element : elements) {
            builder.append(element.toString()).append("<br>");
        }

//        方法二：
        CharArrayWriter w= new CharArrayWriter();
        PrintWriter pw = new PrintWriter(w);
        e.printStackTrace(pw);
        String s = new String(w.toCharArray());
        s =s.replace("\n","<br>");
        System.out.println("rizhi:"+s);


        ModelAndView modelAndView = new ModelAndView();
//        设置视图的名字
        modelAndView.setViewName("error");



        String message;
        if (e instanceof DefaultException){
            message = e.getMessage();
        }else {
            message = "未知的异常";
        }

        modelAndView.addObject("errorMsg",message);
        modelAndView.addObject("stackTrace",s);
        return modelAndView;
    }
}

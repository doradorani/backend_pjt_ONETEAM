package com.oneteam.dormease.product;

import com.oneteam.dormease.user.parents.ParentsDto;
import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

public class ParentsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        ParentsDto loginedParentsDto = (ParentsDto) session.getAttribute("loginedParentsDto");

        if (loginedParentsDto == null) {

            String message = "alert('가입된 학부모만 사용이 가능합니다. 로그인을 해주세요!');";

            // 응답에 JavaScript 코드를 출력하고 문자 인코딩 설정
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>" + message + "</script>");
            out.flush();

            // JavaScript가 실행된 이후에 일정 시간(0.1초 후)에 리디렉션을 수행
            out.println("<script>setTimeout(function() { location.href = '" + request.getContextPath() + "/'; }, 100);</script>");
            response.sendRedirect("/user/loginForm");
            return false;
        } else {
            return true;
        }
    }

}

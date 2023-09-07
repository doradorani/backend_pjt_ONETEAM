package com.oneteam.dormease.product;

import com.github.rkpunjal.sqlsafe.SQLInjectionSafe;
import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

@Data
public class ProductOrderDto {

    private @SQLInjectionSafe int no;                   //COMMENT '상품 주문 번호'
    private @SQLInjectionSafe String img;               //COMMENT '상품 이미지'
    private @SQLInjectionSafe String id;                //COMMENT '학생 ID'
    private @SQLInjectionSafe String name;             //COMMENT '상품 명'
    private @SQLInjectionSafe int count;                //COMMENT '상품 주문 수'
    private @SQLInjectionSafe int price;                //COMMENT '상품 개당 가격'
    private @SQLInjectionSafe int sum;                  //COMMENT '상품 별 총 합계'
    private @SQLInjectionSafe int allsum;               //COMMENT '총 합계'
    private @SQLInjectionSafe String reg_date;          //COMMENT '등록 날짜'
    private @SQLInjectionSafe String reg_date_trim;     //COMMENT '등록 날짜 공백제거'
    private @SQLInjectionSafe String mod_date;          //COMMENT '수정 날짜'


    public static class ProductInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            HttpSession session = request.getSession();
            StudentDto loginedStudentDto = (StudentDto) session.getAttribute("loginedStudentDto");

            if(loginedStudentDto == null) {

                String message = "alert('학교 학생만 사용이 가능합니다.');";

                // 응답에 JavaScript 코드를 출력하고 문자 인코딩 설정
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>" + message + "</script>");
                out.flush();

                // JavaScript가 실행된 이후에 일정 시간(0.1초 후)에 리디렉션을 수행
                out.println("<script>setTimeout(function() { location.href = '" + request.getContextPath() + "/'; }, 100);</script>");

                return false;
            } else {
                return true;
            }
        }
    }
}

package com.oneteam.dormease.product;

import com.oneteam.dormease.user.school.SchoolDto;
import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/product")
public class ProductController {

    //생성자 주입
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    /*
     * 우리 학교 상품 보기
     */
    @GetMapping("/mySchoolProductForm")
    public String mySchoolProductForm(HttpSession session, Model model){
        log.info("mySchoolProductForm()");

        String nextPage = "product/mySchoolProductForm";

//        StudentDto loginedStudentDto = (StudentDto)session.getAttribute("loginedStudentDto");
//        if(loginedStudentDto == null){
//            //로그인을 해주어야 nextPage로 이동
//            return "redirect:/";
//        }

        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setZip_code("24286"); //테스트용
        StudentDto loginedStudentDto = new StudentDto(); //테스트용
        loginedStudentDto.setId("test"); //테스트용

        model.addAttribute("schoolDto", schoolDto);     //추후엔 집코드를 logined에 붙여줄 예정
        model.addAttribute("loginedStudentDto", loginedStudentDto);

        return nextPage;
    }

    /*
     * 전체 상품 조회(ajax)
     */
    @PostMapping("/mySchoolProduct")
    @ResponseBody
    public Object mySchoolProduct(@RequestBody Map<String ,String> msgMap){
        log.info("mySchoolProduct()");

        String zipCode = msgMap.get("zipCode");

        Map<String, Object> resultMap = productService.mySchoolProduct(zipCode);

        return resultMap;
    }

    /*
     * 상품 검색 (ajax)
     */
    @PostMapping("/findProduct")
    @ResponseBody
    public Object selectProduct(@RequestBody Map<String ,String> msgMap){
        log.info("selectProduct()");

        String productName = msgMap.get("name");
        String zipCode = msgMap.get("zipCode");

        Map<String, Object> resultMap = productService.findProduct(productName, zipCode);

        return resultMap;
    }

    /*
     * 상품 등록 확인
     */
    @PostMapping("/registProductConfirm")
    public String registProductConfirm(ProductOrderDto productOrder,
                                       @RequestParam("name") List<String> name,
                                       @RequestParam("price") List<Integer> price,
                                       @RequestParam("cnt") List<Integer> cnt,
                                       @RequestParam("img") List<String> img){
        log.info("registProductConfirm()");

        int result = productService.registProductConfirm(productOrder, name, price, cnt, img);

        return "redirect:/product/mySchoolProductForm";
    }

    /*
     * 결제 내역 확인
     */
    @PostMapping("/paymentHistory")
    public String paymentHistory(ProductOrderDto productOrder){
        log.info("paymentHistory()");

        String nextPage = "product/paymentHistory";



        return nextPage;
    }





}

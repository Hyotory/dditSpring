package kr.or.ddit.controller;

import kr.or.ddit.dto.LprodForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
public class LprodController {

    @GetMapping("/lprod/new")
    public String newArticleForm() {
        return "lprod/new";
    }
    /*
    요청URI : /lprod/create
    요청파라미터 : request{lprodId=1,lprodGu=P101,lprodNm=컴퓨터제품}
    요청방식 : post

    DTO 이외의 매개변수로 request객체 안에 있는 파라미터를 받아보자
    스프링프레임워크에서 '1'라는 숫자형 문자 파라미터값을 int 타입의 매개변수로
        자동형변환하여 받을 수 있음
     */
    @PostMapping("/lprod/create")
    public String createLprod(LprodForm form, int lprodId, String lprodGu, String lprodNm,
                              Map<String, Object> map) {
         log.info("form: " + form);
         log.info("lprodId: " + lprodId);
         log.info("lprodGu: " + lprodGu);
         log.info("lprodName: " + lprodNm);
         log.info("map: " + map);

        return "redirect:/lprod/new";

    }

    /*
    요청URI : /lprod/createAjax
    요청파라미터 : JSON String{"lprodId":"1","lprodGu":"P101","lprodNm":"컴퓨터제품"}
    요청방식 : post
     */
    @ResponseBody
    @PostMapping("/lprod/createAjax")
    public String createLprodAjax(@RequestBody LprodForm form) {
        log.info("createLprodAjax -> form: " + form);

        // 데이터
        return "success";

    }
}

package kr.or.ddit.api;

import kr.or.ddit.entity.Lprod;
import kr.or.ddit.repository.LprodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class LprodApiController {

    // DI/ IoC(제어의 역전)
    @Autowired
    LprodRepository lprodRepository;

    //비동기 목록 출력
    //아작나써유..(피)(씨다)타써
    /*
    요청URI : /api/lprods
    요청파라미터 :
    요청방식 : post
    */

    /*
    요청URI: /api/lprod/1
    요청파라미터: lprodId
    요청방식: get
     */
    @GetMapping("/api/lprod/{lprodId}")
    public Lprod show(@PathVariable(value="lprodId") Long lprodId) {
       log.info("show -> lprodId: ", lprodId);

       Lprod lprodEntity = this.lprodRepository.findById(lprodId).orElse(null);
       log.info("show -> lprodEntity: ", lprodEntity);

       //데이터 응답
        return lprodEntity;

    }

    //RestController에 의해서 ResponseBody 애너테이션 생략
    @PostMapping("/api/lprods")
    public List<Lprod> lprods() {
        List<Lprod> lprodList =  this.lprodRepository.findAll();
        log.info("lprod -> lprodList: " + lprodList);
        return lprodList;
    }
}

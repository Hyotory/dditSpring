package kr.or.ddit.api;

import kr.or.ddit.dto.LprodForm;
import kr.or.ddit.entity.Lprod;
import kr.or.ddit.repository.LprodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
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
    @GetMapping("/lprod/{lprodId}")
    public Lprod show(@PathVariable(value="lprodId") Long lprodId) {
       log.info("show -> lprodId: ", lprodId);

       Lprod lprodEntity = this.lprodRepository.findById(lprodId).orElse(null);
       log.info("show -> lprodEntity: ", lprodEntity);

       //데이터 응답
        return lprodEntity;

    }

    //RestController에 의해서 ResponseBody 애너테이션 생략
    @PostMapping("/lprods")
    public List<Lprod> lprods() {
        List<Lprod> lprodList =  this.lprodRepository.findAll();
        log.info("lprod -> lprodList: " + lprodList);
        return lprodList;
    }

    @PostMapping("/lprods/update")
    public Lprod update(@RequestBody LprodForm form) {
        log.info("update -> form: " + form);

        Lprod lprodEntity = form.toEntity();
        log.info("update -> lprodEntity: " + lprodEntity);

        Lprod target = this.lprodRepository.findById(lprodEntity.getLprodId()).orElse(null);
        log.info("update -> target: " + target);

        if(target != null) {
            target = this.lprodRepository.save(lprodEntity);
        }
        return target;
    }
}

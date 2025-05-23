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

    /* 글 삭제
    요청URI : api/lprods/delete
    요청 파라미터 : JSON String{id: 2}
    요청방식 : POST

    @RequestBody Long id => 실패
    @RequestBody ArticleForm articleForm => 성공
     */
    @PostMapping("/lprods/delete")
    public Lprod delete(@RequestBody LprodForm lprodForm) {
        // 로그: 삭제 요청이 수신되었음을 기록합니다.
        log.info("delete-> lprodForm : " + lprodForm);
        Long lprodId = lprodForm.getLprodId();
        log.info("delete-> id : " + lprodId);

        //1) 삭제할 대상 가져오기
        // lprodRepository를 사용하여 전달받은 id로 Lprod 엔티티를 데이터베이스에서 조회합니다.
        // 만약 해당 id의 엔티티가 존재하지 않으면 null을 반환합니다.
        // 로그: 조회된 삭제 대상 엔티티 정보를 기록합니다.
        Lprod target = this.lprodRepository.findById(lprodId).orElse(null);
        log.info("delete-> target : " +target);
        //2) 대상 엔티티 삭제하기
        //삭제할 대상이 있는지 확인
        // 조회된 엔티티(target)가 null이 아닌지, 즉 삭제할 대상이 존재하는지 확인합니다.
        if(target != null) {
            //delete() 메서드로 대상 삭제
            this.lprodRepository.delete(target);
        }
        return target;

    }
}

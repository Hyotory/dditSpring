package kr.or.ddit.dto;

/*
DB의 큰 목적 2가지
    데이터 중복 방지(P.K), 데이터 불일치 방지(F.K)-참조 무결성
*/
//자바빈 클래스 : 자바빈 규약을 지키는 클래스
//              1) 프로퍼티 2) 기본생성자 3) getter/setter메소드

import kr.or.ddit.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

/*AllArgsConstructor :
public ArticleForm(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
}

골뱅이 ToString : toString()메서드를 사용하는 것과 같음
*/

@AllArgsConstructor
@ToString
public class ArticleForm {
    /*
    long은 primitive type으로, 값이 없을 경우 0으로 초기화된다.
    따라서, id가 없어서 0으로 세팅이 된 것인지, 아니면 실제 값이 0인지
    데이터만 보고 판별할 수 없다.
    반면 Long은 wrapper type으로, 값이 없을 경우 null로 초기화 된다.
    따라서 값이 0이라면, id가 0으로 저장됐음을 알 수 았다.
    */
    private Long id;
    //제목을 받을 필드
    private String title;
    //내용을 받을 필드
    private String content;
    // 기본 생성자
    public ArticleForm() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // DTO 를 엔티티로 변환해주는 메서드
    public Article toEntity() {
        //null -> id로 수정(글 수정을 위함)
        Article article = new Article(this.id,this.title,this.content);
        return article;
    }
}

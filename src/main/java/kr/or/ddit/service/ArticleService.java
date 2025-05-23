package kr.or.ddit.service;

import kr.or.ddit.entity.Article;

import java.util.List;

public interface ArticleService {

    // 글 목록
    public List<Article> findAll();
}

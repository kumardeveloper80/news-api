package com.news.service;

import com.news.model.RegisterComment;
import com.news.model.RegisterNews;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author lapto
 */
public interface NewsService {


    RegisterNews addUpdateNews(RegisterNews news);

    List<RegisterNews> getNewsList(String title, String tags);

    void deleteNews(Long id);

    Optional<RegisterNews> findNews(Long id);

    RegisterComment addUpdateComment(RegisterComment comment);

    List<RegisterComment> getComment(Long newsID);

    void deleteComment(Long id);

}

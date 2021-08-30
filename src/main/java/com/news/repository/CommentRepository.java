package com.news.repository;

import com.news.model.RegisterComment;
import com.news.model.RegisterNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository
        extends JpaRepository<RegisterComment, Long> {
    @Query("select rc from RegisterComment rc where  rc.NewsId = ?1")
    List<RegisterComment> findRegisterCommentByNewsId( Long NewsId);
}
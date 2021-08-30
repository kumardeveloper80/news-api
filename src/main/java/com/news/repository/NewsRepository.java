package com.news.repository;

import com.news.model.RegisterNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository
        extends JpaRepository<RegisterNews, Long> {

    @Query("SELECT m FROM RegisterNews m WHERE m.title LIKE %:title%")
    List<RegisterNews> searchByTitleLike(@Param("title") String title);

    @Query(value = "select * from News where tags ~* :tags", nativeQuery = true)
     List<RegisterNews> findByTags(@Param("tags") String tags);

    @Query(value ="SELECT * FROM News WHERE  tags ~* :tags and title LIKE %:title%" , nativeQuery = true)
    List<RegisterNews> searchByTagsAndTitle(@Param("title") String title,@Param("tags") String tags);

}
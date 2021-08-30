package com.news.service;

import com.news.model.RegisterComment;
import com.news.model.RegisterNews;
import com.news.repository.CommentRepository;
import com.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lapto
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public RegisterNews addUpdateNews(RegisterNews news) {
        return newsRepository.save(news);
    }

    @Override
    public List<RegisterNews> getNewsList(String title, String tags) {
        if (title != null && tags != null) {
            String searchTerm = Arrays.stream(tags.split(","))
                    .map(String::trim)
                    .collect(Collectors.joining("|", "(", ")"));
            return newsRepository.searchByTagsAndTitle(title, searchTerm);
        }
        if (title != null)
            return newsRepository.searchByTitleLike(title);
        if (tags != null) {
            String searchTerm = Arrays.stream(tags.split(","))
                    .map(String::trim)
                    .collect(Collectors.joining("|", "(", ")"));
            return newsRepository.findByTags(searchTerm);
        }

        return newsRepository.findAll();
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public Optional<RegisterNews> findNews(Long id) {
        return newsRepository.findById(id);
    }

    @Override
    public RegisterComment addUpdateComment(RegisterComment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<RegisterComment> getComment(Long newsID) {
        return commentRepository.findRegisterCommentByNewsId(newsID);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }


}

package com.news.handler;

import com.news.bean.CommentRequest;
import com.news.bean.NewsRequest;
import com.news.enums.ErrorMessageEnum;
import com.news.model.RegisterComment;
import com.news.model.RegisterNews;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.news.bean.WsResponse;
import com.news.constants.ResponseMessage;
import com.news.exception.NewsException;
import com.news.service.NewsService;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lapto
 */
@Component
public class NewsHandlerImpl implements NewsHandler {

    @Autowired
    private NewsService newsService;

    /**
     * Method is used to get current weather
     *
     * @param newsRequest
     */
    @Override
    public WsResponse add(NewsRequest newsRequest) throws NewsException {
        final WsResponse response = new WsResponse();
        RegisterNews newNews = new RegisterNews();
        BeanUtils.copyProperties(newsRequest, newNews);
        newNews = newsService.addUpdateNews(newNews);
        response.setMessage(ResponseMessage.SUCCESS);
        response.setStatus((newNews == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
        response.setData(newNews);
        return response;

    }

    @Override
    public WsResponse getNewsList(String title, String tags) throws NewsException {
        final WsResponse response = new WsResponse();
        response.setMessage(ResponseMessage.SUCCESS);

        List<RegisterNews> data = newsService.getNewsList(title, tags);

        for (RegisterNews news : data) {
            news.setComments(newsService.getComment(news.getId()));
        }
        response.setStatus((data == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
        response.setData(data.isEmpty() ? new ArrayList<RegisterNews>() : data);
        return response;

    }

    @Override
    public WsResponse deleteNews(Long newsId) throws NewsException {
        final WsResponse response = new WsResponse();
        response.setMessage(ResponseMessage.SUCCESS);
        RegisterNews find = newsService.findNews(newsId).orElse(null);
        if (find == null) {
            throw new NewsException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());
        }
        List<RegisterComment> commentList = newsService.getComment(find.getId());
        for (RegisterComment news : commentList) {
            newsService.deleteComment(news.getId());
        }
        newsService.deleteNews(newsId);
        response.setStatus(HttpStatus.OK.value());
        response.setData(null);
        return response;
    }

    @Override
    public WsResponse updateNews(NewsRequest newsRequest, Long id) throws NewsException {

        final WsResponse response = new WsResponse();
        response.setMessage(ResponseMessage.SUCCESS);
        RegisterNews find = newsService.findNews(id).orElse(null);
        if (find == null) {
            throw new NewsException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());

        }
        if (!newsRequest.getAuthorName().isEmpty())
            find.setAuthorName(newsRequest.getAuthorName());
        if (!newsRequest.getContent().isEmpty())
            find.setContent(newsRequest.getContent());
        if (!newsRequest.getTitle().isEmpty())
            find.setTitle(newsRequest.getTitle());
        if (!newsRequest.getTags().isEmpty())
            find.setTags(newsRequest.getTags());
        if (newsRequest.getDate() != null)
            find.setDate(newsRequest.getDate());
        newsService.addUpdateNews(find);
        response.setStatus(HttpStatus.OK.value());
        response.setData(newsService);
        return response;
    }

    @Override
    public WsResponse addComment(CommentRequest commentRequest, Long newdId) throws NewsException {
        final WsResponse response = new WsResponse();
        response.setMessage(ResponseMessage.SUCCESS);
        RegisterNews find = newsService.findNews(newdId).orElse(null);
        if (find == null) {
            throw new NewsException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());

        }
        RegisterComment addComment = new RegisterComment();
        BeanUtils.copyProperties(commentRequest, addComment);
        addComment.setNewsId(newdId);
        addComment = newsService.addUpdateComment(addComment);
        response.setStatus((addComment == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
        response.setData(addComment);
        return response;
    }

    @Override
    public WsResponse getNewsById(Long newsId) throws NewsException {
        final WsResponse response = new WsResponse();
        response.setMessage(ResponseMessage.SUCCESS);
        RegisterNews find = newsService.findNews(newsId).orElse(null);
        if (find == null) {
            throw new NewsException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());
        }
        find.setComments(newsService.getComment(find.getId()));
        response.setStatus((find == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
        response.setData(find);
        return response;

    }

    @Override
    public WsResponse getCommentByNewsId(Long newsId) throws NewsException {
        final WsResponse response = new WsResponse();
        response.setMessage(ResponseMessage.SUCCESS);
        RegisterNews find = newsService.findNews(newsId).orElse(null);
        if (find == null) {
            throw new NewsException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());
        }
        List<RegisterComment> comments = newsService.getComment(find.getId());
        response.setStatus((comments == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
        response.setData(comments);
        return response;
    }


}

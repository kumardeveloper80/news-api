package com.news.handler;

import com.news.bean.CommentRequest;
import com.news.bean.NewsRequest;
import com.news.bean.WsResponse;
import com.news.exception.NewsException;

public interface NewsHandler {

	WsResponse add(NewsRequest newsRequest) throws NewsException;
	WsResponse getNewsList(String title,String tags) throws NewsException;
	WsResponse deleteNews(Long newsId) throws NewsException;
	WsResponse updateNews(NewsRequest newsRequest,Long id) throws NewsException;
	WsResponse addComment(CommentRequest commentRequest,Long newdId) throws NewsException;
	WsResponse getNewsById(Long newsId) throws NewsException;
	WsResponse getCommentByNewsId(Long newsId) throws NewsException;
	
}

package com.news.controller;

import com.news.bean.CommentRequest;
import com.news.bean.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.news.bean.WsResponse;
import com.news.exception.NewsException;
import com.news.handler.NewsHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "/api/v1/news", description = "news API")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(value = "/api/v1/news")
public class NewsController {
    @Autowired
    private NewsHandler newsHandler;

    /**
     * @param newsRequest
     * @return
     */
    @PostMapping
    @ApiOperation(value = "API to post news")
    public ResponseEntity<WsResponse> addNews(@RequestBody NewsRequest newsRequest)
            throws NewsException {
        final WsResponse response = newsHandler.add(newsRequest);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "API to get news")
    public ResponseEntity<WsResponse> getNewsList(@RequestParam(value = "title", required = false) String title,
                                                  @RequestParam(value = "tags", required = false) String tags)
            throws NewsException {
        final WsResponse response = newsHandler.getNewsList(title, tags);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "API to get news")
    public ResponseEntity<WsResponse> getNews(@PathVariable(value = "id", required = true) Long newsId)
            throws NewsException {
        final WsResponse response = newsHandler.getNewsById(newsId);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/comment/{newsId}")
    @ApiOperation(value = "API to get news comment")
    public ResponseEntity<WsResponse> getNewsComment(@PathVariable(value = "newsId", required = true) Long newsId)
            throws NewsException {
        final WsResponse response = newsHandler.getCommentByNewsId(newsId);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "API to delete news")
    public ResponseEntity<WsResponse> deleteNews(@PathVariable(value = "id", required = true) Long newsId)
            throws NewsException {
        final WsResponse response = newsHandler.deleteNews(newsId);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "API to update news")
    public ResponseEntity<WsResponse> addNews(@RequestBody NewsRequest newsRequest, @PathVariable(value = "id", required = true) Long newsId)
            throws NewsException {
        final WsResponse response = newsHandler.updateNews(newsRequest, newsId);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }


    @PostMapping("/comment/{newsId}")
    @ApiOperation(value = "API to register comment news")
    public ResponseEntity<WsResponse> addNews(@RequestBody CommentRequest commentRequest, @PathVariable(value = "newsId", required = true) Long newsId)
            throws NewsException {
        final WsResponse response = newsHandler.addComment(commentRequest, newsId);
        return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
    }

}

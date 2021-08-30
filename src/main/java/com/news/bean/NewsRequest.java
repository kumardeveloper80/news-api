package com.news.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewsRequest {
    private String title;
    private String content;
    private String authorName;
    private String tags;
    private java.util.Date date;
}

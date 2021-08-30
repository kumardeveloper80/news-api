package com.news.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="News")
@Getter
@Setter
@NoArgsConstructor
public class RegisterComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="content")
	private String content;

	@Column(name="authorName", nullable=false, length=200)
	private String authorName;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	@Column(name = "newsId")
	private Long NewsId;



}

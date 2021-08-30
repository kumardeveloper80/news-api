package com.news.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class RegisterNews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="title")
	private String title;

	@Column(name="content")
	private String content;

	@Column(name="authorName", nullable=false, length=200)
	private String authorName;

	@Column(name="tags")
	private String tags;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<RegisterComment> comments;
}

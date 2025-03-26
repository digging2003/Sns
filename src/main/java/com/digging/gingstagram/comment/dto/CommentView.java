package com.digging.gingstagram.comment.dto;

import com.digging.gingstagram.comment.domain.Comment;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentView {

	private int commentId;
	private int userId;
	private String loginId;
	private String contents;
}

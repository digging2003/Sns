package com.digging.gingstagram.post.dto;

import java.util.List;

import com.digging.gingstagram.comment.dto.CommentView;

import lombok.Builder;
import lombok.Getter;

// DTO
// 게시글 하나를 표현하는 화면을 구성하기 위해 필요한 값들을 관리하기위한 클래스

@Builder
@Getter
public class CardView {

	// 피드 정보
	private int postId;
	
	private String contents;
	private String imagePath;
	
	private int userId;
	private String loginId;
	
	// 댓글 정보
	private List<CommentView> commentList;
	private int commentCount;
	
	// 좋아요 정보
	private boolean isLike;
	private int likeCount;
	
}

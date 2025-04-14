package com.project.BloggingServer.Service;

import com.project.BloggingServer.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long postId, String postedBy, String content);
    List<Comment> getCommentsByPostId(Long postId);
}

package org.example.baba.controller.dto.response;

import java.util.List;

import org.example.baba.domain.Post;
import org.example.baba.domain.enums.SNSType;

public record PostSimpleResponseDto(
    Long id,
    Long memberId,
    SNSType type,
    String title,
    String content,
    int viewCount,
    int likeCount,
    int shareCount,
    List<String> hashTags) {
  public static PostSimpleResponseDto from(Post post, List<String> hashTags) {
    return new PostSimpleResponseDto(
        post.getId(),
        post.getMemberId(),
        post.getType(),
        post.getTitle(),
        post.getContent(),
        post.getViewCount(),
        post.getLikeCount(),
        post.getShareCount(),
        hashTags);
  }
}

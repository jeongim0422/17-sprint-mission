package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Message {
    // 도메인 공통 필드
    final UUID id;
    final Long createdAt;
    Long updatedAt;

    // Message 만의 필드
    String content;
    final UUID channelId;
    final UUID authorId;

    public Message(String content, UUID channelId, UUID userId){
        id = UUID.randomUUID();
        createdAt = System.currentTimeMillis();
        this.content = content;
        this.channelId = channelId;
        authorId = userId;
    }

    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getContent() {
        return content;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void update(String content){
        this.content = content;
        updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content +
                "', channelId=" + channelId +
                ", authorId=" + authorId +
                '}';
    }
}

package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Channel {
    // 도메인 공통 필드
    final UUID id;
    final Long createdAt;
    Long updatedAt;

    // Channel 만의 필드
    ChannelType channelType;
    String channelName;
    String channelDesc;

    public Channel(ChannelType channelType, String channelName, String channelDesc){
        id = UUID.randomUUID();
        createdAt = System.currentTimeMillis();
        this.channelType = channelType;
        this.channelName = channelName;
        this.channelDesc = channelDesc;
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

    public ChannelType getChannelType() {
        return channelType;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void update(ChannelType channelType, String channelName, String channelDesc){
        this.channelType = channelType;
        this.channelName = channelName;
        this.channelDesc = channelDesc;
        updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelType=" + channelType +
                ", channelName=" + channelName +
                ", channelDesc=" + channelDesc + '}';
    }
}

package com.sprint.mission.discodeit.service;



import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;

import java.util.List;
import java.util.UUID;

public interface ChannelService {

    Channel create(ChannelType channelType, String channelName, String channelDesc);
    Channel find(UUID channerId);
    List<Channel> findAll();
    Channel update(UUID channerId, ChannelType channelType, String channelName, String channelDesc);
    void delete(UUID uuid);
}

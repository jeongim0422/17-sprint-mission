package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.*;

public class JCFChannelService implements ChannelService {
    final Map<UUID, Channel> data;

    public JCFChannelService(){
        data = new HashMap<>();
    }

    @Override
    public Channel create(ChannelType channelType, String channelName, String channelDesc) {

        Channel channel = new Channel(channelType, channelName, channelDesc);
        data.put(channel.getId(), channel);

        return channel;
    }

    @Override
    public Channel find(UUID channelId) {
        Channel channel = data.get(channelId);
        if (channel == null){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다. id=" + channelId);
        }
        return channel;
    }

    @Override
    public List<Channel> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Channel update(UUID channerId, ChannelType channelType, String channelName, String channelDesc) {
        Channel channel = find(channerId);
        channel.update(channelType, channelName, channelDesc);

        return channel;
    }

    @Override
    public void delete(UUID channelId) {
        if (!data.containsKey(channelId)){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다. id=" + channelId);
        }
        data.remove(channelId);
    }
}

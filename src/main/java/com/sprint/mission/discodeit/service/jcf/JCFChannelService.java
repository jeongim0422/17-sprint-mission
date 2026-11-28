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
        try{
            if (channel == null){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.out.println("채널 조회 실패: id=" + channelId);
        }

        return channel;
    }

    @Override
    public List<Channel> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Channel update(UUID channelId, ChannelType channelType, String channelName, String channelDesc) {
        Channel channel = find(channelId);
        try{
            if (channel == null){
                throw new IllegalArgumentException();
            }
            channel.update(channelType, channelName, channelDesc);
        } catch (Exception e) {
            System.out.println("채널 수정 실패: id=" + channelId);
        }
        return channel;
    }

    @Override
    public void delete(UUID channelId) {
        try{
            if (!data.containsKey(channelId)){
                throw new IllegalArgumentException();
            }
            data.remove(channelId);
        } catch (IllegalArgumentException e) {
            System.out.println("채널 삭제 실패: id=" + channelId);
        }


    }
}

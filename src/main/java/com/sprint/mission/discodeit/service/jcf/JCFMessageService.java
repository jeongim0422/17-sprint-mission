package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;

public class JCFMessageService implements MessageService {

    final Map<UUID, Message> data;
    JCFUserService userService;
    JCFChannelService channelService;

    public JCFMessageService(JCFUserService userService, JCFChannelService channelService){
        data = new HashMap<>();
        this.userService = userService;
        this.channelService = channelService;
    }


    @Override
    public Message create(String content, UUID channelId, UUID authorId) {
        try{
            userService.find(authorId);
            channelService.find(channelId);
        } catch (IllegalArgumentException e){
            System.out.println("사용자를 찾을 수 없습니다." + e.getMessage());
            return null;
        }

        Message message = new Message(content, channelId, authorId);
        data.put(message.getId(), message);
        return message;
    }

    @Override
    public Message find(UUID messageId) {
        Message message = data.get(messageId);
        if (message == null){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다. id=" + messageId);
        }
        return message;
    }

    @Override
    public List<Message> findAll() {

        return new ArrayList<>(data.values());
    }

    @Override
    public Message update(UUID messageId, String content, UUID channelId) {

        Message message = find(messageId);
        message.update(content, channelId);
        return message;
    }

    @Override
    public void delete(UUID messageId) {
        if (!data.containsKey(messageId)){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다. id=" + messageId);
        }
        data.remove(messageId);
    }
}

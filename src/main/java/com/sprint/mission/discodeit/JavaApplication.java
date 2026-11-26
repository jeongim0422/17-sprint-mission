package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

public class JavaApplication {

    public static void main(String[] args){
        JCFUserService userService = new JCFUserService();
        JCFChannelService channelService = new JCFChannelService();

        /* UserService 테스트
        // User 1. 등록
        User user = userService.create("유저a", "code12@sss.com", "aaaaa");
        userService.create("유저b", "fdfs34@sss.com", "bbbbb");
        userService.create("유저c", "hhhfgb@xcs.net", "ccccc");

        // User 2. 조회
        System.out.println("단건 조회:  " + userService.find(user.getId()));
        System.out.println("다건 조회: " + userService.findAll().size() + "명");

        // User 3. 수정
        userService.update(user.getId(), "유저1", "qwer12@dd.net", "11111");
        System.out.println("수정 후: " + userService.find(user.getId()));

        // User 4. 삭제
        userService.delete(user.getId());
        System.out.println("삭제 후 : " + userService.findAll().size() + "명");
        try {
            userService.find(user.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }
         */

        // Channel 1. 등록
        Channel channel = channelService.create(ChannelType.PRIVATE, "비공개 채널1", "비공개 채널 예시1");
        channelService.create(ChannelType.PRIVATE, "비공개 채널2", "비공개 채널 예시2");
        channelService.create(ChannelType.PUBLIC, "공개 채널1", "공개 채널 예시1");

        // Channel 2. 조회
        System.out.println("단건 조회: " + channelService.find(channel.getId()));
        System.out.println("다건 조회: " + channelService.findAll().size() + "개");

        // Channel 3. 수정
        channelService.update(channel.getId(), ChannelType.PUBLIC, "공개 채널a", "비공개 채널1 에서 공개 채널a로 수정됨");
        System.out.println("수정 후: " + channelService.find(channel.getId()));

        // Channel 4. 삭제
        channelService.delete(channel.getId());
        System.out.println("삭제 후: " + channelService.findAll().size() + "개");
        try{
            channelService.find(channel.getId());
        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: " + e.getMessage());
        }
    }

}

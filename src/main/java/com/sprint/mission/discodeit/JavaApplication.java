package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.file.FileUserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

import java.io.IOException;
import java.util.UUID;

public class JavaApplication {

    public static void main(String[] args){
        JCFUserService userService = new JCFUserService();
        JCFChannelService channelService = new JCFChannelService();
        JCFMessageService messageService = new JCFMessageService(userService, channelService);

        FileUserService fileUserService = new FileUserService();

        /*
        // JCF Service
        // User 1. 등록
        User user = userService.create("유저a", "code12@sss.com", "aaaaa");
        User user2 = userService.create("유저b", "fdfs34@sss.com", "bbbbb");
        userService.create("유저c", "hhhfgb@xcs.net", "ccccc");

        // User 2. 조회
        try{
            System.out.println("단건 조회:  " + userService.find(user.getId()));
        }
        catch (IllegalArgumentException e){
            System.out.println("조회 실패 :" + e.getMessage());
        }
        System.out.println("다건 조회: " + userService.findAll().size() + "명");


        // User 3. 수정
        try{
            userService.update(user.getId(), "유저1", "qwer12@dd.net", "11111");
            System.out.println("수정 후: " + userService.find(user.getId()));
        }
        catch (IllegalArgumentException e){
            System.out.println("수정 실패(존재하지 않는 사용자): " + e.getMessage());
        }


         // User 4. 삭제
        userService.delete(user.getId());
        System.out.println("삭제 후 : " + userService.findAll().size() + "명");
        try {
            userService.find(user.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }


        // ChannelService 테스트
        // Channel 1. 등록
        Channel channel = channelService.create(ChannelType.PRIVATE, "비공개 채널1", "비공개 채널 예시1");
        Channel channel2 = channelService.create(ChannelType.PRIVATE, "비공개 채널2", "비공개 채널 예시2");
        channelService.create(ChannelType.PUBLIC, "공개 채널1", "공개 채널 예시1");

        // Channel 2. 조회
        try{
            System.out.println("단건 조회: " + channelService.find(channel.getId()));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("존재하지 않는 채널입니다." + e.getMessage());
        }
        System.out.println("다건 조회: " + channelService.findAll().size() + "개");


        // Channel 3. 수정
        try{
            channelService.update(channel.getId(), ChannelType.PUBLIC, "공개 채널a", "비공개 채널1 에서 공개 채널a로 수정됨");
            System.out.println("수정 후: " + channelService.find(channel.getId()));
        }
        catch (IllegalArgumentException e){
            System.out.println("채널 수정 실패: " + e.getMessage());
        }


        // Channel 4. 삭제
        channelService.delete(channel.getId());
        System.out.println("삭제 후: " + channelService.findAll().size() + "개");
        try{
            channelService.find(channel.getId());
        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: " + e.getMessage());
        }


        // MessageService 테스트

        // Message 1. 생성
        Message message = messageService.create("메시지 전달1", channel.getId(), user.getId());
        messageService.create("메시지 전달2", channel.getId(), user.getId());


        // Message 2. 조회
        try{
            System.out.println("단건 조회: " + messageService.find(message.getId()));
        }
        catch (IllegalArgumentException e){
            System.out.println("조회 실패: " + e.getMessage());
        }

        System.out.println("다건 조회: " + messageService.findAll().size() + "개");

        // Message 3. 수정
        try{
            messageService.update(message.getId(), "메시지: 채널에서 채널 2로 변경", channel2.getId());
            System.out.println("수정 후: " + messageService.find(message.getId()));
        }
        catch (IllegalArgumentException e){
            System.out.println("수정 실패: " + e.getMessage());
        }


        // Message 4. 삭제
        messageService.delete(message.getId());
        System.out.println("삭제 후 : " + messageService.findAll().size() + "개");
        try{
            messageService.find(message.getId());
        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: " + e.getMessage());
        }

        // Message 검증 테스트
        messageService.create("등록되지 않은 사용자: ", channel.getId(), UUID.randomUUID());
        messageService.create("등록되지 않은 채널: ", UUID.randomUUID(), user.getId());
        messageService.create("메시지 전달3", channel2.getId(), user2.getId());
        System.out.println("검증 조회: " + messageService.findAll().size() + "개");
        */

        // File User 1. 생성
        User fileUser = fileUserService.create("user1", "erer23@dede.com", "1234");
        fileUserService.create("user2", "qqqq1111@dede.com", "0000");

        // File User 2. 조회
        try{
            System.out.println("단건 조회: " + fileUserService.find(fileUser.getId()));
        } catch (IllegalArgumentException e){
            System.out.println("생성 실패: " + e.getMessage());
        }
        System.out.println("다건 조회: " + fileUserService.findAll().size() + "명");


        System.out.println("삭제 전: " + fileUserService.findAll());
        // File User 3. 삭제
        fileUserService.delete(fileUser.getId());
        try{
            fileUserService.delete(fileUser.getId());
            System.out.println("삭제한 사용자: " + fileUserService.find(fileUser.getId()));

        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: " + e.getMessage());
        }
        System.out.println("삭제 후: " + fileUserService.findAll().size() + "명");
    }
}

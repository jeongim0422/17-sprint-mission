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


        // JCF Service
        // User 1. 등록
        User user = userService.create("유저a", "code12@sss.com", "aaaaa");
        User userTest = userService.create("유저b", "fdfs34@sss.com", "bbbbb");
        userService.create("유저c", "hhhfgb@xcs.net", "ccccc");

        // User 2. 조회
        System.out.println("===  JFC User 조회 테스트 ===");
        System.out.println("단건 조회:  " + userService.find(user.getId()));
        System.out.println("다건 조회: " + userService.findAll().size() + "명");
        System.out.println();

        // User 3. 수정
        System.out.println("===  JFC User 수정 테스트 ===");
        System.out.println("수정 전: " + userService.find(userTest.getId()));
        userService.update(userTest.getId(), "유저1", "qwer12@dd.net", "11111");
        System.out.println("수정 후: " + userService.find(userTest.getId()));
        System.out.println();


         // User 4. 삭제
        System.out.println("===  JFC User 삭제 테스트 ===");
        System.out.println("삭제 전 : " + userService.findAll().size() + "명");
        userService.delete(userTest.getId());
        System.out.println("삭제 후 : " + userService.findAll().size() + "명");
        userService.find(userTest.getId());
        System.out.println();

        // Channel 1. 등록
        Channel channel = channelService.create(ChannelType.PRIVATE, "비공개 채널1", "비공개 채널 예시1");
        Channel channelTest = channelService.create(ChannelType.PRIVATE, "비공개 채널2", "비공개 채널 예시2");
        channelService.create(ChannelType.PUBLIC, "공개 채널1", "공개 채널 예시1");


        // Channel 2. 조회
        System.out.println("===  JFC Channel 조회 테스트 ===");

        System.out.println("단건 조회: " + channelService.find(channel.getId()));
        System.out.println("다건 조회: " + channelService.findAll().size() + "개");
        System.out.println();

        // Channel 3. 수정
        System.out.println("===  JFC Channel 수정 테스트 ===");

        System.out.println("수정 전: " + channelService.find(channelTest.getId()));
        channelService.update(channelTest.getId(), ChannelType.PUBLIC, "공개 채널a", "비공개 채널1 에서 공개 채널a로 수정됨");
        System.out.println("수정 후: " + channelService.find(channelTest.getId()));
        System.out.println();

        // Channel 4. 삭제
        System.out.println("===  JFC Channel 삭제 테스트 ===");
        System.out.println("삭제 전: " + channelService.findAll().size() + "개");
        channelService.delete(channelTest.getId());
        System.out.println("삭제 후: " + channelService.findAll().size() + "개");
        System.out.println();


        // MessageService 테스트

        // Message 1. 생성
        System.out.println("===  JFC Message 생성 테스트 ===");
        Message message = messageService.create("메시지1", channel.getId(), user.getId());
        Message messageTest = messageService.create("메시지2", channel.getId(), user.getId());
        messageService.create("메시지3", channel.getId(), user.getId());
        System.out.println();

        // Message 2. 조회
        System.out.println("===  JFC Message 조회 테스트 ===");
        System.out.println("단건 조회: " + messageService.find(message.getId()));
        System.out.println("다건 조회: " + messageService.findAll().size() + "개");
        System.out.println();

        // Message 3. 수정
        System.out.println("===  JFC Message 수정 테스트 ===");
        System.out.println("수정 전: " + messageService.find(messageTest.getId()));
        messageService.update(messageTest.getId(), "채널 변경", channel.getId());
        System.out.println("수정 후: " + messageService.find(messageTest.getId()));
        System.out.println();

        // Message 4. 삭제
        System.out.println("===  JFC Message 수정 테스트 ===");
        System.out.println("삭제 전: " + messageService.findAll().size() + "개");
        messageService.delete(messageTest.getId());
        System.out.println("삭제 후: " + messageService.findAll().size() + "개");
        messageService.find(messageTest.getId());
        System.out.println();

        // Message 검증 테스트
//        messageService.create("등록되지 않은 사용자: ", channel.getId(), UUID.randomUUID());
//        messageService.create("등록되지 않은 채널: ", UUID.randomUUID(), user.getId());
//        messageService.create("메시지 전달3", channel2.getId(), userTest.getId());
//        System.out.println("검증 조회: " + messageService.findAll().size() + "개");
//
//
//        // File User 1. 생성
//        User fileUser = fileUserService.create("user1", "erer23@dede.com", "1234");
//        fileUserService.create("user2", "qqqq1111@dede.com", "0000");
//
//        // File User 2. 조회
//        try{
//            System.out.println("단건 조회: " + fileUserService.find(fileUser.getId()));
//        } catch (IllegalArgumentException e){
//            System.out.println("생성 실패: " + e.getMessage());
//        }
//        System.out.println("다건 조회: " + fileUserService.findAll().size() + "명");
//        System.out.println("삭제 전: " + fileUserService.findAll());
//
//        // File User 3. 삭제
//        fileUserService.delete(fileUser.getId());
//        try{
//            fileUserService.delete(fileUser.getId());
//            System.out.println("삭제한 사용자: " + fileUserService.find(fileUser.getId()));
//
//        } catch (IllegalArgumentException e){
//            System.out.println("삭제 확인: " + e.getMessage());
//        }
//        System.out.println("삭제 후: " + fileUserService.findAll().size() + "명");
//
//        // File User 4. 수정
//
//        fileUserService.update(fileUser.getId(), "수정한이름", "modify12@ss.com", "mmmmmmm");
//
//        try{
//        } catch (IllegalArgumentException e){
//            System.out.println("조회 실패: " + e.getMessage());
//        }
    }
}

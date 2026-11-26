package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

public class JavaApplication {

    public static void main(String[] args){
        JCFUserService userService = new JCFUserService();

        // User 1. 등록
        User user = userService.create("유저a", "code12@sss.com", "aaaaa");
        userService.create("유저b", "fdfs34@sss.com", "bbbbb");
        userService.create("유저c", "hhhfgb@xcs.net", "ccccc");

        // User 2. 조회
        System.out.println("단건 조회:  " + userService.find(user.getId()));
        System.out.println("다건 조회: " + userService.findAll().size() + "명");

        //User 3. 수정
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
    }
}

package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {

    final Map<UUID, User> data;

    public JCFUserService(){
        data = new HashMap<>();
    }

    @Override
    public User create(String userName, String email, String password) {

        User user = new User(userName, email, password);
        data.put(user.getId(), user);

        return user;
    }

    @Override
    public User find(UUID userId) {
        User user = data.get(userId);
        try{
            if (user == null){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
           System.out.println("사용자 조회 실패: id=" + userId);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public User update(UUID userId, String userName, String email, String password) {
        User user = find(userId);
        try{
            if (user == null)
                throw new IllegalArgumentException();
            user.update(userName, email, password);
        } catch (IllegalArgumentException e){
            System.out.println("사용자 수정 실패: id=" + userId);
        }
        return user;
    }

    @Override
    public void delete(UUID userId) {
        User user = data.get(userId);
        try{
            if (!data.containsKey(userId)){
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("사용자 삭제 실패: id=" + userId);
        }
        data.remove(userId);
    }
}

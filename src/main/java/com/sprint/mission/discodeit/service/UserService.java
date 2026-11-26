package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User create(String userName, String email, String password);
    User find(UUID userId);
    List<User> findAll();
    User update(UUID userId, String userName, String email, String password);
    void delete(UUID userId);

}

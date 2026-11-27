package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUserService implements UserService{

    Path directory = Paths.get(System.getProperty("user.dir"), "data");

    public FileUserService(){
        init (directory);
    }

    // 직렬화
    public static void init(Path directory){
        if (!Files.exists(directory)){
            try{
                Files.createDirectories(directory);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void save(Path filePath, T data){
        try(
                FileOutputStream fos = new FileOutputStream(filePath.toFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(data);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> load(Path directory){
        if (Files.exists(directory)){
            try{
                List<T> list = Files.list(directory)
                        .map(path -> {
                            try(
                                    FileInputStream fis = new FileInputStream(path.toFile());
                                    ObjectInputStream ois = new ObjectInputStream(fis);
                                    ) {
                                Object data = ois.readObject();
                                return (T) data;
                            } catch (IOException | ClassNotFoundException e){
                                throw new RuntimeException(e);
                            }
                        })
                        .toList();
                return list;
        } catch (IOException e){
            throw new RuntimeException(e);}
        }
        else{
            return new ArrayList<>();
        }
 }

    // CRUD
    @Override
    public User create(String userName, String email, String password) {
        User user = new User(userName, email, password);
        Path filePath = directory.resolve(user.getId().toString().concat(".ser"));
        save(filePath, user);

        return user;
    }

    @Override
    public User find(UUID userId) {

        Path filePath = directory.resolve(userId.toString().concat(".ser"));
        User user;
        try {
            if (!Files.exists(filePath)) {
                throw new IOException();
            }
            FileInputStream fis = new FileInputStream(filePath.toFile());
            ObjectInputStream ois = new ObjectInputStream(fis);

            user =  (User) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException("파일을 찾을 수 없습니다." + e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        //List<User> users = load(directory);
        return load(directory);
    }

    @Override
    public User update(UUID userId, String userName, String email, String password) {
        return null;
    }

    @Override
    public void delete(UUID userId) {
        Path filePath = directory.resolve(userId.toString().concat(".ser"));
        try{
            Files.delete(filePath);
        }
        catch (IOException e){
            System.out.println("사용자를 찾을 수 없습니다." + e.getMessage());
        }



    }


}

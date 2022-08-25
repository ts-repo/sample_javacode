package com.app.boot.service;

import com.app.boot.dto.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

//    ユーザー情報リポジトリ
//    private UserRepository userRepository;

//    public List<User> serarchAll(){
//        return userRepository.findAll();
//    }

    public List<User> getDemoList(){
        List<User> demoList = new ArrayList<>();

        //TODO Repositoryからの取得に変更する
        User demoForm1 = new User();
        User demoForm2 = new User();
        demoForm1.setId(1);
        demoForm1.setName("新車一郎");
        LocalDate date = LocalDate.now();
        demoForm1.setDatee(date.minusDays(100));
        demoForm2.setId(2);
        demoForm2.setName("新車二郎");
        demoForm2.setDatee(date.minusDays(10));

        demoList.add(demoForm1);
        demoList.add(demoForm2);

        // Mapへの置き換え

        return demoList;
    }
}

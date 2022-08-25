package com.app.boot.controller;


import com.app.boot.dto.User;
import com.app.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes(types = User.class)
public class TestController {

    @Autowired
    private UserService demoService;

//    /**
//     * Formオブジェクトを初期化して返却する
//     * @return Formオブジェクト
//     */
//    @ModelAttribute("demoForm")
//    public DemoForm createDemoForm(){
//        DemoForm demoForm = new DemoForm();
//        demoForm.setName("test太郎");
//        return demoForm;
//    }
//
//    /**
//     * 入力画面に遷移する
//     * @param demoForm Formオブジェクト
//     * @return 入力画面へのパス
//     */
//    @GetMapping("/")
//    public String index(DemoForm demoForm){
//        return "input";
//    }
//
//    /**
//     * 確認画面に遷移する
//     * @param demoForm Formオブジェクト
//     * @return 確認画面へのパス
//     */
//    @PostMapping("/confirm")
//    public String confirm(DemoForm demoForm){
//        return "confirm";
//    }
//
//    /**
//     * 完了画面へのリダイレクトパスに遷移する
//     * @return 完了画面へのリダイレクトパス
//     */
//    @PostMapping("/send")
//    public String send(DemoForm demoForm){
//        return "redirect:/complete";
//    }
//
//    /**
//     * 完了画面に遷移する
//     * @Param sessionStatus
//     * @return 完了画面へのリダイレクトパス
//     */
//    @GetMapping("/complete")
//    public String complete(SessionStatus sessionStatus){
//        // セッションオブジェクトを破棄
//        sessionStatus.setComplete();
//        return "complete";
//    }

    /**
     * 入力画面に遷移する
     * @return 入力画面へのパス
     */
    @GetMapping("/test")
    public String index(Model model){
        List<User> demoList = demoService.getDemoList();
        model.addAttribute("list", demoList);
        return "test";
    }
}

package com.app.boot.controller;


import com.app.boot.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(types = User.class)
public class DemoController {


    /**
     * Formオブジェクトを初期化して返却する
     * @return Formオブジェクト
     */
    @ModelAttribute("demoForm")
    public User createDemoForm(){
        User demoForm = new User();
        demoForm.setName("test太郎");
        return demoForm;
    }

    /**
     * 入力画面に遷移する
     * @param demoForm Formオブジェクト
     * @return 入力画面へのパス
     */
    @GetMapping("/")
    public String index(User demoForm){
        return "input";
    }

    /**
     * 確認画面に遷移する
     * @param demoForm Formオブジェクト
     * @return 確認画面へのパス
     */
    @PostMapping("/confirm")
    public String confirm(User demoForm){
        return "confirm";
    }

    /**
     * 完了画面へのリダイレクトパスに遷移する
     * @return 完了画面へのリダイレクトパス
     */
    @PostMapping("/send")
    public String send(User demoForm){
        return "redirect:/complete";
    }

    /**
     * 完了画面に遷移する
     * @Param sessionStatus
     * @return 完了画面へのリダイレクトパス
     */
    @GetMapping("/complete")
    public String complete(SessionStatus sessionStatus){
        // セッションオブジェクトを破棄
        sessionStatus.setComplete();
        return "complete";
    }
}

package com.app.boot.servlet;

import com.app.boot.servlet.dto.WizardForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@SessionAttributes(value = {"wizardForm"})
public class HelloServlet extends HttpServlet {


    @ModelAttribute(value = "wizardForm") // (1)
    public WizardForm setUpWizardForm() {
        return new WizardForm();
    }

    // sessionに値セット

    /**
     * create session
     *
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "session1")
    public String createSession1(WizardForm form,
                                 Model model) {
        form.setName("aaaaaaa");
        model.addAttribute(form); // (3)
        return "createAccount";
    }


    // sessionの値確認

    /**
     * check session
     *
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "session2")
    public String checkSession(WizardForm form,
                               Model model) {

        System.out.println(form.getName());

        model.addAttribute(form); // (3)
        return "createAccount";
    }


    /**
     * delete session
     *
     * @param form
     * @param model
     * @param sessionStatus
     * @return
     */
    @RequestMapping(value = "session3")
    public String deleteSession(WizardForm form,
                                Model model, SessionStatus sessionStatus) {

        if (form.getName() != null) {
            System.out.println("sessionを破棄します" + form.getName());
            sessionStatus.setComplete();
            System.out.println("sessionを破棄しました");
            System.out.println(form.getName()); //sessionStatus.setComplete();が呼び出されてすぐに破棄されないのでこの時点では、まだ表示される。

        }
        model.addAttribute(form); // (3)
        return "createAccount";
    }

    @GetMapping("/aaa")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=Shift_JIS");
        Cookie cookie = new Cookie("visited", "1");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>セッションテスト</title>");
        out.println("</head>");
        out.println("<body>");

        if (session == null) {
            out.println("<p>セッションは存在しません。開始します</p>");
            session = request.getSession(true);
        } else {
            out.println("<p>セッション開始してます</p>");
        }
        response.addCookie(cookie);
        out.println("<a href=¥>再表示</a>");

        out.println("</body>");
        out.println("</html>");


        Cookie[] cookies = request.getCookies();
        Cookie visitedCookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("visited")) {
                out.println(cookies[i].getValue());
                visitedCookie = cookies[i];
            }
        }
        if (visitedCookie != null) {
            int visitedInt = Integer.parseInt(visitedCookie.getValue());
            visitedCookie.setValue(Integer.toString(visitedInt + 1));
            response.addCookie(visitedCookie);
        }
    }

    @GetMapping("/session")
    public void doSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=Shift_JIS");


        PrintWriter out = response.getWriter();


        HttpSession session = request.getSession(false);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>セッションテスト</title>");
        out.println("</head>");
        out.println("<body>");

        if (session == null) {
            out.println("<p>セッションは存在しません。開始します</p>");
            session = request.getSession(true);
        } else {
            out.println("<p>セッション開始してます</p>");
        }

        out.println("<a href=¥>再表示</a>");

        out.println("</body>");
        out.println("</html>");

        System.out.println(session.getId());

        Cookie[] cookies = request.getCookies();
        Cookie visitedCookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("visited")) {
                out.println(cookies[i].getValue());
                visitedCookie = cookies[i];
            }
        }
        if (visitedCookie != null) {
            int visitedInt = Integer.parseInt(visitedCookie.getValue());
            visitedCookie.setValue(Integer.toString(visitedInt + 1));
            response.addCookie(visitedCookie);
        }
    }

    @GetMapping("/loginForm")
    public String getLoginForm() {
        return "loginForm";
    }

    @GetMapping("/createAccount")
    public String getcreateAccount() {
        return "createAccount";
    }

    //    @SessionAttributes(value = {"accountCreateForm"})
    @PostMapping("/createAccount")
    public String postCreateAccount(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

        if (name.equals("aaa") && email.equals("user@aaa") && password.equals("aaa")) {
            return "confirm";
        }

        return "createAccount";
    }


    @PostMapping("/login")
    public String getLoginForm(@RequestParam String name, @RequestParam String mailAddress, @RequestParam String password) {
        return "login";
    }

}

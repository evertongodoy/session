package br.senac.sp.session.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(HttpSession session, Model model) {
        int sessionTimeout = session.getMaxInactiveInterval(); // Tempo de timeout da sessão em segundos
        model.addAttribute("sessionTimeout", sessionTimeout); // Adiciona ao modelo
        System.out.println("----> tempo do timeout " + sessionTimeout);
        return "inicio";
    }

    @GetMapping("/pagina1")
    public String pagina1() {
        return "pagina1";
    }

    @GetMapping("/pagina2")
    public String pagina2() {
        return "pagina2";
    }

    @GetMapping("/pagina3")
    public String pagina3() {
        return "pagina3";
    }

}
package br.senac.sp.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio() {
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
package br.senac.sp.session.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(HttpSession session, Model model) {
        // Recuperar o nome de usuário do SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Nome do usuário logado

        // Armazenar o nome de usuário na sessão (caso você precise de algo persistente)
        session.setAttribute("usuario", username);

        // Passar o nome de usuário para o modelo para ser exibido
        model.addAttribute("usuarioLogado", session.getAttribute("usuario"));

        int sessionTimeout = session.getMaxInactiveInterval(); // Tempo de timeout da sessão em segundos
        model.addAttribute("sessionTimeout", sessionTimeout); // Adiciona ao modelo
        System.out.println("----> tempo do timeout " + sessionTimeout);
        return "inicio";
    }

    @GetMapping("/pagina1")
    public String pagina1(HttpSession session, Model model) {
        int sessionTimeout = session.getMaxInactiveInterval(); // Tempo de timeout da sessão em segundos
        model.addAttribute("sessionTimeout", sessionTimeout); // Adiciona ao modelo
        System.out.println("----> tempo do timeout " + sessionTimeout);
        return "pagina1";
    }

    @GetMapping("/pagina2")
    public String pagina2(HttpSession session, Model model) {
        int sessionTimeout = session.getMaxInactiveInterval(); // Tempo de timeout da sessão em segundos
        model.addAttribute("sessionTimeout", sessionTimeout); // Adiciona ao modelo
        System.out.println("----> tempo do timeout " + sessionTimeout);
        return "pagina2";
    }

    @GetMapping("/pagina3")
    public String pagina3(HttpSession session, Model model) {
        int sessionTimeout = session.getMaxInactiveInterval(); // Tempo de timeout da sessão em segundos
        model.addAttribute("sessionTimeout", sessionTimeout); // Adiciona ao modelo
        System.out.println("----> tempo do timeout " + sessionTimeout);
        return "pagina3";
    }

}
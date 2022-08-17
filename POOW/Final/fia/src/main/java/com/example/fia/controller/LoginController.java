package com.example.fia.controller;

import com.example.fia.dao.UsuarioDao;
import com.example.fia.model.Usuario;
import com.example.fia.service.UsuarioService;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String logar(Model model, Usuario Usuario) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String logar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attributes, HttpServletRequest req) throws PSQLException {



        boolean autenticado = new UsuarioService().autenticacao(usuario.getEmail(), usuario.getSenha());

        if (autenticado) {

            Usuario user = new UsuarioDao().getUsuario(usuario.getEmail());

            HttpSession session = req.getSession();
            session.setAttribute("usuario_logado", user);

            return "dashboard";

        } else {
            attributes.addFlashAttribute("erro", true);
            return "login";
        }

    }

    @GetMapping("/voltar")
    public String voltar(){return "dashboard";}

    @GetMapping("/sair")
    public RedirectView sair(HttpServletRequest req) {
        RedirectView redirect = new RedirectView("/fia/login");
        req.getSession().invalidate();

        return redirect;
    }

}

package com.example.fia.controller;

import com.example.fia.dao.EquipeDao;
import com.example.fia.model.Equipe;
import com.example.fia.service.EquipeService;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/equipe")
public class EquipeController {


    @GetMapping("/cadastrarEquipe")
    public String cadastrarEquipe(Model model){
        model.addAttribute("equipe",new Equipe());
        model.addAttribute("equipes", new EquipeDao().getEquipes());
        return "cadastroEquipe";
    }

    @PostMapping("/cadastrarEquipe")
    public RedirectView  cadastrarEquipe(@ModelAttribute("equipe")Equipe equipe, RedirectAttributes attributes) throws PSQLException {
        RedirectView redirect = new RedirectView("/fia/equipe/cadastrarEquipe");
        new EquipeDao().setEquipe(equipe);

        System.out.println("tentando cadastrar");
        return redirect;
    }

    @GetMapping("/editarEquipe")
    public String editarEquipe(Model model, @RequestParam("e")int e){
        model.addAttribute("equipe",new Equipe());
        Equipe equipe = new EquipeService().pegar(e);
        model.addAttribute("equipe",equipe);
        return "editarEquipe";
    }

    @PostMapping("/editarEquipe")
    public RedirectView editarEquipe(@ModelAttribute("equipe")Equipe equipe){
        RedirectView redirect = new RedirectView("/fia/equipe/cadastrarEquipe");
        new EquipeDao().editarEquipe(equipe);
        return redirect;

    }

    @GetMapping("/excluirEquipe")
    public String excluirEquipe(Model model, @RequestParam("e")int e){
        System.out.println("tentando excluir equipe");
        model.addAttribute("equipe",new Equipe());
        new EquipeDao().excluirEquipe(e);
        model.addAttribute("equipes", new EquipeDao().getEquipes());
        return "cadastroEquipe";
    }




}

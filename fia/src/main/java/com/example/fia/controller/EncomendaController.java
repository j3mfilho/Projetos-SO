package com.example.fia.controller;


import com.example.fia.dao.EncomendaDao;
import com.example.fia.dao.EquipeDao;
import com.example.fia.dao.ProdutoDao;
import com.example.fia.model.Encomenda;
import com.example.fia.service.EncomendaService;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="/encomenda")
public class EncomendaController {


    @GetMapping("/cadastrarEncomenda")
    public String cadastrarEncomenda(Model model){
        model.addAttribute("encomenda",new Encomenda());
        model.addAttribute("equipe",new EquipeDao().getEquipes());
        model.addAttribute("produto",new ProdutoDao().getProdutos());
        model.addAttribute("encomendas", new EncomendaDao().getEncomendass());

        return "cadastroEncomenda";
    }

    @PostMapping("/cadastrarEncomenda")
    public RedirectView cadastrarEncomenda(@ModelAttribute("encomenda")Encomenda encomenda, RedirectAttributes attributes,Model model) throws PSQLException {
        RedirectView redirect = new RedirectView("/fia/encomenda/cadastrarEncomenda");
        new EncomendaDao().setEncomenda(encomenda);
        return redirect;

    }

    @GetMapping("/editarEncomenda")
    public String editarEncomenda(Model model, @RequestParam("id")int id){
        model.addAttribute("encomenda", new EncomendaService().pegarEn(id));
        model.addAttribute("equipe",new EquipeDao().getEquipes());
        model.addAttribute("produto",new ProdutoDao().getProdutos());
        return "editarEncomenda";
    }

    @PostMapping("/editarEncomenda")
    public RedirectView editarEncomenda(@ModelAttribute("encomenda")Encomenda encomenda){
        RedirectView redirect = new RedirectView("/fia/encomenda/cadastrarEncomenda");


        new EncomendaDao().editarEncomenda(encomenda);

        return redirect;

    }

    @GetMapping("/excluirEncomenda")
    public String excluirEncomenda(Model model, @RequestParam("id")int id){
        model.addAttribute("encomenda",new Encomenda());
        new EncomendaDao().excluirEncomenda(id);
        model.addAttribute("encomendas", new EncomendaDao().getEncomendass());
        return "cadastroEncomenda";
    }

}
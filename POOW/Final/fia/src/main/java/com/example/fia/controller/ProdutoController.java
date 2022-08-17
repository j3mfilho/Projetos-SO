package com.example.fia.controller;

import com.example.fia.dao.EquipeDao;
import com.example.fia.dao.ProdutoDao;
import com.example.fia.model.Produto;
import com.example.fia.service.ProdutoService;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {
    private ProdutoService produtoService;


    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    @GetMapping("/cadastrarProduto")
    public String cadastrarProd(Model model){
        model.addAttribute("produto",new Produto());
        model.addAttribute("produtos", new ProdutoDao().getProdutos());
        return "cadastroProduto";
    }

    @PostMapping("/cadastrarProduto")
    public String logar(@ModelAttribute("produto")Produto produto, RedirectAttributes attributes, Model model) throws PSQLException {
        System.out.println("___CONTROLLER___");
        System.out.println(produto.getId());
        System.out.println("Nome:"+produto.getNome());
        System.out.println("Preço:"+produto.getValor());
        model.addAttribute("produto", new ProdutoDao().getProdutos());
       new ProdutoService().cadastro(produto);

        return "redirect:/produto/cadastrarProduto";

    }

    @GetMapping("/editarProduto")
    public String editarProd(Model model, @RequestParam("n")int n){
        model.addAttribute("produto",new Produto());
      Produto produto =new ProdutoService().pegar(n);
        model.addAttribute("produto",produto);
       return "editarProduto";
    }

    @PostMapping("/editarProduto")
    public RedirectView editarProd(@ModelAttribute("produto")Produto produto){
        RedirectView redirect = new RedirectView("/fia/produto/cadastrarProduto");

        System.out.println("___CONTROLLER___");
        System.out.println("Nome:"+produto.getNome());
        System.out.println("Preço:"+produto.getValor());

        new ProdutoDao().editarProduto(produto);

        return redirect;

    }

    @GetMapping("/excluirProduto")
    public RedirectView excluirProd(@RequestParam("n")int n, RedirectAttributes attributes){
        new ProdutoDao().excluirProduto(n);
        RedirectView redirect = new RedirectView("/fia/produto/cadastrarProduto");
        attributes.addFlashAttribute("excluiu", true);

        return redirect;
    }

}

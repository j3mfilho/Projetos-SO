package com.example.fia.service;

import com.example.fia.dao.EncomendaDao;
import com.example.fia.model.Encomenda;

import java.util.List;

public class EncomendaService {

    public static Encomenda cadastroEn(Encomenda encomenda){

        System.out.println("___ENCOMENDA SERVICE___");
        System.out.println("ID:"+encomenda.getId());

        return null;
    }

    public Encomenda pegarEn(int x){
        System.out.println("Nome editar encomenda:"+x);
        Encomenda encomenda= new EncomendaDao().getEncomendas(x);
        return encomenda;
    }

    public static List<Encomenda> getEncomendas() {
        return new EncomendaDao().getEncomendass();
    }

}

package com.example.fia.service;

import com.example.fia.model.Equipe;
import com.example.fia.dao.EquipeDao;
import com.example.fia.model.Equipe;

public class EquipeService {

    public static Equipe cadastroE(Equipe equipe){

        System.out.println("___ENDERECO SERVICE___");
        System.out.println("Nome:"+ equipe.getNome());
        System.out.println("Endereco:" + equipe.getEndereco());



        return null;
    }

    public Equipe pegar(int n){
        System.out.println("Nome editar cliente:"+n);
        Equipe equipe= new EquipeDao().equipeID(n);
        return equipe;
    }




}

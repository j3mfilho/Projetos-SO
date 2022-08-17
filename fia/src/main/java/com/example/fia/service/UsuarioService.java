package com.example.fia.service;

import com.example.fia.dao.UsuarioDao;
import com.example.fia.model.Usuario;

public class UsuarioService {

    public boolean autenticacao(String email, String senha)  {
        if(email!="" && senha!=""){
            System.out.println("___SERVICE___");
            System.out.println("Email:"+email);
            System.out.println("Senha:"+senha);

            Usuario us = new UsuarioDao().getUsuario(email);

            if( us!= null){


                System.out.println("___SERVICE___");
                System.out.println("Dados retornado do DAO para SERVICE:");
                System.out.println("Id:"+ us.getId());
                System.out.println("Nome:"+ us.getNome());
                System.out.println("Email:"+ us.getEmail());
                System.out.println("Senha:"+ us.getSenha());

                if(us.getEmail().equals(email) && us.getSenha().equals(senha)){
                    return  true;
                }

            }
        }
        return false;
    }

}

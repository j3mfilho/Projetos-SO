package com.example.fia.dao;

import com.example.fia.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private String status;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String sql;

    public Usuario getUsuario(String email) {
        System.out.println("___DAO___");
        System.out.println("Email a ser verificado:" + email);

        Usuario u = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "SELECT * FROM usuario WHERE email=?";

            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, email);

            this.resultSet = this.preparedStatement.executeQuery();

            while(resultSet.next()){
                u = new Usuario();
                u.setId((int) resultSet.getInt("id_usuario"));
                u.setNome(resultSet.getString("nome"));
                u.setEmail(resultSet.getString("email"));
                u.setSenha(resultSet.getString("senha"));

                System.out.println("Usuario encontrado no banco:"+u.getNome());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public Usuario setUsuario(Usuario u) throws SQLException {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "INSERT INTO usuario (nome, email, senha, ativo, id_permissao) VALUES (?, ?, ?, ?, ?)";
            System.out.println(u.getNome());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, u.getNome());
            preparedStatement.setString(2, u.getEmail());
            preparedStatement.setString(3,u.getSenha());
            preparedStatement.setBoolean(4, true);
            preparedStatement.setInt(5, 2);
            preparedStatement.execute();
        }

        return u;
    }


}

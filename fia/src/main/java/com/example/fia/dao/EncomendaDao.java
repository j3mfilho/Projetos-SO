package com.example.fia.dao;

import com.example.fia.model.Encomenda;


import java.sql.*;
import java.util.ArrayList;

public class EncomendaDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private Statement stmt;
    private ResultSet resultSet;
    private String status;


    public Encomenda getEncomendas(int id){
        Encomenda encomenda = null;


        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = " SELECT * FROM encomenda WHERE id_encomenda = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println(this.sql);
            while (resultSet.next()){
                encomenda = new Encomenda();
                encomenda.setId(resultSet.getInt("id_encomenda"));
                encomenda.setQuantidade(resultSet.getInt("quantidade"));
                encomenda.setEquipe(new EquipeDao().getEquipes(resultSet.getInt("id_equipe")));
                encomenda.setProduto(new ProdutoDao().getProdutos(resultSet.getInt("id_produto")));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return encomenda;
    }
    public Encomenda setEncomenda(Encomenda en) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "INSERT INTO encomenda (id_equipe, id_produto, quantidade) VALUES (?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, en.getEquipe().getId());
            this.preparedStatement.setInt(2,en.getProduto().getId());
            this.preparedStatement.setFloat(3, en.getQuantidade());
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return en;
    }

    public ArrayList<Encomenda> getEncomendass(){
        ArrayList<Encomenda> encomendas = new ArrayList<>();
        try(Connection connection = new ConectaDBPostgres().getConexao()) {
            this.sql = "SELECT * FROM encomenda";
            this.stmt = connection.createStatement();
            this.resultSet = this.stmt.executeQuery(sql);

            while (this.resultSet.next()) {
                Encomenda encomenda = new Encomenda();
                encomenda.setId(resultSet.getInt("id_encomenda"));
                encomenda.setQuantidade(resultSet.getInt("quantidade"));
                encomenda.setEquipe(new EquipeDao().getEquipes(resultSet.getInt("id_equipe")));
                encomenda.setProduto(new ProdutoDao().getProdutos(resultSet.getInt("id_produto")));
                encomendas.add(encomenda);

            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return encomendas;
    }

    public String editarEncomenda(Encomenda encomenda){
        try(Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql= "UPDATE encomenda SET id_equipe=?, id_produto=?, quantidade=? WHERE id_encomenda= ?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, encomenda.getEquipe().getId());
            this.preparedStatement.setInt(2, encomenda.getProduto().getId());
            this.preparedStatement.setInt(3, encomenda.getQuantidade());
            this.preparedStatement.setInt(4, encomenda.getId());
            this.preparedStatement.executeUpdate();
            if(this.preparedStatement.getUpdateCount() > 0){
                this.status= "Encomenda editada com sucesso!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }


    public String excluirEncomenda(int id){
        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql= "DELETE FROM encomenda WHERE id_encomenda=?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status="Encomenda excluída com sucessp!";
    }


    public void addEncomenda(Encomenda encomenda) {
    }



}

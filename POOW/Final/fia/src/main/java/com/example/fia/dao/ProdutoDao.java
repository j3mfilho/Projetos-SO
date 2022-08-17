package com.example.fia.dao;


import com.example.fia.model.Produto;

import java.sql.*;
import java.util.ArrayList;


public class ProdutoDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private Statement stmt;
    private ResultSet resultSet;
    private String status;


    public Produto getProdutos(int id_produto){
        Produto produto = null;


        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = " SELECT * FROM produto WHERE id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_produto);
            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println(this.sql);
            while (resultSet.next()){
                produto = new Produto();
                produto.setId(resultSet.getInt("id_produto"));
                produto.setNome(resultSet.getString("produto"));
                produto.setValor(resultSet.getFloat("preco"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return produto;
    }
    public Produto setProduto(Produto p) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "INSERT INTO produto (produto, preco) VALUES (?, ?)";
            System.out.println(p.getNome());
            this.preparedStatement = connection.prepareStatement(sql);

            this.preparedStatement.setString(1, p.getNome());
            this.preparedStatement.setFloat(2, p.getValor());
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> produtos = new ArrayList<>();
        try(Connection connection = new ConectaDBPostgres().getConexao()) {
            this.sql = "SELECT * FROM produto";
            this.stmt = connection.createStatement();
            this.resultSet = this.stmt.executeQuery(sql);

            while (this.resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(this.resultSet.getInt("id_produto"));
                produto.setNome(this.resultSet.getString("produto"));
                produto.setValor(this.resultSet.getFloat("preco"));

                produtos.add(produto);

            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return produtos;
    }

    public String editarProduto(Produto produto){
        try(Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql= "UPDATE produto SET produto=?, preco=? WHERE id_produto= ?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setString(1, produto.getNome());
            this.preparedStatement.setFloat(2, produto.getValor());
            this.preparedStatement.setInt(3, produto.getId());
            this.preparedStatement.executeUpdate();
            if(this.preparedStatement.getUpdateCount() > 0){
                this.status= "Produto editado com sucesso!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public Produto buscarProduto(int id){
        Produto produto= null;
        try(Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = "SELECT * FROM produto WHERE id_produto= ?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet= this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                produto = new Produto();
                produto.setId(id);
                produto.setNome(this.resultSet.getString("produto"));
                produto.setValor(this.resultSet.getFloat("preco"));

            }

        }catch (SQLException e){
            e.printStackTrace();
            this.status= "error";
        }

        return produto;
    }

    public int  excluirProduto(int n){
        int l;
        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql= "DELETE FROM produto WHERE id_produto=?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, n);
            this.preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l=0;
    }


    public void addProduto(Produto produto) {
    }

    public Produto recuperar(int id){
        Produto produto = null;


        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = " SELECT * FROM produto WHERE id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println(this.sql);
            while (resultSet.next()){
                produto = new Produto();
                produto.setId(resultSet.getInt("id_produto"));
                produto.setNome(resultSet.getString("produto"));
                produto.setValor(resultSet.getFloat("preco"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return produto;
    }

    public Produto pegarId (int id){
        Produto produto = null;


        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = " SELECT * FROM produto WHERE id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println(this.sql);
            while (resultSet.next()){
                produto = new Produto();
                produto.setId(resultSet.getInt("id_produto"));
                produto.setNome(resultSet.getString("produto"));
                produto.setValor(resultSet.getFloat("preco"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return produto;
    }
}

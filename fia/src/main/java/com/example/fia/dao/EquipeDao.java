package com.example.fia.dao;

import com.example.fia.model.Equipe;

import java.sql.*;
import java.util.ArrayList;

public class EquipeDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private Statement stmt;
    private ResultSet resultSet;
    private String status;


    public Equipe getEquipes(int id_equipe){
        Equipe equipe = null;


        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = " SELECT * FROM equipe WHERE id_equipe = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_equipe);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                equipe = new Equipe();
                equipe.setId(resultSet.getInt("id_equipe"));
                equipe.setNome(resultSet.getString("equipe"));
                equipe.setEndereco(resultSet.getString("endereco"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return equipe;
    }
    public Equipe setEquipe(Equipe eq) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "INSERT INTO equipe (equipe, endereco) VALUES (?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, eq.getNome());
            this.preparedStatement.setString(2, eq.getEndereco());
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eq;
    }

    public ArrayList<Equipe> getEquipes(){
        ArrayList<Equipe> equipes = new ArrayList<>();
        try(Connection connection = new ConectaDBPostgres().getConexao()) {
            this.sql = "SELECT * FROM equipe";
            this.stmt = connection.createStatement();
            this.resultSet = this.stmt.executeQuery(sql);

            while (this.resultSet.next()) {
                Equipe equipe = new Equipe();
                equipe.setId(this.resultSet.getInt("id_equipe"));
                equipe.setNome(this.resultSet.getString("equipe"));
                equipe.setEndereco(this.resultSet.getString("endereco"));

                equipes.add(equipe);

            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return equipes;
    }

    public String editarEquipe(Equipe equipe){
        try(Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql= "UPDATE equipe SET equipe=?, endereco=? WHERE id_equipe= ?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setString(1, equipe.getNome());
            this.preparedStatement.setString(2, equipe.getEndereco());
            this.preparedStatement.setInt(3, equipe.getId());
            this.preparedStatement.executeUpdate();
            if(this.preparedStatement.getUpdateCount() > 0){
                this.status= "Equipe editada com sucesso!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public Equipe buscarEquipe(int id){
        Equipe equipe= null;
        try(Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = "SELECT * FROM equipe WHERE id_equipe= ?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet= this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                equipe = new Equipe();
                equipe.setId(id);
                equipe.setNome(this.resultSet.getString("equipe"));
                equipe.setEndereco(this.resultSet.getString("endereco"));

            }

        }catch (SQLException e){
            e.printStackTrace();
            this.status= "error";
        }

        return equipe;
    }

    public String excluirEquipe(int id){
        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql= "DELETE FROM equipe WHERE id_equipe=?";
            this.preparedStatement= connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status="Equipe excluída com sucesso!";
    }

    public Equipe equipeID (int id){
       Equipe equipe  = null;


        try (Connection connection = new ConectaDBPostgres().getConexao()){
            this.sql = " SELECT * FROM equipe WHERE id_equipe = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                equipe = new Equipe();
                equipe .setId(resultSet.getInt("id_equipe"));
                equipe .setNome(resultSet.getString("equipe"));
                equipe .setEndereco(resultSet.getString("endereco"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return equipe;
    }

}

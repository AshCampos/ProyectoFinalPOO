package org.example.persistencia;

import org.example.modelo.Naruto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemoNarutoDB {

    public DemoNarutoDB() {
    }
    public void insertarStatement(){
        String elPersonaje = "Rock lee";
        String suOcupacion = "Ninja bajo";
        String suAldea = "Konoha";
        String suClan = "Lee";
        String suURL = "https://images.mubicdn.net/images/avatars/530704/cache-530704-1666338957/images-large.jpg?size=280x280";

        try{
            Statement stm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().createStatement();

            String sqlInsert = "INSERT INTO Naruto(Personaje,Ocupacion,Aldea,Clan,URL) VALUES('"+ elPersonaje
                    +"','" + suOcupacion + "','"+ suAldea +"','"+ suClan +"','"+ suURL +"')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("se insertaron "+ rowCount + "registros");
        }catch(SQLException sqle){
            System.out.println("Error al conectar" + sqle.getMessage());
        }

    }
    public void insertarPreparedStatement(){
        String elPersonaje = "Gaara";
        String suOcupacion = "Comandante del ejercito shinobi";
        String suAldea = "Suna";
        String suClan = "Akasuna";
        String suURL = "https://i.pinimg.com/280x280_RS/db/cf/31/dbcf31c778c5d1b7ffdf02d0c1554e37.jpg";
        String sqlInsert = "INSERT INTO Naruto(Personaje,Ocupacion,Aldea,Clan,URL) VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,elPersonaje);
            pstm.setString(2,suOcupacion);
            pstm.setString(3,suAldea);
            pstm.setString(4,suClan);
            pstm.setString(5,suURL);
            int rowCount = pstm.executeUpdate();
            System.out.println("se insertaron "+ rowCount + "registros");
        }catch(SQLException sqle){
            System.out.println("Error prepared statement" + sqle.getMessage());
        }
    }
    public boolean insertarNaruto(Naruto naruto){
        String sqlInsert = "INSERT INTO Naruto(Personaje,Ocupacion,Aldea,Clan,URL) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        try{
            PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,naruto.getPersonaje());
            pstm.setString(2,naruto.getOcupacion());
            pstm.setString(3,naruto.getAldea());
            pstm.setString(4,naruto.getClan());
            pstm.setString(5,naruto.getUrl());
            rowCount = pstm.executeUpdate();
        }catch(SQLException sqle){
            System.out.println("Error prepared statement" + sqle.getMessage());
        }
        return rowCount > 0;
    }

    public Naruto buscarPersonajeporId (int id){
        String sql = "SELECT * FROM Naruto WHERE ID = ? ;";
        Naruto persona = null;
        try{
            PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rst = pstm.executeQuery();
            if(rst.next()){
                persona = new Naruto(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            }
        }catch (SQLException sqle){
            System.out.println("Error al buscar");
        }
        return persona;
    }
    public ArrayList<Naruto> obtenerTodos(){
        String sql = "SELECT * FROM Naruto";
        ArrayList<Naruto> resultado = new ArrayList<>();
        try{
            Statement stm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                 resultado.add(new Naruto(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
            }
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}

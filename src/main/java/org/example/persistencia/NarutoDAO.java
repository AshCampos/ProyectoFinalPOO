package org.example.persistencia;

import org.example.modelo.Naruto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NarutoDAO implements InterfazDAO{

    public NarutoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Naruto(Personaje,Ocupacion,Aldea,Clan,URL) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Naruto)obj).getPersonaje());
        pstm.setString(2,((Naruto)obj).getOcupacion());
        pstm.setString(3,((Naruto)obj).getAldea());
        pstm.setString(4,((Naruto)obj).getClan());
        pstm.setString(5,((Naruto)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Naruto SET Personaje = ?,Ocupacion = ?,Aldea = ?,Clan = ?,URL = ? WHERE ID = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Naruto)obj).getPersonaje());
        pstm.setString(2,((Naruto)obj).getOcupacion());
        pstm.setString(3,((Naruto)obj).getAldea());
        pstm.setString(4,((Naruto)obj).getClan());
        pstm.setString(5,((Naruto)obj).getUrl());
        pstm.setInt(6,((Naruto)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Naruto WHERE ID = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sqlDelete);
        //Se preparan valores para el comodin
        pstm.setInt(1,Integer.parseInt(id));
        //se le asigna el statement al rowCount
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Naruto";
        ArrayList<Naruto> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Naruto(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
            }

        return resultado;

    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Naruto WHERE ID = ? ;";
        Naruto persona = null;

            PreparedStatement pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if(rst.next()){
                persona = new Naruto(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
               return persona;
            }

        return null;

    }
}

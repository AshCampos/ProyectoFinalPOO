package org.example.modelo;

import org.example.persistencia.NarutoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaNaruto implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Naruto> datos;
    private NarutoDAO ndao;

    public ModeloTablaNaruto() {
        ndao = new NarutoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaNaruto(ArrayList<Naruto> datos) {
        this.datos = datos;
        ndao = new NarutoDAO();
    }


    @Override
    public int getRowCount() {
      return datos.size();

    }

    @Override
    public int getColumnCount() {

        return COLUMNS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch(rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Personaje";
            case 2:
                return "Ocupacion";
            case 3:
                return "Aldea";
            case 4:
                return "Clan";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch(rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Naruto tmp = datos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getPersonaje();
            case 2:
                return tmp.getOcupacion();
            case 3:
                return tmp.getAldea();
            case 4:
                return tmp.getClan();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         switch(columnIndex){
             case 0:
                 //datso.get(rowIndex).setId();
                 break;
             case 1:
                 datos.get(rowIndex).setPersonaje((String) aValue);
                 break;
             case 2:
                 datos.get(rowIndex).setOcupacion((String) aValue);
                 break;
             case 3:
                 datos.get(rowIndex).setAldea((String) aValue);
                 break;
             case 4:
                 datos.get(rowIndex).setClan((String) aValue);
                 break;
             case 5:
                 datos.get(rowIndex).setUrl((String) aValue);
                 break;
             default:
                 System.out.println("No se modifica nada ");

         }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarDatos(){
        try{
            ArrayList<Naruto> poner = ndao.obtenerTodo();
            System.out.println(poner);
            datos = ndao.obtenerTodo();
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }
    public boolean agregarPersonaje(Naruto personaje){
        boolean resul = false;
      try{
          if(ndao.insertar(personaje)){
              datos.add((personaje));
              resul = true;
      }else{
              resul = false;
          }
        }catch(SQLException sqle){
          System.out.println(sqle.getMessage());
      }
      return resul;
    }
    public Naruto getPersonajeAtIndex(int idx){
         return datos.get(idx);
            }
            public boolean actualizar(Naruto personaje){
        boolean resul = false;
        try{
            if(ndao.update(personaje)){
                datos.add(personaje);
                resul = true;
            }else{
              resul = false;
            }
        }catch(SQLException sqle){
            System.out.println("Error, no se pudo actualizar");
            System.out.println(sqle.getMessage());
        }
        return resul;
            }

}

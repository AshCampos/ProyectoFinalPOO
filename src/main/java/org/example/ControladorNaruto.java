package org.example;

import org.example.modelo.ModeloTablaNaruto;
import org.example.modelo.Naruto;
import org.example.persistencia.ConexionSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorNaruto extends MouseAdapter {
    private Ventana view;
    private ModeloTablaNaruto modelo;

    public ControladorNaruto(Ventana view) {
        this.view = view;
        modelo = new ModeloTablaNaruto();
        this.view.getTblNaruto().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblNaruto().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnCargar()){

            modelo.cargarDatos();
            this.view.getTblNaruto().setModel(modelo);
            this.view.getTblNaruto().updateUI();

        }
        if(e.getSource() == this.view.getBtnAgregar()){
            Naruto pers = new Naruto();
            pers.setId(0);
            pers.setPersonaje(this.view.getTxtPersonaje().getText());
            pers.setOcupacion(this.view.getTxtOcupacion().getText());
            pers.setAldea(this.view.getTxtAldea().getText());
            pers.setClan(this.view.getTxtClan().getText());
            pers.setUrl(this.view.getTxtURL().getText());

            if (modelo.agregarPersonaje(pers)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente","AVISO",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblNaruto().updateUI();
            }else{
                JOptionPane.showMessageDialog(view,"No se pudo agregar correctamente a la base de datos. Revise su conexion", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }
        if (e.getSource() == this.view.getTblNaruto()){
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTblNaruto().getSelectedRow();
            Naruto tmp = modelo.getPersonajeAtIndex(index);

            try{
                this.view.getImagenPersonaje().setIcon(tmp.getImagen());
                //this.view.getImagenPersonaje().setText("");
            }catch(MalformedURLException mfue){
                System.out.println(e.toString());
            }


        }
        if(e.getSource() == this.view.getBtnActualizar()){
            int resul = JOptionPane.showConfirmDialog(view,"¿Quieres actualizar el registro?","ATENCION",JOptionPane.YES_NO_OPTION);
            if(resul == 0){
                Naruto personaje = new Naruto();
                personaje.setId(Integer.parseInt((String)this.view.getTxtIdNuevo().getText()));
                personaje.setPersonaje(this.view.getTxtPersonajeNuevo().getText());
                personaje.setOcupacion(this.view.getTxtOcupacionNuevo().getText());
                personaje.setAldea(this.view.getTxtAldeaNuevo().getText());
                personaje.setClan(this.view.getTxtClanNuevo().getText());
                personaje.setUrl(this.view.getTxtURLNuevo().getText());
                this.view.getTblNaruto().updateUI();
                if(modelo.actualizar(personaje)){
                    JOptionPane.showMessageDialog(view,"Se actualizo el registro","ATENCION",JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblNaruto().updateUI();
                }else{
                    JOptionPane.showMessageDialog(view,"No se actualizo. Revisar conexion","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                this.view.limpiarNuevo();
            }else{
                this.view.limpiarNuevo();
            }
        }
       if(e.getSource() == this.view.getBtnEliminar()){
            int resultado = JOptionPane.showConfirmDialog(view,"¿Estas seguro de querer eliminar este registro?","Advertencia",JOptionPane.YES_NO_CANCEL_OPTION);
            if(resultado == 0 ){
                String sqlDelete = "DELETE FROM Naruto WHERE ID = ? ;";
                PreparedStatement pstm = null;
                try{
                    pstm = ConexionSingleton.getInstance("NarutoDB.db").getConnection().prepareStatement(sqlDelete);
                }catch(SQLException sqle){
                    throw new RuntimeException(sqle);
                }
                try{
                    pstm.setInt(1,Integer.parseInt(this.view.getTxtIdEliminar().getText()));
                    JOptionPane.showMessageDialog(view,"Se ha eliminado el registro","AVISO",JOptionPane.INFORMATION_MESSAGE);
                }catch(NumberFormatException nfe){
                 JOptionPane.showMessageDialog(view,"No se pudo eliminar","ERROR",JOptionPane.ERROR_MESSAGE);
                 }catch(SQLException sqle){
                    System.out.println(sqle.getMessage());
                    }
                try{
                    pstm.executeUpdate();
                    }catch(SQLException sqle){
                    JOptionPane.showMessageDialog(view,"No se pudo eliminar. Revisar Id","ERROR",JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(sqle);
                    }
                    this.view.limpiarNuevo();
            }

        }

    }
}

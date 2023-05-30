package org.example;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private GridLayout layout;
    private JLabel lblId;
    private JLabel lblPersonaje;
    private JLabel lblOcupacion;
    private JLabel lblAldea;
    private JLabel lblClan;
    private JLabel lblURL;
    private JTextField txtId;
    private JTextField txtPersonaje;
    private JTextField txtOcupacion;
    private JTextField txtAldea;
    private JTextField txtClan;
    private JTextField txtURL;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblNaruto;
    private JScrollPane scrollPane;
    private JLabel imagenPersonaje;

    //para ultimo panel nuevos componentes
    private JLabel lblIdNuevo;
    private JLabel lblPersonajeNuevo;
    private JLabel lblOcupacionNuevo;
    private JLabel lblAldeaNuevo;
    private JLabel lblClanNuevo;
    private JLabel lblURLNuevo;
    private JLabel lblIdEliminar;
    private JTextField txtIdNuevo;
    private JTextField txtPersonajeNuevo;
    private JTextField txtOcupacionNuevo;
    private JTextField txtAldeaNuevo;
    private JTextField txtClanNuevo;
    private JTextField txtURLNuevo;
    private JTextField txtIdEliminar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JLabel lblTitulo;
    private JLabel lblActuyEli;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(1000,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel 1 formulario
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(246, 117, 76));
        lblId = new JLabel("Id");
        lblPersonaje = new JLabel("Personaje");
        lblOcupacion = new JLabel("Ocupacion");
        lblAldea = new JLabel("Aldea");
        lblClan = new JLabel("Clan");
        lblURL = new JLabel("URL");
        lblTitulo = new JLabel("Formulario de personajes. Bienvenido. Introduzca los datos correspondientes a lo que se pide");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtPersonaje = new JTextField(20);
        txtOcupacion = new JTextField(15);
        txtAldea = new JTextField(10);
        txtClan = new JTextField(12);
        txtURL = new JTextField(50);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblTitulo);
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblPersonaje);
        panel1.add(txtPersonaje);
        panel1.add(lblOcupacion);
        panel1.add(txtOcupacion);
        panel1.add(lblAldea);
        panel1.add(txtAldea);
        panel1.add(lblClan);
        panel1.add(txtClan);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);

        //panel 2 tabla
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(255, 240, 89));
        tblNaruto = new JTable();
        scrollPane = new JScrollPane(tblNaruto);
        panel2.add(scrollPane);
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);


        //panel 3 Imagen
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(103, 100, 192));
        imagenPersonaje = new JLabel("...");
        panel3.add(imagenPersonaje);

        // panel 4 Eliminar y Actualizar
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(225, 116, 197));
        lblIdNuevo = new JLabel("Id: ");
        lblPersonajeNuevo = new JLabel("Personaje: ");
        lblOcupacionNuevo = new JLabel("Ocupacion: ");
        lblAldeaNuevo = new JLabel("Aldea: ");
        lblClanNuevo = new JLabel("Clan: ");
        lblURLNuevo = new JLabel("URL: ");
        lblActuyEli = new JLabel("Actualizar y eliminar. Introduzca el Id para eliminar algun registro o los datos para actualizar");
        txtIdNuevo = new JTextField(3);
        txtPersonajeNuevo = new JTextField(15);
        txtOcupacionNuevo = new JTextField(15);
        txtAldeaNuevo = new JTextField(10);
        txtClanNuevo = new JTextField(12);
        txtURLNuevo = new JTextField(50);
        lblIdEliminar = new JLabel("ID para eliminar:");
        txtIdEliminar = new JTextField(3);
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        panel4.add(lblActuyEli);
        panel4.add(lblIdNuevo);
        panel4.add(txtIdNuevo);
        panel4.add(lblPersonajeNuevo);
        panel4.add(txtPersonajeNuevo);
        panel4.add(lblOcupacionNuevo);
        panel4.add(txtOcupacionNuevo);
        panel4.add(lblAldeaNuevo);
        panel4.add(txtAldeaNuevo);
        panel4.add(lblClanNuevo);
        panel4.add(txtClanNuevo);
        panel4.add(lblURLNuevo);
        panel4.add(txtURLNuevo);
        panel4.add(btnActualizar);
        panel4.add(lblIdEliminar);
        panel4.add(txtIdEliminar);
        panel4.add(btnEliminar);


        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getPanel1() {

        return panel1;
    }

    public void setPanel1(JPanel panel1) {

        this.panel1 = panel1;
    }

    public JPanel getPanel2() {

        return panel2;
    }

    public void setPanel2(JPanel panel2) {

        this.panel2 = panel2;
    }

    public JPanel getPanel3() {

        return panel3;
    }

    public void setPanel3(JPanel panel3) {

        this.panel3 = panel3;
    }

    public JPanel getPanel4() {

        return panel4;
    }

    public void setPanel4(JPanel panel4) {

        this.panel4 = panel4;
    }

    @Override
    public GridLayout getLayout() {

        return layout;
    }

    public void setLayout(GridLayout layout) {

        this.layout = layout;
    }

    public JLabel getLblId() {

        return lblId;
    }

    public void setLblId(JLabel lblId) {

        this.lblId = lblId;
    }

    public JLabel getLblPersonaje() {

        return lblPersonaje;
    }

    public void setLblPersonaje(JLabel lblPersonaje) {

        this.lblPersonaje = lblPersonaje;
    }

    public JLabel getLblOcupacion() {

        return lblOcupacion;
    }

    public void setLblOcupacion(JLabel lblOcupacion) {

        this.lblOcupacion = lblOcupacion;
    }

    public JLabel getLblAldea() {

        return lblAldea;
    }

    public void setLblAldea(JLabel lblAldea) {

        this.lblAldea = lblAldea;
    }

    public JLabel getLblClan() {

        return lblClan;
    }

    public void setLblClan(JLabel lblClan) {

        this.lblClan = lblClan;
    }

    public JLabel getLblURL() {

        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {

        this.lblURL = lblURL;
    }

    public JTextField getTxtId() {

        return txtId;
    }

    public void setTxtId(JTextField txtId) {

        this.txtId = txtId;
    }

    public JTextField getTxtPersonaje() {

        return txtPersonaje;
    }

    public void setTxtPersonaje(JTextField txtPersonaje) {

        this.txtPersonaje = txtPersonaje;
    }

    public JTextField getTxtOcupacion() {

        return txtOcupacion;
    }

    public void setTxtOcupacion(JTextField txtOcupacion) {

        this.txtOcupacion = txtOcupacion;
    }

    public JTextField getTxtAldea() {

        return txtAldea;
    }

    public void setTxtAldea(JTextField txtAldea) {

        this.txtAldea = txtAldea;
    }

    public JTextField getTxtClan() {

        return txtClan;
    }

    public void setTxtClan(JTextField txtClan) {

        this.txtClan = txtClan;
    }

    public JTextField getTxtURL() {

        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {

        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {

        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {

        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {

        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {

        this.btnCargar = btnCargar;
    }
    public void limpiar(){
        txtPersonaje.setText("");
        txtOcupacion.setText("");
        txtAldea.setText("");
        txtClan.setText("");
        txtURL.setText("");
    }

    public JTable getTblNaruto() {

        return tblNaruto;
    }

    public void setTblNaruto(JTable tblNaruto) {

        this.tblNaruto = tblNaruto;
    }

    public JScrollPane getScrollPane() {

        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {

        this.scrollPane = scrollPane;
    }

    public JLabel getLblIdNuevo() {
        return lblIdNuevo;
    }

    public void setLblIdNuevo(JLabel lblIdNuevo) {
        this.lblIdNuevo = lblIdNuevo;
    }

    public JLabel getLblPersonajeNuevo() {
        return lblPersonajeNuevo;
    }

    public void setLblPersonajeNuevo(JLabel lblPersonajeNuevo) {
        this.lblPersonajeNuevo = lblPersonajeNuevo;
    }

    public JLabel getLblOcupacionNuevo() {
        return lblOcupacionNuevo;
    }

    public void setLblOcupacionNuevo(JLabel lblOcupacionNuevo) {
        this.lblOcupacionNuevo = lblOcupacionNuevo;
    }

    public JLabel getLblAldeaNuevo() {
        return lblAldeaNuevo;
    }

    public void setLblAldeaNuevo(JLabel lblAldeaNuevo) {
        this.lblAldeaNuevo = lblAldeaNuevo;
    }

    public JLabel getLblClanNuevo() {
        return lblClanNuevo;
    }

    public void setLblClanNuevo(JLabel lblClanNuevo) {
        this.lblClanNuevo = lblClanNuevo;
    }

    public JLabel getLblURLNuevo() {
        return lblURLNuevo;
    }

    public void setLblURLNuevo(JLabel lblURLNuevo) {
        this.lblURLNuevo = lblURLNuevo;
    }

    public JLabel getLblIdEliminar() {
        return lblIdEliminar;
    }

    public void setLblIdEliminar(JLabel lblIdEliminar) {
        this.lblIdEliminar = lblIdEliminar;
    }

    public JTextField getTxtIdNuevo() {
        return txtIdNuevo;
    }

    public void setTxtIdNuevo(JTextField txtIdNuevo) {
        this.txtIdNuevo = txtIdNuevo;
    }

    public JTextField getTxtPersonajeNuevo() {
        return txtPersonajeNuevo;
    }

    public void setTxtPersonajeNuevo(JTextField txtPersonajeNuevo) {
        this.txtPersonajeNuevo = txtPersonajeNuevo;
    }

    public JTextField getTxtOcupacionNuevo() {
        return txtOcupacionNuevo;
    }

    public void setTxtOcupacionNuevo(JTextField txtOcupacionNuevo) {
        this.txtOcupacionNuevo = txtOcupacionNuevo;
    }

    public JTextField getTxtAldeaNuevo() {
        return txtAldeaNuevo;
    }

    public void setTxtAldeaNuevo(JTextField txtAldeaNuevo) {
        this.txtAldeaNuevo = txtAldeaNuevo;
    }

    public JTextField getTxtClanNuevo() {
        return txtClanNuevo;
    }

    public void setTxtClanNuevo(JTextField txtClanNuevo) {
        this.txtClanNuevo = txtClanNuevo;
    }

    public JTextField getTxtURLNuevo() {
        return txtURLNuevo;
    }

    public void setTxtURLNuevo(JTextField txtURLNuevo) {
        this.txtURLNuevo = txtURLNuevo;
    }

    public JTextField getTxtIdEliminar() {
        return txtIdEliminar;
    }

    public void setTxtIdEliminar(JTextField txtIdEliminar) {
        this.txtIdEliminar = txtIdEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JLabel getLblActuyEli() {
        return lblActuyEli;
    }

    public void setLblActuyEli(JLabel lblActuyEli) {
        this.lblActuyEli = lblActuyEli;
    }

    public void limpiarNuevo(){
        txtIdNuevo.setText("");
        txtPersonajeNuevo.setText("");
        txtOcupacionNuevo.setText("");
        txtAldeaNuevo.setText("");
        txtClanNuevo.setText("");
        txtURLNuevo.setText("");
    }

    public JLabel getImagenPersonaje() {
        return imagenPersonaje;
    }

    public void setImagenPersonaje(JLabel imagenPersonaje) {
        this.imagenPersonaje = imagenPersonaje;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author lcast
 */
public class MainWindow extends JFrame {
 
    // creamos un objeto de la clase GridBagLayout este sera nuestro layout el cual determinara 
    // el orden en que se distribuiran los componentes
    GridBagLayout layout = new GridBagLayout();
  
    // creamos un objeto de la clase GridBagContraints 
    // en el cual se guarda información de cómo y dónde añadir el componente. 
    GridBagConstraints constraint = new GridBagConstraints();
    
    // creamos tres objetos de la clase JPanel
    Home home = new  Home();
    Configurar configurar = new Configurar();

    public MainWindow(){
        initComponents();
    }
    
    private void initComponents(){
        setTitle("Concurso - Preguntas y respuestas");
        
        /*
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        this.setSize(1020, 720); //asignamos ancho y alto
        setLocationRelativeTo(null); //centramos la pantalla
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        this.setLayout(layout);
  
                 // agregamos los respectivos contenedores y componentes al JFrame
        constraint.gridx=0;
        constraint.gridy=0;
        constraint.gridwidth=2;
        constraint.gridheight=1;
        constraint.weightx=1.0;
        constraint.weighty=1.0;
        constraint.anchor=GridBagConstraints.CENTER;
        constraint.fill= GridBagConstraints.BOTH;
        this.add(home, constraint);
        this.add(configurar, constraint);

        home.setVisible(true);
        configurar.setVisible(false);

    }
}
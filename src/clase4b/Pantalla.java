/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class Pantalla implements ActionListener,MouseListener, IVista {

    JFrame marco;
    JPanel panel;
    JButton b;
    JButton bcobro;
    JList pantallax;
    JLabel salida;
    JLabel cobro;
    JLabel cobro2;
    DefaultListModel dlm;
    public IModelo modelodatos;
    public IModelo2 operacionesmodelodatos;

    public Pantalla() {
        marco = new JFrame();
        marco.setSize(1000, 700);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = (JPanel) marco.getContentPane();
        dlm = new DefaultListModel();
        pantallax = new JList();
        // para vincular variabledelalista.setmodel(nombredevariabledetipoDefaultListModel);
        pantallax.setModel(dlm);

        panel.setLayout(null);

        salida = new JLabel();

        panel.add(pantallax);
        panel.add(salida);

        pantallax.setBounds(300, 10, 500, 300);
        salida.setBounds(300, 350, 200, 75);
        salida.setText("Importe: 0.0");
        
        pantallax.addMouseListener(this);
        
        bcobro = new JButton("Cobro");
        cobro = new JLabel();
        cobro2 = new JLabel();
        panel.add(bcobro);
        panel.add(cobro);
        panel.add(cobro2);
        
        bcobro.setBounds(800,400,100,50);
        cobro.setBounds(300,400,200,75);
        cobro2.setBounds(300,500,200,75);
        cobro.setText("Dinero recibido: 0.0");
        cobro2.setText("Cambio: 0.0");

    }

    public void crearBotones() {
        for (int i = 0; i < modelodatos.size(); i++) {
            Producto pb = new Producto();
            pb = modelodatos.get(i);
            b = new JButton(pb.nombre);
            b.setBounds(20, 55 * i, 100, 50);
            panel.add(b);
            b.setActionCommand("" + i);
            b.addActionListener(this);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String valor = e.getActionCommand();

        int posicion = Integer.parseInt(valor);

        operacionesmodelodatos.addCantidad(posicion);
    }

    @Override
    public void mostrarlista() {

        this.dlm.clear();
        for (int i = 0; i < this.modelodatos.size(); i++) {
            Producto p = this.modelodatos.get(i);

            dlm.addElement(p.cantidad + " x " + p.nombre);

        }
    }

    @Override
    public void mostrarimporte() {
        salida.setText("Importe: " + operacionesmodelodatos.getImporte());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // doble click
        
        if(e.getClickCount()==2)
        {
            if(this.pantallax.getSelectedIndex()> -1)
            {
                operacionesmodelodatos.removeCantidad(pantallax.getSelectedIndex());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

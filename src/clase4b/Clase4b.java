/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4b;

/**
 *
 * @author admin
 */
public class Clase4b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Pantalla p = new Pantalla();
       Modelo m = new Modelo();
       
       
       p.modelodatos = m;
       p.operacionesmodelodatos = m;
       
       m.visual=p;
       
       p.crearBotones();
       //p.mostrarlista();
       
       
       
    }
    
}

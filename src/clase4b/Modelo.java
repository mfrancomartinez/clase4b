/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4b;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Modelo implements IModelo, IModelo2{
    public IVista visual;
    ArrayList <Producto> listaproductos;
    
    public Modelo(){
    Producto p = new Producto();
    p.nombre="Bolígrafo";
    p.precio=1.2;
    Producto p2 = new Producto();
    p2.nombre="Lápiz";
    p2.precio=1.0;
    Producto p3 = new Producto();
    p3.nombre="Libreta";
    p3.precio=2.1;
    
      listaproductos = new ArrayList();
    listaproductos.add(p);
    listaproductos.add(p2);
    listaproductos.add(p3);
}

    @Override
    public int size() {
        return listaproductos.size();
    }

    @Override
    public Producto get(int posicion) {
        return listaproductos.get(posicion);
    }

    @Override
    public void addCantidad(int posicion) {
        this.listaproductos.get(posicion).cantidad++;
        
        visual.mostrarimporte();
        visual.mostrarlista();
    }

    @Override
    public double getImporte() {
         double importe=0;
        for(int i=0; i< this.listaproductos.size();i++)
        {
            Producto p= this.listaproductos.get(i);
            
          importe =importe + p.cantidad*p.precio;
    }
    return importe;
    
}

    @Override
    public void removeCantidad(int posicion) {
       this.listaproductos.get(posicion).cantidad--;
       
       visual.mostrarimporte();
       visual.mostrarlista();
    }
}

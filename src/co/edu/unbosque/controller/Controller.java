package co.edu.unbosque.controller;

import co.edu.unbosque.model.Campo;
import co.edu.unbosque.model.Continental;
import co.edu.unbosque.model.Menu;
import co.edu.unbosque.model.Nutricionista;
import co.edu.unbosque.view.View;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {

    Campo cam;
    View vista;
    Nutricionista nutri;
    Continental cont;

    public Controller() {
        //Posición Conejo

        vista=new View();

        int op=Integer.parseInt(vista.pedirdato("Ingrese la opcion"+"\n1.Nutricionista"+"\n2.Continental"+"\n3.Conejo"));
        casos(op);
    }

    public void casos(int opcion){
        switch (opcion){
            case 1:
                ArrayList<Menu> miLista = new ArrayList<Menu>();
                try {
                    int cant = Integer.parseInt(vista.pedirdato("ingrese la cantidad de platos del menu"));

                    for (int i = 0; i < cant; i++) {
                        String nombre = vista.pedirdato("ingrese el nombre del plato");
                        try {
                            double cal = Double.parseDouble(vista.pedirdato("ingrese la cantidad de calorias de su plato"));

                            miLista.add(new Menu(nombre, cal));
                        } catch (Exception e) {
                            vista.mostrarmensaje("Ingrese en caloria valores numericos");
                            int op = Integer.parseInt(vista.pedirdato("Ingrese la opcion"));
                            casos(op);
                        }
                    }
                    int min = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el minimo de calorias"));
                    nutri = new Nutricionista(miLista, min);

                    System.out.println("1");
                }catch (Exception e){
                    vista.mostrarmensaje("Ingrese valores numericos en donde se le pide");
                    int op = Integer.parseInt(vista.pedirdato("Ingrese la opcion"));
                    casos(op);
                }
                break;
            case 2:

                System.out.println("2");
                cont=new Continental();
                break;
            case 3:
                int h=Integer.parseInt(vista.pedirdato("Ingrese la altur del campo"));
                int a=Integer.parseInt(vista.pedirdato("Ingrese la anchura del campo"));
                int x=Integer.parseInt(vista.pedirdato("ingrese la cordenada de llegada x"))-1;
                int y=Integer.parseInt(vista.pedirdato("Ingrese cordenada de llegada en y"))-1;


                int ox=Integer.parseInt(vista.pedirdato("ingrese en donde esta el conejo en x en estos momentos"))-1;
                int oy=Integer.parseInt(vista.pedirdato("Ingrese en donde se encuentra el conejo en y en estos momentos"))-1;
                int md=Integer.parseInt(vista.pedirdato("ingrese cuantas casillas hacia los lados se va a mover"));
                int ma=Integer.parseInt(vista.pedirdato("Ingrese cuantas casillas en vertical se va a mover el conejo"));
                if(h<0 || a<0 || x<0 || y<0 || ox<0 || oy<0 || md<0 || ma<0) {
                    vista.mostrarmensaje("ingrese valores validos");
                    System.exit(0);
                }
                if(x> a-1 || y > h-1){
                    vista.mostrarmensaje("la coordenada de llegada no puede ser mayor al tamaño del campo");
                    System.exit(0);

                }

                cam=new Campo(h,a,x,y);
                cam.solucion(ox,oy,0,md,ma);
                System.out.println("3");
                break;
            case 4:
                vista.mostrarmensaje("ingrese Hasta luego");
                System.exit(0);
        }
    }

}

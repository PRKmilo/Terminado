package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import co.edu.unbosque.model.Menu;

import javax.swing.*;

/**
 * progama que calcula una de las posibles opciones optimas
 * el ejercio 1 que pide optimizar un menu y esconger
 * los platos que cumpla la cantidad de calorias minimas
 * escogidas por el usuario
 * @author villarreal,hernadez,piza,camacho
 *
 */

public class Nutricionista {
    ArrayList<Menu> menu = new ArrayList<Menu>();
    ArrayList<Menu> comida = new ArrayList<Menu>();
    ArrayList<Menu> optimo_iteracion = new ArrayList<Menu>();
    ArrayList<Menu> optimo = new ArrayList<Menu>();
    double minCalorias;
    double maxCaloriasMenu;
    double calorias_optimas = 100000;
    double sumatoriaCaloria=0;
    double caloriaActual=0;
    int iteracion =0;
    /**
     * constructor de la clase llena el array del menu
     * crea un ciclo que llama al metodo calculoCaloria
     * guarda la mejor opcio que se acomode al minimo de calorias
     * y que tenga la mayor cantidad de platos
     */
    public Nutricionista(ArrayList<Menu> lista,int minCal) {
        listaMenu(lista);
        minCalorias = minCal;
        for (int i = 0; i < menu.size(); i++) {
            calculoCaloria(i);
            if(sumatoriaCaloria <= calorias_optimas && optimo_iteracion.size() > optimo.size()) {
                calorias_optimas = sumatoriaCaloria;
                optimo = optimo_iteracion;
            }
            sumatoriaCaloria = 0;
            comida = new ArrayList<Menu>();;
        }

        System.out.println("la lista de comida optima es");
        JOptionPane.showMessageDialog(null,"la lista de comida optima es");
        String res="";
        for(int j=0;j<optimo.size()-1;j++ ) {
            res+="comida "+optimo.get(j).getComida()+" calorias "+optimo.get(j).getCaloria()+"\n";
        }
        JOptionPane.showMessageDialog(null,res);
        calorias_optimas=0;
        for(int n =0;n<optimo.size()-1;n++) {
            calorias_optimas +=optimo.get(n).getCaloria();
        }
        JOptionPane.showMessageDialog(null,"su sumatoria es "+calorias_optimas);
        System.out.println("su sumatoria es "+calorias_optimas);
    }
    /**
     * metodo para agragar elementos al arraylis menu
     */
    public void listaMenu(ArrayList<Menu> lista) {
        for(Menu c:lista){
            menu.add(c);
        }
        menu.add(new Menu("pescado",5));
        menu.add(new Menu("carne",1));
        menu.add(new Menu("pasta",4));
        menu.add(new Menu("ensalada",1));
        menu.add(new Menu("hamburgesa",1));
    }
    /**
     * calcula la con cada elemento del array menu la sumatoria de calorias
     * solo deja entrar a las calorias menores o iguales a las pedidas
     * si llega el caso de que el minimo de colias minia que pide regresara
     * un arreglo vacio
     * @param i se le conoce como la iteracio que tendra el metodo
     * para recorer todo el arreglo de menu
     */
    public void calculoCaloria(int i){

        if(i == menu.size()) {
            return;
        }
        caloriaActual=menu.get(i).getCaloria();
        if(caloriaActual <= minCalorias) {
            sumatoriaCaloria += caloriaActual;
            comida.add(menu.get(i));
        }

        if(sumatoriaCaloria >= minCalorias) {
            if(minCalorias+1 >=sumatoriaCaloria ) {
                comida.add(menu.get(i));
                optimo_iteracion = comida;
                calorias_optimas = sumatoriaCaloria;
                return;
            }

        }
        else {
            //comida.add(menu.get(i));
            calculoCaloria(i + 1);
        }
    }
}

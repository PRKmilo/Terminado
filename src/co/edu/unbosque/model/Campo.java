package co.edu.unbosque.model;

import javax.swing.*;
/**
 * hace todo lo del ejercio 3 de rama y poda
 * calcula que salto debe hacer un objeto "conejo" dentro
 * de una matriz para llegar al elemento seleccionado
 * como destino
 * @author villarreal,hernadez,piza,camacho
 *
 */

public class Campo {
    int[][] campo;
    Conejo co = new Conejo(0, 0, 0);
    int saltos = 0;
    int llegadai, llegadaj;
    Boolean ab = null;
     //Tamaño saltos arriba abajo
    /**
     * constructor que define el tamaño de la matriz y asigna el punto de
     * partida del objeto y el punto de llegada
     * @param p es para asignar las filas de la matriz
     * @param q es para asignar las colummnas de la matriz
     * @param u es la la fila del punto de llegada
     * @param v es la columna del punto de llegada
     */
    public Campo(int p, int q, int u, int v) {
        campo = new int[p][q];
        campo[u][v] = 2;
        llegadai = u;
        llegadaj = v;
    }
    /**
     * imprime el campo
     * @param a matriz que creo el usuario donde esta el objeto
     * conejo y su destino
     */
    public static void impCampo(int[][] a) {
        String res="";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" | ");
                res+=a[i][j]+" | ";
                if(j==a[0].length-1) {
                    res+="\n";
                    System.out.println();
                }
            }
        }
        JOptionPane.showMessageDialog(null,res);
        System.out.println("---------------");
    }
    /**
     * compara en que posicion esta el objeto con su punto de llega
     * y dependiendo de la dirreccion horizontal o vertil
     * se mueva hacia ella
     * @param x la fila donde esta el objeto "conejo"
     * @param y la columna donde esta el "conejo"
     * @param count contador en la recursividad para conocer los
     * desplazamientos del "conejo"
     */
    public void solucion(int x, int y, int count,int d,int a) {
        if(llegadai%d != 0 || llegadaj%a != 0) {
            System.out.println("No se pueden hacer los movimientos");
            System.exit(0);
            return;
        }
        co.setPosx(x);
        co.setPosy(y);
        co.setContador(count);
        campo[co.getPosx()][co.getPosy()] = 1;
        impCampo(campo);
        System.out.println("Saltos: "+count);
        if(co.getPosx() == llegadai && co.getPosy() == llegadaj) {
            System.out.println("El Conejo esta en el final");
            String res="El Conejo esta en el final con el numero de saltos de "+count;
            JOptionPane.showMessageDialog(null,res);
            System.exit(0);
            return;
        }
        double dis = distan(x, y, llegadai, llegadaj);
        System.out.println("Dis: "+dis);
        //Contador 0
        if(co.getContador() == 0) {
            //Si esta pegado a la izquierda se mueve a la derecha
            if(co.getPosy() == 0) {
                campo[co.getPosx()][co.getPosy()] = 0;
                ab=false;
                solucion(co.getPosx(),co.getPosy()+d,count+1,d,a);
            }else
                //Si esta pegadoa la derecha se mueve a la izquierda
                if(co.getPosy() == campo[0].length-1) {
                    campo[co.getPosx()][co.getPosy()] = 0;
                    ab=false;
                    solucion(co.getPosx(),co.getPosy()-d,count+1,d,a);
                }else
                    //Si esta en el centro se mueve a la derecha o izquierda dependiendo de la llegada
                    if(co.getPosy() > 0 && co.getPosy() < campo[0].length-1) {
                        //iz
                        if(llegadaj < co.getPosy()) {
                            campo[co.getPosx()][co.getPosy()] = 0;
                            ab=false;
                            solucion(co.getPosx(),co.getPosy()-d,count+1,d,a);
                        }
                        //dere
                        if(llegadaj > co.getPosy()) {
                            campo[co.getPosx()][co.getPosy()] = 0;
                            ab=false;
                            solucion(co.getPosx(),co.getPosy()+d,count+1,d,a);
                        }

                    }
        }


        if(ab != null) {
            if(ab==true) {
                if(co.getPosy() == llegadaj) {
                    if(co.getPosy() == campo.length-1) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=false;
                        solucion(co.getPosx(),co.getPosy()-d,count+1,d,a);
                    }
                    if(co.getPosy() == 0) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=false;
                        solucion(co.getPosx(),co.getPosy()+d,count+1,d,a);
                    }

                }
                if(co.getPosy() > 0 && co.getPosy() < campo[0].length-1) {
                    //iz
                    if(llegadaj < co.getPosy()) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=false;
                        solucion(co.getPosx(),co.getPosy()-d,count+1,d,a);
                    }
                    //dere
                    if(llegadaj > co.getPosy()) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=false;
                        solucion(co.getPosx(),co.getPosy()+d,count+1,d,a);
                    }

                }
            }
            if(ab==false) {
                System.out.println("entre false");

                if(co.getPosx() == llegadai) {

                    if(co.getPosx() == campo.length-1) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=true;
                        solucion(co.getPosx()-a,co.getPosy(),count+1,d,a);
                    }
                    if(co.getPosx() == 0) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=true;
                        solucion(co.getPosx()+a,co.getPosy(),count+1,d,a);
                    }
                    if(co.getPosx() > 0 && co.getPosx() < campo.length-1) {
                        if(llegadai < co.getPosx()) {
                            campo[co.getPosx()][co.getPosy()] = 0;
                            ab=true;
                            solucion(co.getPosx()+a,co.getPosy(),count+1,d,a);
                        }
                        if(llegadai > co.getPosx()) {
                            campo[co.getPosx()][co.getPosy()] = 0;
                            ab=true;
                            solucion(co.getPosx()-a,co.getPosy(),count+1,d,a);
                        }else
                        if(co.getPosx() == llegadai) {
                            campo[co.getPosx()][co.getPosy()] = 0;
                            ab=true;
                            solucion(co.getPosx()+a,co.getPosy(),count+1,d,a);
                        }
                    }
                }

                if(co.getPosx() > 0 || co.getPosx() < campo.length-1) {
                    //abajo
                    if(llegadai < co.getPosx()) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=true;
                        System.out.println("entre abajo");
                        solucion(co.getPosx()-a,co.getPosy(),count+1,d,a);
                    }
                    //arriba
                    if(llegadai > co.getPosx()) {
                        campo[co.getPosx()][co.getPosy()] = 0;
                        ab=true;
                        System.out.println("entre arriba");
                        solucion(co.getPosx()+a,co.getPosy(),count+1,d,a);
                    }

                }
            }
        }

        if(dis == 1.0) {
            if(llegadaj == co.getPosy()) {
                campo[co.getPosx()][co.getPosy()] = 0;
                solucion(co.getPosx()+a,co.getPosy(),count+1,d,a);
            }

        }

    }
    /**
     * calcula la distancia entre el "conejo" y su destino
     * @param x fila en la que esta el "conejo"
     * @param y columna en la que esta el "conejo"
     * @param u fila en la que esta el destino
     * @param v columna en la que esta el destino
     * @return la distana en valor decimal
     */
    public double distan(int x, int y, int u, int v) {
        double dis = ((Math.sqrt(Math.pow(x-u,2)+Math.pow(y-v,2))));
        return dis;
    }
}

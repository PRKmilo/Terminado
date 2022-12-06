package co.edu.unbosque.model;

/**
 * Clase Continental Programa el cual busca por medio del algoritmo de
 * backtracking que quede una solo una pieza en el centro en todo el tablero.
 *
 * @author villarreal,hernadez,piza,camacho
 *
 */
public class Continental {
    private int tablero = 7;
    private int[][] continental = new int[tablero][tablero];
    private int[][] rescont = continental;
    public Continental() {
        cargarMesa(continental);
        imprimirMesa(continental);
        backtrackingChaval(rescont);
    }

    /**
     * Metodo para cargar la matriz principal
     *
     * @param m
     */
    public void cargarMesa(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if ((i > 4 && j > 4) || (i > 4 && j < 2) || (i < 2 && j < 2) || (i < 2 && j > 4)
                        || (i == 3 && j == 3)) {
                    m[i][j] = 7;
                    m[3][3] = 1;
                }
                else{
                    m[i][j] = 0;
                }
            }
        }
    }

    /**
     * Metodo para crear una nueva matriz
     *
     * @param m
     * @param x
     * @param y
     * @param k
     */
    public void nuevaMesa(int[][] m, int x, int y, int k) {
        //m[y][x] = k;
        for(int i = x; i < m.length;i++) {
            for(int j = y; j < m[i].length;j++) {
                if(m[i][j] != 7) {
                    m[i][j]=k;
                }
            }
        }
    }

    /**
     * Metodo para imprimir la matriz
     *
     * @param m
     */
    public void imprimirMesa(int[][] m) {
        System.out.println("----------Tablero--------------");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    /**
     * metodo para realizar las diferentes combinaciones por medio del backtracking
     * este recibe como parametro una matriz temporal
     *
     * @param tmp
     */
    public void backtrackingChaval(int[][] tmp) {
        for (int i = 0; i < continental.length; i++) {// Filas (horizontal)
            for (int j = 0; j < continental[i].length; j++) {// Columnas (vertical)
                if ((j + 1 < 7) && (j + 2 < 7)) {
                    if (continental[i][j] == 0 && continental[i][j + 1] == 0 &&  continental[i][j + 2] == 1) {
                        continental[i][j] = 1;
                        continental[i][j + 1] = 1;
                        continental[i][j + 2] = 0;
                        nuevaMesa(tmp, i , j , 1);
                        backtrackingChaval(tmp);
                        System.out.println("----1----");
                        imprimirMesa(tmp);
                    }
                }
                if ((j  - 1 > 0)&&(j - 2 > 0)) {
                    if (continental[i][j] == 0 && continental[i][j - 1] == 0 && continental[i][j - 2] == 1) {
                        continental[i][j - 2] = 0;
                        continental[i][j - 1] = 1;
                        continental[i][j] = 1;
                        nuevaMesa(tmp, i , j , 1);
                        backtrackingChaval(tmp);
                        System.out.println("----2----");
                        imprimirMesa(tmp);
                    }
                }
                if ((i + 1 < 7)&&(i + 2< 7)) {
                    if (continental[i][j] == 0 && continental[i + 1][j] == 0 && continental[i + 2][j] == 1) {
                        continental[i][j] = 1;
                        continental[i + 1][j] = 1;
                        continental[i + 2][j] = 0;
                        nuevaMesa(tmp, i , j , 1);
                        backtrackingChaval(tmp);
                        System.out.println("----3----");
                        imprimirMesa(tmp);
                    }
                }
                if ((i - 1 > 0)&&(i - 2 > 0)) {
                    if ((continental[i][j] == 0 && continental[i - 1][j] == 0 && continental[i - 2][j] == 1)) {
                        continental[i - 2][j] = 0;
                        continental[i - 1][j] = 1;
                        continental[i][j] = 1;
                        nuevaMesa(tmp, i , j , 1);
                        backtrackingChaval(tmp);
                        System.out.println("----4----");
                        imprimirMesa(tmp);
                    }
                }
            }
        }

    }
}
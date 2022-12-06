package co.edu.unbosque.model;
/**
 * creacion del objeto "conejo" para ejercio 3
 * @author villarreal,hernadez,piza,camacho
 *
 */
public class Conejo {
    int posx, posy, contador;
    /**
     * tiene la posion del conejo y el condator de su pasos
     * @param posx fila del conejo
     * @param posy columna del conejo
     * @param contador contador de desplazamiento del conejo
     */
    public Conejo(int posx, int posy, int contador) {
        this.posx = posx;
        this.posy = posy;
        this.contador = contador;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}

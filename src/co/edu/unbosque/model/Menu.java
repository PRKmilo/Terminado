package co.edu.unbosque.model;
/**
 * creacion de los arraylist que tenga los elemtos del menu que son
 * el nombre y la caloria de la comida
 * @author villarreal,hernadez,piza,camacho
 *
 */
public class Menu {
    private String comida;
    private double caloria;
    /**
     * asigna valores a la clase para que lo guarde sus getters y setters
     * @param c nombre de la comida
     * @param ca valor calorico de la comida
     */
    public Menu(String c, double ca) {
        // TODO Auto-generated constructor stub

        comida = c;
        caloria = ca;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }
}

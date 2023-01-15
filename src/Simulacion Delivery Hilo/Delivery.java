/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacionDelivery;

/**
 *
 * @author Carlos
 */
public class Delivery {
    private String direccion;
    private int totalPaquetes;
    private int id;

    public Delivery(String direccion, int totalPaquetes, int id) {
        this.direccion = direccion;
        this.totalPaquetes = totalPaquetes;
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTotalPaquetes() {
        return totalPaquetes;
    }

    public int getId() {
        return id;
    }


}

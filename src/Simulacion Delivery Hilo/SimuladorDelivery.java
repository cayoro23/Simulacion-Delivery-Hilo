/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacionDelivery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimuladorDelivery extends Thread {

    private Delivery delivery;

    public SimuladorDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Carlos\\Documents\\NetBeansProjects\\EjerciciosHiloIA\\src\\delivery\\deliveries.txt"))) {
            String leer;
            while ((leer = reader.readLine()) != null) {
                String[] partes = leer.split(",");
                String direccion = partes[0];
                int cantidadPaquetes = Integer.parseInt(partes[1]);
                int id = Integer.parseInt(partes[2]);;

                Delivery delivery = new Delivery(direccion, cantidadPaquetes, id);
                SimuladorDelivery thread = new SimuladorDelivery(delivery);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error en: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < delivery.getTotalPaquetes(); i++) {
            System.out.println("Entregando paquete " + (i + 1) + " de la entrega " + delivery.getId() + " a la dirección " + delivery.getDireccion());
            try {
                Thread.sleep(1000); // esperar un segundo antes de realizar la siguiente entrega
            } catch (InterruptedException e) {
                System.out.println("Error en: " + e.getMessage());
            }
        }
    }
}

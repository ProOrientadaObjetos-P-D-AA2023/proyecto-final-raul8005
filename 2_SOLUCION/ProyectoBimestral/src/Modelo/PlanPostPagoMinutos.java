/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author Raul Medina
 */
public class PlanPostPagoMinutos extends Cliente {
    
    // minutos nacionales | costo minuto nacional | minutos internacionales | costo minuto internacional

    private int minutosNacionales;
    private int costoMinutoNacional;
    private int minutosInternacionales;
    private int costoMinutoInternacional;

    public PlanPostPagoMinutos(int minutosNacionales, int costoMinutoNacional, int minutosInternacionales, int costoMinutoInternacional, String nombre, 
            String cedula, String ciudad, String marca, String modelo, String numeroCelular, int edad, String direccion) {
        super(nombre, cedula, ciudad, marca, modelo, numeroCelular, edad, direccion);
        this.minutosNacionales = minutosNacionales;
        this.costoMinutoNacional = costoMinutoNacional;
        this.minutosInternacionales = minutosInternacionales;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    public int getMinutosNacionales() {
        return minutosNacionales;
    }

    public void setMinutosNacionales(int minutosNacionales) {
        this.minutosNacionales = minutosNacionales;
    }

    public int getCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public void setCostoMinutoNacional(int costoMinutoNacional) {
        this.costoMinutoNacional = costoMinutoNacional;
    }

    public int getMinutosInternacionales() {
        return minutosInternacionales;
    }

    public void setMinutosInternacionales(int minutosInternacionales) {
        this.minutosInternacionales = minutosInternacionales;
    }

    public int getCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    public void setCostoMinutoInternacional(int costoMinutoInternacional) {
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

   

    @Override
    public void calcularPagoMensual() {
        pagoMensual = (minutosNacionales * costoMinutoNacional)
                + (minutosInternacionales * costoMinutoInternacional);
    }


    @Override
    public String toString() {
        String cadena = String.format(""
                + "%s"
                + "Minutos Nacionales: %d\n"
                + "Costo Minuto Nacional: $ %d\n"
                + "Minutos Internacionales: %d\n"
                + "Costo Minuto Internacional: $ %d\n\n"
                + "Pago Mensual: $ %d\n",
                super.toString(),
                minutosNacionales,
                costoMinutoNacional,
                minutosInternacionales,
                costoMinutoInternacional,
                pagoMensual);
        return cadena;
    }
}

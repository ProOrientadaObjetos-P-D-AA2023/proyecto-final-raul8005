/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.Enlace;

/**
 *
 * @author Raul Medina
 */
public class PlanPostPagoMinutosMegasEconomico extends Cliente{

    private int minutos;
    private int costoMinutos;
    private int megasEnGigas;
    private int costoGiga;
    private int descuento;

    public PlanPostPagoMinutosMegasEconomico(int minutos, int costoMinutos, int megasEnGigas, int costoGiga, int descuento, String nombre, String cedula, String ciudad, String marca, String modelo, String numeroCelular, int edad, String direccion) {
        super(nombre, cedula, ciudad, marca, modelo, numeroCelular, edad, direccion);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.megasEnGigas = megasEnGigas;
        this.costoGiga = costoGiga;
        this.descuento = descuento;
    }

  

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getCostoMinutos() {
        return costoMinutos;
    }

    public void setCostoMinutos(int costoMinutos) {
        this.costoMinutos = costoMinutos;
    }

    public int getMegasEnGigas() {
        return megasEnGigas;
    }

    public void setMegasEnGigas(int megasEnGigas) {
        this.megasEnGigas = megasEnGigas;
    }

    public int getCostoGiga() {
        return costoGiga;
    }

    public void setCostoGiga(int costoGiga) {
        this.costoGiga = costoGiga;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

   
   

    

    @Override
    public void calcularPagoMensual() {
        int totalMins = minutos * costoMinutos;
        int totalMegas = megasEnGigas * costoGiga;
        int totalPago = totalMins + totalMegas;
        int descuentoAplicado = totalPago * (descuento / 100);
        pagoMensual = totalPago - descuentoAplicado;
    }

    @Override
    public String toString() {
        String cadena = String.format(""
                + "%s"
                + "Mins: %d\n"
                + "Costo Mins: %d\n"
                + "Megas: %d\n"
                + "Costo Megas: %d\n"
                + "Descuento: %d\n"
                + "Pago Mensual: $ %d\n",
                super.toString(),
                minutos,
                costoMinutos,
                megasEnGigas,
                costoGiga,
                descuento,
                pagoMensual
                );
        return cadena;
    }
}

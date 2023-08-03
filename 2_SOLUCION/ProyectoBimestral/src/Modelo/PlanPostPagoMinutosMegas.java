/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author Raul Medina
 */
public class PlanPostPagoMinutosMegas extends Cliente{
      // minutos | costo minutos | megas expresado en gigas | costo por cada giga

    private int minutos;
    private int costoMinutos;
    private int megasEnGigas;
    private int costoPorGiga;

    public PlanPostPagoMinutosMegas(int minutos, int costoMinutos, int megasEnGigas, int costoPorGiga, String nombre, String cedula, String ciudad, String marca, String modelo, String numeroCelular, int edad, String direccion) {
        super(nombre, cedula, ciudad, marca, modelo, numeroCelular, edad, direccion);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.megasEnGigas = megasEnGigas;
        this.costoPorGiga = costoPorGiga;
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

    public int getCostoPorGiga() {
        return costoPorGiga;
    }

    public void setCostoPorGiga(int costoPorGiga) {
        this.costoPorGiga = costoPorGiga;
    }


    @Override
    public void calcularPagoMensual() {
        pagoMensual = (minutos * costoMinutos) + (megasEnGigas * costoPorGiga);
    }


    @Override
    public String toString() {
        String cadena = String.format(""
                + "%s"
                + "Minutos: %d\n"
                + "Costo Minutos: %d\n"
                + "Megas Expresado en Gigas: %d\n"
                + "Costo por cada Giga: %d\n\n"
                + "Pago Mensual: $ %d\n",
                super.toString(),
                minutos,
                costoMinutos,
                megasEnGigas,
                costoPorGiga,
                pagoMensual);
        return cadena;
        }

}

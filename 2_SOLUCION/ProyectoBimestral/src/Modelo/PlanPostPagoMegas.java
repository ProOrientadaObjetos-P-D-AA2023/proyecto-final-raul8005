/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Raul Medina
 */
public class PlanPostPagoMegas extends Cliente{

    // Megas expresado en gigas | Costo por cada giga | Tarifa base
    private int megasEnGigas;
    private int costoPorGiga;
    private int tarifaBase;

    public PlanPostPagoMegas(int megasEnGigas, int costoPorGiga, int tarifaBase, String nombre, 
            String cedula, String ciudad, String marca, String modelo, String numeroCelular, int edad, String direccion) {
        super(nombre, cedula, ciudad, marca, modelo, numeroCelular, edad, direccion);
        this.megasEnGigas = megasEnGigas;
        this.costoPorGiga = costoPorGiga;
        this.tarifaBase = tarifaBase;
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

    public int getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(int tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

   
    
    @Override
    public void calcularPagoMensual() {
        pagoMensual = (megasEnGigas * costoPorGiga) + tarifaBase;
    }

    @Override
    public String toString() {
        String cadena = String.format(""
                + "%s"
                + "Megas expresado en Gigas: %d\n"
                + "Costo por cada Giga: $ %d\n"
                + "Tarifa base: %d\n\n"
                + "Pago Mensual: $ %d\n",
                super.toString(),
                megasEnGigas,
                costoPorGiga,
                tarifaBase,
                pagoMensual);
        return cadena;
    }
    
}

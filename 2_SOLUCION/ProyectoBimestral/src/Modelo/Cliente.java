/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Raul Medina
 */
public abstract class Cliente {

    protected int pagoMensual;
    protected String nombre;
    protected String cedula;
    protected String ciudad;
    protected String marca;
    protected String modelo;
    protected String numeroCelular;
    protected int edad;
    protected String direccion;

    public Cliente(String nombre, String cedula, String ciudad, String marca, String modelo, String numeroCelular, int edad, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        this.edad = edad;
        this.direccion = direccion;
    }
    
    public abstract void calcularPagoMensual();
public int getPagoMensual() {
        return pagoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
     public double setPagoMensual() {
        return pagoMensual;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        String cadena = "****INFORMACION DEL PLAN****\n"
                + "Datos Factura:\n";
        cadena = String.format(""
                + "%s"
                + "Nombre: %s\n"
                + "Cedula: %s\n"
                + "Ciudad: %s\n"
                + "Marca Celular: %s\n"
                + "Modelo Celular: %s\n"
                + "Numero Celular: %s\n"
                + "Edad: %d\n"
                + "Direccion: %s\n",
                cadena,
                nombre,
                cedula,
                ciudad,
                marca,
                modelo,
                numeroCelular,
                edad,
                direccion);
        return cadena;
    }
}

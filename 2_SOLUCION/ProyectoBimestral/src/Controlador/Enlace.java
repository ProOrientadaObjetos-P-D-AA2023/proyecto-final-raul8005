/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.PlanPostPagoMegas;
import Modelo.PlanPostPagoMinutos;
import Modelo.PlanPostPagoMinutosMegas;
import Modelo.PlanPostPagoMinutosMegasEconomico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import 
/**
 *
 * @author Raul Medina
 */
public class Enlace {

    private Connection conn;
    public ArrayList<PlanPostPagoMinutosMegasEconomico> listaPlan1;
    public ArrayList<PlanPostPagoMinutos> listaPlan2;
    public ArrayList<PlanPostPagoMegas> listaPlan3;
    public ArrayList<PlanPostPagoMinutosMegas> listaPlan4;

    private int contadorPlanes1;
    private int contadorPlanes2;
    private int contadorPlanes3;
    private int contadorPlanes4;

    public Enlace() {
        contadorPlanes1 = 0;
        contadorPlanes2 = 0;
        contadorPlanes3 = 0;
        contadorPlanes4 = 0;
    }

    // INCREMENTAR CONTADOR PLAN 1
    public void incrementarContadorPlan1() {
        contadorPlanes1++;
    }

    // OBTENER CONPTADOR PLAN 1
    public int obtenerContadorPlan1() {
        return contadorPlanes1;
    }

    // PLAN 2
    public void incrementarContadorPlan2() {
        contadorPlanes2++;
    }

    public int obtenerContadorPlan2() {
        return contadorPlanes2;
    }

    //PLAN 3
    public void incrementarContadorPlan3() {
        contadorPlanes3++;
    }

    public int obtenerContadorPlan3() {
        return contadorPlanes3;
    }

    //PLAN 4 
    public void incrementarContadorPlan4() {
        contadorPlanes4++;
    }

    public int obtenerContadorPlan4() {
        return contadorPlanes4;
    }

    //--------------------------------------------------------------------------
    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:db/informacion.db";  //Conección con la base de datos
            conn = DriverManager.getConnection(url);
            // System.out.println("Directorio actual: " + System.getProperty("user.dir"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection obtenerConexion() {
        return conn;
    }

    //--------------------------------------------------------------------------
    //METODOS PARA INSERTAR LOS DATOS EN LOS PLANES
    public void insertarPlan1(PlanPostPagoMinutosMegasEconomico plan1) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "INSERT INTO Plan1 "
                    + "(nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion,"
                    + "minutos, "
                    + "costoMinutos, "
                    + "megasEnGigas, "
                    + "costoGiga, "
                    + "descuento, "
                    + "pagoMensual) "
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d,'%s', "
                    + "%d, %d, %d, %d,%d,%d)",
                    plan1.getNombre(),
                    plan1.getCedula(),
                    plan1.getCiudad(),
                    plan1.getMarca(),
                    plan1.getModelo(),
                    plan1.getNumeroCelular(),
                    plan1.getEdad(),
                    plan1.getDireccion(),
                    plan1.getMinutos(),
                    plan1.getCostoMinutos(),
                    plan1.getMegasEnGigas(),
                    plan1.getCostoGiga(),
                    plan1.getDescuento(),
                    plan1.getPagoMensual()
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("PLAN INGRESADO EXITORAMENTE");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR PLAN");
            System.out.println("");
            System.out.println(e.getMessage());
        }
    }

    public void insertarPlan2(PlanPostPagoMinutos plan2) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "INSERT INTO Plan2 "
                    + "(nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion,"
                    + "minutosNacionales, "
                    + "costoMinutoNacional, "
                    + "minutosInternacionales, "
                    + "costoMinutoInternacional, "
                    + "pagoMensual) "
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', "
                    + "%d, %d, %d, %d, %d)",
                    plan2.getNombre(),
                    plan2.getCedula(),
                    plan2.getCiudad(),
                    plan2.getMarca(),
                    plan2.getModelo(),
                    plan2.getNumeroCelular(),
                    plan2.getEdad(),
                    plan2.getDireccion(),
                    plan2.getMinutosNacionales(),
                    plan2.getCostoMinutoNacional(),
                    plan2.getMinutosInternacionales(),
                    plan2.getCostoMinutoInternacional(),
                    plan2.getPagoMensual()
            );

            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("PLAN INGRESADO EXITORAMENTE");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR PLAN");
            System.out.println("");
            System.out.println(e.getMessage());
        }
    }

    public void insertarPlan3(PlanPostPagoMegas plan3) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "INSERT INTO Plan3 "
                    + "(nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion, "
                    + "megasEnGigas, "
                    + "costoPorGiga, "
                    + "tarifaBase, "
                    + "pagoMensual) "
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', "
                    + "%d, %d, %d, %d)",
                    plan3.getNombre(),
                    plan3.getCedula(),
                    plan3.getCiudad(),
                    plan3.getMarca(),
                    plan3.getModelo(),
                    plan3.getNumeroCelular(),
                    plan3.getEdad(),
                    plan3.getDireccion(),
                    plan3.getMegasEnGigas(),
                    plan3.getCostoPorGiga(),
                    plan3.getTarifaBase(),
                    plan3.getPagoMensual()
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("PLAN INGRESADO EXITORAMENTE");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("Exception2:");
            System.out.println(e.getMessage());
        }
    }

    public void insertarPlan4(PlanPostPagoMinutosMegas plan4) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "INSERT INTO Plan4 "
                    + "(nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion, "
                    + "minutos, "
                    + "costoMinutos, "
                    + "megasEnGigas, "
                    + "costoPorGiga, "
                    + "pagoMensual) "
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', "
                    + "%d, %d, %d, %d,%d)",
                    plan4.getNombre(),
                    plan4.getCedula(),
                    plan4.getCiudad(),
                    plan4.getMarca(),
                    plan4.getModelo(),
                    plan4.getNumeroCelular(),
                    plan4.getEdad(),
                    plan4.getDireccion(),
                    plan4.getMinutos(),
                    plan4.getCostoMinutos(),
                    plan4.getMegasEnGigas(),
                    plan4.getCostoPorGiga(),
                    plan4.getPagoMensual()
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("PLAN INGRESADO EXITORAMENTE");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR PLAN");
            System.out.println("");
            System.out.println(e.getMessage());
        }
    }

    //----------------------------------------------------------------------
    //METODOS PARA ACTUALIZAR LOS DATOS DE LOS PLANOS
    public void actualizarPlan1(int id, PlanPostPagoMinutosMegasEconomico plan1Act) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "UPDATE Plan1 SET "
                    + "nombre = '%s', "
                    + "cedula = '%s', "
                    + "ciudad = '%s', "
                    + "marca = '%s', "
                    + "modelo = '%s', "
                    + "numeroCelular = '%s', "
                    + "edad = %d, "
                    + "direccion = '%s', "
                    + "minutos = %d, "
                    + "costoMinutos = %d, "
                    + "megasEnGigas = %d, "
                    + "costoGiga = %d, "
                    + "descuento = %d, "
                    + "pagoMensual = %d "
                    + "WHERE id = %d",
                    plan1Act.getNombre(),
                    plan1Act.getCedula(),
                    plan1Act.getCiudad(),
                    plan1Act.getMarca(),
                    plan1Act.getModelo(),
                    plan1Act.getNumeroCelular(),
                    plan1Act.getEdad(),
                    plan1Act.getDireccion(),
                    plan1Act.getMinutos(),
                    plan1Act.getCostoMinutos(),
                    plan1Act.getMegasEnGigas(),
                    plan1Act.getCostoGiga(),
                    plan1Act.getDescuento(),
                    plan1Act.getPagoMensual(),
                    id
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("----PLAN ACTUALIZADO----");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL PLAN");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public void actualizarPlan2(int id, PlanPostPagoMinutos plan2Act) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "UPDATE Plan2 SET"
                    + "nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion,"
                    + "minutosNacionales, "
                    + "costoMinutoNacional, "
                    + "minutosInternacionales, "
                    + "costoMinutoInternacional, "
                    + "pagoMensual "
                    + "WHERE id = %d",
                    plan2Act.getNombre(),
                    plan2Act.getCedula(),
                    plan2Act.getCiudad(),
                    plan2Act.getMarca(),
                    plan2Act.getModelo(),
                    plan2Act.getNumeroCelular(),
                    plan2Act.getEdad(),
                    plan2Act.getDireccion(),
                    plan2Act.getMinutosNacionales(),
                    plan2Act.getCostoMinutoNacional(),
                    plan2Act.getMinutosInternacionales(),
                    plan2Act.getCostoMinutoInternacional(),
                    plan2Act.getPagoMensual(),
                    id
            );

            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("----PLAN ACTUALIZADO----");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL PLAN");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public void actualizarPlan3(int id, PlanPostPagoMegas plan3Act) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "UPDATE Plan3 SET"
                    + "nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion, "
                    + "megasEnGigas, "
                    + "costoPorGiga, "
                    + "tarifaBase, "
                    + "pagoMensual "
                    + "WHERE id = %d",
                    plan3Act.getNombre(),
                    plan3Act.getCedula(),
                    plan3Act.getCiudad(),
                    plan3Act.getMarca(),
                    plan3Act.getModelo(),
                    plan3Act.getNumeroCelular(),
                    plan3Act.getEdad(),
                    plan3Act.getDireccion(),
                    plan3Act.getMegasEnGigas(),
                    plan3Act.getCostoPorGiga(),
                    plan3Act.getTarifaBase(),
                    plan3Act.getPagoMensual(),
                    id
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("----PLAN ACTUALIZADO----");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL PLAN 3");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public void actualizarPlan4(int id, PlanPostPagoMinutosMegas plan4Act) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "UPDATE Plan4 SET"
                    + "nombre, "
                    + "cedula, "
                    + "ciudad, "
                    + "marca, "
                    + "modelo, "
                    + "numeroCelular, "
                    + "edad, "
                    + "direccion, "
                    + "minutos, "
                    + "costoMinutos, "
                    + "megasEnGigas, "
                    + "costoPorGiga, "
                    + "pagoMensual "
                    + "WHERE id = %d",
                    plan4Act.getNombre(),
                    plan4Act.getCedula(),
                    plan4Act.getCiudad(),
                    plan4Act.getMarca(),
                    plan4Act.getModelo(),
                    plan4Act.getNumeroCelular(),
                    plan4Act.getEdad(),
                    plan4Act.getDireccion(),
                    plan4Act.getMinutos(),
                    plan4Act.getCostoMinutos(),
                    plan4Act.getMegasEnGigas(),
                    plan4Act.getCostoPorGiga(),
                    plan4Act.getPagoMensual(),
                    id
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("----PLAN ACTUALIZADO----");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL PLAN 4");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    //--------------------------------------------------------------------------
    //METODOS PARA ESTABLECER LOS DATOS DE LOS PLANES
    public void establecerListaPlan1() {
        listaPlan1 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "SELECT * FROM Plan1";
            ResultSet rs = statement.executeQuery(data);

            while (rs.next()) {

                PlanPostPagoMinutosMegasEconomico plan1 = new PlanPostPagoMinutosMegasEconomico(
                        rs.getInt("minutos"),
                        rs.getInt("costoMinutos"),
                        rs.getInt("megasEnGigas"),
                        rs.getInt("costoGiga"),
                        rs.getInt("descuento"),
                        rs.getString("nombre"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numeroCelular"),
                        rs.getInt("edad"),
                        rs.getString("direccion")
                );
                plan1.calcularPagoMensual();
                listaPlan1.add(plan1);
            }
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("ERROR AL ESTABLECER LISTA");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public void establecerListaPlan2() {
        listaPlan2 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "SELECT * FROM Plan2";

            ResultSet rs = statement.executeQuery(data);

            while (rs.next()) {
                PlanPostPagoMinutos plan2 = new PlanPostPagoMinutos(
                        rs.getInt("minutosNacionales"),
                        rs.getInt("costoMinutoNacional"),
                        rs.getInt("minutosInternacionales"),
                        rs.getInt("costoMinutoInternacional"),
                        rs.getString("nombre"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numeroCelular"),
                        rs.getInt("edad"),
                        rs.getString("direccion")
                );
                plan2.calcularPagoMensual();
                listaPlan2.add(plan2);
            }
            obtenerConexion().close();

        } catch (SQLException e) {
            System.out.println("ERROR AL ESTABLECER LISTA");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public void establecerListaPlan3() {
        listaPlan3 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "SELECT * FROM Plan3";
            ResultSet rs = statement.executeQuery(data);

            while (rs.next()) {
                PlanPostPagoMegas plan3 = new PlanPostPagoMegas(
                        rs.getInt("megasEnGigas"),
                        rs.getInt("costoPorGiga"),
                        rs.getInt("tarifaBase"),
                        rs.getString("nombre"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numeroCelular"),
                        rs.getInt("edad"),
                        rs.getString("direccion")
                );
                plan3.calcularPagoMensual();
                listaPlan3.add(plan3);
            }
            obtenerConexion().close();

        } catch (SQLException e) {
            System.out.println("ERROR AL ESTABLECER LISTA");
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public void establecerListaPlan4() {
        listaPlan4 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "SELECT * FROM Plan4";
            ResultSet rs = statement.executeQuery(data);

            while (rs.next()) {
                PlanPostPagoMinutosMegas plan4 = new PlanPostPagoMinutosMegas(
                        rs.getInt("minutos"),
                        rs.getInt("costoMinutos"),
                        rs.getInt("megasEnGigas"),
                        rs.getInt("costoPorGiga"),
                        rs.getString("nombre"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numeroCelular"),
                        rs.getInt("edad"),
                        rs.getString("direccion")
                );
                plan4.calcularPagoMensual();
                listaPlan4.add(plan4);
            }
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("ERROR AL ESTABLECER LISTA");
            System.out.println(e.getMessage());
        }
    }

    //METODOS PARA ELIMINAR LOS PLANES
    public void eliminarPlan1(int identificador) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(
                    "DELETE FROM Plan1 WHERE id='%d'; ",
                    identificador
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("");
            System.out.println("PLAN ELIMINADO");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR PLAN");
            System.out.println(e.getMessage());
        }
    }

    public void eliminarPlan2(int identificador) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(
                    "DELETE FROM Plan2 WHERE id='%d'; ",
                    identificador
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("");
            System.out.println("PLAN ELIMINADO");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR PLAN");
            System.out.println(e.getMessage());
        }
    }

    public void eliminarPlan3(int identificador) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(
                    "DELETE FROM Plan3 WHERE id='%d'; ",
                    identificador
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("");
            System.out.println("PLAN ELIMINADO");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR PLAN");
            System.out.println(e.getMessage());
        }
    }

    public void eliminarPlan4(int identificador) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(
                    "DELETE FROM Plan4 WHERE id='%d'; ",
                    identificador
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
            System.out.println("");
            System.out.println("PLAN ELIMINADO");
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR PLAN");
            System.out.println(e.getMessage());
        }
    }
    // Se crea la variable para el maximo de planes permitido por usuario que es = 2;
    private static final int maximoPlanes = 2;
    private Map<String, Integer> contadorPlan1Cedula = new HashMap<>();
    private Map<String, Integer> contadorPlan2Cedula = new HashMap<>();
    private Map<String, Integer> contadorPlan3Cedula = new HashMap<>();
    private Map<String, Integer> contadorPlan4Cedula = new HashMap<>();

    public boolean maximoPlanesU(String ced) {
        int contadorPlan1 = contadorPlan1Cedula.getOrDefault(ced, 0);
        int contadorPlan2 = contadorPlan2Cedula.getOrDefault(ced, 0);
        int contadorPlan3 = contadorPlan3Cedula.getOrDefault(ced, 0);
        int contadorPlan4 = contadorPlan4Cedula.getOrDefault(ced, 0);
        int contadorActual = contadorPlan1 + contadorPlan2 + contadorPlan3 + contadorPlan4;
        if (contadorActual >= maximoPlanes) {
            System.out.println("ERROR:\n El usuario con cédula " + ced + " ya ha sido ingresado más de " + maximoPlanes + " veces.\n"
                    + "No puede ingresar mas planes.\n");
            return false;
        }
        // Se incrementa el contador para cada plan
        contadorPlan1Cedula.put(ced, contadorPlan1 + 1);
        contadorPlan2Cedula.put(ced, contadorPlan2 + 1);
        contadorPlan3Cedula.put(ced, contadorPlan3 + 1);
        contadorPlan4Cedula.put(ced, contadorPlan4 + 1);
        return true;
    }

    public ArrayList<PlanPostPagoMinutosMegasEconomico> obtenerListaPlan1() {
        return listaPlan1;
    }

    public ArrayList<PlanPostPagoMinutos> obtenerListaPlan2() {
        return listaPlan2;
    }

    public ArrayList<PlanPostPagoMegas> obtenerListaPlan3() {
        return listaPlan3;
    }

    public ArrayList<PlanPostPagoMinutosMegas> obtenerListaPlan4() {
        return listaPlan4;
    }

}

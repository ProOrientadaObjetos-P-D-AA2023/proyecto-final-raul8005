/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Modelo.PlanPostPagoMinutosMegasEconomico;
import Modelo.Cliente;
import Modelo.PlanPostPagoMegas;
import Modelo.PlanPostPagoMinutosMegas;
import Controlador.Enlace;
import java.util.Scanner;
import Modelo.PlanPostPagoMinutos;
import java.util.ArrayList;

/**
 *
 * @author Raul Medina
 *         Cristian Espinosa
 *         Alex Sánchez
 */
public class ProyectoBimestral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        boolean bandera = true;
        Enlace enlace = new Enlace();
        ArrayList<Cliente> listaPlanes = new ArrayList<>();

        String nombre = "", cedula = "", ciudad = "", marca = "", modelo = "", numeroCelular = "", direccion = "";
        int edad = 0;

        while (bandera) {
            System.out.println("\t----TELEFONIA PILOTOS----\n"
                    + "Bienvenidos a nuestro programa, ingrese el servicio que desee:\n"
                    + "[Recuerde que se puede ingresar solo 2 tipos de planes por usuario]\n"
                    + "CREAR PLAN:\n"
                    + "1 -> Ingresar Plan Post Pago Minutos Megas Economico\n"
                    + "2 -> Ingresar Plan Post Pago Minutos\n"
                    + "3 -> Ingresar Plan Post Pago Megas\n"
                    + "4 -> Ingresar Plan Post Pago Minutos Megas\n"
                    + "----MENU CRUD PARA PLANES----\n"
                    + "5 -> Mostrar todos los planes (FACTURAS)\n"
                    + "6 -> Actualizar un plan\n"
                    + "7 -> Eliminar un plan\n"
                    + "8 -> Salir \n");

            System.out.print("Ingrese una opcion: \n");
            int opcion = entrada.nextInt();
            System.out.println("");

            if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
                entrada.nextLine();
                System.out.println("Ingrese los datos del cliente");
                System.out.println("Ingrese los nombres del usuario: ");
                nombre = entrada.nextLine();
                System.out.println("Ingrese el Pasaporte/Cedula del usuario: ");
                cedula = entrada.nextLine();
                boolean puedeAgregarPlan = enlace.maximoPlanesU(cedula);
                if (!puedeAgregarPlan) {
                    System.out.println("");
                    continue;
                }
                System.out.println("Ingrese la ciudad del usuario: ");
                ciudad = entrada.nextLine();
                System.out.println("Ingrese la marca del celular: ");
                marca = entrada.nextLine();
                System.out.println("Ingrese el modelo del celular: ");
                modelo = entrada.nextLine();
                System.out.println("Ingrese el numero de telefono: ");
                numeroCelular = entrada.nextLine();
                System.out.println("Ingrese la edad del usuario:");
                edad = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la direccion del usuario:");
                direccion = entrada.nextLine();

            }
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los minutos consumidos: ");
                    int minutos = entrada.nextInt();
                    System.out.println("Ingrese el costo del minuto: ");
                    int costoMinutos = entrada.nextInt();
                    System.out.println("Ingrese las megas expresado en Gigas: ");
                    int megasEnGigas = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingrese el costo por cada Giga: ");
                    int costoGigas = entrada.nextInt();
                    System.out.println("Ingrese el porcentaje de descuento: ");
                    int descuento = entrada.nextInt();

                    PlanPostPagoMinutosMegasEconomico plan1 = new PlanPostPagoMinutosMegasEconomico(
                            minutos,
                            costoMinutos,
                            megasEnGigas,
                            costoGigas,
                            descuento,
                            nombre,
                            cedula,
                            ciudad,
                            marca,
                            modelo,
                            numeroCelular,
                            edad,
                            direccion
                    );
                    plan1.calcularPagoMensual();
                    enlace.insertarPlan1(plan1);
                    enlace.establecerListaPlan1();
                    enlace.incrementarContadorPlan1();
                    enlace.obtenerContadorPlan1();
                    System.out.println("----------------------------");
                    System.out.println("Su numero id del plan es " + enlace.obtenerContadorPlan1());
                    System.out.println("----------------------------");

                    break;
                case 2:
                    System.out.println("Ingrese los Minutos Nacionales: ");
                    int minutosNacionales = entrada.nextInt();
                    System.out.println("Ingrese el costo de Minutos Nacionales: ");
                    int costoMinutoNacional = entrada.nextInt();
                    System.out.println("Ingrese los Minutos Internacionales: ");
                    int minutosInternacionales = entrada.nextInt();
                    System.out.println("Ingrese el costo de Minutos Internacionales: ");
                    int costoMinutoInternacional = entrada.nextInt();
                    entrada.nextLine();

                    // Aquí están los datos del propietario
                    PlanPostPagoMinutos plan2 = new PlanPostPagoMinutos(
                            minutosNacionales,
                            costoMinutoNacional,
                            minutosInternacionales,
                            costoMinutoInternacional,
                            nombre,
                            cedula,
                            ciudad,
                            marca,
                            modelo,
                            numeroCelular,
                            edad,
                            direccion
                    );

                    plan2.calcularPagoMensual();
                    enlace.insertarPlan2(plan2);
                    enlace.establecerListaPlan2();
                    enlace.incrementarContadorPlan2();
                    enlace.obtenerContadorPlan2();
                    System.out.println("----------------------------");
                    System.out.println("Su numero id del plan es " + enlace.obtenerContadorPlan2());
                    System.out.println("----------------------------");

                    break;

                case 3:
                    System.out.println("Ingrese las megas expresado en Gigas: ");
                    megasEnGigas = entrada.nextInt();
                    System.out.println("Ingrese el costo por cada Giga: ");
                    int costoPorGiga = entrada.nextInt();
                    System.out.println("Ingrese la tarifa base: ");
                    int tarifaBase = entrada.nextInt();

                    PlanPostPagoMegas plan3 = new PlanPostPagoMegas(
                            megasEnGigas,
                            costoPorGiga,
                            tarifaBase,
                            nombre,
                            cedula,
                            ciudad,
                            marca,
                            modelo,
                            numeroCelular,
                            edad,
                            direccion
                    );
                    plan3.calcularPagoMensual();
                    enlace.insertarPlan3(plan3);
                    enlace.establecerListaPlan3();
                    enlace.incrementarContadorPlan3();
                    enlace.obtenerContadorPlan3();
                    System.out.println("----------------------------");
                    System.out.println("Su numero id del plan es " + enlace.obtenerContadorPlan3());
                    System.out.println("----------------------------");

                    break;
                case 4:
                    System.out.println("Ingrese los minutos consumidos: ");
                    minutos = entrada.nextInt();
                    System.out.println("Ingrese el costo del minuto: ");
                    costoMinutos = entrada.nextInt();
                    System.out.println("Ingrese las megas expresado en Gigas: ");
                    megasEnGigas = entrada.nextInt();
                    System.out.println("Ingrese el costo por cada Giga: ");
                    costoPorGiga = entrada.nextInt();
                    PlanPostPagoMinutosMegas plan4 = new PlanPostPagoMinutosMegas(
                            minutos,
                            costoMinutos,
                            megasEnGigas,
                            costoPorGiga,
                            nombre,
                            cedula,
                            ciudad,
                            marca,
                            modelo,
                            numeroCelular,
                            edad,
                            direccion
                    );
                    plan4.calcularPagoMensual();
                    enlace.establecerListaPlan4();
                    enlace.insertarPlan4(plan4);
                    enlace.incrementarContadorPlan4();
                    enlace.obtenerContadorPlan4();
                    System.out.println("----------------------------");
                    System.out.println("Su numero id del plan es " + enlace.obtenerContadorPlan4());
                    System.out.println("----------------------------");

                    break;

                case 5:
                    // Mostrar todos los planes
                    enlace.establecerListaPlan1();
                    enlace.establecerListaPlan2();
                    enlace.establecerListaPlan3();
                    enlace.establecerListaPlan4();

                    System.out.println("***************************************");
                    ArrayList<PlanPostPagoMinutosMegasEconomico> plan1l = enlace.obtenerListaPlan1();
                    System.out.println("Plan Post Pago Minutos Mengas Economico:\n");

                    for (PlanPostPagoMinutosMegasEconomico dato : plan1l) {
                        System.out.println("----------------------------");
                        System.out.println(dato);
                        System.out.println("----------------------------");
                    }
                    System.out.println("***************************************");
                    ArrayList<PlanPostPagoMinutos> plan2l = enlace.obtenerListaPlan2();
                    System.out.println("Plan Post Pago Minutos:\n");
                    for (PlanPostPagoMinutos dato : plan2l) {
                        System.out.println(dato);
                    }
                    System.out.println("***************************************");
                    ArrayList<PlanPostPagoMegas> plan3l = enlace.obtenerListaPlan3();
                    System.out.println("Plan Post Pago  Megas:\n");
                    for (PlanPostPagoMegas dato : plan3l) {
                        System.out.println(dato);
                    }
                    System.out.println("***************************************");
                    ArrayList<PlanPostPagoMinutosMegas> plan4l = enlace.obtenerListaPlan4();
                    System.out.println("Plan Post Pago Minutos Megas:\n");
                    for (PlanPostPagoMinutosMegas dato : plan4l) {
                        System.out.println("----------------------------");
                        System.out.println(dato);
                        System.out.println("----------------------------");
                    }

                    break;

                case 6:
                    System.out.println("Que tipo de plan es el que desea actualizar:\n"
                            + "1 -> Actualizar Plan Post Pago Minutos Megas Economico\n"
                            + "2 -> Actualizar Plan Post Pago Minutos\n"
                            + "3 -> Actualizar Plan Post Pago Megas\n"
                            + "4 -> Actualizar Plan Post Pago Minutos Megas\n");
                    int opcPlan = entrada.nextInt();
                    System.out.println("Ingrese el id del plan que desea actualizar");
                    int idAct = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingrese los nombres del usuario: ");
                    nombre = entrada.nextLine();
                    System.out.println("Ingrese el Pasaporte/Cedula del usuario: ");
                    cedula = entrada.nextLine();
                    System.out.println("Ingrese la ciudad del usuario: ");
                    ciudad = entrada.nextLine();
                    System.out.println("Ingrese la marca del celular: ");
                    marca = entrada.nextLine();
                    System.out.println("Ingrese el modelo del celular: ");
                    modelo = entrada.nextLine();
                    System.out.println("Ingrese el numero de telefono: ");
                    numeroCelular = entrada.nextLine();
                    System.out.println("Ingrese la edad del usuario:");
                    edad = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingrese la direccion del usuario:");
                    direccion = entrada.nextLine();

                    switch (opcPlan) {
                        case 1:

                            System.out.println("Ingrese los minutos consumidos: ");
                            int min = entrada.nextInt();
                            System.out.println("Ingrese el costo del minuto: ");
                            int costoMin = entrada.nextInt();
                            System.out.println("Ingrese las megas expresado en Gigas: ");
                            int megasGigas = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Ingrese el costo por cada Giga: ");
                            int costGigas = entrada.nextInt();
                            System.out.println("Ingrese el porcentaje de descuento: ");
                            int descuentoA = entrada.nextInt();
                            PlanPostPagoMinutosMegasEconomico plan1Act = new PlanPostPagoMinutosMegasEconomico(
                                    min,
                                    costoMin,
                                    megasGigas,
                                    costGigas,
                                    descuentoA,
                                    nombre,
                                    cedula,
                                    ciudad,
                                    marca,
                                    modelo,
                                    numeroCelular,
                                    edad,
                                    direccion
                            );
                            plan1Act.calcularPagoMensual();
                            enlace.actualizarPlan1(idAct, plan1Act);

                            break;
                        case 2:

                            System.out.println("Ingrese los Minutos Nacionales: ");
                            int minutosNac = entrada.nextInt();
                            System.out.println("Ingrese el costo de Minutos Nacionales: ");
                            int costoMinutoNac = entrada.nextInt();
                            System.out.println("Ingrese los Minutos Internacionales: ");
                            int minutosInt = entrada.nextInt();
                            System.out.println("Ingrese el costo de Minutos Internacionales: ");
                            int costoMinutoInt = entrada.nextInt();
                            entrada.nextLine();

                            // Aquí están los datos del propietario
                            PlanPostPagoMinutos plan2Act = new PlanPostPagoMinutos(
                                    minutosNac,
                                    costoMinutoNac,
                                    minutosInt,
                                    costoMinutoInt,
                                    nombre,
                                    cedula,
                                    ciudad,
                                    marca,
                                    modelo,
                                    numeroCelular,
                                    edad,
                                    direccion);
                            plan2Act.calcularPagoMensual();
                            enlace.actualizarPlan2(idAct, plan2Act);

                            break;
                        case 3:
                            System.out.println("Ingrese las megas expresado en Gigas: ");
                            megasGigas = entrada.nextInt();
                            System.out.println("Ingrese el costo por cada Giga: ");
                            int costoGiga = entrada.nextInt();
                            System.out.println("Ingrese la tarifa base: ");
                            int tarifaBas = entrada.nextInt();

                            PlanPostPagoMegas plan3Act = new PlanPostPagoMegas(
                                    megasGigas,
                                    costoGiga,
                                    tarifaBas,
                                    nombre,
                                    cedula,
                                    ciudad,
                                    marca,
                                    modelo,
                                    numeroCelular,
                                    edad,
                                    direccion
                            );
                            plan3Act.calcularPagoMensual();
                            enlace.actualizarPlan3(idAct, plan3Act);

                            break;
                        case 4:
                            System.out.println("Ingrese los minutos consumidos: ");
                            min = entrada.nextInt();
                            System.out.println("Ingrese el costo del minuto: ");
                            costoMin = entrada.nextInt();
                            System.out.println("Ingrese las megas expresado en Gigas: ");
                            megasGigas = entrada.nextInt();
                            System.out.println("Ingrese el costo por cada Giga: ");
                            costoGiga = entrada.nextInt();
                            PlanPostPagoMinutosMegas plan4Act = new PlanPostPagoMinutosMegas(
                                    min,
                                    costoMin,
                                    megasGigas,
                                    costoGiga,
                                    nombre,
                                    cedula,
                                    ciudad,
                                    marca,
                                    modelo,
                                    numeroCelular,
                                    edad,
                                    direccion
                            );
                            plan4Act.calcularPagoMensual();
                            enlace.actualizarPlan4(idAct, plan4Act);

                            break;
                    }

                    break;

                case 7:
                    System.out.println("Que tipo de plan es el que desea eliminar:\n"
                            + "1 -> Eliminar Plan Post Pago Minutos Megas Economico\n"
                            + "2 -> Eliminar Plan Post Pago Minutos\n"
                            + "3 -> Eliminar Plan Post Pago Megas\n"
                            + "4 -> Eliminar Plan Post Pago Minutos Megas\n");
                    int opcEli = entrada.nextInt();
                    System.out.print("Ingrese el id(numero de archivo de su plan) ");
                    int identificador = entrada.nextInt();

                    switch (opcEli) {
                        // Eliminar el plan seleccionado por el usuario
                        case 1:
                            enlace.eliminarPlan1(identificador);
                            //enlace.incrementarContadorPlan1();
                            break;
                        case 2:
                            enlace.eliminarPlan2(identificador);
                            //enlace.incrementarContadorPlan2();
                            break;
                        case 3:
                            enlace.eliminarPlan3(identificador);
                            //enlace.incrementarContadorPlan3();
                            break;
                        case 4:
                            enlace.eliminarPlan4(identificador);
                            //enlace.incrementarContadorPlan4();
                            break;
                    }
                    break;

                case 8:

                    System.out.println("Saliendo del Programa...");
                    bandera = false;
                    break;

                default:
                    System.out.println("La opcion ingresada es invalida.");
                    entrada.nextLine();
            }
            entrada.nextLine();

        }
    }

}

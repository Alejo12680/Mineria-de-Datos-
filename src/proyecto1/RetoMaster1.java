
package proyecto1;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;
import java.lang.Math.*;

public class RetoMaster1 {
    public static void main(String[] args) {
        
        boolean salir = false;
        int option;
        int i, j;
        int maxFila = 0, maxColumna = 0, maxPse = 0, maxJunio = 0, total = 0;
        int medio = 0, mes = 0, posPse = 0, posJunio = 0;
        
        final int FILAS = 5, COLUMNAS = 6;
        int[][] matrix = new int[FILAS][COLUMNAS];
        
        int[] sumaFilas = new int[FILAS];
        int[] sumaColumnas = new int[COLUMNAS];
        
        int[] pse = new int [COLUMNAS];
        
        String[] meses = new String[8];       
        meses[0] = "Medio de Pago";
        meses[1] = "Enero";
        meses[2] = "Febrero";
        meses[3] = "Marzo";
        meses[4] = "Abril";
        meses[5] = "Mayo";
        meses[6] = "Junio";
        meses[7] = "TOTAL";

        String[] medioPago = new String[6];
        medioPago[0] = "PayPal";
        medioPago[1] = "Tarjetas";
        medioPago[2] = "Trans Bancaria";
        medioPago[3] = "Pago x Movil";
        medioPago[4] = "PSE";

        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("║ Reto 1 ║ Ciclo 2 ║ UNAB ║ Fabio Alejandro Ramirez ║");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        Scanner consola = new Scanner(System.in);

        do {
            System.out.println("<<<<<< Mineria de Datos >>>>>>>");
            System.out.println("1. Proceso de Datos");
            System.out.println("2. Salir del Sistema");
            System.out.println("Elija una opción: ");
            option = consola.nextInt();
            switch (option) {
                case 1:
                    System.out.println("*** Matriz de Forma Aleatoria ***");
                    
                     for (i = 0; i < FILAS; i++) {
                        for (j = 0; j < COLUMNAS; j++) {
                            matrix[i][j] = (int) Math.round(Math.random() * 20);
                        }
                    }
                    System.out.println("-----------------------------------------");
                    System.out.println("║            Valores Generados          ║");
                    System.out.println("-----------------------------------------"); 
                    
                    for (i = 0; i < FILAS; i++) {
                        for (j = 0; j < COLUMNAS; j++) {
                            sumaFilas[i] += matrix[i][j]; 
                            if (j==5) {
                                if (matrix[i][j] > maxJunio) {
                                    maxJunio = matrix[i][j];
                                    posJunio = i;                                    
                                }                                
                            }
                        }
                        
                        if (sumaFilas[i] > maxFila) {
                            maxFila = sumaFilas[i];
                            medio = i;
                        }
                        total += sumaFilas[i];
                    }
                    
                    for (j = 0; j < COLUMNAS; j++) {
                        for (i = 0; i < FILAS; i++) {
                            sumaColumnas[j] += matrix[i][j];
                            if (i==4) {
                                pse[j]= matrix[i][j]; 
                            }
                        }
                        if (sumaColumnas[j] > maxColumna) {
                            maxColumna = sumaColumnas[j];
                            mes = j;                            
                        }
                    }
                    
                    for (i = 0; i < 8; i++) {
                        System.out.printf("%14s║", meses[i]);
                    }
                    System.out.println();

                    for (i = 0; i < matrix.length; i++) {
                        System.out.printf("%14s║", medioPago[i]);
                        for (j = 0; j < matrix[i].length; j++) {
                            System.out.printf("%14d║", matrix[i][j]);
                        }
                        System.out.printf("%14d", sumaFilas[i]);
                        System.out.println();

                    }
                    System.out.printf("%14s", "TOTAL");
                    
                    for (i = 0; i < COLUMNAS; i++) {
                        System.out.printf("%15d", sumaColumnas[i]);
                    }
                    System.out.println();
                    
                    for ( i = 0; i < pse.length; i++) {
                        if (pse[i]>maxPse) {
                            maxPse = pse[i];
                            posPse = i;
                        }
                    }
                    System.out.println();
                    System.out.println("01. El medio de pago mas utilizado por los clientes es "+ medioPago[medio]+"  y la cantidad de transacciones son "+ maxFila);
                    System.out.println("02. El mes con mayor cantidad de transacciones es "+ meses[mes+1]+ " Con "+ maxColumna);
                    System.out.println("03. Para pago con PSE el mes con mayor transacciones es "+ meses[posPse+1]);
                    System.out.println("04. En el mes de Junio, fue el sistema de pago más utilizado es " + medioPago[posJunio]);
                    System.out.println("05. Total de transacciones realisada en los seis meses es de "+ total);
                    System.out.println("06. Mapa de medio de pago y valor de transacciones: ");
                    System.out.println();
                    
                    Map totalPago = new HashMap();
                    totalPago.put("PayPal", sumaFilas[0]);
                    totalPago.put("Tarjetas", sumaFilas[1]);
                    totalPago.put("Trans Bancaria", sumaFilas[2]);
                    totalPago.put("Pago x Movil", sumaFilas[3]);
                    totalPago.put("PSe", sumaFilas[4]);
                    
                    Set<String> keys1 = totalPago.keySet();                 
                     
                    for (String key:keys1) {
                        
                        System.out.println("----------------------------");
                        System.out.printf("║%-15s║%10d", key, totalPago.get(key));
                        System.out.println("║");
                    }
                    System.out.println("----------------------------");
                    System.out.println();
                    
                    break;
                case 2:
                    salir = true;
                    System.out.println("Gracias por utilizar el programa");
                    break;
                default:
                    System.out.println("Ingrese un dato correcto");

            }

        } while (!salir);
    }
    
}

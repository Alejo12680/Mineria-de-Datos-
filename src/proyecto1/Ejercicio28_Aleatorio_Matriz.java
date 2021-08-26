package proyecto1;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;
import java.lang.Math.*;

public class Ejercicio28_Aleatorio_Matriz {

    public static void main(String[] args) {

        boolean salir = false; //bandera 
        int option;
        int i, j;
        int maxFila, maxColumna, maxPse, maxJunio, total;
        int medio, mes, posPse, posJunio;

        final int FILAS = 5, COLUMNAS = 6;//variable constante el indicador final y la variable debe ir en mayuscula.
        int[][] matrix = new int[FILAS][COLUMNAS]; //Se crea una matriz de 5 filas y 6 columnas

        int[] sumaFilas = new int[FILAS];//vector = array 
        int[] sumaColumnas = new int[COLUMNAS];
        
        int[] pse = new int [COLUMNAS]; // vector para el mayor de esa columna

        String[] meses = new String[8];//crea un vector con los meses en fila        
        meses[0] = "Medio de Pago";
        meses[1] = "Enero";
        meses[2] = "Febrero";
        meses[3] = "Marzo";
        meses[4] = "Abril";
        meses[5] = "Mayo";
        meses[6] = "Junio";
        meses[7] = "TOTAL";

        String[] medioPago = new String[6];//crea un vector con las formas de pago en columnas
        medioPago[0] = "PayPal";
        medioPago[1] = "Tarjetas";
        medioPago[2] = "Trans Bancaria";
        medioPago[3] = "Pago x Movil";
        medioPago[4] = "PSE";

        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("║ Reto 1 ║ Ciclo 2 ║ UNAB ║ Fabio alejandro Ramirez ║");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        Scanner consola = new Scanner(System.in);

        do {
            System.out.println("<<<<<<<<<< Mineria de Datos >>>>>>>>>>>");
            System.out.println("1. Proceso de Datos");
            System.out.println("2. Salir del Sistema");
            System.out.println("Elija una opción: ");
            option = consola.nextInt();
            switch (option) {
                case 1:
                    System.out.println("*** Matriz de forma aleatoria ***");

                    for (i = 0; i < FILAS; i++) {
                        for (j = 0; j < COLUMNAS; j++) {
                            matrix[i][j] = (int) Math.round(Math.random() * 20);//Creacion de los numeros aliatorios el math.round dice que sea un numero entero y el otro metodo crea el proceso de los numeros randos. que es math.random y le damos el limite que es 20 como el mayor numero.
                        }
                    }

                    System.out.println("---------------------");
                    System.out.println("║ Valores Generados ║");
                    System.out.println("---------------------");

                    //Imprime la matriz normal de numero aleatorios y se hace el recorrido de lo creado arriba antes.
//                    for (i = 0; i < matrix.length; i++) {
//                        for (j = 0; j < matrix[i].length; j++) {
//                            System.out.print(matrix[i][j] + "|");
//                        }
//                        System.out.println();
//                    }
                    //Recorridos para hacer los totales de las columnas y filas con el vector sumafila y sumacolumnas y el += para que lo almacene y no lo sustitulla despues de cada vuelta del bucle.
                    maxFila = sumaFilas[0];//inicialicimos
                    medio = 0;
                    maxJunio=0;
                    posJunio=0;
                    total = 0;

                    for (i = 0; i < FILAS; i++) {

                        for (j = 0; j < COLUMNAS; j++) {
                            sumaFilas[i] += matrix[i][j]; //llena el vector y lo almacene y lo sume. cada cada cambio de posicion sumaFila[0] acumula la sumatoria de la fila de la matrix posicion [0] 5+ 3+ 2 + 1 y acumula el total de toda la fila en la poscion [0]=11 y cambia de posicion sumaFila[1] y empieza de nuevo posicion[1] 6 + 4 +5 +2 y lo acumula junto la anterior posicio [1]=17 y asi hasta que termine el bucle.  
                            if (j==5) {
                                if (matrix[i][j] > maxJunio) {
                                    maxJunio = matrix[i][j];
                                    posJunio = i;
                                    
                                }
                                
                            }
                        }
                        //System.out.println(sumaFilas[i]);// sumatoria de las filas 
                        if (sumaFilas[i] > maxFila) {
                            maxFila = sumaFilas[i];
                            medio = i;
                        }
                        total += sumaFilas[i];
                    }
                    System.out.println("Total de transacciones realisada en los seis meses es: "+ total);
                    System.out.println("El mayor valor de la columna de JUNIO es " + medioPago[posJunio]);
                    System.out.println("El medio de pago mas utilizado fue: "+ medioPago[medio]+" la cantidad de transacciones son "+ maxFila);
                    
                    maxColumna = sumaColumnas[0];
                    mes=0;
                    
                    for (j = 0; j < COLUMNAS; j++) {

                        for (i = 0; i < FILAS; i++) {
                            sumaColumnas[j] += matrix[i][j];// sumatoria de las columnas pasa igual que la anterior con la diferencia que ya no es en filas sino que es en columnas y va sumando cada valos de la columna.  
                            if (i==4) {
                                pse[j]= matrix[i][j]; //alamacenamiento del vector de pse con el total de valores de la comlumna
                                //forma conta 
                                /*if(i==4){// define la fila cuatro del pse
                                     if(matrix[i][j]> maxPse){ //almacena el valor mayor de la varible
                                     maxPse = matrix[i][j]; //determina el mayor de la pocision 
                                     posPse = j; // determina la posicion en la que esta el valor mayor para definir el mes.
                                }
                                }
                                System.out.println("En PSE el mes con mayor transacciones fue: "+ meses[posPse+1]); lo imprimimos fuera de los dos for.
                                */
                            }
                        }
                        //System.out.print(pse[j]+ "*");
                        //System.out.print(sumaColumnas[j]);
                        if (sumaColumnas[j] > maxColumna) {
                            maxColumna = sumaColumnas[j];
                            mes = j;
                            
                        }
                    }
                    
                    System.out.println("El mes con mayor cantidad de transacciones es "+ meses[mes+1]+ " Con "+ maxColumna);// le hacemos suma de 1 a la posicion que es la variable (mes) para reponer el valor de la pocision que le quitamos en vector anterior. 

                    //Totales de la filas unidos al final:
                    for (i = 0; i < 8; i++) {
                        System.out.printf("%15s", meses[i]);//formato de la celda es printf con "%- No. de caracteres y s si es un string o d si es un numero."
                    }
                    System.out.println();//imprime una linea vacia como un \n

                    for (i = 0; i < matrix.length; i++) {
                        System.out.printf("%15s", medioPago[i]);
                        for (j = 0; j < matrix[i].length; j++) {

                            System.out.printf("%15d", matrix[i][j]);

                        }
                        System.out.printf("%15d", sumaFilas[i]);
                        System.out.println();

                    }
                    //Al final de la matriz tiene todos los totales de las columnas.
                    System.out.printf("%15s", "TOTAL");
                    for (i = 0; i < COLUMNAS; i++) {
                        System.out.printf("%15d", sumaColumnas[i]);
                    }
                    System.out.println();
                    
                    maxPse=0;
                    posPse=0;
                    for ( i = 0; i < pse.length; i++) {
                        if (pse[i]>maxPse) {
                            maxPse = pse[i];
                            posPse = i;
                        }
                    }
                    System.out.println();
                    System.out.println("En PSE el mes con mayor transacciones fue: "+ meses[posPse+1]);
                    
                    Map totalPago = new HashMap();
                    totalPago.put("PayPal", sumaFilas[0]);
                    totalPago.put("Tarjetas", sumaFilas[1]);
                    totalPago.put("Trans Bancaria", sumaFilas[2]);
                    totalPago.put("Pago x Movil", sumaFilas[3]);
                    totalPago.put("PSe", sumaFilas[4]);
                    
                    Set<String> keys1 = totalPago.keySet();                 
                     
                    for (String key:keys1) {
                        //System.out.println(key+totalPago.get(key));
                                          
                        System.out.printf("|%-15s|%10d", key, totalPago.get(key));
                        System.out.println("|");
                    }
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

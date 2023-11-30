import java.util.Random;
/**
 * Genera números aleatorios entre 1 y 7 usando una función que genera números aleatorios entre 1 y 5.
 * Hay dos opciones:
 * @see getAleatorioUnoASiete() (mejor)
 * @see getAleatorioUnoASieteV2() (peor)
 * 
 * @author Gonzalo Franco Gimeno
 */
public class ejercicioAleatorios {

    public static void main(String[] args) {
        //Pruebas de la función getAleatorioUnoASiete()
        //Genera n números aleatorios entre 1 y 7 y muestra las frecuencias de cada uno
        int[] frecuencias = new int[7];
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            //int aleatorio = getAleatorioUnoASieteV2();
            int aleatorio = getAleatorioUnoASiete();
            frecuencias[aleatorio - 1]++;
        }
        System.out.println("Frecuencias de los números aleatorios entre 1 y 7:");
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.print("Número " + (i + 1) + ": " + frecuencias[i]);
            System.out.printf(" (%.2f%%)\n", (float) frecuencias[i] / n * 100);
        }
    }

    /**
     * Opción 1 (mejor):
     * Utilizar una combinación de dos números [1,5] para generar un número entre 1 y 25,
     * descartar los números [22,25] y convertir los 21 restantes en un número entre 1 y 7.
     * 
     * Ventajas: en la mayoría de casos, es bastante eficiente (solo 2 o 4 llamadas).
     *           La distribución es totalmente aleatoria.
     * Limitaciones: el número de veces que se llama a la función getAleatorioUnoACinco() es incierto.	
     * 
     * @return un entero aleatorio entre 1 y 7
     */
    
    private static int getAleatorioUnoASiete() {
        int aleatorio = 0;
        while (aleatorio == 0) {
            int cifra1 = getAleatorioUnoACinco();
            int cifra2 = getAleatorioUnoACinco();
            int posibles25 = (cifra1 - 1) * 5 + cifra2; //Convierte ambas cifras en un número entre 1 y 25
            if (posibles25 <= 21) { //descarta los números entre 22 y 25
                aleatorio = posibles25 % 7 + 1; //Convierte el número entre 1 y 21 en un número entre 1 y 7 usando el módulo
            }
        }
        return aleatorio;
    }

    /**
     * Opción 2 (bastante peor):
     * Sumar n números aleatorios entre 1 y 5 y convertir el resultado en un número entre 1 y 7.
     
     * Ventajas: tiempo de ejecución finito y predecible.
     * Limitaciones: NO es verdaderamente aleatorio, pero es una buena aproximación.
     *              no es muy eficiente (n llamadas a la función getAleatorioUnoACinco()).
     *           
     * @return un entero aleatorio entre 1 y 7
     */
    private static int getAleatorioUnoASieteV2() {
        int n = 10; //número de rondas, más rondas => menos sesgado	
        int aleatorio = 0;
        int suma = 0;
        for (int i = 0; i < n; i++) 
            suma += getAleatorioUnoACinco();
        aleatorio = suma % 7 + 1; 
        return aleatorio;
    }

    /** @return un entero aleatorio entre 1 y 5 */
    private static int getAleatorioUnoACinco() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
}

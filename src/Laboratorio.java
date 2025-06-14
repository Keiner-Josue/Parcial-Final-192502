public class Laboratorio {

    
    public static int contarDiasCalurosos(int[][] matriz) {
        int contador = 0;
        for (int[] ciudad : matriz) {
            for (int temp : ciudad) {
                if (temp > 30) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static double promedioDiasFrescos(int[][] matriz) {
        int suma = 0;
        int contador = 0;
        for (int[] ciudad : matriz) {
            for (int temp : ciudad) {
                if (temp < 20) {
                    suma += temp;
                    contador++;
                }
            }
        }
        return (contador == 0) ? 0 : (double) suma / contador;
    }

    public static void imprimirTemperaturasExtremas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int temp = matriz[i][j];
                if (temp < 10 || temp > 35) {
                    System.out.println("Temp extrema: " + temp + "°C en posición [" + i + "][" + j + "]");
                }
            }
        }
    }

    public static int[] posicionTemperaturaMasAlta(int[][] matriz) {
        int maxTemp = Integer.MIN_VALUE;
        int[] posicion = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maxTemp) {
                    maxTemp = matriz[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    public static void imprimirPromedioPorCiudad(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int temp : matriz[i]) {
                suma += temp;
            }
            double promedio = (double) suma / matriz[i].length;
            System.out.println("Promedio Ciudad " + i + ": " + promedio + "°C");
        }
    }

    public static void main(String[] args) {
        int[][] temperaturas = {
            {22, 35, 19, 38, 17, 28, 31},
            {15, 9, 10, 33, 36, 21, 25},
            {18, 20, 22, 19, 8, 10, 30}
        };

        System.out.println("Días calurosos (>30°C): " + contarDiasCalurosos(temperaturas));
        System.out.println("Promedio de días frescos (<20°C): " + promedioDiasFrescos(temperaturas));
        imprimirTemperaturasExtremas(temperaturas);

        int[] posMax = posicionTemperaturaMasAlta(temperaturas);
        System.out.println("Temperatura más alta en posición: [" + posMax[0] + "][" + posMax[1] + "]");
        
        imprimirPromedioPorCiudad(temperaturas);
    }
}

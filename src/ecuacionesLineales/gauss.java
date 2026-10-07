package ecuacionesLineales;

/**
 * Contiene los métodos para resolver un sistema de ecuaciones
 * mediante el método de eliminación de Gauss.
 */
public class gauss {

    /**
     * Realiza la eliminación gaussiana sobre una matriz aumentada.
     *
     * @param matriz matriz aumentada del sistema de ecuaciones
     */
    public static void eliminacionGaussiana(double[][] matriz) {

        int n = matriz.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                double factor = matriz[j][i] / matriz[i][i];

                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    /**
     * Obtiene las soluciones mediante sustitución regresiva.
     *
     * @param matriz matriz después de la eliminación gaussiana
     * @return arreglo con las soluciones
     */
    public static double[] sustitucionRegresiva(double[][] matriz) {

        int n = matriz.length;
        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {

            double suma = 0;

            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j];
            }

            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        return x;
    }
}
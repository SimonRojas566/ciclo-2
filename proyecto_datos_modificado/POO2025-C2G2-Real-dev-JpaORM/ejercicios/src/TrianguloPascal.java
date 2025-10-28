import java.util.Scanner;

public class TrianguloPascal {

    public static void dibujarTrianguloPascal(int tamaño) {
        // Validar que el tamaño sea positivo
        if (tamaño <= 0) {
            System.out.println("El tamaño debe ser un número positivo.");
            return;
        }

        // Crear matriz para almacenar los valores
        int[][] triangulo = new int[tamaño][];

        // Calcular los valores del triángulo
        for (int i = 0; i < tamaño; i++) {
            triangulo[i] = new int[i + 1];
            triangulo[i][0] = 1; // Primer elemento siempre es 1
            triangulo[i][i] = 1; // Último elemento siempre es 1

            // Calcular valores internos
            for (int j = 1; j < i; j++) {
                triangulo[i][j] = triangulo[i-1][j-1] + triangulo[i-1][j];
            }
        }

        // Calcular espaciado para centrar
        int espacios = tamaño - 1;

        // Dibujar el triángulo
        System.out.println("\nTriángulo de Pascal de tamaño " + tamaño + ":");
        System.out.println("----------------------------------------");

        for (int i = 0; i < tamaño; i++) {
            // Espacios para centrar
            for (int s = 0; s < espacios; s++) {
                System.out.print("  ");
            }
            espacios--;

            // Imprimir números de la fila
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", triangulo[i][j]);
            }
            System.out.println();
        }
    }

    // Versión alternativa más compacta
    public static void dibujarTrianguloPascalCompacto(int tamaño) {
        if (tamaño <= 0) {
            System.out.println("El tamaño debe ser un número positivo.");
            return;
        }

        System.out.println("\nTriángulo de Pascal (versión compacta):");
        System.out.println("----------------------------------------");

        for (int i = 0; i < tamaño; i++) {
            // Espacios para centrar
            for (int s = 0; s < tamaño - i - 1; s++) {
                System.out.print(" ");
            }

            int numero = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(numero + " ");
                numero = numero * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GENERADOR DEL TRIÁNGULO DE PASCAL ===");

        while (true) {
            System.out.print("\nIngresa el tamaño del lado del triángulo (0 para salir): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar buffer
                continue;
            }

            int tamaño = scanner.nextInt();

            if (tamaño == 0) {
                System.out.println("¡Hasta luego!");
                break;
            }

            if (tamaño < 0) {
                System.out.println("El tamaño no puede ser negativo.");
                continue;
            }

            if (tamaño > 20) {
                System.out.println("Tamaño muy grande. Se recomienda máximo 20 para mejor visualización.");
                System.out.print("¿Continuar de todos modos? (s/n): ");
                String respuesta = scanner.next();
                if (!respuesta.equalsIgnoreCase("s")) {
                    continue;
                }
            }

            // Dibujar ambas versiones
            dibujarTrianguloPascal(tamaño);
            dibujarTrianguloPascalCompacto(tamaño);
        }

        scanner.close();
    }
}
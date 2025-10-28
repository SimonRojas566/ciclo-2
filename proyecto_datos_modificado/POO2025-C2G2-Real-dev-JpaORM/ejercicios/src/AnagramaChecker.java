import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramaChecker {

    public static boolean sonAnagramas(String palabra1, String palabra2) {
        if (palabra1.length() != palabra2.length()) {
            return false;
        }

        palabra1 = palabra1.toLowerCase().replace(" ", "");
        palabra2 = palabra2.toLowerCase().replace(" ", "");

        Map<Character, Integer> frecuencia = new HashMap<>();

        for (char c : palabra1.toCharArray()) {
            frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
        }

        for (char c : palabra2.toCharArray()) {
            if (!frecuencia.containsKey(c)) {
                return false;
            }
            frecuencia.put(c, frecuencia.get(c) - 1);
            if (frecuencia.get(c) == 0) {
                frecuencia.remove(c);
            }
        }

        return frecuencia.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        System.out.println("=== VERIFICADOR DE ANAGRAMAS ===");

        do {
            System.out.println("\n--- Nueva Verificación ---");

            // Solicitar palabras
            System.out.print("Ingresa la primera palabra: ");
            String palabra1 = scanner.nextLine();

            System.out.print("Ingresa la segunda palabra: ");
            String palabra2 = scanner.nextLine();

            // Verificar si son anagramas
            boolean resultado = sonAnagramas(palabra1, palabra2);

            // Mostrar resultado
            System.out.println("\n--- RESULTADO ---");
            System.out.println("Palabra 1: '" + palabra1 + "'");
            System.out.println("Palabra 2: '" + palabra2 + "'");

            if (resultado) {
                System.out.println(" ¡SON ANAGRAMAS!");
                System.out.println("Explicación: Ambas palabras contienen las mismas letras en la misma cantidad, solo en diferente orden.");
            } else {
                System.out.println(" NO son anagramas");
                System.out.println("Explicación: Las palabras tienen letras diferentes o las mismas letras en cantidades distintas.");
            }

            // Preguntar si quiere continuar
            System.out.print("\n¿Quieres verificar otro par de palabras? (s/n): ");
            opcion = scanner.nextLine();

        } while (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("si"));

        System.out.println("¡Gracias por usar el verificador de anagramas!");
        scanner.close();
    }
}
import java.util.Scanner;

public class CifradoCesar {

    // Método para cifrar un texto
    public static String cifrar(String texto, int desplazamiento) {
        return procesarTexto(texto, desplazamiento, true);
    }

    // Método para descifrar un texto
    public static String descifrar(String texto, int desplazamiento) {
        return procesarTexto(texto, desplazamiento, false);
    }

    // Método principal que realiza el cifrado/descifrado
    private static String procesarTexto(String texto, int desplazamiento, boolean esCifrado) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        StringBuilder resultado = new StringBuilder();

        // Ajustar desplazamiento para descifrado
        if (!esCifrado) {
            desplazamiento = -desplazamiento;
        }

        // Normalizar desplazamiento
        desplazamiento = desplazamiento % 26;
        if (desplazamiento < 0) {
            desplazamiento += 26;
        }
  
        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                char cifrado = (char) ((caracter - base + desplazamiento) % 26 + base);
                resultado.append(cifrado);
            } else {
                // Mantener caracteres que no son letras sin cambios
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    // Método para mostrar información sobre el cifrado César
    public static void mostrarInformacion() {
        System.out.println("\n INFORMACIÓN SOBRE EL CIFRADO CÉSAR");
        System.out.println("=====================================");
        System.out.println("• Desarrollado por Julio César para comunicaciones militares");
        System.out.println("• Es un cifrado por sustitución donde cada letra se desplaza");
        System.out.println("  una cantidad fija de posiciones en el alfabeto");
        System.out.println("• Ejemplo con desplazamiento 3:");
        System.out.println("  A → D, B → E, C → F, ..., X → A, Y → B, Z → C");
        System.out.println("• Texto: 'HOLA' → Cifrado: 'KROD'");
        System.out.println("• Para descifrar, usar el mismo desplazamiento pero en sentido contrario");
    }

    // Método para probar con ejemplos
    public static void mostrarEjemplos() {
        System.out.println("\n EJEMPLOS PRÁCTICOS:");
        System.out.println("Texto original: 'HOLA MUNDO'");

        int[] desplazamientos = {3, 7, 13};
        for (int desplazamiento : desplazamientos) {
            String cifrado = cifrar("HOLA MUNDO", desplazamiento);
            String descifrado = descifrar(cifrado, desplazamiento);
            System.out.printf("Desplazamiento %2d: '%s' → '%s' → '%s'%n",
                    desplazamiento, "HOLA MUNDO", cifrado, descifrado);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" CIFRADO CÉSAR - PROGRAMA COMPLETO");
        System.out.println("=====================================");

        mostrarInformacion();
        mostrarEjemplos();

        while (true) {
            System.out.println("\n MENÚ PRINCIPAL:");
            System.out.println("1. Cifrar texto");
            System.out.println("2. Descifrar texto");
            System.out.println("3. Mostrar información");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción (1-4): ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    realizarCifrado(scanner, true);
                    break;
                case "2":
                    realizarCifrado(scanner, false);
                    break;
                case "3":
                    mostrarInformacion();
                    mostrarEjemplos();
                    break;
                case "4":
                    System.out.println(" ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println(" Opción no válida. Por favor, selecciona 1-4.");
            }
        }
    }

    private static void realizarCifrado(Scanner scanner, boolean esCifrado) {
        String operacion = esCifrado ? "cifrar" : "descifrar";

        System.out.printf("\n %s TEXTO%n", esCifrado ? "CIFRAR" : "DESCIFRAR");
        System.out.println("-------------------");

        // Solicitar texto
        System.out.printf("Ingresa el texto a %s: ", operacion);
        String texto = scanner.nextLine();

        // Solicitar desplazamiento
        int desplazamiento = 0;
        while (true) {
            System.out.print("Ingresa el desplazamiento (1-25): ");
            if (scanner.hasNextInt()) {
                desplazamiento = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                if (desplazamiento >= 1 && desplazamiento <= 25) {
                    break;
                } else {
                    System.out.println(" El desplazamiento debe estar entre 1 y 25.");
                }
            } else {
                System.out.println(" Por favor, ingresa un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }

        // Realizar operación
        String resultado;
        if (esCifrado) {
            resultado = cifrar(texto, desplazamiento);
        } else {
            resultado = descifrar(texto, desplazamiento);
        }

        // Mostrar resultados
        System.out.println("\n RESULTADO:");
        System.out.println("Texto original: '" + texto + "'");
        System.out.println("Desplazamiento: " + desplazamiento);
        System.out.printf("Texto %sdo: '%s'%n", operacion, resultado);

        // Mostrar comparación caracter por caracter (solo para textos cortos)
        if (texto.length() <= 50) {
            System.out.println("\n COMPARACIÓN DETALLADA:");
            System.out.println("Original:  " + texto);
            if (esCifrado) {
                System.out.println("Cifrado:   " + resultado);
            } else {
                System.out.println("Descifrado: " + resultado);
            }
        }

        // Preguntar si quiere realizar la operación inversa
        if (texto.length() > 0) {
            System.out.print("\n¿Quieres " + (esCifrado ? "descifrar" : "cifrar") +
                    " este resultado? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                String operacionInversa;
                if (esCifrado) {
                    operacionInversa = descifrar(resultado, desplazamiento);
                } else {
                    operacionInversa = cifrar(resultado, desplazamiento);
                }
                System.out.println(" Operación inversa: '" + operacionInversa + "'");
            }
        }
    }
}
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {

        int totalLibros = 0;
        int totalRevistas = 0;
        int totalAudio = 0;
        int opcion = -1;
        int contL = 0;
        int contR = 0;
        int contA = 0;
        String nombreL = "";
        String autorL = "";
        String nombreR = "";
        String autorR = "";
        String nombreA = "";
        String autorA = "";
        boolean encontrado = false;

        Scanner eleccion = new Scanner(System.in);

        System.out.println("Hola, ¿Cuántos libros tiene?");
        totalLibros = eleccion.nextInt();
        System.out.println("¿Cuántas revistas tiene?");
        totalRevistas = eleccion.nextInt();
        System.out.println("¿Cuántos audiolibros tiene?");
        totalAudio = eleccion.nextInt();

        String[][] Libros = new String[totalLibros][2];
        String[][] Revistas = new String[totalRevistas][2];
        String[][] AudioLibros = new String[totalAudio][2];
        boolean[] LibrosLeidos = new boolean[totalLibros];
        boolean[] RevistasLeidas = new boolean[totalRevistas];
        boolean[] AudioLeidos = new boolean[totalAudio];

        while (opcion != 0) {
            System.out.println("\n--Biblioteca digital--");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Revista");
            System.out.println("3. Registrar Audiolibro");
            System.out.println("4. Buscar libro por titulo");
            System.out.println("5. Buscar revista por titulo");
            System.out.println("6. Buscar audiolibro por titulo");
            System.out.println("7. Buscar libro por autor");
            System.out.println("8. Buscar revista por autor");
            System.out.println("9. Buscar audiolibro por autor");
            System.out.println("10. Marcar libro como leido");
            System.out.println("11. Marcar revista como leida");
            System.out.println("12. Marcar audiolibro como leido");
            System.out.println("13. Consultar contenidos leidos");
            System.out.println("0. Salir");

            opcion = eleccion.nextInt();
            eleccion.nextLine();

            switch (opcion) {
                case 1:
                    if (contL < totalLibros) {
                        System.out.println("Ingrese el nombre del Libro: ");
                        nombreL = eleccion.nextLine();
                        Libros[contL][0] = nombreL;
                        System.out.println("Ingrese el autor del Libro: ");
                        autorL = eleccion.nextLine();
                        Libros[contL][1] = autorL;
                        contL++;
                        System.out.println("El libro fue registrado exitosamente.");
                    } else {
                        System.out.println("Ya registraste todos tus libros.");
                    }
                    break;

                case 2:
                    if (contR < totalRevistas) {
                        System.out.println("Ingrese el nombre de la Revista: ");
                        nombreR = eleccion.nextLine();
                        Revistas[contR][0] = nombreR;
                        System.out.println("Ingrese el autor de la Revista: ");
                        autorR = eleccion.nextLine();
                        Revistas[contR][1] = autorR;
                        contR++;
                        System.out.println("La revista fue registrada exitosamente.");
                    } else {
                        System.out.println("Ya registraste todas tus revistas.");
                    }
                    break;

                case 3:
                    if (contA < totalAudio) {
                        System.out.println("Ingrese el nombre del Audiolibro: ");
                        nombreA = eleccion.nextLine();
                        AudioLibros[contA][0] = nombreA;
                        System.out.println("Ingrese el autor del Audiolibro: ");
                        autorA = eleccion.nextLine();
                        AudioLibros[contA][1] = autorA;
                        contA++;
                        System.out.println("El audiolibro fue registrado exitosamente.");
                    } else {
                        System.out.println("Ya registraste todos tus audiolibros.");
                    }
                    break;

                case 4:
                    encontrado = false;
                    System.out.println("Ingrese el titulo:");
                    nombreL = eleccion.nextLine();
                    for (int i = 0; i < contL; i++) {
                        if (Libros[i][0].equals(nombreL)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("El libro esta registrado.");
                    } else {
                        System.out.println("El libro no esta registrado.");
                    }
                    break;

                case 5:
                    encontrado = false;
                    System.out.println("Ingrese el titulo:");
                    nombreR = eleccion.nextLine();
                    for (int i = 0; i < contR; i++) {
                        if (Revistas[i][0].equals(nombreR)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("La revista esta registrada.");
                    } else {
                        System.out.println("La revista no esta registrada.");
                    }
                    break;

                case 6:
                    encontrado = false;
                    System.out.println("Ingrese el titulo:");
                    nombreA = eleccion.nextLine();
                    for (int i = 0; i < contA; i++) {
                        if (AudioLibros[i][0].equals(nombreA)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("El audiolibro esta registrado.");
                    } else {
                        System.out.println("El audiolibro no esta registrado.");
                    }
                    break;

                case 7:
                    encontrado = false;
                    System.out.println("Ingrese el nombre del autor:");
                    autorL = eleccion.nextLine();
                    for (int i = 0; i < contL; i++) {
                        if (Libros[i][1].equals(autorL)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("El libro esta registrado.");
                    } else {
                        System.out.println("El libro no esta registrado.");
                    }
                    break;

                case 8:
                    encontrado = false;
                    System.out.println("Ingrese el nombre del autor:");
                    autorR = eleccion.nextLine();
                    for (int i = 0; i < contR; i++) {
                        if (Revistas[i][1].equals(autorR)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("La revista esta registrada.");
                    } else {
                        System.out.println("La revista no esta registrada.");
                    }
                    break;

                case 9:
                    encontrado = false;
                    System.out.println("Ingrese el nombre del autor:");
                    autorA = eleccion.nextLine();
                    for (int i = 0; i < contA; i++) {
                        if (AudioLibros[i][1].equals(autorA)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("El audiolibro esta registrado.");
                    } else {
                        System.out.println("El audiolibro no esta registrado.");
                    }
                    break;

                case 10:
                    encontrado = false;
                    System.out.println("Ingrese el titulo del libro leido:");
                    nombreL = eleccion.nextLine();
                    for (int i = 0; i < contL; i++) {
                        if (Libros[i][0].equals(nombreL)) {
                            LibrosLeidos[i] = true;
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("Libro marcado como leido.");
                    } else {
                        System.out.println("El libro no esta registrado.");
                    }
                    break;

                case 11:
                    encontrado = false;
                    System.out.println("Ingrese el titulo de la revista leida:");
                    nombreR = eleccion.nextLine();
                    for (int i = 0; i < contR; i++) {
                        if (Revistas[i][0].equals(nombreR)) {
                            RevistasLeidas[i] = true;
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("Revista marcada como leida.");
                    } else {
                        System.out.println("La revista no esta registrada.");
                    }
                    break;

                case 12:
                    encontrado = false;
                    System.out.println("Ingrese el titulo del audiolibro leido:");
                    nombreA = eleccion.nextLine();
                    for (int i = 0; i < contA; i++) {
                        if (AudioLibros[i][0].equals(nombreA)) {
                            AudioLeidos[i] = true;
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("Audiolibro marcado como leido.");
                    } else {
                        System.out.println("El audiolibro no esta registrado.");
                    }
                    break;

                case 13:
                    System.out.println("\n-- Contenidos leidos --");
                    System.out.println("Libros:");
                    for (int i = 0; i < contL; i++) {
                        if (LibrosLeidos[i]) {
                            System.out.println("  " + Libros[i][0] + " - " + Libros[i][1]);
                        }
                    }
                    System.out.println("Revistas:");
                    for (int i = 0; i < contR; i++) {
                        if (RevistasLeidas[i]) {
                            System.out.println("  " + Revistas[i][0] + " - " + Revistas[i][1]);
                        }
                    }
                    System.out.println("Audiolibros:");
                    for (int i = 0; i < contA; i++) {
                        if (AudioLeidos[i]) {
                            System.out.println("  " + AudioLibros[i][0] + " - " + AudioLibros[i][1]);
                        }
                    }
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intentelo de nuevo.");
                    break;
            }
        }
    }
}

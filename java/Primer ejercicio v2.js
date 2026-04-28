import java.util.Scanner;

public class PrimerEjercicio 
{
    
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   AGENCIA SECRETA DE DETECTIVES");
        System.out.println("         Caso: SOMBRA OCULTA");
        System.out.println("================================");

        System.out.println("¡Hola detective!");

        System.out.print("¿Cual es tu nombre? ");
        String nombre = teclado.nextLine();

        System.out.println("Bienvenido, " + nombre);
 
        System.out.print("Antes de comenzar, confirmemos tu edad ¿Cuantos años tienes? ");
        int edad = teclado.nextInt();

        if(edad < 12)
        {
            System.out.println("Vuelve cuando tengas la edad suficiente.");
            return;
        }
                
        if(edad >= 60)
        {
            System.out.println("¡Feliz retiro!");
            return;
        }

        if(edad >= 18)
        {
            System.out.println("¡Bienvenido al equipo de detectives!");
        }
        else
        {
            System.out.println("Puedes ser detective Junior.");
        }

        String[] sospechosos = {
            "Victoria Mendoza",
            "Aurelio Vásquez",
            "Bruno",
            "Simón Quiroga"
        };

        System.out.println("\nTenemos 4 posibles sospechosos en el caso:");
        for(int i = 0; i < sospechosos.length; i++)
        {
            System.out.println((i + 1) + ". " + sospechosos[i]);
        }

        System.out.print("\nElige quién crees que es el culpable: ");
        int sospechosoElegido = teclado.nextInt();
        teclado.nextLine();

        int pistas = 0;
        int opcion;
        boolean casoResuelto = false;
        boolean acusado = false;

        System.out.print("\n¡Tu misión es encontrar al verdadero culpable!");
        System.out.print("\nReune pistas e interroga sospechosos para encontrar a nuestro asesino");

        do
        {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Buscar pistas");
            System.out.println("2. Interrogar sospechosos");
            System.out.println("3. Acusar sospechoso");
            System.out.println("4. Respuesta del caso");
            System.out.print("Elige una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch(opcion)
            {
                case 1:

                    if(pistas == 4)
                    {
                        System.out.println("Ya buscaste pistas aquí, no hay más.");
                        break;
                    }

                    System.out.println("\nBuscando pistas...");

                    String[] evidencias = {
                        "Huella digital en la ventana",
                        "Copa de vino con residuos",
                        "Nota rasgada en el escritorio",
                        "Cuchillo en la cocina"
                    };

                    String decision = "si";
                    int i = pistas;

                    while(i < evidencias.length && decision.equals("si"))
                    {
                        System.out.println("\nPista " + (i + 1) + ": " + evidencias[i]);
                        pistas++;

                        if(i < evidencias.length - 1)
                        {
                            System.out.print("¿Deseas buscar otra pista (si) o intentar resolver (no)? ");
                            decision = teclado.nextLine();
                        }
                        else
                        {
                            System.out.println("Ya no hay más pistas.");
                        }

                        i++;
                    }

                    System.out.println("Saliste de la búsqueda de pistas.");
                    break;

                case 2:
                    System.out.println("\n¿A quién deseas interrogar?");
                    for(int j = 0; j < sospechosos.length; j++)
                    {
                        System.out.println((j + 1) + ". " + sospechosos[j]);
                    }

                    System.out.print("Elige una opcion: ");
                    int elegido = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("\n--- INTERROGATORIO ---");
                    System.out.println("Sospechoso: " + sospechosos[elegido - 1]);

                    // COARTADAS (NUEVO)
                    if(elegido == 1)
                    {
                        System.out.println("Coartada: Estaba en casa viendo televisión toda la noche.");
                    }
                    else if(elegido == 2)
                    {
                        System.out.println("Coartada: Estaba revisando documentos en su oficina privada hasta tarde.");
                    }
                    else if(elegido == 3)
                    {
                        System.out.println("Coartada: Salió a comprar comida alrededor de las 10:30 PM.");
                    }
                    else if(elegido == 4)
                    {
                        System.out.println("Coartada: Dice que estaba dormido y nadie lo vio salir.");
                    }

                    System.out.println("... " + sospechosos[elegido - 1] + " dice que es inocente.");

                    break;

                case 3:

                    if(pistas < 3)
                    {
                        System.out.println("Necesitas al menos 3 pistas para acusar.");
                        break;
                    }

                    System.out.println("\nAcusando sospechoso...");

                    System.out.print("¿Deseas acusar a tu sospechoso actual (" + sospechosos[sospechosoElegido - 1] + ")? (si/no): ");
                    String acusar = teclado.nextLine();

                    if(acusar.equals("no"))
                    {
                        System.out.println("\nElige a quién acusar:");
                        for(int k = 0; k < sospechosos.length; k++)
                        {
                            System.out.println((k + 1) + ". " + sospechosos[k]);
                        }

                        System.out.print("Nueva elección: ");
                        sospechosoElegido = teclado.nextInt();
                        teclado.nextLine();
                    }

                    acusado = true;

                    if(sospechosos[sospechosoElegido - 1].equals("Aurelio Vásquez"))
                    {
                        System.out.println("¡Correcto! Has atrapado al culpable.");
                        casoResuelto = true;
                    }
                    else
                    {
                        System.out.println("Fallaste... No era el culpable.");
                        System.out.println("Ahora puedes ver la respuesta del caso.");
                    }

                    break;

                case 4:

                    if(!acusado)
                    {
                        System.out.println("Primero debes acusar a un sospechoso.");
                        break;
                    }

                    System.out.println("\nRespuesta del caso...");
                    System.out.println("El verdadero culpable es: Aurelio Vásquez");
                    System.out.println("Caso cerrado, detective " + nombre);
                    casoResuelto = true;

                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while(!casoResuelto);

        System.out.println("\nFin del juego.");
        teclado.close();
    }
}

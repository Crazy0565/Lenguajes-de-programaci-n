import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class Calculadora {

    public static double suma(double a, double b)
    {
        return a + b;
    }
    public static double resta(double a, double b)
    {
        return a - b;
    }
    public static double multiplicacion(double a, double b)
    {
        return a * b;
    }
    public static double division(double a, double b)
    {
        return a / b;
    }
    public static double potencia(double base, double exponente)
    {
        return Math.pow(base, exponente);
    }
    public static double raiz(double a)
    {
        return Math.sqrt(a);
    }
    public static double seno(double angulo)
    {
        return Math.sin(Math.toRadians(angulo));
    }
    public static double coseno(double angulo)
    {
        return Math.cos(Math.toRadians(angulo));
    }

    public static void main(String[] args)
    {

        double resultado;
        int opcion;
        Scanner opc = new Scanner(System.in);

        ArrayList<String> Historial= new ArrayList<>();

        System.out.println("¡Hola, ¿Qué deseas hacer hoy?");
        System.out.println("========= Calculadora =========");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potencia");
        System.out.println("6. Raíz cuadrada");
        System.out.println("7. Seno");
        System.out.println("8. Coseno");
        System.out.println("9. Ver historial");

        opcion = opc.nextInt();

        switch(opcion){
            case 1:
                System.out.print("Ingresa un número: ");
                double a = opc.nextDouble();

                System.out.print("Ingresa el otro número: ");
                double b = opc.nextDouble();

                resultado = suma(a, b);
                System.out.println("Resultado: " + resultado);
                Historial.add("Suma: "+ a +"+"+b+"="+ resultado);
            break;

            case 2:
                System.out.print("Ingresa un número: ");
                a = opc.nextDouble();

                System.out.print("Ingresa el otro número: ");
                b = opc.nextDouble();

                resultado = resta(a, b);
                System.out.println("Resultado: " + resultado);
                Historial.add("Resta: "+ a +"-"+b+"="+ resultado);
            break;

            case 3:
                System.out.print("Ingresa un número: ");
                a = opc.nextDouble();

                System.out.print("Ingresa el otro número: ");
                b = opc.nextDouble();

                resultado = multiplicacion(a, b);
                System.out.println("Resultado: " + resultado);
                Historial.add("Multiplicación: "+ a +"*"+b+"="+ resultado);
            break;

            case 4:
                System.out.print("Ingresa el dividendo: ");
                a = opc.nextDouble();

                System.out.print("Ingresa el divisor: ");
                b = opc.nextDouble();

                try
                {
                   if(b==0) throw new Exception("No se puede dividir por 0");
                   resultado= division(a,b);
                   System.out.println("Resultado: " + resultado);
                   Historial.add("División: "+ a +"/"+b+"="+ resultado);
                }
                catch (Exception e)
                {
                    System.out.println("Error: "+ e.getMessage());
                }

            break;

            case 5:
                System.out.print("Ingresa la base: ");
                double base = opc.nextDouble();

                System.out.print("Ingresa el exponente: ");
                double exponente = opc.nextDouble();

                resultado = potencia(base, exponente);
                System.out.println("Resultado: " + resultado);
                Historial.add("Potencia: "+ base +"**"+ exponente +"="+ resultado);
            break;

            case 6:
                System.out.println("Ingrese el número: ");
                a = opc.nextDouble();
                resultado = raiz(a);
                System.out.println("Resultado: " + resultado);
                Historial.add("Raíz: √"+a+" ="+ resultado);
            break;

            case 7:
                System.out.println("Ingrese el ángulo: ");
                a = opc.nextDouble();
                resultado = seno(a);
                System.out.println("Resultado: " + resultado);
                Historial.add("seno: sin("+a+") ="+ resultado);
            break;

            case 8:
                System.out.println("Ingrese el ángulo: ");
                a = opc.nextDouble();
                resultado = coseno(a);
                System.out.println("Resultado: " + resultado);
                Historial.add("coseno: cos("+a+") ="+ resultado);
            break;

            case 9:
                if (Historial.isEmpty())
                    {
                        System.out.println("No se hanrealizado operaciones.");
               
                    }else
                        {
                            System.out.println("Historial");
                            for(int i=0; i < Historial.size() ;i++)
                                {
                                    System.out.println(Historial.get(i));
                                }
                        }
            break;

            default:
                System.out.println("Opción no válida. Intentelo de nuevo.");
            break;

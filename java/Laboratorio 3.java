import java.util.*;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> nom = new HashMap<>();
        HashMap<String, String> cat = new HashMap<>();
        HashMap<String, Double> pre = new HashMap<>();
        HashMap<String, Integer> stk = new HashMap<>();
        HashMap<String, Integer> min = new HashMap<>();
        ArrayList<String> ventas = new ArrayList<>();

        HashMap<String, Integer> cont = new HashMap<>();
        cont.put("C",2); cont.put("CF",2); cont.put("B",1); cont.put("A",);

        nom.put("C001","Arroz Roa"); cat.put("C001","Carbohidratos"); pre.put("C001",3000.0); stk.put("C001",10); min.put("C001",3);
        nom.put("CF001","Salchicha Zenu"); cat.put("CF001","Carnes Frias"); pre.put("CF001",5000.0); stk.put("CF001",5); min.put("CF001",2);
        nom.put("B001","Manzana Postobon"); cat.put("B001","Bebidas"); pre.put("B001",2500.0); stk.put("B001",8); min.put("B001",2);
        nom.put("A001","Jabon Rey"); cat.put("A001","Aseo"); pre.put("A001",1500.0); stk.put("A001",12); min.put("A001",3);

        int op;

        do
        {
            System.out.println("\n======== TIENDA ========");
            System.out.println("1. Agregar Producto\n2. Realizar Venta\n3. Ver Inventario\n4. Ventas Realizadas\n5. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt(); sc.nextLine();

            if (op == 1)
            {
                System.out.println("1.Carbohidratos \n2.Carnes Frias \n3.Bebidas \n4.Aseo:");
                int c = sc.nextInt(); sc.nextLine();

                String[] p = {"C","CF","B","A"};
                String[] n = {"Carbohidratos","Carnes Frias","Bebidas","Aseo"};

                String pref = p[c-1], categoria = n[c-1];
                String cod = pref + String.format("%03d", cont.get(pref));
                cont.put(pref, cont.get(pref)+1);

                System.out.print("Nombre del producto: "); nom.put(cod, sc.nextLine());
                cat.put(cod, categoria);
                System.out.print("Valor unitario: "); pre.put(cod, sc.nextDouble());
                System.out.print("Stock disponible: "); stk.put(cod, sc.nextInt());
                System.out.print("Mínimo: "); min.put(cod, sc.nextInt()); sc.nextLine();

                System.out.println("Codigo: " + cod);
            }

            if (op == 2)
            {
                for (String c : nom.keySet())
                    System.out.println(nom.get(c) + " | " + c);

                System.out.print("Codigo: ");
                String c = sc.nextLine();

                if (!stk.containsKey(c))
                {
                    System.out.println("No existe");
                    continue;
                }

                System.out.print("Cantidad: ");
                int cant = sc.nextInt(); sc.nextLine();

                if (stk.get(c) >= cant)
                {
                    stk.put(c, stk.get(c) - cant);
                    double t = cant * pre.get(c);

                    String v = nom.get(c) + " x" + cant + " = " + t;
                    ventas.add(v);

                    System.out.println("Venta: " + v);
                }
                else
                {
                    System.out.println("Stock insuficiente");
                }
            }

            if (op == 3)
            {
                ArrayList<String> l = new ArrayList<>(nom.keySet());
                Collections.sort(l);

                for (String c : l)
                {
                    System.out.println(nom.get(c) + " | " + c + " | " + stk.get(c));
                    if (stk.get(c) < min.get(c)) System.out.println("Stock bajo");
                }
            }

            if (op == 4)
            {
                for (String v : ventas) System.out.println(v);
            }

        } while (op != 5);

        sc.close();
    }
}

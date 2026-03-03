using System;

class Inventario
{
    static string[] nombres = { "Leche", "Pan", "Agua", "Arroz", "Azúcar" };
    static double[] precios = { 3500, 1200, 1500, 4200, 2800 };
    static int[] stocks = { 20, 30, 15, 10, 25 };
    static double totalVentas = 0;

    static void VerInventario()
    {
        Console.WriteLine("===INVENTARIO===");
        for (int i = 0; i < nombres.Length; i++)
            Console.WriteLine($"{i + 1}, {nombres[i]} ${precios[i]} Stock:{stocks[i]}");
    }

    static bool Vender(int idx, int cant)
    {
        if (stocks[idx] < cant) return false;
        stocks[idx] -= cant;
        totalVentas += precios[idx] * cant;
        return true;
    }

    static void Main()
    {
        int op;
        do
        {
            Console.WriteLine("1. Ver inventario");
            Console.WriteLine("2. Vender");
            Console.WriteLine("3. Ver total ventas");
            Console.WriteLine("4. Salir");
            Console.Write("Opción: ");
            op = int.Parse(Console.ReadLine());

            switch (op)
            {
                case 1:
                    VerInventario();
                    break;

                case 2:
                    VerInventario();
                    Console.Write("Producto: ");
                    int idx = int.Parse(Console.ReadLine()) - 1;
                    Console.Write("Cantidad: ");
                    int cant = int.Parse(Console.ReadLine());

                    if (Vender(idx, cant))
                        Console.WriteLine("Venta realizada");
                    else
                        Console.WriteLine("No hay suficiente stock");
                    break;

                case 3:
                    Console.WriteLine("Total ventas: $" + totalVentas);
                    break;
            }

        } while (op != 4);
    }
}

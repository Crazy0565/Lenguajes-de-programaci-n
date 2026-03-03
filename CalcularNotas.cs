using System;
class CalcularNotas
{
    static void Main()
    {
        Console.Write("Nombre estudiante: ");
        string nombre = Console.ReadLine();
        double[] notas = new double[5];
        double suma = 0, max = 0, min = 5;
        int aprobadas = 0;

        for (int i = 0; i < 5; i++)
        {
            Console.Write($"Nota {i + 1}: ");
            double n = double.Parse(Console.ReadLine());
            if (n < 0 || n > 5) { i--; continue; }
            notas[i] = n; suma += n;
            if (n > max) max = n;
            if (n < min) min = n;
            if (n >= 3.0) aprobadas++;
        }

        double prom = suma / 5;
        Console.WriteLine($"Promedio: {prom:F2}");
        Console.WriteLine($"Max:{max} Min:{min}");
        string res = prom >= 3.0 ? "Aprobó" : "Reprobó";
        Console.WriteLine($"{nombre}: {res}");
    }
}

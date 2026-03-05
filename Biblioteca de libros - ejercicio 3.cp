using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;

abstract class Material
{
    public string Titulo { get; set; }
    public string Autor { get; set; }
    public string Anno { get; set; }

    public abstract void MostrarInfo();
}

class Libro : Material
{
    public string Genero { get; set; }
    public bool Disponible { get; set; } = true;

    public override void MostrarInfo() =>
        Console.WriteLine($"[Libro] {Titulo} - {Autor}");
}

class Biblioteca
{
    List<Material> Catalogo = new();

    public void Agregar(Material M) => Catalogo.Add(M);

    public void PrestarLibro(string Titulo)
    {
        var Libro = Catalogo.OfType<Libro>().FirstOrDefault(L => L.Titulo == Titulo);

        if (Libro == null || !Libro.Disponible)
            throw new Exception("No disponible");

        Libro.Disponible = false;
    }
}

class Program
{
    static void Main()
    {
    }
}

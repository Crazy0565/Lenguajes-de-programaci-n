using System;

using System.Collections.Generic;

using System.Linq;

// ============================================================

// CLASE BASE ABSTRACTA: Material

// ============================================================

abstract class Material
{

    public string Titulo { get; set; }

    public string Autor { get; set; }

    public int Anno { get; set; }

    public bool Disponible { get; set; } = true;

    public abstract void MostrarInfo();

}



// ============================================================

// CLASE DERIVADA: Libro

// ============================================================

class Libro : Material
{

    public string Genero { get; set; }

    public int Paginas { get; set; }



    public Libro(string titulo, string autor, int anno,

                 string genero, int paginas)
    {

        Titulo = titulo;

        Autor = autor;

        Anno = anno;

        Genero = genero;

        Paginas = paginas;

    }



    public override void MostrarInfo()
    {

        string estado = Disponible ? "Disponible" : "Prestado";

        Console.WriteLine($"[LIBRO]   {Titulo,-30} | Autor: {Autor,-20} | Anio: {Anno} | Genero: {Genero,-12} | Paginas: {Paginas,4} | Estado: {estado}");

    }

}



// ============================================================

// CLASE DERIVADA: Revista

// ============================================================

class Revista : Material
{

    public int Edicion { get; set; }

    public string Tematica { get; set; }



    public Revista(string titulo, string autor, int anno,

                   int edicion, string tematica)
    {

        Titulo = titulo;

        Autor = autor;

        Anno = anno;

        Edicion = edicion;

        Tematica = tematica;

    }



    public override void MostrarInfo()
    {

        string estado = Disponible ? "Disponible" : "Prestado";

        Console.WriteLine($"[REVISTA] {Titulo,-30} | Autor: {Autor,-20} | Anio: {Anno} | Edicion: {Edicion,4} | Tematica: {Tematica,-15} | Estado: {estado}");

    }

}



// ============================================================

// CLASE: Biblioteca

// ============================================================

class Biblioteca
{

    private List<Material> catalogo = new List<Material>();



    public void Agregar(Material m) =>

        catalogo.Add(m);



    public Material BuscarPorTitulo(string titulo) =>

        catalogo.FirstOrDefault(m => m.Titulo.Equals(titulo, StringComparison.OrdinalIgnoreCase));



    public void ListarDisponibles()
    {

        Console.WriteLine("\n=== MATERIALES DISPONIBLES ===");

        var disponibles = catalogo.Where(m => m.Disponible).ToList();

        if (disponibles.Count == 0)

            Console.WriteLine("  (No hay materiales disponibles)");

        else
        {

            int i = 1;

            foreach (var m in disponibles)
            {

                Console.Write($"{i}. ");

                m.MostrarInfo();

                i++;

            }

        }

    }



    public void ListarPrestados()
    {

        Console.WriteLine("\n=== MATERIALES PRESTADOS ===");

        var prestados = catalogo.Where(m => !m.Disponible).ToList();

        if (prestados.Count == 0)

            Console.WriteLine("  (No tienes materiales prestados)");

        else
        {

            int i = 1;

            foreach (var m in prestados)
            {

                Console.Write($"{i}. ");

                m.MostrarInfo();

                i++;

            }

        }

    }



    public void PrestarMaterial(int indice)
    {

        var disponibles = catalogo.Where(m => m.Disponible).ToList();

        if (indice < 1 || indice > disponibles.Count)

            throw new Exception("Seleccion invalida.");



        disponibles[indice - 1].Disponible = false;

        Console.WriteLine("  >> Material prestado con exito.");

    }



    public void DevolverMaterial(int indice)
    {

        var prestados = catalogo.Where(m => !m.Disponible).ToList();

        if (indice < 1 || indice > prestados.Count)

            throw new Exception("Seleccion invalida.");



        prestados[indice - 1].Disponible = true;

        Console.WriteLine("  >> Material devuelto con exito.");

    }



    public void ListarTodo()
    {

        Console.WriteLine($"\n=== CATALOGO COMPLETO ({catalogo.Count} materiales) ===");

        catalogo.ForEach(m => m.MostrarInfo());

    }

}



// ============================================================

// PROGRAMA PRINCIPAL

// ============================================================

class Program
{

    static void Main(string[] args)
    {

        Biblioteca bib = new Biblioteca();



        // Agregar libros

        bib.Agregar(new Libro("Cien Anios de Soledad", "Garcia Marquez", 1967, "Novela", 417));

        bib.Agregar(new Libro("El Principito", "Saint-Exupery", 1943, "Infantil", 96));

        bib.Agregar(new Libro("1984", "George Orwell", 1949, "Distopia", 328));



        // Agregar revistas

        bib.Agregar(new Revista("National Geographic", "Varios", 2024, 312, "Ciencia"));

        bib.Agregar(new Revista("Scientific American", "Varios", 2023, 289, "Tecnologia"));



        bool salir = false;



        while (!salir)
        {



            Console.WriteLine("\n===== MENU BIBLIOTECA =====");

            Console.WriteLine("1. Ver catalogo completo");

            Console.WriteLine("2. Ver materiales disponibles");

            Console.WriteLine("3. Prestar material");

            Console.WriteLine("4. Devolver material");

            Console.WriteLine("5. Buscar material");

            Console.WriteLine("6. Salir");



            Console.Write("Seleccione una opcion: ");

            int opcion = int.Parse(Console.ReadLine());



            try
            {

                switch (opcion)
                {

                    case 1:

                        bib.ListarTodo();

                        break;



                    case 2:

                        bib.ListarDisponibles();

                        break;



                    case 3:

                        Console.WriteLine("\nSeleccione el material a prestar:");

                        bib.ListarDisponibles();



                        Console.Write("Numero: ");

                        int numPrestamo = int.Parse(Console.ReadLine());



                        bib.PrestarMaterial(numPrestamo);

                        break;



                    case 4:

                        Console.WriteLine("\nMateriales prestados:");

                        bib.ListarPrestados();



                        Console.Write("Numero: ");

                        int numDevolver = int.Parse(Console.ReadLine());



                        bib.DevolverMaterial(numDevolver);

                        break;



                    case 5:

                        Console.Write("Titulo a buscar: ");

                        string titulo = Console.ReadLine();



                        var encontrado = bib.BuscarPorTitulo(titulo);



                        if (encontrado != null) { Console.Write("Encontrado: "); encontrado.MostrarInfo(); }

                        else Console.WriteLine("No encontrado.");



                        break;



                    case 6:

                        salir = true;

                        break;



                    default:

                        Console.WriteLine("Opcion no valida.");

                        break;

                }

            }

            catch (Exception e)
            {

                Console.WriteLine(e.Message);

            }

        }



        Console.WriteLine("\nPrograma finalizado.");

    }
}

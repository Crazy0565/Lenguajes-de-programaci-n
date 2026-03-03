#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

struct Producto
{
    int id;
    string nombre;
    float precio;
    int cantidad;
};

int main()
{
    ofstream archivo;
    ifstream lectura;

    int opcion;
    Producto p;
    int contadorID = 0;   // CONTADOR SIMPLE

    do
    {
        cout << "\n1. Agregar\n2. Listar\n3. Buscar\n4. Actualizar\n5. Total\n6. Salir\n";
        cout << "Opcion: ";
        cin >> opcion;

        if (opcion == 1)
        {
            contadorID++;   // GENERA EL SIGUIENTE ID
            p.id = contadorID;

            archivo.open("inventario.txt", ios::app);

            cout << "ID generado: "
                 << setw(3) << setfill('0') << p.id << endl;

            cout << "Nombre: ";
            cin >> p.nombre;

            cout << "Precio: ";
            cin >> p.precio;

            cout << "Cantidad: ";
            cin >> p.cantidad;

            archivo << p.id << " "
                    << p.nombre << " "
                    << p.precio << " "
                    << p.cantidad << endl;

            archivo.close();

            cout << "Producto agregado\n";
        }

        else if (opcion == 2)
        {
            lectura.open("inventario.txt");

            while (lectura >> p.id >> p.nombre >> p.precio >> p.cantidad)
            {
                cout << setw(3) << setfill('0') << p.id << " "
                     << p.nombre << " "
                     << p.precio << " "
                     << p.cantidad << endl;
            }

            lectura.close();
        }

        else if (opcion == 3)
        {
            lectura.open("inventario.txt");
            int idBuscado;
            bool encontrado = false;

            cout << "ID a buscar: ";
            cin >> idBuscado;

            while (lectura >> p.id >> p.nombre >> p.precio >> p.cantidad)
            {
                if (p.id == idBuscado)
                {
                    cout << setw(3) << setfill('0') << p.id << " "
                         << p.nombre << " "
                         << p.precio << " "
                         << p.cantidad << endl;
                    encontrado = true;
                }
            }

            if (!encontrado)
                cout << "Producto no encontrado\n";

            lectura.close();
        }

        else if (opcion == 4)
        {
            lectura.open("inventario.txt");
            archivo.open("temp.txt");
            int idBuscado;
            bool encontrado = false;

            cout << "ID a actualizar: ";
            cin >> idBuscado;

            while (lectura >> p.id >> p.nombre >> p.precio >> p.cantidad)
            {
                if (p.id == idBuscado)
                {
                    cout << "Nueva cantidad: ";
                    cin >> p.cantidad;
                    encontrado = true;
                }

                archivo << p.id << " "
                        << p.nombre << " "
                        << p.precio << " "
                        << p.cantidad << endl;
            }

            lectura.close();
            archivo.close();

            remove("inventario.txt");
            rename("temp.txt", "inventario.txt");

            if (encontrado)
                cout << "Cantidad actualizada\n";
            else
                cout << "Producto no encontrado\n";
        }

        else if (opcion == 5)
        {
            lectura.open("inventario.txt");
            float total = 0;

            while (lectura >> p.id >> p.nombre >> p.precio >> p.cantidad)
            {
                total += p.precio * p.cantidad;
            }

            cout << "Valor total inventario: " << total << endl;
            lectura.close();
        }

    } while (opcion != 6);

    return 0;
}

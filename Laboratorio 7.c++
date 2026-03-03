#include <iostream>
#include <vector>
#include <string>
#include <ctime>
#include <cstdlib>

using namespace std;

class Cuenta
{
private:
    string titular;
    string numeroCuenta;
    string llave;
    double saldo;

    string generarNumero()
    {
        string num = "";
        for (int i = 0; i < 10; i++)
        {
            num += char('0' + rand() % 10);
        }
        return num;
    }

    string generarLlave()
    {
        string clave = "";
        for (int i = 0; i < 4; i++)
        {
            clave += char('0' + rand() % 10);
        }
        return clave;
    }

public:
    Cuenta(string t, double s)
    {
        titular = t;
        saldo = (s >= 0) ? s : 0;
        numeroCuenta = generarNumero();
        llave = generarLlave();
    }

    string getNumero()
    {
        return numeroCuenta;
    }

    string getLlave()
    {
        return llave;
    }

    string getTitular()
    {
        return titular;
    }

    double getSaldo()
    {
        return saldo;
    }

    void depositar(double m)
    {
        if (m > 0)
        {
            saldo += m;
            cout << "\nDeposito exitoso.\n";
        }
        else
        {
            cout << "\nMonto invalido.\n";
        }
    }

    void retirar(double m)
    {
        if (m > 0 && m <= saldo)
        {
            saldo -= m;
            cout << "\nRetiro exitoso.\n";
        }
        else
        {
            cout << "\nFondos insuficientes o monto invalido.\n";
        }
    }

    bool transferir(Cuenta &destino, double m, string claveIngresada)
    {
        if (claveIngresada != llave)
        {
            cout << "\nLlave incorrecta.\n";
            return false;
        }

        if (m <= 0 || m > saldo)
        {
            cout << "\nTransferencia no valida.\n";
            return false;
        }

        saldo -= m;
        destino.saldo += m;

        cout << "\nTransferencia exitosa.\n";
        return true;
    }

    void mostrar()
    {
        cout << "\n=============================\n";
        cout << "Titular : " << titular << endl;
        cout << "Cuenta  : " << numeroCuenta << endl;
        cout << "Saldo   : " << saldo << endl;
        cout << "=============================\n";
    }
};

int buscar(vector<Cuenta> &v, string num)
{
    for (int i = 0; i < v.size(); i++)
    {
        if (v[i].getNumero() == num)
        {
            return i;
        }
    }
    return -1;
}

int existeTitular(vector<Cuenta> &v, string nombre)
{
    for (int i = 0; i < v.size(); i++)
    {
        if (v[i].getTitular() == nombre)
        {
            return 1;
        }
    }
    return 0;
}

int main()
{
    srand(time(0));

    vector<Cuenta> cuentas;
    int op;

    do
    {
        cout << "\n=============================\n";
        cout << "      SISTEMA BANCARIO\n";
        cout << "=============================\n";
        cout << "1. Crear cuenta\n";
        cout << "2. Depositar\n";
        cout << "3. Retirar\n";
        cout << "4. Transferir\n";
        cout << "5. Mostrar cuenta\n";
        cout << "6. Salir\n";
        cout << "=============================\n";
        cout << "Opcion: ";

        cin >> op;

        if (op == 1)
        {
            string t;
            double s;

            cout << "\nTitular: ";
            cin.ignore();
            getline(cin, t);

            if (t.empty())
            {
                cout << "\nEl nombre no puede estar vacio.\n";
                continue;
            }

            if (existeTitular(cuentas, t))
            {
                cout << "\nEste usuario ya tiene una cuenta.\n";
                continue;
            }

            cout << "Saldo inicial: ";
            cin >> s;

            Cuenta nueva(t, s);
            cuentas.push_back(nueva);

            cout << "\n====================================\n";
            cout << "   CUENTA CREADA EXITOSAMENTE\n";
            cout << "====================================\n";
            cout << "Numero de cuenta: " << nueva.getNumero() << endl;
            cout << "Llave asignada:   " << nueva.getLlave() << endl;
            cout << "====================================\n";
        }

        if (op == 2)
        {
            string n;
            double m;

            cout << "\nNumero de cuenta: ";
            cin >> n;

            int i = buscar(cuentas, n);

            if (i != -1)
            {
                cout << "Monto: ";
                cin >> m;
                cuentas[i].depositar(m);
            }
            else
            {
                cout << "\nCuenta no encontrada.\n";
            }
        }

        if (op == 3)
        {
            string n;
            double m;

            cout << "\nNumero de cuenta: ";
            cin >> n;

            int i = buscar(cuentas, n);

            if (i != -1)
            {
                cout << "Monto: ";
                cin >> m;
                cuentas[i].retirar(m);
            }
            else
            {
                cout << "\nCuenta no encontrada.\n";
            }
        }

        if (op == 4)
        {
            string origen, destino, clave;
            double m;

            cout << "\nCuenta origen: ";
            cin >> origen;

            cout << "Cuenta destino: ";
            cin >> destino;

            int io = buscar(cuentas, origen);
            int id = buscar(cuentas, destino);

            if (io != -1 && id != -1)
            {
                cout << "Llave: ";
                cin >> clave;

                cout << "Monto: ";
                cin >> m;

                cuentas[io].transferir(cuentas[id], m, clave);
            }
            else
            {
                cout << "\nUna de las cuentas no existe.\n";
            }
        }

        if (op == 5)
        {
            string n;

            cout << "\nNumero de cuenta: ";
            cin >> n;

            int i = buscar(cuentas, n);

            if (i != -1)
            {
                cuentas[i].mostrar();
            }
            else
            {
                cout << "\nCuenta no encontrada.\n";
            }
        }

    }
    while (op != 6);

    cout << "\nSistema finalizado.\n";
    return 0;
}

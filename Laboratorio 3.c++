#include <iostream>
using namespace std;

int main() {

    float nota;

    cout << "Ingrese la nota: ";
    cin >> nota;

    if (nota > 5 || nota < 0) {
        cout << "Esta no es una nota valida." << endl;
    }
    else if (nota <= 2.9) {
        cout << "Reprobado." << endl;
    }
    else if (nota <= 4.5) {
        cout << "Aprobado." << endl;
    }
    else { // de 4.6 a 5.0
        cout << "Excelente." << endl;
    }

    return 0;
}

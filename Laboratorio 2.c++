#include <iostream>
using namespace std;

int main() {

    float num1;
    float num2;
    float suma;
    float resta;
    float producto;
    float division;

    cout << "Ingrese el primer número: ";
    cin >> num1;

    cout << "Ingrese el segundo número: ";
    cin >> num2;

    suma = num1 + num2;
    resta = num1 - num2;
    producto = num1 * num2;

    if (num2 != 0) {
        division = num1 / num2;
        cout << "División: " << division << endl;
    } else {
        cout << "No se puede dividir entre cero." << endl;
    }

    cout << "Suma: " << suma << endl;
    cout << "Resta: " << resta << endl;
    cout << "Multiplicación: " << producto << endl;

    if (num1 > num2) {
        cout << "El primer número es mayor que el segundo." << endl;
    } 
    else if (num1 == num2) {
        cout << "Los números son iguales." << endl;
    } 
    else {
        cout << "El primer número es menor que el segundo." << endl;
    }

    return 0;
}

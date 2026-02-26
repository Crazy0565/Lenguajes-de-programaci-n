#include <iostream>
using namespace std;
const int MAX = 10;
void ingresar (int m[MAX][MAX], int f,int c)
{
    for(int i=0; i<f; i++)
    for (int j=0; j<c; j++)
    cin>>m[i][j];
}
void mostrar (int m[MAX][MAX], int f, int c)
{
    for(int i=0; i<f; i++)
    {
    for (int j=0; j<c; j++)
        cout<<m[i][j]<<" ";
        cout<<endl;
    }
}
void sumar (int a[MAX][MAX], int b[MAX][MAX], int f, int c)
{
    int r[MAX][MAX];
    for(int i = 0; i<f; i++)
    for(int j = 0; j<c; j++)
    r[i][j] = a[i][j] + b[i][j];
}
void restar (int a[MAX][MAX], int b[MAX][MAX], int f, int c)
{
    int r[MAX][MAX];
    for(int i = 0; i<f; i++)
    for(int j = 0; j<c; j++)
    r[i][j] = a[i][j] - b[i][j];
}
void multiplicar (int a[MAX][MAX], int b[MAX][MAX], int f, int c)
{
    int r[MAX][MAX];
    for(int i = 0; i<f; i++)
    for(int j = 0; j<c; j++)
    r[i][j] = a[i][j] * b[i][j];
}
void dividir (int a[MAX][MAX], int b[MAX][MAX], int f, int c)
{
    int r[MAX][MAX];
    for(int i = 0; i<f; i++)
    for(int j = 0; j<c; j++)
{
    if(b[i][j] != 0)
    r[i][j] = a[i][j] / b[i][j];
    else
    r[i][j] = 0;
}
}
    int main()
{
    int A[MAX][MAX], B[MAX][MAX];
    int f, c;
        cout <<"Filas y columnas: ";
        cin >> f >> c;
        cout << "Matriz A:\n";
            ingresar(A,f,c);
        cout << "Matriz B:\n";
            ingresar(B,f,c);
        sumar(A,B,f,c);
        restar(A,B,f,c);
        multiplicar(A,B,f,c);
        dividir(A,B,f,c);
        
    return 0;
}

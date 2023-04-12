#include <iostream>

using namespace std;

void argumentByValue(int n) {
    n++;
    cout << "Im Funktionsaufruf von argumentByValue hat das Argument "
    << "nach dem Inkrementieren den Wert " << n << endl;
}
void argumentByReference(int* p) {
    (*p)++; // int-Wert an der Speicherstelle p wird um 1 erhöht
    cout << "Im Funktionsaufruf von argumentByReference hat das Argument "
    << "nach dem Inkrementieren den Wert " << *p << endl;
}

int main() {
    int x = 3;
    cout << "Wert von x im Hauptprogramm nach der Initialisierung: "
    << x << endl;
    argumentByValue(x);
    cout << "Wert von x im Hauptprogramm nach dem Aufruf von "
    << "argumentByValue: " << x << endl;
    argumentByReference(&x);
    cout << "Wert von x im Hauptprogramm nach dem Aufruf von "
    << "argumentByReference: " << x << endl;
    return 0;
}

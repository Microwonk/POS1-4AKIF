#include <iostream>
using namespace std;

int x = 3; // globale Variable

void ausgabe(int x) { // geht nöt weil param und lokal gleichen namen haben
    int x = 5; // lokale Variable
    cout << x << endl;
}

int main() {
    ausgabe(3);
    cout << x << endl;
    return 0;
}

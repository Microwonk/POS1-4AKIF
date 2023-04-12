#include <iostream>

int main() {
    int a = 3;
    int c;
    int* p; // Deklaration eines Zeigers auf einen Integer-Wert
    p = &a; // Ermitteln der Speicheradresse von a
    // Zuweisung dieser Adresse an p (Referenzierung)
    c = *p + 1; // Integer-Wert an der in p hinterlegten
    // Speicherstelle wird ermittelt
    // (Dereferenzierung), erhöht und c zugewiesen
    std::cout << "Variable a hat den Wert " << a 
    << " an der Speicherstelle " << p << std::endl;
    std::cout << "Das direkte Auslesen der Speicherstelle " << p
    << " liefert ebenfalls den Wert " << *p << std::endl;
    std::cout << "c hat nun den Wert " << c 
    << " der an der Speicherstelle " << &c << " liegt." << std::endl;
    std::cout << "Fuer die Pointer-Variable p wurde die Speicherstelle " << &p 
    << " reserviert. Der Wert an dieser Speicherstelle ist " << p << std::endl;
    return 0;
}

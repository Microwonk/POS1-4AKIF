#include <iostream>

int main() {
    int a = 3; // Variable vom Typ int wird deklariert: Eine
    // Speicherstelle der Größe von 4 Byte wird reserviert
    // &a liefert die Speicheradresse des ersten der vier für die
    // Variable a reservierten Speicherblöcke
    std::cout << "Speicherbereich von a beginnt bei Adresse " << &a << std::endl;

    std::cout << a << std::endl;
    std::cout << *(&a) << std::endl; 
    std::cout << &a << std::endl; // memory address

    return 0;
}
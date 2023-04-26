#include <iostream>

void divide(int a, int b, int& rest, int& quotient) {
    rest = a%b;
    quotient = a/b;
}


int main() {
    int rest;
    int quotient;

    divide(17, 5, rest, quotient);

    std::cout << "Rest: " << rest << std::endl;
    std::cout << "Quotient: " << quotient << std::endl;

    return 0;
}
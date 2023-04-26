#include <iostream>

int rest;
int quotient;

void divide(int a, int b) {
    rest = a%b;
    quotient = a/b;
}


int main() {
    divide(17, 5);
    std::cout << "Rest: " << rest << std::endl;
    std::cout << "Quotient: " << quotient << std::endl;
    return 0;
}
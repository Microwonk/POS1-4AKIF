#include <iostream>

struct Division
{
    Division(int rest, int quotient) {
        this->rest = rest;
        this->quotient = quotient;
    }
    int rest;
    int quotient;
};

Division divide(int a, int b) {
    return Division(a%b, a/b);
}


int main() {
    Division div = divide(17, 5);
    std::cout << "Rest: " << div.rest << std::endl;
    std::cout << "Quotient: " << div.quotient << std::endl;
    return 0;
}
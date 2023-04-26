#include <io.h>

struct Koordinate
{
    int x;
    int y;
} koordinate;

void set(int* kx, int* ky, int x, int y) {
    kx = x;
    ky = y;
}


int main() {

    koordinate.x = 12;
    koordinate.y = 17;


    return 0;
}
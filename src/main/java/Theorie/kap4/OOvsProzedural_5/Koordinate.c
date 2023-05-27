#include <stdio.h>

typedef struct {
    int x;
    int y;
} Koordinate;

void set(Koordinate* k, int x, int y) {
    k->x = x;
    k->y = y;
}

void ausgeben(Koordinate k) {
    printf("(x=%d, y=%d)\n", k.x, k.y);
}

int main() {
    Koordinate k = {0, 0};
    set(&k, 5, 10);
    ausgeben(k);
    return 0;
}

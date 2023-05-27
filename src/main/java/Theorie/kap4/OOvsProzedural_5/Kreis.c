#include <stdio.h>

typedef struct {
    struct {
        int x;
        int y;
    } mitte;
    int radius;
} Kreis;

void setPosition(Kreis* k, int x, int y) {
    k->mitte.x = x;
    k->mitte.y = y;
}

void print(Kreis k) {
    printf("Mittelpunkt: (%d, %d)\nRadius: %d\n", k.mitte.x, k.mitte.y, k.radius);
}

int main() {
    Kreis k = {{0, 0}, 5};
    setPosition(&k, 10, 10);
    print(k);
    return 0;
}

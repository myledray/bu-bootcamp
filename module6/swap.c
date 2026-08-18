#include <stdio.h>

// Define a function void swap(int *a, int *b) that exchanges the values 
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// In main, declare two integer variables and assign them any two different values 
int main() {
    int x = 10;
    int y = 20;

    printf("Before: x = %d, y = %d\n", x, y);

    swap(&x, &y);

    printf("After: x = %d, y = %d\n", x, y);

    return 0;
}
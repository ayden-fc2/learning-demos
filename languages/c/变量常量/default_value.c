#include <stdio.h>

int getValue();

int getValue(){
    int value2;
    return value2;
}

int main() {
    int value1;
    printf("value1 = %d\n", value1); // value1 = 0
    printf("value2 = %d\n", getValue()); // value2 = ?
}
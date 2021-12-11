#include <stdio.h>

int main()
{
    int num = 5;
    int sumOfBits = 0;

    for (int i = 0; i < 32; i++)
    {
        sumOfBits += num & 1;
        printf("%d\n", sumOfBits);
        num = num >> 1;
    }
    printf("%lu", sizeof(num));
    return 0;
}

// 00000101
// 11111010+1
// 11111011
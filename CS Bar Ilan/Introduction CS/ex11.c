// Input: Get 3 numbers
// Output: arrange them from smallest to biggest
#include <stdio.h>

int main()
{
    int num1, num2, num3;

    printf("Please enter 3 numbers\n");
    scanf("%d %d %d", &num1, &num2, &num3);
    if ((num1 <= num2) && (num1 <= num3))
    {
        if (num2 <= num3)
            printf("%d %d %d", num1, num2, num3);
        if (num2 > num3)
            printf("%d %d %d", num1, num3, num2);
    }
    else if ((num2 <= num1) && (num2 <= num3))
    {
        if (num1 <= num3)
            printf("%d %d %d", num2, num1, num3);
        if (num1 > num3)
            printf("%d %d %d", num2, num3, num1);
    }
    else if ((num3 <= num1) && (num3 <= num2))
    {
        if (num1 <= num2)
            printf("%d %d %d", num3, num1, num2);
        if (num2 < num1)
            printf("%d %d %d", num3, num2, num1);
    }
    return 0;
}

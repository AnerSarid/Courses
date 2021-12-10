// Input: get 3 integers
// Output: determine if order increases, decreases, or neither
#include <stdio.h>

int main()
{
    int num1, num2, num3;

    printf("Please enter 3 numbers\n");
    scanf("%d %d %d", &num1, &num2, &num3);

    if ((num1 <= num2) && (num2 <= num3))
        printf("The set order is increasing\n");
    else if ((num1 >= num2) && (num2 >= num3))
        printf("The set order is decreasing\n");
    else
        printf("The set isn't ordered\n");
    return 0;
}

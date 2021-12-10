// Input:
// Output:
#include <stdio.h>

int main()
{
    int n, i, j;
    scanf("%d", &n);
    if (n % 2)
    {
        for (i = 1; i <= n; i += 2)
        {
            for (j = 0; j < (n - i) / 2; printf(" "), j++)
                ;
            for (j = 0; j < i; printf("*"), j++)
                ;
            printf("\n");
        }
    }
    else
        printf("Input Error\n");

    return 0;
}

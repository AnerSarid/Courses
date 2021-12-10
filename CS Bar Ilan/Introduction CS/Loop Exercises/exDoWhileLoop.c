// Input:
// Output:
#include <stdio.h>

int main()
{
    int n, i = 0;
    scanf("%d", &n);
    do
    {
        printf("*\n", i++);
    } while (i < n);
    return 0;
}

// Input:
// Output:
#include <stdio.h>

int main()
{
    int n, i = 0, sum = 0;
    scanf("%d", &n);
    for (; i < n + 1; i++)
    {
        if (i % 4 == 0)
            continue;
        sum += i;
    }
    printf("%d", sum);
    return 0;
}

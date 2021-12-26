#include <stdio.h>
#include <math.h>
#define MAX 100

int counter;
const double inf = INFINITY;

double iterPow(double x, int y)
{
    int i;
    double result = 1.0;
    if (y == 0)
        return 1;
    if (y == 1)
        return x;
    if (x == 0 && y < 0)
        return INFINITY;
    for (i = 0; i < y; i++)
    {
        result *= x;
        counter++;
    }
    return result;
}

double recPow(double x, int y)
{
    counter++;
    if (y == 0)
        return 1;
    if (y == 1)
        return x;
    if (x == 0 && y < 0)
        return INFINITY;
    return x * recPow(x, y - 1);
}

double recEffiPow(double x, int y)
{
    counter++;
    if (y == 0)
        return 1;
    if (y == 1)
        return x;
    if (x == 0 && y < 0)
        return INFINITY;
    if ((y % 2))
        return x * (recEffiPow(x, y / 2) * recEffiPow(x, y / 2));
    return (recEffiPow(x, y / 2) * recEffiPow(x, y / 2));
}

int isPermutation(int arr1[], int size1, int arr2[], int size2)
{
    if (size1 != size2)
        return 0;
    int i;
    int arr1X[MAX] = {0};
    int arr2X[MAX] = {0};

    for (i = 0; i < MAX; i++)
    {
        arr1X[arr1[i]]++;
        arr2X[arr2[i]]++;
    }

    for (i = 0; i < MAX; i++)
    {
        if (arr1X[i] != arr2X[i])
        {
            return 0;
        }
    }
    return 1;
}

void printArr2D(int arr[][MAX], int size1, int size2)
{
    int mostDigits = 1, row, col;
    for (row = 0; row < size1; row++)
    {
        for (col = 0; col < size2; col++)
        {
            if (log10(arr[row][col]) > mostDigits)
                mostDigits = log(arr[row][col]) - 1;
        }
    }

    for (row = 0; row < size1; row++)
    {
        for (col = 0; col < size2; col++)
        {
            printf("%0*d ", mostDigits, arr[row][col]);
        }
        printf("\n");
    }
}

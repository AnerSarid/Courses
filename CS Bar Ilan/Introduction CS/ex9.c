// Input: ask user for grade between 1-100
// Output: If not 1-100 'invalid number', if <60 'Failed', if 60<x<80 'Passed', if 80=<x=<100 'Great'
#include <stdio.h>
#define MAX_GRADE 100
#define MIN_GRADE 0
int main()
{
    int grade;

    printf("Please enter a grade between 1 and 100\n");
    scanf("%d", &grade);

    if (grade < MIN_GRADE || grade > MAX_GRADE)
    {
        printf("Invalid number\n");
    }
    else if (grade < 60)
    {
        printf("You failed!\n");
    }
    else if (grade < 80)
    {
        printf("You Passed!\n");
    }
    else
    {
        printf("Great job!\n");
    }
    return 0;
}

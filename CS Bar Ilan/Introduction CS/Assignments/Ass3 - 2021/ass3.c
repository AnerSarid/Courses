#include <stdio.h>
#include <time.h>
#include "ass3.h"

int main()
{
    //Hanoi Towers

    int n = 7;                      // Number of disks
    towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are the names of the rods

    // //1 - Palindrom

    // char str1[] = "malayalam";
    // isPalindrome(str1, 9);
    // char str2[] = "sun";
    // isPalindrome(str2, 3);

    // //2 - All Combinations

    // char pattern[] = "1?12?";
    // printAllCombinations(pattern, 5);

    // //3 - To the Power of

    // powRec(-2, 3);

    // //4 - Divisible by 3

    // isDivisibleBy3(123232323231);
    // isDivisibleBy3(123232323232);

    // //5 - GCD

    // gcd(105, 51);

    // //6 - Count Digit

    // countDigit(1234567891, 1);

    // //7 - Iterations

    return 0;
}

void towerOfHanoi(int numDisks, char fromRod, char toRod, char auxRod)
{
    if (numDisks == 1)
    {
        printf("Move disk 1 from %c to %c\n", fromRod, toRod);
        return;
    }

    towerOfHanoi(numDisks - 1, fromRod, auxRod, toRod);
    printf("Move disk %d from %c to %c\n", numDisks, fromRod, toRod);
    towerOfHanoi(numDisks - 1, auxRod, toRod, fromRod);
}
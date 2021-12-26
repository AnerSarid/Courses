#include <stdio.h>

int main()
{
    int selection;
    do
    {
        //Selection Menu
        printf("Choose an option\noption:\n1 : Draw\n2 : Even or Odd\n3 : Text type\n4 : Hex to Dec\n5 : Base to Dec\n6 : Count bits\n0: Exit\n");
        scanf("%d", &selection);
        //Wrong Input
        if (selection < 0 || selection > 6)
        {
            printf("Wrong option!");
            continue;
        }
        //Drawing a square by "2x+1" dimensions
        else if (selection == 1)
        {
            int x;
            printf("Please enter a number\n");
            scanf("%d", &x);
            int i, j;
            for (i = 0; i < 2 * x + 1; i++)
            {
                for (j = 0; j < 2 * x + 1; j++)
                {
                    if ((i == j) && (i == x))
                        printf("X");
                    else if (((i == 0) && (j == 0)) || ((i == 2 * x) && (j == 0)) || ((i == 0) && (j == 2 * x)) || ((i == 2 * x) && (j == 2 * x)))
                        printf("+");
                    else if ((i == 0) || (i == 2 * x))
                        printf("-");
                    else if ((j == 0) || (j == 2 * x))
                        printf("|");
                    else if ((i == j))
                        printf("\\");
                    else if ((i == 2 * x - j))
                        printf("/");
                    else
                        printf(" ");
                }
                printf("\n");
            }
        }

        // Even or Odd
        else if (selection == 2)
        {
            char ch;
            int i = 1;
            printf("Type anything\n");
            scanf(" ", &ch);
            while (ch != '\n')
            {
                scanf("%c", &ch);
                i = !i;
            }

            if (i == 1)
                printf("Your text's length is odd\n");
            else
                printf("Your text's length is even\n");
        }

        // Text Type
        else if (selection == 3)
        {
            char ch, prevch;
            int smallLetterFlag = 1, increasingFlag = 1, decreasingFlag = 1;
            printf("Type anything\n");
            scanf(" ", &ch);
            scanf("%c", &ch);
            prevch = ch;
            while (ch != '\n')
            {

                if (!(ch >= 'a' && ch <= 'z' && ch != '\n'))
                {
                    smallLetterFlag = 0;
                    break;
                }
                if (ch > prevch)
                    decreasingFlag = 0;
                else if (ch < prevch)
                    increasingFlag = 0;
                prevch = ch;
                scanf("%c", &ch);
            }

            if (smallLetterFlag == 1)
            {
                if (increasingFlag == 0 && decreasingFlag == 0)
                    printf("Your text is mixed\n");
                else if (increasingFlag == 1 && decreasingFlag == 0)
                    printf("Your text is increasing\n");
                else if (increasingFlag == 0 && decreasingFlag == 1)
                    printf("Your text is decreasing\n");
                else
                    printf("Your text is constant\n");
            }
            else
                printf("Your text is invalid\n");
        }

        // Hex to Dec
        else if (selection == 4)
        {
            int base = 1, curr_place = 0, notHexFlag = 1;
            unsigned int sum = 0, curr_num;
            char num;
            printf("Type a hexadecimal number\n");
            scanf(" ", &num);
            scanf("%c", &num);
            do
            {
                if (((num >= '0') && (num <= '9')) || ((num >= 'A') && (num <= 'F')) || ((num >= 'a') && (num <= 'f')))
                {
                    if (num >= '0' && num <= '9')
                    {
                        curr_num = num - 0x30;
                    }
                    else
                    {
                        switch (num)
                        {
                        case 'A':
                        case 'a':
                            curr_num = 10;
                            break;
                        case 'B':
                        case 'b':
                            curr_num = 11;
                            break;
                        case 'C':
                        case 'c':
                            curr_num = 12;
                            break;
                        case 'D':
                        case 'd':
                            curr_num = 13;
                            break;
                        case 'E':
                        case 'e':
                            curr_num = 14;
                            break;
                        case 'F':
                        case 'f':
                            curr_num = 15;
                            break;
                        default:
                            curr_num = 0;
                        }
                    }
                    for (int i = 0; i < curr_place; i++)
                        base = base * 16;
                    curr_num *= base;
                    sum += curr_num;
                    curr_place++;
                    // Binus's way of implementing power within the do-while
                    // do {
                    // if (c>= 'A' && c<='F')
                    //     c+=32;

                    // if (c>='a' && c<='f')
                    //     num = 10 + c - 'a';

                    //     dec_value += num * i;

                    //     i*=16;
                    // } while
                }
                else
                {
                    notHexFlag = 0;
                    printf("Error! %c is not a valid digit in base 16\n", num);
                }
                scanf("%c", &num);
            } while (num != '\n');

            if (notHexFlag == 1)
            {
                unsigned int hexvalue = 0;
                hexvalue = sum;
                printf("The decimal value is %d\n", hexvalue);
            }
        }

        // Base to Dec
        else if (selection == 5)
        {
            int base, baseP, curr_place = 0, notValidFlag = 1;
            int sum = 0, curr_num;
            char num;
            printf("Type in the number's base\n");
            scanf("%d", &base);
            printf("Type in the number\n");
            scanf(" ", &num);
            scanf("%c", &num);
            do
            {
                if (num >= '0' && num <= (base + 48 - 1))
                {
                    curr_num = num - 48;
                    baseP = 1;
                    for (int i = 0; i < curr_place; i++)
                        baseP = baseP * base;
                    curr_num *= baseP;
                    sum += curr_num;
                    curr_place++;
                }
                else
                {
                    notValidFlag = 0;
                    printf("Error! %c is not a valid digit in base %d\n", num, base);
                }
                scanf("%c", &num);
            } while (num != '\n');

            if (notValidFlag == 1)
            {
                unsigned int hexvalue = 0;
                hexvalue = sum;
                printf("The decimal value is %d\n", hexvalue);
            }
        }

        // Count bits
        else if (selection == 6)
        {
            int num, sumOfBits = 0;
            printf("Enter a number\n");
            scanf("%d", &num);
            for (int i = 0; i < 32; i++)
            {
                sumOfBits += num & 1;
                num = num >> 1;
            }
            printf("The bit count is %d\n", sumOfBits);
        }
    } while (selection != 0);

    return 0;
}

// base = 1; //should 16^base
// place = 1;
// curr_num = given number
//     sum = 0;
// //input recived while(not enter)
// for (i = 0; i < place; i++)
// {
//     base = base * 16;
// }
// curr_num = curr_num *base
//     sum = sum + curr_num;

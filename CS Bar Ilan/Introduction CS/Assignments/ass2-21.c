#include <stdio.h>

int main()
{
    int selection;
    do
    {
        //Selection Menu
        printf("Choose an option\noption:\n1 : Draw\n2 : 20 to Dec\n3 : Base to Dec\n4 : Pow2\n5 : Different Bits\n6 : Add\n7 : Multiply\n0: Exit\n");
        scanf("%d", &selection);
        //Wrong Input
        if (selection < 0 || selection > 7)
        {
            printf("Wrong option!\n");
            continue;
        }
        //Drawing a Rhombus by length side x
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
                        printf("+");
                    else if (j == x)
                        printf("*");
                    else if (((i == x) && (j == 0)) || ((i == x) && (j == 2 * x)))
                        printf("|");
                    else if (((j == x - (i + 1)) && (i < x)) || ((i > x) && (j == 2 * x - (i - (x + 1)))))
                        printf("/");
                    else if (((j == x + (i + 1)) && (i < x)) || ((i > x) && (j == i - (x + 1))))
                        printf("\\");
                    else
                        printf(" ");
                }
                printf("\n");
            }
        }

        // 20 to decimal
        else if (selection == 2)
        {
            int base = 1, not20Flag = 1;
            unsigned int sum = 0, curr_num;
            char num;
            printf("Type a number in base 20\n");
            scanf(" ", &num);
            scanf("%c", &num);
            do
            {
                if (((num >= '0') && (num <= '9')) || ((num >= 'A') && (num <= 'J')) || ((num >= 'a') && (num <= 'j')))
                {
                    if (num >= '0' && num <= '9')
                        curr_num = num - 48;
                    if (num >= 'A' && num <= 'J')
                        num += 32;
                    if (num >= 'a' && num <= 'j')
                        curr_num = 10 + (num - 'a');
                    curr_num *= base;
                    sum += curr_num;
                }
                else
                {
                    not20Flag = 0;
                    printf("Error! %c is not a valid digit in base 20\n", num);
                }
                scanf("%c", &num);
                base *= 20;
            } while (num != '\n');

            if (not20Flag)
            {
                unsigned int hexvalue = 0;
                hexvalue = sum;
                printf("The decimal value is %d\n", hexvalue);
            }
        }

        // Base to Decimal
        else if (selection == 3)
        {
            int base, baseP = 1, notValidFlag = 1;
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
                    curr_num *= baseP;
                    sum += curr_num;
                }
                else
                {
                    notValidFlag = 0;
                    printf("Error! %c is not a valid digit in base %d\n", num, base);
                }
                scanf("%c", &num);
                baseP *= base;
            } while (num != '\n');

            if (notValidFlag == 1)
            {
                unsigned int hexvalue = 0;
                hexvalue = sum;
                printf("The decimal value is %d\n", hexvalue);
            }
        }

        // Pow2
        else if (selection == 4)
        {
            int number;
            printf("Enter a number\n");
            scanf("%d", &number);

            if ((number != 0) && (((number & (number - 1)) == 0)))
                printf("%d is a power of 2\n", number);
            else
                printf("%d is not a power of 2\n", number);
        }

        // Different Bits
        else if (selection == 5)
        {
            int number1, number2, bits = 0, i;
            printf("Enter two numbers\n");
            scanf("%d %d", &number1, &number2);

            for (i = 0; i < 32; i++)
            {
                if ((number1 & 1) ^ (number2 & 1))
                    bits++;
                number1 >>= 1;
                number2 >>= 1;
            }
            printf("there are %d different bits\n", bits);
        }

        // Add
        else if (selection == 6)
        {
            int x, y, sum = 0;
            unsigned remain;
            printf("Enter two numbers\n");
            scanf("%d %d", &x, &y);

            while (y)
            {
                remain = x & y;
                x = x ^ y;
                y = remain << 1;
            }

            printf("%d\n", x);
        }

        //Multiply
        else if (selection == 7)
        {
            int sum = 0;
            unsigned x, y;
            printf("Enter two numbers\n");
            scanf("%d %d", &x, &y);

            while (y != 0)
            {
                if (y & 1)
                    sum += x;
                x = x << 1;
                y = y >> 1;
            }
            printf("The multiplication is %d\n", sum);
        }
    } while (selection != 0);

    return 0;
}

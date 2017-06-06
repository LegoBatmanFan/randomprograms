// LegoBatmanFan
// given any number, this program will print the multiplication table
// for that particular number

#include <stdio.h>
#include <stdlib.h>

void print_table(int x);

int main()
{
    int m_number;

    printf("Multiplication table...\n");
    printf("Give me a number ==> ");
    scanf("%d", &m_number);
    printf("\n");
    printf("multiplication table for ==> %d\n", m_number);
    print_table(m_number);
    return 0;
}

void print_table(int x)
{
    // This program was written with CodeBlocks. You'll get an error if you declare the control
    // variables in the loop.

    int i, j, multiple;

    for (i=1; i <= x; i++) {
        for (j=1; j <=x; j++) {
            multiple = j * i;
            printf("%5d", multiple);
        }
        printf("\n");
    }
}

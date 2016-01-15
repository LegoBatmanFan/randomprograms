//LegoBatmanFan
//This program will print out the first n Fibonacci numbers
//using iteration. The number n is user input.
#include <stdio.h>
#include <stdlib.h>

void print_fibonacci(int x);

int main()
{
    int number;
    printf("This program prints out n Fibonacci numbers...\n");
    printf("Give me a number ==> ");
    scanf("%d", &number);
    //Call the function that calculates and prints out the Fibonacci numbers
    print_fibonacci(number);
    printf("================= \n");
    printf("\n");
    printf("Done...");
    return 0;
}

//This is the function that calculates and prints out the Fibonacci numbers
void print_fibonacci(int x)
{
    int i;
    int num001 = 0;
    int num002 = 0;
    int sum = 1;

    printf("Printing %d Fibonacci numbers...\n", x);
    for (i = 0; i < (x - 1); i++){
        //the if loop will print out the first Fibonacci number 0
        if (i < 1){
            printf("%d\n",i);
        }
        //Now, calculate and print the numbers
        printf("%d\n", sum);
        num001 = num002;
        num002 = sum;
        sum = num001 + num002;

    }
}



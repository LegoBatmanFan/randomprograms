// LegoBatmanFan
// This program reverses a string

#include <stdio.h>
#include <stdlib.h>

// Function prototypes
int string_size(char x[]);
void reverse_string(char y[], int j);

int main()
{
    // Code for reading in string comes from
    // http://www.mkyong.com/c/how-to-handle-unknow-size-user-input-in-c/
    // This code allows for dynamic allocation of memory so that the user can
    // enter a string of any size.
    unsigned int len_max = 128;
    unsigned int current_size = 0;

    // Allocate some memory for the string
    char *myString = malloc(len_max);
    current_size = len_max;

    // Now, set stringLength to 100. This could be set to any value, as long as it greater
    // than the maximum value for the input string, meaning we only want to process strings
    // of a certain length
    int stringLength = 100;

    // While the string length is greater than 50, prompt the user to enter a string
    while (stringLength > 50) {
        printf("Enter a String value ==> ");

        if(myString != NULL)
        {
            int c = EOF;
            unsigned int i =0;
            // Accept user input until '\n' or end of file character by character
            while (( c = getchar() ) != '\n' && c != EOF){
                myString[i++]=(char)c;

                // Reallocate memory if the maximum size has been reached
                if(i == current_size)
                {
                    current_size = i+len_max;
                    myString = realloc(myString, current_size);
                }
            }

            // Now, add the endline character.
            myString[i] = '\0';

            // Print some messages
            printf("\nLong String value:%s \n\n",myString);

            // Get the length of the string
            stringLength = string_size(myString);
            printf("the length of the string ==> %d\n",stringLength);
        }
    }

    // Once we have the correct input, reverse the string
    printf("The length of the string is less than 50 characters\n");
    reverse_string(myString, stringLength);

    // Free up the memory
	free(myString);
	myString = NULL;

    return 0;
}

// There is a C function to calculate the length of a string, but
// it was written out in this program for funzees. Starting with the
// first character, count all of the characters in the array until you
// reach \0. Increment i as you count. Return i when finished.
int string_size(char x[])
{
    int i = 0;
    while(x[i] !='\0')
    {
        i++;
    }
    return i;
}

// You can use fgets and putcharto reverse a string in C. However, I
// decided to do something a little different for funzees. Starting at the
// end of the input string, this function copies each character into
// backwardsString (character by character).
void reverse_string(char y[], int j)
{
    char backwardsString[j];

    int i;
    int k = j-1;

    for (i = 0; i < j; i++){
        backwardsString[i] = y[k];
        k--;
    }
    backwardsString[i] = '\0';
    printf("the reverse of string %s ", y);
    printf("==> %s\n", backwardsString);
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/***********************************************************************************************************
 * Lego Batman Fan
 * This little program determines if two strings are palindromes. A few rules:
 * 1. If one or both of the strings are blank, flagString = false. 
 * 2. It the strings are not the same length, flagString = false.
 * 3. The characters in the string are sorted in alphabetical order. If the strings do not contain the same
 *      characters, flagString = false.
 * 4. If the reverse of first string is not the same as second string (which has not been altered), 
 *      flagString = false.
 * 
 * The code contains a number of nested loops and is difficult to follow.
 ************************************************************************************************************
 */

namespace ConsoleApplication1
{
	class Program
	{
		static void Main(string[] args)
		{
			Boolean flagString;

			Console.WriteLine("Hello Lego Batman");
			Console.WriteLine("Now give me two strings and I will determine if they are palindromes..");
			Console.Write("String #1: ");
			string string001 = Console.ReadLine();
			Console.Write("String #2: ");
			string string002 = Console.ReadLine();
			Console.WriteLine("You entered: ");
			Console.WriteLine(string001);
			Console.WriteLine("AND");
			Console.WriteLine(string002);
			Console.WriteLine("");

            //STEP 1. If one or both of the strings are blank, flagString = false (this is not a palindrome).
            //Continue if the strings are not empty.
			if (string001 == "" | string002 == "")
			{
				flagString = false;
				Console.WriteLine("one of the strings is blank");
			}

			//STEP 2. If the strings are not the same length, flagString = false (this is not a palindrome).
            //Continue the test if the strings are the same length.
			else if (string001.Length == string002.Length)
			{
				Console.WriteLine("the strings are the same length");

                //Convert the strings into character arrays.
				char[] inputCharArray001 = string001.ToArray();
				char[] inputCharArray002 = string002.ToArray();

                //reverseStringBuider will be used for building the reverse of string001.
				var reverseStringBuilder = new StringBuilder();

                //Sort the character array and convert it to a string.
				Array.Sort(inputCharArray001);
				Array.Sort(inputCharArray002);
				string sortedString001 = new string(inputCharArray001);
				string sortedString002 = new string(inputCharArray002);

                //STEP 3. Compare the sorted strings. If they are not the same (containing the same characters), 
                //flagString = false (this is not a palindrome). If the strings contain the same characters,
                //continue the test.
				if (sortedString001 == sortedString002)
				{
					Console.WriteLine("the strings have the same characters");

                    //Reverse the first string.
					for (int k = string001.Length - 1; k >= 0; k--)
					{
						reverseStringBuilder.Append(string001[k]);
					}

                    //Convert reverseStringBuilder to a string and print the first, second, and reverse string
                    //to the console.
					string reverseString = reverseStringBuilder.ToString();

					Console.WriteLine("first string: " + string001);
					Console.WriteLine("second string: " + string002);
					Console.WriteLine("The reverse string " + reverseString);

					//STEP 4. Compare the reverse string to the second unaltered string. This is the final test.
					//If the reverse of the first string is the same as the second string, flagString = true.
					//Else, flagString = false (this is not a palindrome).
					if (reverseString == string002)
					{
						Console.WriteLine("the reverse and forward strings are the same");
						flagString = true;
					}
					else
					{
                        //Print message if the reverse and forward strings are not the same. flagString = false.
						Console.WriteLine("the reverse and forward strings are not the same");
						flagString = false;
					}
				}
				else
				{
                    //Print message if the strings do not have the same letters. flagString = false.
					Console.WriteLine("the strings do not have the same letters");
					flagString = false;
				}
			}
			else
			{
                //Print message if the strings are not the same length. flagString = false.
				Console.WriteLine("the strings are not the same length");
				flagString = false;
			}

            //If flagString = true, print the message "this is a palindrome," else print "this is not a palindrome.
			if (flagString == true)
			{
				Console.WriteLine("this is a palindrome");
			}
			else
			{
				Console.WriteLine("this is not a palindrome");
			}
			Console.Read();

		}
	}
}

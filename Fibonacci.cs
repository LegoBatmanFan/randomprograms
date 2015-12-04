/// Lego Batman Fan
/// This is simple program that prints out a fibonacci number using two different methods
/// oldfashionedfibonacci and recursivefibonacci

using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace RandomPrograms
{
     [TestClass]
     public class Fibonacci
     {
          [TestMethod]
          public void TestMethod1()
          {
               /// Print the 6th fibonacci using a recursive method
			   Console.Out.WriteLine("Printing fibonacci numbers...");
               Console.Out.WriteLine("recursive...");
               Console.Out.WriteLine("the 6th fibonacci number...");
               Console.Out.WriteLine(recursivefibonacci(6));
			   
			   /// Print the 25th fibonacci number using a recursive method
               Console.Out.WriteLine("the 25th fibonacci number...");
               Console.Out.WriteLine(recursivefibonacci(25));
               Console.Out.WriteLine(" ");
			   
			   /// Print 25 fibonacci numbers the old fashioned way
               Console.Out.WriteLine("the old fashioned way...let's print 25 fibonacci numbers...");
               oldfashionedfibonacci();

          }

          private void oldfashionedfibonacci()
          {
               int sum = 1;
               int num001 = 0;
               int num002 = 0;
               for (int i = 1; i <= 25; i++)
               {
                    Console.Out.WriteLine(sum);
                    num001 = num002;
                    num002 = sum;
					/// sum is the fibonacci number we want
                    sum = num001 + num002;
               }
          }

          private int recursivefibonacci(int p)
          {
               if (p == 0 || p == 1)
               {
                    return p;
               }
               else
               {
                    return recursivefibonacci(p - 1) + recursivefibonacci(p - 2);
               }
          }

          
     }
}

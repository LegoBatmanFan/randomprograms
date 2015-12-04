/// Lego Batman Fan
///
/// FizzBuzz
///
/// If a number is divisible by 3, the program will print "FIZZ."
/// If a number is divisible by 5, the program will print "BUZZ."
/// If a number is divisible by 15, the program will print "FIZZBUZZ."

using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace RandomPrograms
{
     [TestClass]
     public class FizzBuzz
     {
          [TestMethod]
          public void TestMethod1()
          {
               for (int i = 1; i <= 100; i++)
               {
                    if (i % 15 == 0)
                    {
                         Console.Out.Write(i);
                         Console.Out.WriteLine(" ==> FIZZBUZZ");
                    }
                    else if (i % 5 == 0)
                    {
                         Console.Out.Write(i);
                         Console.Out.WriteLine(" ==> BUZZ");
                    }
                    else if (i % 3 == 0)
                    {
                         Console.Out.Write(i);
                         Console.Out.WriteLine(" ==> FIZZ");
                    }
                    else
                    {
                         Console.Out.WriteLine(i);
                    }
               }
          }
     }
}

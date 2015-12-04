/// Lego Batman Fan
///
/// FizzBuzz
///
/// if a number if a multiple of 3, print "FIZZ"
/// if the number is a multiple of 5, print "BUZZ"
/// if the number is a multiple of 3 and 5 print FIZZBUZZ"
///
/// check for i % 15 first, then check for 3 or 5 because you
/// want multiples of 15 to print out "FIZZBUZZ" instead of
/// "Fizz" or "Buzz."

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

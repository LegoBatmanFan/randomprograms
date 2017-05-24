using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
	class Program
	{
        static void Main(string[] args)
        {
            int batNumber, batMultiple;
            string batString;

            Console.WriteLine("Hello Lego Batman");
            Console.WriteLine("Give me a number and I'll create a multiplication table..");
            batString = Console.ReadLine();

            batNumber = Int32.Parse(batString);
            Console.WriteLine("");
            Console.WriteLine("");
            Console.WriteLine("Your multiplication table Lego Batman, sir");
            Console.WriteLine("===================================================");
            for (int i = 1; i <= batNumber; i++)
            {
                for (int j = 1; j <= batNumber; j++)
                {
                    batMultiple = i * j;
                    Console.Write(string.Format("{0,5}", batMultiple));
                }
                Console.WriteLine("");
            }
        }
	}
}

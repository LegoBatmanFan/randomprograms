# LegoBatmanFan
# Fizz Buzz in Python
# for numbers between 1 and 100
# if a number if a multiple of 3, print "FIZZ"
# if the number is a multiple of 5, print "BUZZ"
# if the number is a multiple of 3 and 5 print FIZZBUZZ"
#
# check for i % 15 first, then check for 3 or 5 because you
# want multiples of 15 to print out "FIZZBUZZ" instead of
# "Fizz" or "Buzz."
# You can run this program at http://www.codeskulptor.org/#user40_LkUWaN94ZC_1.py


def fizzbuzz():
    for i in range(1,101):
        #i=+1
        if i % 15 == 0:
            print str(i) + "==> FIZZBUZZ"
        elif i % 3 == 0:
            print str(i) + "==> Fizz"
        elif i % 5 == 0:
            print str(i) + "==> Buzz"
        else:
            print i

fizzbuzz()
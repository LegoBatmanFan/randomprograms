# LegoBatmanFan
# This is simple program that prints out a fibonacci number using two different methods
# printfibonacci and recursivefibnumber
#
# You can run this program using CodeSkulptor at the following link:
# http://www.codeskulptor.org/#user40_tkOCcY8B0UzTdzo.py

# recursivefibnumber(n) prints out the numbers using
# recursion. 
def recursivefibnumber(n):
    if n == 0 or n == 1:
        return n
    else:
        return recursivefibnumber(n-1) + recursivefibnumber(n-2)    

		
# printfibonacci prints out 25 fibonacci numbers  
def printfibonacci():
    num001 = 0
    num002 = 0
    sum = 1
 
    for i in range(1,26):
        print str(i) + " ==> " + str(sum)
        num001 = num002
        num002 = sum
		# sum is the fibonacci number we want
        sum = num001 + num002
        
    
   
    
# print out the results
print "recursive fibonacci..."
print "six ==> " + str(recursivefibnumber(6))
print "twenty-five==> " + str(recursivefibnumber(25))
print " "
print "Just printing 25 fibonacci numbers..."
printfibonacci()


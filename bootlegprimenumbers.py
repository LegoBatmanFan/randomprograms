###################################################################
# LegoBatmanFan
#
# Bootleg Prime Numbers
# This program finds the nth prime number. It works when n <= 30. 
# There are many algorithms for finding the nth prime number...
# check out https://en.wikipedia.org/wiki/Prime_number
# This is my bootleg version.
#
# This program can be executed using Code Skulptor at the following link:
# http://www.codeskulptor.org/#user40_GaxOTYuijlxMMNN.py
#
###################################################################

import simplegui
import math

def find_the_prime(bat_num):
    bat_count = 0
    possible_bat_prime = 1
    composite_bat_num = 0
    
    while (bat_count < bat_num):
        possible_bat_prime += 1
        if (possible_bat_prime == 2) or (possible_bat_prime == 3) or (possible_bat_prime == 5) or (possible_bat_prime == 7):
            bat_count += 1
        elif ((possible_bat_prime % 2 == 0) or (possible_bat_prime % 3 == 0) or (possible_bat_prime % 5 == 0) or (possible_bat_prime % 7 == 0)):
            composite_bat_num += 1
        else:
            bat_count += 1

        
    print "count ==> " +str(bat_count)    
    print "the nth prime where n equals " +str(bat_num)+ " is..." +str(possible_bat_prime)
    print "====================================="
    print " "
    print " "
    
# Check the input. We only want integers greater than zero but less than or 
# equal to 30. Ask the user to try again if the input contains any characters
# or if the number is zero. If the user enters an integer, convert the string
# into an integer and send the value to the function find_the_prime.
def check_number(n_number):
    if not (n_number.isdigit()):
        print "there are characters in the string " +n_number+ "...try again"
        print " "   
    elif (n_number.isdigit() and int(n_number) == 0):
        print "the number cannot be zero...try again"
        print " "
    elif (n_number.isdigit() and int(n_number) > 30):
        print "enter a number less than or equal to 30...try again"
    else:
        print "converting " +n_number+ " to an integer..."
        x = int(n_number)
        print "searching for the nth prime number where n equals " +str(x)
        find_the_prime(x)

        
# Create the frame.
# Register event handlers for control elements and start frame.        
f = simplegui.create_frame("find the Nth Prime number", 200, 200)
f.add_input("enter a number", check_number, 150)

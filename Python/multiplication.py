# Lego Batman Fan
# Print the multiplication table up to 12 x 12
#
# The code for this program can be executed at 
# http://www.codeskulptor.org/#user40_AZG0AKnKLa_1.py

def multiplication_table():
    for i in range(1,13):
        for j in range(1,13):
            print('%5d'% (j*i)),
        print(" ")
        
multiplication_table();
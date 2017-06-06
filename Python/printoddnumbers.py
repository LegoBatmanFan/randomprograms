# Lego Batman Fan
#
# Print all of the odd numbers between 1 and 100
#
# The code for this program can be executed at
# http://www.codeskulptor.org/#user40_gVLwAlhJLD_0.py

def print_odd_numbers():
    count = 0
    print(" ")
    for i in range(1, 100, 2):
        if count > 4:
            print(" ")
            count = 0
        print('%5d'% (i)),
        count+= 1
        #print(str(count))
        
        
print_odd_numbers()
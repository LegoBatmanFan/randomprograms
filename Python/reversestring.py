# LegoBatmanFan
# Reverse a string
# This program reverses a string using two different methods
# one method uses an array and the other using [::-1] 
#
# This program can be executed using Code Skulptor at the following link:
#  http://www.codeskulptor.org/#user40_C2XiwEZEZP3jGLi_1.py

import simplegui


string001 = " "
string002 = " "
string003 = " "

def reverse_my_string(this_string):
    global string001, string002, string003
    
    n = len(this_string)
    backwards_string = " "

    for i in range(n-1, -1, -1):
        backwards_string += this_string[i]
    
    string001 = this_string
    
    string002 = backwards_string
    
    string003 =  this_string[::-1]
  

def draw(canvas):
    message001 = "here is the original string..."
    message002 = "here is another way of reversing a string..."
    message003 = "another way of reversing a string using [::-1]..."

    canvas.draw_text(str(message001), (30, 50), 20, 'White')
    canvas.draw_text(str(string001), (30, 80), 20, 'White')
    canvas.draw_text(str(message002), (30, 140), 20, 'White')
    canvas.draw_text(str(string002), (30, 170), 20, 'White')
    canvas.draw_text(str(message003), (30, 230), 20, 'White')
    canvas.draw_text(str(string003), (30, 260), 20, 'White')
    
    
# Create the frame.
# Register event handlers for control elements and start frame.        
f = simplegui.create_frame("Reverse a String...", 450, 300)
f.add_input("enter a string", reverse_my_string, 150)
f.set_draw_handler(draw)

f.start()
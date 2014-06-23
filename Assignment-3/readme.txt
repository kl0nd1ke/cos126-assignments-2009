/**********************************************************************
 *  readme.txt template                                                   
 *  Recursive Graphics
 **********************************************************************/

Name: Vladimir Costescu
Login: costescu
Precept: P04A
OS: Windows Vista SP2
Text editor: Eclipse 3.5
Hours to complete assignment (optional):



/**********************************************************************
 *  Describe your artistic creation, and how you went about writing   
 *  a program to produce it. If you used any sources such as the book
 *  or booksite, reference them here. 
 **********************************************************************/

My artistic creation (in its present incarnation) is called the twin
dragon curve, which is basically two stacked Heighway dragon curves.
I was initially trying to create a Heighway dragon curve, but that failed
miserably, so I instead used the trig foundations I had set up to try to
create some other fractal. I ended up creating the Pythagoras tree using
lines, but I wasn't fully content because someone last year did that in
the form of a jester hat. Some thinking later, I decided to un-hardcode
the angles of the two directions (left and right) and play around with
them to see what I would get (the initial angles for the Pythagoras tree
were 45 and 45 degrees from the orientation of the previous line drawn).

To my great delight, I stumbled onto the 135 and 45 degree combination
that created the twindragon curve (I can't really explain why it works,
given that I was unable to create a single dragon curve). I also found
some other values that created interesting fractals (including values
that create a kind of H-tree) that I included as comments in the code.

Ultimately, I decided to change from lines to points (worked better for
the appearance of the fractals, especially the twindragon curve), which
I feel was the right way to go.

Wikipedia was my main source for inspiration (this is where I found the
dragon curve, and also the Pythagoras tree / Levy C curve, which are
similar). I also glanced at the book's implementation of H-tree after I
had found a way to create it differently (though in my final code I use
the values for the twindragon in order to fulfill the difference
requirement).

/**********************************************************************
 *  List whatever help (if any) that you received, and the names of
 *  any students with whom you collaborated.                          
 **********************************************************************/



/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

Trying to figure out what counted as "different enough" for the art part
of the assignment.


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

I enjoyed the art part of the assignment, though my failure to create the
Heighway dragon curve did create a lot of frustration for some time,
until I stumbled onto the twindragon curve and the other fractals in the
code comments.
/**********************************************************************
 *  readme template                                                   
 *  TSP Heuristics
 **********************************************************************/

Name: Vladimir Costescu
Login: costescu
Precept: P04A
Partner (if any):
Partner's email:
Partner's precept:

Hours to complete assignment (optional): ~3 (~4.5 including readme)


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/

I used a do while loop to iterate through the nodes and calculate the
distance from the current node to the point to be inserted. I also kept
track of the smallest distance calculated thus far and compared it to
the distance calculated in the previous iteration of the loop (since I 
calculated the next distance at the end of each iteration, with an
initial condition for the first loop iteration). After the loop, I 
inserted the new node after the closest node (of which I also kept
track in the for loop).

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/

I performed the same steps as in the nearest insertion heuristic, 
except for the calculation of the current and best distance. Instead of
simply calculating the distance from the current node to the point to 
be inserted, I calculated the following: distance from current node to
new point + distance from new point to (current node).next - distance
from current node to (current node).next.

/**********************************************************************
 *  Fill in the distances computed by your heuristics.                
 **********************************************************************/

data file          nearest neighbor     smallest increase      extra credit
-----------------------------------------------------------------------------
tsp10.txt              1566.136              1655.746
tsp100.txt             7389.930              4887.219
tsp1000.txt           27868.711             17265.628
usa13509.txt          77449.979             45074.777

/**********************************************************************
 *  Estimate the running time of your two heuristics as a function
 *  of N using an expression of the following form: a * N^b  seconds.
 *  DESCRIBE HOW YOU DETERMINED YOUR ANSWER. You are encouraged to use
 *  more than 3 data points. You may use TSPTimer.java as described
 *  in the checklist.
 **********************************************************************/

nearest: a * N^b = 1.74e-10 * N^2.47

  doubling factor: 6.608 4.96 5.01 (avg = 5.53)
  exponent b = log2(doubling factor) = log2(5.53) = 2.47

  N = 8000: 0.72 seconds
  N = 16000: 4.758 seconds
  N = 32000: 23.59 seconds
  N = 64000: 118.253 seconds

  a: 1.65e-10 1.96e-10 1.76e-10 1.59e-10 (avg = 1.74e-10)

smallest: a * N^b = 5.94e-9 * N^2.18
  
  doubling factor: 4.86 4.87 3.83 (avg = 4.52)
  exponent b = log2(doubling factor) = log2(4.52) = 2.18

  N = 8000: 1.826 seconds
  N = 16000: 8.88 seconds
  N = 32000: 43.251 seconds
  N = 64000: 165.551 seconds

  a: 5.66e-9 6.07e-9 6.53e-9 5.51e-9 (avg = 5.94e-9)

/**********************************************************************
 *  Explain why you used a circular linked list instead of an array.  
 **********************************************************************/

Firstly, if you don't have a circular structure of some sort, the
salesperson can't get home! Furthermore, an array of any sort is not an 
appropriate data structure because it is time-consuming and unnecessary 
to shuffle around the elements in an array each time a point is 
inserted, whereas using a linked list is much more effective at this.

/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/



/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/



/**********************************************************************
 *  List whatever help (if any) that you received, and the names of  
 *  any students with whom you collaborated.                          
 **********************************************************************/



/**********************************************************************
*  If you collaborated, would you recommend partnering for     
*  future assignments? And explain why or why not.
 **********************************************************************/





/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/




/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

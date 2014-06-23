/**********************************************************************
 *  readme.txt template                                                   
 *  Atomic Nature of Matter
**********************************************************************/

Name: Vladimir Costescu
Login: costescu
Precept: P04A
Partner (if any):
Partner's email:
Partner's precept:

Hours to complete assignment (optional):



/**********************************************************************
 *  Describe how you identified the beads.
 **********************************************************************/

For each blob, I determined whether the blob size was acceptable or not,
and then I stored the acceptable blobs in an ArrayList.

/**********************************************************************
 *  Give the estimate of Avogadro's number for each of the 
 *  10 datasets.
 **********************************************************************/
run_1: 6.607e23
run_2: 6.063e23
run_3: 6.391e23
run_4: 5.964e23
run_5: 6.292e23
run_6: 6.153e23
run_7: 6.479e23
run_8: 5.820e23
run_9: 6.182e23
run_10: 6.438e23


/**********************************************************************
 *  What is the average case running time of your BeadTracker program 
 *  as a function of the input size (the total number of pixels across
 *  all frames)? Linear, linearithmic, quadratic, or exponential?
 *  By average case, we mean inputs like the ones in run_[1-9].
 *  Explain.
 **********************************************************************/

Run time data:
41.65 seconds - run_1 (frames 0-199)
20.20 seconds - run_1 (frames 0-99)
2.69 seconds - run_1 (frames 0-9)

The run time data strongly suggests a linear run time (doubling
hypothesis - when the amount of data doubles, the run time doubles as
well, suggesting a power of around 1, which is linear).

Total numbers of pixels:
640 * 480 * 200 = 61440000 (6.144e7)
640 * 480 * 100 = 30720000 (3.072e7)
640 * 480 * 10 = 3072000 (3.072e6)

Estimated run time equation (based on average of first two data points):
6.677e-7 * n


/**********************************************************************
 *  Explain any known bugs / limitations in your program.
 **********************************************************************/


/**********************************************************************
 *  List whatever help (if any) that you received.
 **********************************************************************/


/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/


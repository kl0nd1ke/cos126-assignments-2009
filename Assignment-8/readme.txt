/**********************************************************************
 *  readme template                                                   
 *  Theory of Computation exercises
 **********************************************************************/

Name: Vladimir Costescu
Login: costescu
Precept: P04A

Hours to complete assignment (optional):


/**********************************************************************
 *  Huntington's:  describe your general approach and how you tested
 *  its correctness (e.g., What test inputs did you use?).
 **********************************************************************/

To find the longest sequence, I looked at each sequence (in order of
appearance) and kept track of the number of repeats in the current
sequence and also of the highest number of repeats in sequences seen so
far. At the end of each sequence (i.e. when the next find was not
right after the previous find in the string), I compared the current
number of repeats with the highest number of repeats, and replaced the
highest number of repeats if necessary.

For test inputs, I used test4.txt, test10.txt, test64.txt,
chromosome4-healthy.txt, and chromosome4-hd.txt.

/**********************************************************************
 *  Turing machine:  describe how your Turing machine works and 
 *  how you tested its correctness (e.g., test inputs).
 **********************************************************************/

The comparator Turing machine I wrote works by subtracting 1 from each
number until one of the numbers becomes zero. If the first number 
becomes zero first, the machine reaches an unaccepting state. If the
second number becomes zero first, the machine reaches an accepting
state. If both numbers become zero (i.e. the numbers are equal), the 
machine reaches an unaccepting state.

The test inputs I used are in the comparator.tur file's tapes section.
To test boundary cases, I used numbers that only differ by one, numbers
that are equal, numbers that have different numbers of digits, and 
numbers that should reach both accepting and unaccepting states (i.e.
tested combinations in which the first number is smaller, and
combinations in which the second number is smaller).

/**********************************************************************
 *  List whatever help (if any) that you received, and the names of  
 *  any students with whom you collaborated.                          
 **********************************************************************/

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

/**********************************************************************
 *  readme template                                                   
 *  DNA Sequence Alignment
 **********************************************************************/

Name: Vladimir COstescu
Login: costescu
Precept: P04A
Partner (if any): N/A
Partner's email: N/A
Partner's precept: N/A

Hours to complete assignment (optional):


/**********************************************************************
 *  Explain what you did to find the alignment itself.
 **********************************************************************/
I calculated a, b, and c as in opt() to represent the 3 options (0/1, 2,
and 2), but instead of setting opt[i][j] to be the minimum of a, b, and
c, I tested to see whether opt[i][j] is a, b, or c, and created the 
strings accordingly.

/**********************************************************************
 *  How much main memory does your computer have? Typical answers
 *  are 1GB and 2GB. If your machine has 512MB or less, use a cluster
 *  machine for this question and the remainder of the readme questions.
 **********************************************************************/
Technically 2GB (but really around 1.6 GB, because of built-in graphics
using up some memory)

/**********************************************************************
 * What additional test data did you create to test your program
 * for special cases? (At least one set of test data required)
 **********************************************************************/
Lots of text files on the ftp site, and the below:

vladisawesomeomg
dovlnoaditbevwfsonfilongty

Output:

Edit distance: 26
- - v l - - a d i s a - - w e s o m e - - o m g - - 
d o v l n o a d i t b e v w f s o n f i l o n g t y 
2 2 0 0 2 2 0 0 0 1 1 2 2 0 1 0 0 1 1 2 2 0 1 0 2 2 

/**********************************************************************
 *  For each data file, fill in the edit distance computed by your
 *  program and the amount of time it takes to compute it. If your
 *  program cannot execute a particular data file on your system 
 *  because of insufficient memory, indicate that instead.
 **********************************************************************/

data file           distance       time (seconds)
-------------------------------------------------
ecoli2500.txt         118               0.65
ecoli3000.txt         125               0.85
ecoli5000.txt         160               3.65
ecoli7000.txt         194               4.69
ecoli10000.txt        223               9.23

/**********************************************************************
 *  As a function of the string length N (assume M = N), estimate the
 *  running time of your program in seconds. Your answer should have the
 *  form a * N^b for some constants a and b. Using the doubling hypothesis
 *  explain how you arrived at your answer.
 *
 *  What is the largest N your program can handle if it is limited to 1
 *  day of computation. Assume you have as much main memory as you need.
 **********************************************************************/
a = 0.0000923 (9.23e-5)
b = 1.25
largest N = 15033138

To find b, I compared 10000 and 5000 and 9.23 and 3.65. As N doubled, 
time increased by roughly 2.5 times. Thus, b = 2.5 / 2 = 1.25.

To find a, I plugged in 10000 for N, 1.25 for b, and 9.23 for time, and
solved for a.

/**********************************************************************
 *  As a function of the string length N (assume M = N), estimate the
 *  amount of memory used in bytes. Your answer should have the
 *  form a * N^b for some constants a and b. Assume char = 2 bytes, and
 *  int = 4 bytes. Justify your answer.
 *
 *  What is the largest N that your program can handle if it is
 *  limited to 1GB (1073741824 bytes) of memory. 
 **********************************************************************/
a = 4
b = 2
largest N = 16384 (rough estimate)

calculations: 
opt[][] array + strings (2 in, 2 out, so 4); temp variables not included
because Java handles garbabe collection after they are used

(N + 1)^2 * 4 + 4 * N * 2 = 
4N^2 + 8N + 4 + 8N = 
4N^2 + 16N + 4

for large N, the most significant part of this is 4N^2 (N^2 increases 2N
times faster than N)

/**********************************************************************
 *  List whatever help (if any) that you received, and the names of  
 *  any students with whom you collaborated.                          
 **********************************************************************/

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Answering all these analysis questions.

/**********************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described in lecture and the article
 *  http://www.cs.princeton.edu/introcs/papers/pairs-kindergarten.pdf
 **********************************************************************/

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
It was kind of tedious, especially all the analysis questions.
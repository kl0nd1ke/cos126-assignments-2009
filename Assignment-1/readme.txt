/**********************************************************************
 *  readme template
 *  Loops
 **********************************************************************/

Name: Vladimir Costescu
Login: costescu
Precept: P04A
OS: Windows Vista SP2
Text editor: Eclipse 3.5
Hours to complete assignment (optional):



/**********************************************************************
 *  How does the mean squared distance of a random walker grow
 *  as a function of the number of steps N? Briefly justify your
 *  answer based on computational experiments.
 *********************************************************************/

The mean squared distance of a random walker grows roughly linearly with the 
number of steps N. According to the example ouputs on the COS 126 site 
(http://www.cs.princeton.edu/courses/archive/fall09/cos126/assignments/loops.html)
and my own observations in running the program with T=100000 and different n
values, this conclusion seems to be valid. Some more example outputs follow below:

% javac RandomWalkers 150 100000
mean squared distance = 149.99276000000947

% javac RandomWalkers 150 100000
mean squared distance = 150.77084000001042

% javac RandomWalkers 379 100000
mean squared distance = 380.73156000001103

% javac RandomWalkers 379 100000
mean squared distance = 381.20428000000663

% javac RandomWalkers 5000 100000
mean squared distance = 5021.536780000188

% javac RandomWalkers 5000 100000
mean squared distance = 5014.576600000194

It does seem that as N gets bigger, the difference between N and the
squared distance gets bigger as well (but remains fairly small).

/**********************************************************************
 *  List whatever help (if any) that you received. You don't need to
 *  include the course materials, lectures, or precepts, but do
 *  include any additional help your received from people (course
 *  staff, lab TAs, classmates) and include their names.
 **********************************************************************/




/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/




/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/


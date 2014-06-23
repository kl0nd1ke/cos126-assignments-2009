/**********************************************************************
 *  readme.txt template                                                   
 *  LFSR PhotoMagic
 **********************************************************************/

Name: Vladimir Costescu
Login: costescu
Precept: P04A

Hours to complete assignment (optional):

/**********************************************************************
 *  Explain why it makes sense to have a separate LFSR class.
 **********************************************************************/

It makes sense to have a separate LFSR class because the functionality
of the LFSR can be reused for some other program, and having it as a
separate class makes this reusability easier.

/**********************************************************************
 *  List whatever help (if any) that you received, and the names of
 *  any students with whom you collaborated.                          
 **********************************************************************/


/**********************************************************************
 *  If you did one or more of the extra credits, name which one(s) you did, 
 *  describe it here and write why it is interesting.
 **********************************************************************/

I did Extra Credit 1, which involved creating a modified version of
PhotoMagic that allowed the user to utilize an alphanumeric "password"
instead of a string representation of pure binary. It is interesting
because such a program is far more suited to general use due to the
alphanumeric password support, so someone could actually use it to
encrypt images (it is doubtful that people would bother to remember
a long binary string).

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/


/**********************************************************************
 *  Did you fill out the midterm evaluation questionnaire?  
 **********************************************************************/

Yes

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

It was an interesting assignment, and provided a springboard for my idea
to create an implementation of digital steganography. My steganography
implementation takes a string (plaintext or ciphertext) and "hides" it
in an image. The message can be retrieved through comparison of the
original and modified images. The steganography client handles both
encryption and decryption and creates a GUI for the user to be able to
select which image to use and to enter the text.

Inspiration:
http://en.wikipedia.org/wiki/Steganography#Digital_steganography
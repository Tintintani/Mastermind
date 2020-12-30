# Projects
Instructions:
Input:
  The number of digits in the random number to be guessed  
    Has to be integer 3-9  
  Whether the digits can have repeated digits or not  
    Has to be character 'n' for no or 'y' for yes  
  The number of attempts the player will have to guess the number  
    Has to be integer  
After the random number has been chosen by the game it will ask player to enter first guess  
Input:  
  Guess  
    The guess should have the same number of digits as previously specified  
    The guess can have repeated digits if it was previously allowed  
Output:  
  The number of correct digits  
    This is the number of digits in your guess that match with the digits in the number to guess  
  The number of digits in the correct position  
    This is the number of correct digits whose position in the number also matches withthe number to guess  
   
 This will repeat upto the number of tries specified  
 
 Example -   
     How many digits should the random number have? (3-9)  
     4 --> Input by the user for number of digits in the number to guess  
     Can the number have repeated digits?(y/n)  
     n --> Input by the user specifying that the number cannot have repeated digits  
     A random number with 4 digits without repeated digits has been chosen  
     How many attempts would you like to guess the number?  
     10 --> Input by the user of number of attempts to guess the number correctly  
     You have 10 attempts to guess the random number  
     Enter guess 1:   
     1234  
     Guess 1:  
     Correct Digits:   0  
     Correct Position: 0  
     Enter guess 2:  

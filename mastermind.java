import java.util.Random;
import java.util.Scanner;

public class mastermindTest {

// Method to convert integer into array of its digits
public static void intToArray(int numToConvert, int numOfDigits, int arr[])
{
  int temp = numToConvert;
  for (int i = 0; i < numOfDigits; i++)
  {
    arr[i] = temp % 10;
    temp /= 10;
  }
}

//Method to sort array
public static void arraySort(int arr[], int length)
{
  for (int i = 0; i < length; i++)
  {
    for (int j = 0; j < length; j++)
    {
      int temp;
      if (arr[i] > arr[j])
      {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
  }
}

//Method to check for repeated digits in integer
public static int checkRepeat(int num, int numOfDigits)
{
  int repeat = 0;
  int tempNumToGuessArr[] = new int[numOfDigits];
  intToArray(num, numOfDigits, tempNumToGuessArr);
  arraySort(tempNumToGuessArr, numOfDigits);
  for (int i = 0; i < numOfDigits - 1; i++)
  {
    if (!(tempNumToGuessArr[i + 1] < tempNumToGuessArr[i]))
    {
      repeat++;
      break;
    }
  }
  return repeat;
}
	public static void main(String[] args) {
		//Declaring variables
		int correctDigit, correctPlace, guess, attempts = 5;
		int numToGuess, win = 0, numOfDigits = 3, maxValue = 1, minValue;
		int guessArr[] = new int[numOfDigits];
		int numToGuessArr[] = new int[numOfDigits];
	  
		//For repeated digits check
		int repeat = 0;
		char userInpRepeat = '2';

		//Creating scanner and random
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
	  
		//Setting number of digits in number
		do
		{
		  System.out.println("How many digits should the random number have? (3-9)");
		  numOfDigits = sc.nextInt();
		} while (!(numOfDigits <= 9 && numOfDigits >= 3));
	  
		//Setting the max and min value of the random number
		for (int i = 0; i < numOfDigits; i++)
		{
		  maxValue *= 10;
		}
		minValue = maxValue/10;
		// printf("min is %d and max is %d\n", minValue, maxValue); // checking min and max
	  
		//Setting whether digits can repeat
		while (!(userInpRepeat == 'y' || userInpRepeat == 'n'))
		{
		  System.out.println("Can the number have repeated digits?(y/n)");
		  sc.nextLine();
		  userInpRepeat = sc.nextLine().charAt(0);
		  // printf("%c", userInpRepeat); // Checking userInpRepeat
		}
	  
		//Setting random number
	  
		if (userInpRepeat == 'n')
		{
		  repeat = 0;
		  do
		  {
	  
			numToGuess = rand.nextInt(maxValue);
		  } while (checkRepeat(numToGuess, numOfDigits) != 0);
		  System.out.println("A random number with "+numOfDigits+" digits without repeated digits has been chosen");
		}
		else
		{
		  repeat = 1;
		  numToGuess = rand.nextInt(maxValue);
		  System.out.println("A random number with " + numOfDigits + " digits with or without repeated digits has been chosen");
		}
	  
		//Setting number of attempts
		System.out.println("How many attempts would you like to guess the number?");
		attempts = sc.nextInt();
		System.out.println("You have "+attempts+" attempts to guess the random number");
	  
		//Taking input of guesses
		for (int i = 0; i < attempts; i++)
		{
		  correctDigit = 0;
		  correctPlace = 0;
	  
		  if (repeat == 0)
		  {
			do
			{
			  System.out.println("Enter guess "+(i+1)+": ");
			  guess = sc.nextInt();
			} while (!(guess > minValue && guess < maxValue && checkRepeat(guess, numOfDigits) == 0));
		  }
		  else
		  {
			do
			{
			  System.out.println("Enter guess "+(i+1)+": ");
			  guess = sc.nextInt();
			} while (!(guess > minValue && guess < maxValue));
		  }
	  
		  //guess can be equal to max and min right?
	  
		  //Converting guess and numtoguess to array for comparison of digits
	  
		  intToArray(numToGuess, numOfDigits, numToGuessArr);
		  intToArray(guess, numOfDigits, guessArr);
	  
		  //Checking guess
		  for (int j = 0; j < numOfDigits; j++)
		  {
			if (numToGuessArr[j] == guessArr[j])
			{
			  correctPlace += 1;
			}
			for (int k = 0; k < numOfDigits; k++)
			{
			  if (numToGuessArr[k] == guessArr[j])
			  {
				correctDigit += 1;
			  }
			}
		  }
		  //Check for win
		  if (correctPlace == numOfDigits)
		  {
			System.out.println("You have guessed the number correctly in "+(i+1)+" attempts\n");
			win = 1;
			break;
		  }
		  //Print hints after guess
		  System.out.println("Guess "+(i+1)+":          " + guess);
		  System.out.println("Correct Digits:   " + correctDigit);
		  System.out.println("Correct Position: " + correctPlace);
		}
		//If guess wasn't correct for number of attempts
		if (win == 0)
		{
		  System.out.println("You couldn't guess the number in %d tries\n" + attempts);
		  System.out.println("The number was " + numToGuess);
		}
		sc.close();
	}
}


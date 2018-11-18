/*
 * @author:     Dominic Iannucci
 * @date:       10/10/2018
 * @descripton: This program converts temperatures from Celsius to Farhenheit, and vice versus.
 * 		The program will prompt the user to select the desired outcome unit of measure, and then 
 * 		prompt the user for the temperature reading to be converted. The program will output the 
 * 		input value and the converted value. Finally, it will prompt the user to convert another
 * 	        value, or end the program.
 */
import java.util.Scanner;
public class Assignment3 
{

	public static void main(String[] args) 
	{
		// Declarations:
		int Choice1 = 0;
		int Choice2 = 0;
		int temp_C = 0;
		int temp_F = 0;
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Welcome to HotJava Temperature Converter!");
		
		while(Choice2 != 2) // Choice2 - Main Loop
		{
			System.out.println("");
			System.out.println("Please make your selection: ");
			System.out.println(" ");
			System.out.println("[1] Convert Celsius to Farenheit");
			System.out.println("[2] Convert Farenheit to Celsius");
				Choice1 = scanner.nextInt();
				if(Choice1 == 1) // Choice1 : Celsius to Farenheit Conversion
				{
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("Please enter the temperature to be converted, in Celsius: ");
					temp_C = scanner.nextInt();
					
					// Celsius to Farenheit Calculation
					int converted_C = (temp_C * 9/5) +32;
					
					// Celsius to Farenheit Output
					System.out.println(" ");
					System.out.println("You entered: " + temp_C + " C");
					System.out.println(" ");
					System.out.println("Which is equal to: " + converted_C + " F");
				}
				else if (Choice1 == 2) // Choice1 : Farenheit to Celsius
				{
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("Please enter the temperature to be converted, in Farenheit: ");
					temp_F = scanner.nextInt();
					
					// Farenheit to Celsius Calculation
					int converted_F = (temp_F -32) * 5/9;
					
					// Farenheit to Celsius Output
					System.out.println(" ");
					System.out.println("You entered: " + temp_F + " F");
					System.out.println(" ");
					System.out.println("Which is equal to: " + converted_F + " C");
				}
				else
					// Exception Handling
					System.out.println("Invalid selection. Please try again.");
		
		// Choice2: Another Conversion or Quit
		System.out.println(" ");
		System.out.println(" ");
		System.out.println ("Please make a selection: ");
		System.out.println("[1] Perform another conversion");
		System.out.println("[2] Quit");
		Choice2 = scanner.nextInt();
		if (Choice2 == 2)	break;
		}
		System.out.println("Good bye.");
	}// End Main
}// End Class

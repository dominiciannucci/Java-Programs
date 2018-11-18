/*
 * @Author:       Dominic Iannucci
 * @Date:         09/28/2018
 * @CreatedWith:  Eclipse Photon IDE v4.8.0
 * @Description:  This program prompts for user input (x3) relating to questions about home ownership,
 *                mortgage status, and annual salary. It compares the user input to the acceptable 
 *                conditional values provided by the project specifications, and returns output which displays
 *                whether the user was approved or disapproved for the loan. 
 */
import java.util.Scanner;

public class Assignment2LoanApplication 
{

	public static void main(String[] args) 
	{
	
		// Declarations:
		int Home, Mortgage, Income;
		Scanner scanner = new Scanner (System.in);
		
		// Output - Welcome Message:
		System.out.println(" ");
		System.out.println("      ##    ###    ##     ##    ###     ######  ##     ## ##    ##    ########     ###    ##    ## ##    ## ");
		System.out.println("      ##    ###    ##     ##    ###     ######  ##     ## ##    ##    ########     ###    ##    ## ##    ## ");
		System.out.println("      ##   ## ##   ##     ##   ## ##   ##    ## ##     ## ###   ##    ##     ##   ## ##   ###   ## ##   ##  ");
		System.out.println("      ##  ##   ##  ##     ##  ##   ##  ##       ##     ## ####  ##    ##     ##  ##   ##  ####  ## ##  ##   ");
		System.out.println("      ## ##     ## ##     ## ##     ##  ######  ##     ## ## ## ##    ########  ##     ## ## ## ## #####    ");
		System.out.println("##    ## #########  ##   ##  #########       ## ##     ## ##  ####    ##     ## ######### ##  #### ##  ##   ");
		System.out.println("##    ## ##     ##   ## ##   ##     ## ##    ## ##     ## ##   ###    ##     ## ##     ## ##   ### ##   ##  ");
		System.out.println(" ######  ##     ##    ###    ##     ##  ######   #######  ##    ##    ########  ##     ## ##    ## ##    ## ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Thank you for choosing JavaSun Bank. Please complete this short questionnaire to process your loan application.");
		System.out.println(" ");
		

		// Input1:
		System.out.println("Do you own a home? ");
		System.out.println("[1] Yes ");
		System.out.println("[2] No");
		System.out.println("Choose a number: ");
			Home = scanner.nextInt();
			if(Home < 1 || Home > 2) 
			{
				System.out.println("Input validation error. Try again.");
				scanner.close();
				return;
			}else if(Home == 2) 
			{
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("                              LOAN APPLICATION SUMMARY");
				System.out.println(" ");
				System.out.println("Do you own a home?                                                                       no");
				System.out.println(" ");
				System.out.println("Do you pay a mortgage on that home?                                                     N/A");
				System.out.println(" ");
				System.out.println("Did you report a gross annual salary greater than $44,999.99 last year?                 N/A");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("STATUS:                                                                              DENIED");
				System.out.println(" ");
				System.out.println("Unfortunately, because you do not own a home, your loan cannot be approved at this time.");
				System.out.println("We hope that you will keep us in mind for any future banking needs.");
				}else 
			{
				System.out.println("Do you pay a mortgage on that home?");
				System.out.println("[1] Yes ");
				System.out.println("[2] No ");
				System.out.println("Choose a number: ");
					Mortgage = scanner.nextInt();
					if(Mortgage < 1 || Mortgage > 2) 
					{
					System.out.println("Input validation error. Try again.");
					scanner.close();
					return;
					}else if(Mortgage == 1) 
					{
						System.out.println(" ");
						System.out.println(" ");
						System.out.println(" ");
						System.out.println("                              LOAN APPLICATION SUMMARY");
						System.out.println(" ");
						System.out.println("Do you own a home?                                                                      yes");
						System.out.println(" ");
						System.out.println("Do you pay a mortgage on that home?                                                      no");
						System.out.println(" ");
						System.out.println("Did you report a gross annual salary greater than $44,999.99 last year?                 N/A");
						System.out.println(" ");
						System.out.println(" ");
						System.out.println("STATUS:                                                                              DENIED");
						System.out.println(" ");
						System.out.println("Unfortunately, because your home is currently under mortgage, your loan cannot be approved at this time.");
						System.out.println("We hope that you will keep us in mind for any future banking needs.");
					}else 
					{
						System.out.println("Did you report a gross annual salary greater than $44,999.99 last year?");
						System.out.println("[1] Yes ");
						System.out.println("[2] No ");
						System.out.println("Choose a number: ");
							Income = scanner.nextInt();
							if(Income < 1 || Income > 2) 
							{
								System.out.println("Input validation error. Try again.");
								scanner.close();
								return;
							}else if(Income == 2) 
							{
								System.out.println(" ");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println("                              LOAN APPLICATION SUMMARY");
								System.out.println(" ");
								System.out.println("Do you own a home?                                                                      yes");
								System.out.println(" ");
								System.out.println("Do you pay a mortgage on that home?                                                      no");
								System.out.println(" ");
								System.out.println("Did you report a gross annual salary greater than $44,999.99 last year?                  no");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println("STATUS:                                                                              DENIED");
								System.out.println(" ");
								System.out.println("Unfortunately, because you reported an annual salary of less than $45,000.00 last year, your loan cannot be approved at this time.");
								System.out.println("We hope that you will keep us in mind for any future banking needs.");

							}else 
							{
								System.out.println(" ");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println("                              LOAN APPLICATION SUMMARY");
								System.out.println(" ");
								System.out.println("Do you own a home?                                                                      yes");
								System.out.println(" ");
								System.out.println("Do you pay a mortgage on that home?                                                      no");
								System.out.println(" ");
								System.out.println("Did you report a gross annual salary greater than $44,999.99 last year?                 yes");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println("STATUS:                                                                            APPROVED");
								System.out.println(" ");
								System.out.println("Congratulations! Your unsecured personal loan has been aproved. Thank you for banking with JavaSun Bank!");

							}
			}
		scanner.close();
		
			}
	}// End of Main
}// End of Class

/*
 * @title:		 QUIKPay Salary Calculator
 * @author:      Dominic Iannucci
 * @date:        11/13/2018
 * @description: This program prompts the user to choose between three different calculations: [1] regular pay
 * 				 ONLY, [2] overtime pay ONLY, [3] regular pay PLUS overtime pay, or [4] Exit . The program then
 * 				 prompts the user to enter their Social Security Number (SSN), the total number of (whole) hours
 * 				 worked per week, and the rate of hourly pay. The program automatically calculates the number of
 * 				 regular hours worked (based upon a 40-hr work week), and the number of overtime hours worked.
 * 				 If overtime hours were detected, the program assigns the rate of time at 1.5 times the RATE
 * 				 of regular pay. Finally, depending on the user's previous selection, the program will display 
 * 				 either the HOURS worked, the RATE of pay, and gross weekly SALARY, minus OVERTIME; the number of
 * 				 OVERTIME hours worked, the RATE of OVERTIME pay, and the gross weekly overtime (ot)SALARY; or 
 * 				 the HOURS worked, the RATE of pay, the number of OVERTIME hours worked, the OTRATE of pay, and 
 * 				 the gross weekly (full)SALARY due. 
 * 				 
 * 				 This program is coded in a modular format using separate methods (functions) for getting the 
 * 				 value of HOURS, getting the value of RATE, calculating the value of OVERTIME, calculating the
 * 				 value of OTRATE, calculating the value of regSALARY, otSALARY, and fullSALARY; and sending those
 * 				 values to regDISPLAY, otDISPLAY, or fullDISPLAY where they are displayed in the JOptionPane panel.
 */
import javax.swing.JOptionPane;

public class HW5_Iannucci 
{

	public static void main(String[] args) 
	{
		// DECLARATIONS:
		int SSN = 0;
		int HOURS = 0;
		double RATE = 0.00;
		int OVERTIME = 0;
		double OTRATE = 0.00;
		double REGSALARY = 0.00;
		double OTSALARY = 0.00;
		double FULLSALARY = 0.00;
		int MENU = 0;
		
		// ACTION:
		while(MENU != 4)
		{	
			MENU = getMENU();
			if(MENU == 1)
			{
				SSN = getSSN();
				HOURS = getHOURS();
				RATE = getRATE();
				REGSALARY = getREGSALARY(HOURS, RATE);
				regDISPLAY (SSN, HOURS, RATE, REGSALARY);
			}
			else if(MENU == 2)
			{	
				SSN = getSSN();
				HOURS = getHOURS();
				RATE = getRATE();
				OVERTIME = getOVERTIME(HOURS);
				OTRATE = getOTRATE(RATE);
				OTSALARY = getOTSALARY(HOURS, OVERTIME, OTRATE);
				otDISPLAY (SSN, OVERTIME, OTRATE, OTSALARY);
			}
			else if(MENU == 3)
			{
				SSN = getSSN();
				HOURS = getHOURS();
				RATE = getRATE();
				OVERTIME = getOVERTIME(HOURS);
				OTRATE = getOTRATE(RATE);
				REGSALARY = getREGSALARY(HOURS, RATE);
				OTSALARY = getOTSALARY(HOURS, OVERTIME, OTRATE);
				FULLSALARY = getFULLSALARY(REGSALARY, OTSALARY);
				fullDISPLAY (SSN, HOURS, RATE, OVERTIME, OTRATE, FULLSALARY);
			}
			else
			{
				if(MENU == 0 || MENU > 4)
				{
					JOptionPane.showMessageDialog(null, "Invalid selection. Please try again.");
				}
				
			}
				
		}// END WHILE getMENU

			JOptionPane.showMessageDialog(null, "Goodbye!");
			
	}// END MAIN
	
	//=====================================
	public static int getMENU()
	{
		int MENU = 0;
		String input = " ";
		input = JOptionPane.showInputDialog("Welcome to QUIKPay Salary Calculator!\n\n" + "\nWould you like to: " + "\n[1] Calculate regular pay, ONLY?" + "\n[2] Calculate overtime pay, ONLY?" + "\n[3] Calculate regular pay PLUS overtime pay?" + "\n[4] Exit" + "\n ");
		MENU = Integer.parseInt(input);
		return MENU;
	}// END getMENU()
			
	//=====================================
	public static int getSSN()
	{
		int SSN = 0;
		String input = " ";
		input = JOptionPane.showInputDialog("Please enter your Social Security Number (SSN), without dashes: \n");
		SSN = Integer.parseInt(input);
		return SSN;
	}// END getSSN()
				
	//=====================================
	public static int getHOURS()
	{
		int HOURS = 0;
		String input = " ";
		input = JOptionPane.showInputDialog("Please enter the number of whole hours worked:\n");
		HOURS = Integer.parseInt(input);
		while(HOURS == 0)
		{
			JOptionPane.showMessageDialog(null, "Hours worked must be greater than zero. Please try again.");
			HOURS = getHOURS();
		}
		return HOURS;
		
	}// END getHOURS()
		
	//=====================================
	public static double getRATE()
	{
		double RATE = 0.00;
		String input = " ";
		input = JOptionPane.showInputDialog("Please enter the hourly rate of pay, in U.S. Dollars: $\n");
		RATE = Double.parseDouble(input);
		while(RATE == 0.00) 
		{
			JOptionPane.showMessageDialog(null, "Hourly rate must be greater than zero. Please try again.");
			RATE = getRATE();
		}
		return RATE;
		
	}// END getRATE()
		
	//=====================================
	public static int getOVERTIME(int HOURS)
	{
		int OVERTIME = 0;
		OVERTIME = (HOURS - 40);
		return OVERTIME;
	}// END getOVERTIME()
		
	//=====================================
	public static double getOTRATE(double RATE)
	{
		double OTRATE = 0;
		OTRATE = (RATE * 1.5);
		return OTRATE;
	}// END getOTRATE()
			
	//=====================================
	public static double getREGSALARY(int HOURS, double RATE)
	{
		double REGSALARY = 0.00;
		if(HOURS > 40)
		{
			REGSALARY = (40 * RATE);
		}else
		{
			REGSALARY = (HOURS * RATE);
		}
		return REGSALARY;
	}// END getREGSALARY()
	
	//=====================================
	public static double getOTSALARY(int HOURS, int OVERTIME, double OTRATE)
	{
		double OTSALARY = 0.00;
		if(HOURS <= 40)
		{
			OTSALARY = (0 * OTRATE);
		}else
		{
			OTSALARY = (OVERTIME * OTRATE);
		}
		return OTSALARY;
	}// END getOTSALARY()
		
	//=====================================
	public static double getFULLSALARY(double REGSALARY, double OTSALARY)
	{
		double FULLSALARY = 0.00;
		FULLSALARY = (REGSALARY + OTSALARY);
		return FULLSALARY;
	}// END getFULLSALARY()
			
	//=======================================
	public static void regDISPLAY(int SSN, int HOURS, double RATE, double REGSALARY)
	{
		JOptionPane.showMessageDialog(null, "EMPLOYEE IDENTIFICATION NUMBER: " + SSN + "\n\n\n" + "You worked " + HOURS + " hours." + String.format("\nYour regular hourly rate is: $%.2f.", RATE) + String.format("\n\nYour gross weekly regular salary," + "\nminus overtime, is: $%.2f.", REGSALARY));
	}
	
	//=======================================
	public static void otDISPLAY(int SSN, int OVERTIME, double OTRATE, double OTSALARY)
	{
		JOptionPane.showMessageDialog(null, "EMPLOYEE IDENTIFICATION NUMBER: " + SSN + "\n\n\n" + "You worked " + OVERTIME + " overtime hours." + String.format("\nYour overtime hourly rate is: $%.2f.", OTRATE) + String.format("\n\nYour gross weekly overtime salary, is: $%.2f.", OTSALARY));
	}
		
	//=======================================
	public static void fullDISPLAY(int SSN, int HOURS, double RATE, int OVERTIME, double OTRATE, double FULLSALARY)
	{
		JOptionPane.showMessageDialog(null, "EMPLOYEE IDENTIFICATION NUMBER: " + SSN + "\n\n\n" + "You worked " + HOURS + " hours." + String.format("\nYour hourly rate is: $%.2f.", RATE) + "\nYou worked " + OVERTIME + " overtime hours." + String.format("\nYour overtime hourly rate is: $%.2f.", OTRATE) + String.format("\n\nYour gross weekly salary, is: $%.2f.", FULLSALARY));
	}
		
	//=======================================
	
}// END CLASS HW5_Iannucci

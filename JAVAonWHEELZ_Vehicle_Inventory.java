/*
 * @author:       Dominic Iannucci
 * @date:         12/12/2018
 * @description:  This program uses a modular design to manage a fleet of trucks, and 
 * 				  identify those trucks with a total mileage greater than 500,000 miles
 * 				  so that they may be sent to auction. The splash menu allows the user to
 * 				  begin the program or exit early. The main menu prompts the user to [1]
 * 				  Add a truck, [2] Search for a truck, [3] Display all trucks, or [4] Exit.
 * 
 * 				  Option [1] prompts the user to enter the truck model, then calls a method to
 * 				  to randomly generate the mileage between 0 - 1,000,000 miles. The program
 * 				  then evaluates the randomly generated mileage, and if over 500,000 sets the
 * 				  truck's status to 'True,' meaning that the vehicle is available for auction.
 * 
 * 				  Option [2] prompts the user to enter a truck model, and then searches all
 * 				  data stored in the arrays for the requested record. If the record is found,
 * 			  	  and the mileage for the truck is greater than 500,000 miles, the program 
 * 				  will display a "Truck to be auctioned." message. Otherwise, it will display a 
 *     			  "Truck not available for auctioning." message.
 *     
 *     			  Option [3] displays information for all trucks whose records are stored within
 *     			  the array, and also displays whether or not each vehicle is available for
 *     			  auction.
 *     
 *     			  Option [4] displays the information for the total trucks in inventory, the truck
 *     			  with the highest mileage, the truck with the lowest mileage, and the number of 
 *     			  trucks available for auction, before finally exiting the program.
 * 				  
 */

import javax.swing.JOptionPane;

public class JAVAonWHEELZ_Vehicle_Inventory
{

	public static void main(String[] args) 
	{
		// DECLARATIONS:
		int SELECTION = 0;
		int nextCOUNT = 0;
		int recordFOUND = -1;
		String truckQUERY = " ";
				
		// TRUCK:
		String[] MAKE = new String [100];
		int[] MILEAGE = new int [100];
		Boolean[] STATUS = new Boolean [100];
		
		// CURRENT INVENTORY:
		String[] currentMAKE = {"Volvo", "Peterbilt", "Mack", "Kenworth", "Scania"};
		int[] currentMILEAGE = {570000, 34000, 85000, 547000, 623000};
		Boolean[] currentSTATUS = {true, false, false, true, true};
		for(int i = 0; i < 5; i++)
		{
			MAKE[i] = currentMAKE[i];
			MILEAGE[i] = currentMILEAGE[i];
			STATUS[i] = currentSTATUS[i];
			nextCOUNT++;
		}
		
		// PROCESS:
		if (JOptionPane.showConfirmDialog(null, "Would you like to start the JavaonWheelz program?", "JAVAonWHEELZ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
		{
		    // YES Option
			while(SELECTION != 4)
			{	
				SELECTION = MENU();
				switch(SELECTION)
				{
					case 1: if (nextCOUNT < 100 && nextCOUNT >= 0)
							{
							addTRUCK(MAKE, MILEAGE, STATUS, nextCOUNT);
							nextCOUNT++;
							}
							break;
						
					case 2: truckQUERY = getTRUCK();
							recordFOUND = searchTRUCK(truckQUERY, MAKE);
							if(recordFOUND < 0)
								JOptionPane.showMessageDialog(null, truckQUERY + " was not located in the database.");
							else
								dispSINGLE(MAKE[recordFOUND], MILEAGE[recordFOUND], STATUS[recordFOUND]);
							break;
					
					case 3: dispTRUCK(MAKE, MILEAGE, STATUS, nextCOUNT);
							break;
				}// END SWITCH SELECTION
				
			}// END WHILE
			
		}// END IF
		//else 
		//{
		    // NO option
			//JOptionPane.showMessageDialog(null, "Thank you for using, JAVAonWHEELZ! Goodbye.");
			
		//}// END ELSE
		
		quitDISPLAY(MAKE, MILEAGE, STATUS, nextCOUNT);
		JOptionPane.showMessageDialog(null, "Thank you for using, JAVAonWHEELZ! Goodbye.");

	}// END MAIN
	//==========================================================================================
	public static int MENU()
	{
		String input = "";
		int SELECTION = 0;
		while(SELECTION < 1 || SELECTION > 5)
		{
			input = JOptionPane.showInputDialog(null, "MAIN MENU:\n\n" + "[1] Add a truck\n" + "[2] Search for a truck\n" + "[3] Display all trucks\n" + "[4] Exit\n\n" + "Enter a selection [1 - 4]: ");
			SELECTION = Integer.parseInt(input);
			if(SELECTION < 1 || SELECTION > 5)
				JOptionPane.showMessageDialog(null,  "Invalid selection. Please enter a valid selection [1 - 4].");
		}// END WHILE
		return SELECTION;
	}// END MENU()
	
	//==========================================================================================
	public static void addTRUCK(String[] MAKE, int[] MILEAGE, Boolean[] STATUS, int nextCOUNT)
	{
		String input = JOptionPane.showInputDialog(null, "Enter make of truck to add: ");
		MAKE[nextCOUNT] = input;
		MILEAGE[nextCOUNT] = getMILEAGE();
		STATUS[nextCOUNT] = getSTATUS(MILEAGE[nextCOUNT]);
		
	}// END addTRUCK()
	
	//==========================================================================================
	public static int getMILEAGE()
	{
		return (int)(Math.random() * 1000000 +1);
	}// END getMILEAGE()

	//==========================================================================================	
	public static Boolean getSTATUS(int randomMILEAGE)
	{
		return randomMILEAGE > 500000;
		
	}// END getSTATUS()
	
	//==========================================================================================
	public static String finalSTATUS(Boolean status)
	{
		if(status)
		{
			return "Truck to be Auctioned";
		}// END IF
		else
		{
			return "Not to be Auctioned";
		}// END ELSE
		
	}// END finalSTATUS()
	
	//==========================================================================================
	public static String getTRUCK()
	{
		String input = "";
		input = JOptionPane.showInputDialog(null, "SEARCH FOR A TRUCK:\n\n" + "Enter truck model to search for: ");
		return input;	
	}// END getTRUCK()
	
	//==========================================================================================
	public static int searchTRUCK(String truckQUERY, String[] MAKE)
	{
		for(int i = 0; i < MAKE.length; i++)
		{
			if(truckQUERY.equalsIgnoreCase(MAKE[i]))
				return i;
		}// END FOR
		return -1;
	}// END searchTRUCK()
	
	//==========================================================================================
	public static void dispSINGLE(String MAKE, int MILEAGE, Boolean STATUS)
	{
		JOptionPane.showMessageDialog(null, "MAKE: " + MAKE + "\nMILEAGE: " + MILEAGE + "\n" + finalSTATUS(STATUS));
	}// END dispSINGLE()
	
	//===========================================================================================
	public static void dispTRUCK(String[] MAKE, int[] MILEAGE, Boolean[] STATUS, int nextCOUNT)
	{
		String records = "TOTAL VEHICLE INVENTORY: \n\n" + "MAKE: \t       \t" + "MILEAGE: \t       \t" + "STATUS: \n\n";
		for (int i = 0; i < nextCOUNT ; i++)
		{
			records = records + MAKE[i] + " \t       \t" + MILEAGE[i] + " \t       \t" + finalSTATUS(STATUS[i]) + "\n";
		}
		JOptionPane.showMessageDialog(null, records);
	}// END dispTRUCK()
	
	//==========================================================================================
	public static void quitDISPLAY(String[] MAKE, int[] MILEAGE, Boolean[] STATUS, int nextCOUNT)	
	{
		int minMILEAGE = 1000001;
		int minINDEX = -1;
		int maxMILEAGE = -1;
		int maxINDEX = -1;
		int auctionCOUNT = 0;
		for (int i = 0; i < nextCOUNT; i++)
		{
			if(MILEAGE[i] > maxMILEAGE)
			{
				maxMILEAGE = MILEAGE[i];
				maxINDEX = i;
			}
			if(MILEAGE[i] < minMILEAGE)
			{
				minMILEAGE = MILEAGE[i];
				minINDEX = i;
			}
			if(STATUS[i])
				auctionCOUNT++;
		}// END FOR
		if(nextCOUNT > 0)
		{
			JOptionPane.showMessageDialog(null, "ACTIVITY SUMMARY: \n\n" + "Total Number of Trucks: " + nextCOUNT + "\n" +
																	   "Truck with Max Mileage: " + MAKE[maxINDEX] + "     Mileage: " + MILEAGE[maxINDEX] + "\n" +
																	   "Truck with Min Mileage: " + MAKE[minINDEX] + "     Mileage: " + MILEAGE[minINDEX] + "\n" + 
																	   "Number of Trucks to be Auctioned: " + auctionCOUNT + "\n");
		}// END IF
		else
		{
			JOptionPane.showMessageDialog(null, "ACTIVITY SUMMARY: \n\n" + "Total Number of Trucks: " + nextCOUNT);
		}
	}// END quitDISPLAY()
	
}// END CLASS JAVAonWHEELZ_Vehicle_Inventory

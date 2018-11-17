/**
  * NAME:
  * DATE:
  * FILE:
  * COMMENTS:
  */

public class Assignment 3 - Temperature Converter extends eecs.Gui
{
   public static void main(String[] args)
   {
      // declare variables
      String raptor_prompt_variable_zzyz = null;
      ?? temp_C = ??;
      ?? Choice2 = ??;
      ?? temp_F = ??;
      ?? Choice1 = ??;
      
      while	(1)
      {
         printLine("Welcome to Hot Java Temperature Converter! Please make your selection: ");
         raptor_prompt_variable_zzyz = "[1] Celsiuis to Farenheit, [2] Farenheit to Celsius";
         Choice1 = get???(raptor_prompt_variable_zzyz);
         if (Choice1 == 1)
         {
            raptor_prompt_variable_zzyz = "Enter temperature to convert: ";
            temp_C = get???(raptor_prompt_variable_zzyz);
            printLine("You entered: " + temp_C + " C");
            print("Which is equal to: ");
            print((temp_C * 9 / 5) + 32);
            printLine(" F");
         }
         else
         {
            raptor_prompt_variable_zzyz = "Enter temperature to convert: ";
            temp_F = get???(raptor_prompt_variable_zzyz);
            printLine("You entered: " + temp_F + " F");
            print("Which is equal to: ");
            print((temp_F - 32) * 5 / 9);
            printLine(" C");
         }
         raptor_prompt_variable_zzyz = "[1] Convert another temperature, [2] Quit";
         Choice2 = get???(raptor_prompt_variable_zzyz);
         if (Choice2 == 2)	break;
      }
      printLine("Good bye.");
   } // close main
} // close Assignment 3 - Temperature Converter

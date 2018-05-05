import java.io.*;
import java.util.*;
public class nestEgg {
   public static void main(String args[]) throws IOException {
      Scanner kbReader = new Scanner(System.in);
      Scanner fileReader = new Scanner(new File("growthRate.txt"));
      double salary = 0, save = 0, growth = 0, inflation, fund = 0; //Declaring all variables
      int years = 0, maxIndex = -1;
      String[] varGrowth = new String[60];
      if (args.length != 4) { //Checking there are 4 arguments
         System.out.println("Proper usage: java nestEgg <salary> <save%> <growth%> <yearsToRetirement>");
         System.exit(0);
      }
      try { //Making sure all arguments are numbers
         salary = Double.parseDouble(args[0]);
         save = Double.parseDouble(args[1]);
         growth = Double.parseDouble(args[2]);
         years = Integer.parseInt(args[3]);
      }
      catch (Exception e) {
         System.out.println("All command line arguments must be numbers");
         System.exit(0);
      }
      while (fileReader.hasNext()) {
         maxIndex++;
         varGrowth[maxIndex] = fileReader.nextLine();
      }
      if (salary <= 0 || save <= 0 || growth <= 0 || years <= 0) { //Checking that all numbers are > 0
         System.out.println("All inputs must be larger than 0");
         System.exit(0);
      }
      if (save >= 100 || growth >= 100) { //Checking that save and growth are < 100
         System.out.println("Save and growth cannot be >= 100");
         System.exit(0);
      }
      try { //Determining whether inflation should be used
         System.out.print("Do you want your salary to grow with inflation? (Y/N) ");
         char choice = kbReader.next(".").charAt(0);
         if (choice == 'Y' || choice == 'y') {
            inflation = 0.022;
            System.out.println("   Your salary will grow with inflation.");
         }
         else {
            inflation = 0;
            System.out.println("   Your salary will not grow with inflation.");
         }
      }
      catch (Exception e) {
         inflation = 0;
         System.out.println("   Your salary will not grow with inflation.");
         kbReader.next();
      }
      for (int i = 1; i <= years; i++) { //Iterative loop that runs for number of years until retirement
         fund = fund * (1 + 0.01 * growth) + salary *save * 0.01; //Calculation for determining retirement fund
         salary = salary * (1 + inflation); //Calculation for determining salary with inflation
      }
      System.out.printf("By the end of %d years, your retirement fund will be $%.2f.\n", years, fund);
   }
}

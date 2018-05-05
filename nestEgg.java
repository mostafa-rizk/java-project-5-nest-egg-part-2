import java.io.*;
import java.util.*;
public class nestEgg {
   public static void main(String args[]) throws IOException {
      Scanner kbReader = new Scanner(System.in);
      Scanner fileReader = new Scanner(new File("growthRate.txt"));
      double salary = 0, save = 0, inflation, expenses = 0, fund = 0; //Declaring all variables
      int yearsA = 0, yearsB = 0, maxIndex = 0;
      double[] varGrowth = new double[61];
      varGrowth[0] = 0;
      if (args.length < 4) { //Checking there are minumum 4 arguments
         System.out.println("Proper usage: java nestEgg <salary> <save%> <yearsToRetirement> " +
         "<yearsOfRetirement> <expenses>");
         System.exit(0);
      }
      try { //Making sure all arguments are numbers
         salary = Double.parseDouble(args[0]);
         save = Double.parseDouble(args[1]);
         yearsA = Integer.parseInt(args[2]);
         yearsB = Integer.parseInt(args[3]);
         if (args.length > 4) {
            expenses = Double.parseDouble(args[4]);
         }
      }
      catch (Exception e) {
         System.out.println("All command line arguments must be numbers");
         System.exit(0);
      }
      if (salary <= 0 || save <= 0 || yearsA <= 0 || yearsB <= 0) { //Checking that inputs are larger than 0
         System.out.println("All inputs must be larger than 0");
         System.exit(0);
      }
      if (save >= 100) { //Checking that save and growth are < 100
         System.out.println("Save cannot be >= 100");
         System.exit(0);
      }
      while (fileReader.hasNext()) { //Copying each growth rate into array
         maxIndex++;
         fileReader.next();
         varGrowth[maxIndex] = Double.parseDouble(fileReader.next());
      }
      fileReader.close();
      if (yearsA > varGrowth.length) { //Checking that program runs for length <= number of growth rates
         System.out.println("Years until retirement cannot be higher than 61");
         System.exit(0);
      }
      try { //Determining whether inflation should be used
         System.out.print("Do you want your salary to grow with inflation? (Y/N) ");
         char choice = kbReader.next(".").charAt(0);
         if (choice == 'Y' || choice == 'y') {
            inflation = 0.022;
            System.out.println("Your salary will grow with inflation.");
         }
         else {
            inflation = 0;
            System.out.println("Your salary will not grow with inflation.");
         }
      }
      catch (Exception e) {
         inflation = 0;
         System.out.println("Your salary will not grow with inflation.");
         kbReader.next();
      }
      for (int i = 1; i <= yearsA; i++) { //Iterative loop that runs for number of years until retirement
         fund = fund * (1 + 0.01 * varGrowth[i-1]) + salary *save * 0.01; //Calculation for determining retirement fund
         salary = salary * (1 + inflation); //Calculation for determining salary with inflation
         if (i < 2) {
            System.out.printf("Year %d: $%,.2f\n", i, fund);
            continue ;
         }
         System.out.printf("Year %d: $%,.2f , %f\n", i, fund, varGrowth[i-1] - varGrowth[i-2]);
      }
      if (expenses == 0) {
         double low = salary / 100, high = fund, withinRange = 100, testFund = fund;
         expenses = (low + high) / 2;
         while (Math.abs(testFund) > withinRange) {
            testFund = fund;
            for (int i = 1; i <= yearsB; i++) {
               testFund = testFund * (1 + 0.01 * varGrowth[i-1]) - expenses;
               //System.out.printf("Year %d: $%,.2f\n", i, testFund);
            }
            if (testFund > withinRange) {
               low = expenses;
            }
            else {
               high = expenses;
            }
            expenses = (low + high) / 2;
         }
      }
      for (int i = 1; i <= yearsB; i++) { //Deducting expenses after calculating new fund size each year
         fund = fund * (1 + 0.01 * varGrowth[i-1]) - expenses;
         System.out.printf("Year %d: $%,.2f\n", i, fund);
      }
   }
}

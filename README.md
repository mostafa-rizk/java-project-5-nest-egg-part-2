# java-project-4-retirement
In this assignment you will expand on your java-project-2-nest-egg code. Start by adding your code from the nest egg assignment to this repository.

## Part 1: Command line arguments
Modify your code to take the following command line arguments:
* Yearly salary during the first year
* Percentage of the salary that should be put into a retirement fund
* Number of remaining years to retirement
* Growth rate 

If the user do not provide any command line arguments, or if the arguments are incorrect, the program should display usage information.

## Part 2: Variable growth rate
Modify program to use the annual investment growth rate data in the provided `growthRate.txt` file. Note that the number of years in the data file defines the maxium number of years for which projectionsc can be made. If the user tries to make projections for more than this maxium, the program must detect this and gracefully manage this scenario. 

The program should print out, the size of the retirement account at the end of each year and the annual growth indicating by how much the value changed from previous year (the annual growth has to be preceeded by either + to indicate an increase in the value or a - to indicate a decrease in the value).

`<Year> <Value of investment> <Annual growth>`

## Part 3:  
Of course, once you retire you will want to be able to withdraw some amount of money each year for living expenses. You can use your previous code to get the size of your retirement fund when you stop working. Now we want to model how much you can withdraw to spend each year after retirement.

Suppose that, after retirement, your retirement fund continues to grow according to a list of annual growth percentages on investments, while your annual expenses are constant (which, ofcourse is unrealistics as inflation is not zero), called expenses. To see how your retirement fund will change after retirement, we can use the following chart, where we let 'F'
represent the size of the retirement fund at the time of retirement, and we let 'expenses' represent the amount of money we withdraw in the first year to cover our living costs:



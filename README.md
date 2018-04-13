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

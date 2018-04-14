# java-project-4-retirement
In this assignment you will expand on your java-project-2-nest-egg code. Start by adding your code from the nest egg assignment to this repository.

## Part 1: Command line arguments
Create a branch called `commandLineArgs` and do Part 1 in this branch. Once the code modifications are completed merge the branch with the `master`.

The command line argument is the argument passed to a program at the time when you run it. To access the command-line argument inside a java program is quite easy, they are stored as string in String array passed to the args parameter of `main()` method.

Modify your code to take the following command line arguments:
* Yearly salary during the first year (`salary`)
* Percentage of the salary that should be put into a retirement fund (`save`)
* Number of remaining years to retirement (`nretirement`)
* Growth rate (`growthRate`)

If the user does not provide any command line arguments, or if the arguments are incorrect, the program should display usage information. Run git or java without any command line arguments to get an idea of how the usage infroamtion shoud look.

## Part 2: Variable growth rate
Create a branch called `varGrowthRates` and do Part 2 in this branch. Once the code modifications are completed merge the branch with the `master`.

Modify program to use the annual investment growth rate data in the provided `growthRate.txt` file. Note that the number of years in the data file defines the maxium number of years for which projections can be made. If the user tries to make projections for more than this maxium the program should detect this and gracefully exit with an appropriate message to the user.

The program should print out, the size of the retirement account at the end of each year and the annual growth indicating by how much the value changed from previous year (the annual growth has to be preceeded by either + to indicate an increase in the value or a - to indicate a decrease in the value).

`<Year> <Value of investment> <Annual growth>`

## Part 3: Retirement Expenses 
Create a branch called `expenses` and do Part 3 in this branch. Once the code modifications are completed merge the branch with the `master`.

Of course, once you retire you will want to be able to withdraw some amount of money each year for living expenses. You can use your previous code to get the size of your retirement fund when you stop working. Now we want to model how much you can withdraw to spend each year after retirement.

Suppose that, after retirement, your retirement fund continues to grow according to the provided annual growth rates while your annual expenses are constant (which, ofcourse is unrealistics as inflation is not zero). To see how your retirement fund will change after retirement, we can use the following chart, where we let 'F' represent the size of the retirement fund at the time of retirement, and we let `expenses` represent the amount of money withdrawn in the first year:

|       | Retirement Fund
| ----- | -----
| End of Year 1: | `F[0] = savings * (1 + 0.01 * growthRates[0]) – expenses`
| End of Year 2: | `F[1] = F[0] * (1 + 0.01 * growthRates[1]) – expenses`
| End of Year 3: | `F[2] = F[1] * (1 + 0.01 * growthRates[2]) – expenses`

Assume that the increase in the investment account savings is calculated before subtracting the annual expenditures (as shown in the above table). Your function should return a list of fund sizes after each year of retirement, accounting for annual expenses and the growth of the retirement fund. 

When the program runs it should first calculate the growth of the investment for the remaining working years (the same way as before) and once it reaches the end of the working years it should switch to the retirement calculations. Add the expenses and the number of years of retirement as command line arguments to your code. Don't forget to update the usage instructions.

Note that if the retirement fund balance becomes negative, expenditures should continue to be subtracted, and the growth rate comes to represent the interest rate on the debt (i.e. the formulas in the above table still apply).

## Part 4: Retirement Budget
Create a branch called `budget` and do Part 4 in this branch. Once the code modifications are completed merge the branch with the `master`.

Suppose you would like to budget your annual retirement expenses such that by the time you pass on, you will have no retirement funds left (leaving no money for your children). One way to determine what your expense budget should be is to
try different values for the annual expenses and determine how many years you will be able to be retired before your money runs out. There are several possible strategies one can use for picking different expenses to test, for example:
* You can start with a low number and progressivelly increase it until your savings = 0 at the end of your retirement.
* You can start with a high number and progressivelly decrease ...
* or you can try [binary search](https://en.wikipedia.org/wiki/Binary_search_algorithm).

Modify the code so that if the user leaves out the `expense` command line argument the program automatically calculates the maxium amout of expenses for a given length of retirement.

## Part 5: Wrapper Script


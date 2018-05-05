#!/bin/bash

read -p 'How much is your yearly salary? ' salary
read -p 'What percentage are you saving? ' save
read -p 'How many years until retirement? ' yearsToRetirement
read -p 'How many years will retirement last? ' yearsRetirement
read -p 'During retirement, how much will your yearly expenses be? ' expenses

java nestEgg $salary $save $yearsToRetirement $yearsRetirement $expenses

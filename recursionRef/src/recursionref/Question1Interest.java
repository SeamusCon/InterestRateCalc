/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionref;

import java.util.Scanner;

public class Question1Interest
{
	/**
	* calculateSavings
	* Recursively compute compound interest.
	* The recursive definition is:
	*     savings(d,i,y) = savings((d*i)+d,i,y-1)
	*  where d = initial deposit, i = interest rate, y = number of years
	* @param initial_deposit Initial amount of deposit
	* @param yearly_interest_rate Interest rate, value between 0-1
	* @param num_years integer that is number of years
	* @return double Savings accrued at the interest rate after the number of years
	*/
	public static double calculateSavings(double initial_deposit, double yearly_interest_rate,
				int num_years)
	{
	  // Base case -- if num_years = 0, then we just get the amount of
	  // the initial deposit
	  if (num_years == 0) return initial_deposit;

	  // If num_years > 0, then for the first year we make
	  // (interest_rate * initial) + initial.    Feed this into the
	  // same function, but now for one fewer year since we have accounted
	  // for the value after this year.

	  return calculateSavings(
		(initial_deposit * yearly_interest_rate) + initial_deposit,
		yearly_interest_rate,
		num_years - 1);
	}
public static void main(String[] args)
	{
	  // Input variables
	  double initial_amount;
	  double interest_rate;
	  int num_years;
	  double future_value;
	  Scanner scan = new Scanner(System.in);

	  System.out.println("Enter initial amount to save:");
	  initial_amount  = scan.nextDouble();
	  System.out.println("Enter yearly interest rate (e.g. 0.10 for 10%)");
	  interest_rate = scan.nextDouble();
	  System.out.println("Enter number of years of compounded interest. ");
	  num_years = scan.nextInt();

	  future_value = calculateSavings(initial_amount, interest_rate, num_years);

	  System.out.println("$" + initial_amount + " after " + num_years + " years, at " +
		  interest_rate + " would amount to $" + future_value);
	}
}
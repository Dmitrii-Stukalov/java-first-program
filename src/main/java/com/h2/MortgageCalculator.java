package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
	private long loanAmount;
	private int termInYears;
	private float annualRate;
	private double monthlyPayment;

	public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
		this.loanAmount = loanAmount;
		this.termInYears = termInYears;
		this.annualRate = annualRate;
	}

	private int getNumberOfPayments() {
		return 12 * termInYears;
	}

	private float getMonthlyInterestRate() {
		return annualRate / 100 / 12;
	}

	public void calculateMonthlyPayment() {
		this.monthlyPayment = loanAmount * (((getMonthlyInterestRate() * Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments()))) / ((Math.pow((1 + getMonthlyInterestRate()), getNumberOfPayments())) - 1));
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return "monthlyPayment: " + df.format(monthlyPayment);
	}

	public static void main(String[] args) {
		long loanAmount = Utilities.getLongValue(args[0]);
		int termInYears = Utilities.getIntValue(args[1]);
		float annualRate = Utilities.getFloatValue(args[2]);
		MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
		calculator.calculateMonthlyPayment();
		System.out.println(calculator);
	}
}

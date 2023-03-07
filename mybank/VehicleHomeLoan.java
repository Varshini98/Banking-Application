package mybank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

class IllegalAgeException extends Exception implements Serializable {
	public IllegalAgeException(String msg) {
		super(msg);
	}
}

public class VehicleHomeLoan {
	private LoanType loanType;
	private double loan_amount;
	private Frequency compound_frequency;
	private int years;
	private float interest;
	private LocalDate currDate;
	private int age;

	String currencyCode = "INR";
	Currency currency = Currency.getInstance(currencyCode);

	VehicleHomeLoan(LoanType loanType, double loan_amount, float interest, LocalDate currDate,
			Frequency compound_frequency, int years, int age) throws IllegalAgeException {
		if (21 >= age || age >= 60) {
			throw new IllegalAgeException("Your Loan Is Denied. Age between 21-60 can only avil loan.");
		}
		this.loanType = loanType;
		this.loan_amount = loan_amount;
		this.compound_frequency = compound_frequency;
		this.years = years;
		this.interest = interest;
		this.currDate = currDate;
		this.age = age;

	}

	@Override
	public String toString() {
		return "VehicleHomeLoan [loanType=" + loanType + ", loan_amount=" + currency.getSymbol() + loan_amount
				+ ", compound_frequency=" + compound_frequency + ", years=" + years + ", interest=" + interest
				+ ", currDate=" + currDate + ", age=" + age + "]";
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public double getLoan_amount() {
		return loan_amount;
	}

	public Frequency getCompound_frequency() {
		return compound_frequency;
	}

	public int getNumbercompoundfrequency() {
		int number_freq;
		number_freq = compound_frequency.getfrequency();
		return number_freq;
	}

	public int getYears() {
		return years;
	}

	public float getInterest() {
		return interest;
	}

	public LocalDate getCurrDate() {
		return currDate;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public void setCompound_frequency(Frequency compound_frequency) {
		this.compound_frequency = compound_frequency;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public void setCurrDate(LocalDate currDate) {
		this.currDate = currDate;
	}

	public LocalDate loanLastDate() {
		return getCurrDate().plusYears(getYears());
	}

	public LocalDate loanDueDate() {
	
		if (getNumbercompoundfrequency() == 1) {
			return getCurrDate().plusYears(1);
		} else if (getNumbercompoundfrequency() == 2) {
			return getCurrDate().plusMonths(6);
		} else if (getNumbercompoundfrequency() == 6) {
			return getCurrDate().plusMonths(4);
		} else if (getNumbercompoundfrequency() == 12) {
			return getCurrDate().plusMonths(1);
		}
		return currDate;
	}
	
	public LocalDate loanDueDateNext() {
		
		if (getNumbercompoundfrequency() == 1) {
			return getCurrDate().plusYears(2);
		} else if (getNumbercompoundfrequency() == 2) {
			return getCurrDate().plusMonths(12);
		} else if (getNumbercompoundfrequency() == 6) {
			return getCurrDate().plusMonths(8);
		} else if (getNumbercompoundfrequency() == 12) {
			return getCurrDate().plusMonths(2);
		}
		return currDate;
	}
	
	
	public int countPayment() {
		int totalpayment;
		totalpayment = getNumbercompoundfrequency()*getYears();
		return totalpayment;
	}

	public void displayVLoan() {
		System.out.println("\n " + "Loan Type: " + getLoanType() + "\n " + "Loan Amount: " + currency.getSymbol()
				+ getLoan_amount() + "\n " + "Loan Intrest: " + getInterest() + "%" + "\n " + "Compound Frequency: "
				+ getCompound_frequency() + " [" + getNumbercompoundfrequency() + "]" + "\n " + "Year: " + getYears()
				+ "\n " + "Closing Date: " + loanLastDate());
	}
}

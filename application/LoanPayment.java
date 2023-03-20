package application;

import java.time.LocalDate;
import java.util.Currency;

public class LoanPayment {
	
	private double payedAmountTillDate=0;
	private LocalDate payDate;
	private LocalDate dueDate;
	private double payedAmount;
	
	String currencyCode = "INR";
	Currency currency = Currency.getInstance(currencyCode);
	
	public LoanPayment(LocalDate payDate, LocalDate dueDate, double payedAmount) {
		this.payDate = payDate;
		this.dueDate = dueDate;
		this.payedAmount = payedAmount;
		
		payedAmountTillDate = payedAmount + getPayedAmountTillDate();
	}
	
	public double getPayedAmountTillDate() {
		return payedAmountTillDate;
	}

	public LocalDate getPayDate() {
		return payDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public double getPayedAmount() {
		return payedAmount;
	}

	public void displayLoanPaymentDetails() {
        //currency.getSymbol()+getBalance()
		System.out.printf("%15s %15s %15s %20s", getPayDate(), getDueDate(), currency.getSymbol() + getPayedAmount(),
				getPayedAmountTillDate());
		System.out.println();
    }

	@Override
	public String toString() {
		return "LoanPayment [payedAmountTillDate=" + payedAmountTillDate + ", payDate=" + payDate + ", dueDate="
				+ dueDate + ", payedAmount=" + payedAmount + ", currencyCode=" + currencyCode + ", currency=" + currency
				+ "]";
	}
	
}

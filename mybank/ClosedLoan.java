package mybank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;

public class ClosedLoan {
	
	private LocalDateTime closingDateTime;
	private String accountno;
	private LoanType loanType;
	private long custID;
	private double loanAmount;
	
	String currencyCode = "INR";
	Currency currency = Currency.getInstance(currencyCode);
	
	ClosedLoan(long custID, String accountno, LoanType loanType, double loanAmount, LocalDateTime closingDateTime) {
		
		this.closingDateTime = closingDateTime;
		this.accountno = accountno;
		this.loanType = loanType;
		this.custID = custID;
		this.loanAmount =loanAmount;
	}

	@Override
	public String toString() {
		return "ClosedLoan [closingDateTime=" + closingDateTime + ", accountno=" + accountno + ", loanType=" + loanType
				+ ", custID=" + custID + ", loanAmount=" + loanAmount + "]";
	}

	public LocalDateTime getClosingDateTime() {
		return closingDateTime;
	}

	public String getAccountno() {
		return accountno;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public long getCustID() {
		return custID;
	}

	public double getLoanAmount() {
		return loanAmount;
	}
	
	public String getFormattedDatetime() {
		LocalDateTime myDateObj = getClosingDateTime();
		//System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		// System.out.println("After formatting: " + formattedDate);
		return formattedDate;
	}
	
	public void displayClosedLoanDetails() {
		System.out.printf("%11s %16s %15s %15s %25s", getCustID(), getAccountno(),getLoanType(), currency.getSymbol() +getLoanAmount(),getFormattedDatetime());  
		System.out.println(); 
	}


}

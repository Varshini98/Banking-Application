package mybank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClosedAccount {
	
	private LocalDateTime closingDateTime;
	private String accountno;
	private AccountType accountType;
	private long custID;
	
	ClosedAccount(long custID, String accountno, AccountType accountType, LocalDateTime closingDateTime) {
		
		this.closingDateTime = closingDateTime;
		this.accountno = accountno;
		this.accountType = accountType;
		this.custID = custID;
	}
	
	public LocalDateTime getClosingDateTime() {
		return closingDateTime;
	}

	public String getAccountno() {
		return accountno;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public long getCustID() {
		return custID;
	}

	public String getFormattedDatetime() {
		LocalDateTime myDateObj = getClosingDateTime();
		//System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		// System.out.println("After formatting: " + formattedDate);
		return formattedDate;
	}
	
	public void displayClosedAccountDetails() {
		//System.out.printf("\n%11s %16s %15s %19s", "CUSTOMER ID", "ACCOUNT NUMBER","ACCOUNT TYPE", "DATE & TIME");
		System.out.printf("%11s %16s %15s %25s", getCustID(), getAccountno(),getAccountType(),getFormattedDatetime());  
		System.out.println(); 
	}


	@Override
	public String toString() {
		return "ClosedAccount [closingDateTime=" + closingDateTime + ", accountno=" + accountno + ", accountType="
				+ accountType + ", custID=" + custID + "]";
	}
}

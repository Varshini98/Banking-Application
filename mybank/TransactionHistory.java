package mybank;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;

public class TransactionHistory {
	
	String currencyCode = "INR";
	Currency currency = Currency.getInstance(currencyCode);

	private LocalDateTime datetime;
	private String description;
	private String action;
	private double amount;
	private double balance;

	TransactionHistory(LocalDateTime datetime, String description, String action, double amount, double balance) {
		this.datetime = datetime;
		this.description = description;
		this.action = action;
		this.amount = amount;
		this.balance = balance;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public String getDescription() {
		return description;
	}

	public double getBalance() {
		return balance;
	}

	public String getAction() {
		return action;
	}

	public double getAmount() {
		return amount;
	}

	public String getFormattedDatetime() {
		LocalDateTime myDateObj = getDatetime();
		//System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		// System.out.println("After formatting: " + formattedDate);
		return formattedDate;
	}

	@Override
	public String toString() {
		return "TransactionHistory [datetime=" + getFormattedDatetime() + ", description=" + description + ", action=" + action
				+ ", amount=" + amount + ", balance=" + balance + "]";
	}

//	public void displayTransactionHistory() {
//		System.out.println(getFormattedDatetime() + "\t" + getDescription() + "\t" + getAction() + "\t" +currency.getSymbol()+ getAmount()
//				+ "\t" +currency.getSymbol()+ getBalance() + "\t");
//	}
	public void displayTransactionHistory() {
		System.out.printf("%19s %20s %10s %15s %15s", getFormattedDatetime(), getDescription(), getAction(), currency.getSymbol()+ getAmount(), currency.getSymbol()+ getBalance());  
		System.out.println(); 
	}


	public int compare(TransactionHistory o) {
		 return getDatetime().compareTo(o.getDatetime());
	}

	//@Override
//	public int compareTo(TransactionHistory o) {
//		// TODO Auto-generated method stub
//		return this.getDatetime() - o.getDatetime();
//	}
//	


}

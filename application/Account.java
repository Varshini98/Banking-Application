package application;

import java.io.Serializable;
import java.time.*;
import java.util.Currency;

class IllegalDepositException extends Exception {
	public IllegalDepositException(String msg) {
		super(msg);
	}
}

class Account implements Serializable{
	public AccountType accounttype;
	private double deposit;
	private double balance;

	LocalDate currDate;

	String currencyCode = "INR";
	Currency currency = Currency.getInstance(currencyCode);

	Account() {
		balance = 0.0;
	}

	Account(AccountType accounttype, double deposit, LocalDate currDate) {
		this.accounttype = accounttype;
		this.deposit = deposit;
		this.currDate = currDate;
	}

	public double getDeposit() {
		return deposit;
	}

	public double getBalance() {
		return balance;
	}

	LocalDate getDateofOpen() {
		return currDate;
	}

	@Override
	public String toString() {
		// return "Account [accounttype=" + accounttype + ", bal=" + balance + ",
		// currDate=" + currDate + "]";
		return "Account [accounttype=" + accounttype + ", bal=" + currency.getSymbol() + balance
				+ ", Account Creation Date=" + currDate + "]";
	}

}

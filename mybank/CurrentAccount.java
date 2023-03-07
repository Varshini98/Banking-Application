package mybank;

import java.io.Serializable;
import java.time.LocalDate;

public class CurrentAccount extends Account implements Serializable {
	 private double bal;

	    public CurrentAccount(AccountType accounttype, double deposit, LocalDate currDate)
	            throws IllegalDepositException {
	        super(accounttype,deposit,currDate);
	        if (deposit < 1000) {
	            throw new IllegalDepositException("Minimum Deposit of Rs.1,000 Required");
	        }
	        bal = deposit + getBalance();
	    }


	    void deposit(double amount) {
	        bal = bal + amount; // adding crediting amount to the savings account balance
	    }

	    void withdraw(double amount) {
	        bal = bal - amount; // subtracting withdrew amount from the savings account balance
	    }

	    public double getBalance() {
	        return bal;
	    }

	    public void displayCurrentAccountDeatils() {
	        System.out.println(
	                "\n " + "Account Type: "+ accounttype + "\n " + "Balance: " + currency.getSymbol() + getBalance() + "\n ");
	    }
	    
	    @Override
		public String toString() {
			//return "Account [accounttype=" + accounttype + ", bal=" + balance + ", currDate=" + currDate + "]";
			return "Account [accounttype=" + accounttype + ", bal=" +currency.getSymbol()+ getBalance() + ", AccountCreationDate=" + currDate + "]";
		}
}

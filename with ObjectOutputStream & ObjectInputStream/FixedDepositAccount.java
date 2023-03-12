package application;

import java.io.Serializable;
import java.time.LocalDate;

public class FixedDepositAccount extends Account implements Serializable{
	
	private Frequency compound_frequency;
    private int years;
    private float interest;
    private LocalDate currDate;
	
	public FixedDepositAccount() {
        super();
    }

    public FixedDepositAccount(AccountType accounttype, double deposit, float interest, LocalDate currDate, Frequency compound_frequency, int years)
            throws IllegalDepositException {
    	super(accounttype,deposit,currDate);
        if (deposit < 10000) {
            throw new IllegalDepositException("Minimum Deposit of Rs.10,000 Required");
        }
        this.compound_frequency = compound_frequency;
        this.years = years;
        this.interest=interest;
        this.currDate=currDate;
    }
    
	public double getInvestment() {
        return getDeposit();
    }
    
    public Frequency getcompoundfrequency() {
        return compound_frequency;
    }

    public int getNumbercompoundfrequency() {
        int number_freq;
        number_freq = compound_frequency.getfrequency();
        return number_freq;
    }

    public int getyears() {
        return years;
    }
    
    public LocalDate getCurrDate() {
		return currDate;	
    }
    
    public LocalDate maturityDate() {
		return getCurrDate().plusYears(getyears());	
    }
    
    
    public void displayFixedDepositDeatils() {
        System.out.println(
                "\n " + "Account Type: "+ accounttype + "\n " + "Investment: "
                        + currency.getSymbol() + getInvestment() + "\n "+ "Year of investment: " + getyears() + "\n " + "Compound Frequency: "
                        + getcompoundfrequency() + " [" + getNumbercompoundfrequency() + "]" +"\n" + " Interest Rate: "+getInterest()+"%"+"\n" 
                        + " Maturity Date: "+getCurrDate().plusYears(getyears()));
    }

	@Override
	public String toString() {
//		return "Account [compound_frequency=" + compound_frequency + ", years=" + years + ", accounttype="
//				+ accounttype + ", currDate=" + currDate
//				+ ", getInvestment()=" +currency.getSymbol()+ getInvestment() + "]";
		
		
		return "Account [Account Type:" + accounttype + ", Deposit:" +currency.getSymbol()+ getInvestment() +  
		 ", Installments:" + compound_frequency + ", years:" + years + ", AccountCreationDate:" + currDate + "Intrest Rate:"+getInterest()+
		"]";
	}

	public float getInterest() {
		return interest;
	}





}

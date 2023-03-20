package application;

import java.io.Serializable;

public class Deposit implements Serializable {
	long custID;
	String accono;
	double ammount;
	
	Deposit(long custID, String accono, double ammount){
		this.custID= custID;
		this.accono= accono;
		this.ammount= ammount;	
	}

	public long getCustID() {
		return custID;
	}

	public String getAccono() {
		return accono;
	}

	public double getAmmount() {
		return ammount;
	}

	@Override
	public String toString() {
		return "Deposit [custID=" + custID + ", accono=" + accono + ", ammount=" + ammount + "]";
	}

}

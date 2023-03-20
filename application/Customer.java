package application;

import java.io.Serializable;
import java.time.*;
import java.util.EnumSet;
import java.util.regex.Pattern;

class IllegalPhoneNumberException extends Exception {
	public IllegalPhoneNumberException(String msg) {
		super(msg);
	}
}

class IllegalEmailIDException extends Exception {
	public IllegalEmailIDException(String msg) {
		super(msg);
	}
}

class IllegalDOBException extends Exception {
	public IllegalDOBException(String msg) {
		super(msg);
	}
}

class IllegalTransferAmountException extends Exception {
	public IllegalTransferAmountException(String msg) {
		super(msg);
	}
}

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmploymentStatus employmentstatus;
	private long CustId;
	private String name;
	private String dob;
	private String address;
	private String email;
	private String phonenumber;

	final String regexPhone = "\\d{10}";
	// for all formats check : ^(?:(?:\+|0{0,2})91(\s*[\
	// -]\s*)?|[0]?)?[789]\d{9}|(\d[ -]?){10}\d$
	// /^[6-9]\d{9};
	final String regexEmail = "[a-zA-Z0-9_.-/#]{3,15}@[a-zA-Z0-9]{3,15}[.][a-zA-Z]{2,5}";
	final String regexDOB = "^((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

	Customer(long CustId, String name, String dob, EmploymentStatus employmentstatus, String email, String phonenumber)
			throws IllegalDOBException, IllegalEmailIDException, IllegalPhoneNumberException {
//        if (phonenumber.length() != 10) {
//            throw new IllegalPhoneNumberException("Invalid Phone Number. Please enter 10 digit phone number.");
//            
//        }
//        if (phonenumber.length() == 10) {
//            for (int i = 0; i < 10; i++) {
//                if (!Character.isDigit(phonenumber.charAt(i))) {
//                    throw new IllegalPhoneNumberException("Invalid Phone Number. Please enter 10 digit phone number.");
//                }
//            }
//        }
		if (!Pattern.matches(regexDOB, dob)) {
			throw new IllegalDOBException("Invalid DOB. Please enter in YYYY-MM-DD format.");
		}
		
		if (!Pattern.matches(regexEmail, email)) {
			throw new IllegalEmailIDException("Invalid EmailId. Please enter valid EmailId.");
		}
		
		if (!Pattern.matches(regexPhone, phonenumber)) {
			throw new IllegalPhoneNumberException("Invalid Phone Number. Please enter 10 digit phone number.");
		}
		

		
//        EnumSet<EmploymentStatus> set = EnumSet.of(EmploymentStatus.Worker, EmploymentStatus.UnEmployed, EmploymentStatus.SelfEmployed, EmploymentStatus.Employee);
//        if(set.contains(employmentstatus)) {
//        	//this.employmentstatus=employmentstatus;
//        } else {
//			throw new IllegalEmploymentStatusException("Invalid Entry ! Please enter correct Value.");
//		}

		this.setCustId(CustId);
		this.name = name;
		this.dob = dob;
		this.employmentstatus = employmentstatus;
		// this.address=address;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	LocalDate getDob() {
		LocalDate dateOfBirth = LocalDate.parse(dob);
		return dateOfBirth;
	}

	int getage() {
		LocalDate dateOfBirth = LocalDate.parse(dob);
		LocalDate currDate = LocalDate.now();
		Period period = Period.between(currDate, dateOfBirth);
		return Math.abs(period.getYears());
	}

	public String getAddress() {
		return address;
	}
	
	public String getDOBasString() {
		return dob;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) throws IllegalPhoneNumberException {
		if (phonenumber.length() != 10) {
			throw new IllegalPhoneNumberException("Invalid Phone Number. Please enter 10 digit phone number.");
		}
		if (phonenumber.length() == 10) {
			for (int i = 0; i < 10; i++) {
				if (!Character.isDigit(phonenumber.charAt(i))) {
					throw new IllegalPhoneNumberException("Invalid Phone Number. Please enter 10 digit phone number.");
				}
			}
		}
		this.phonenumber = phonenumber;
	}

	public void displayCustomerDetails() {
		System.out.println("\n " + "Customer ID:" + getCustId() + "\n " + "Name: " + getName() + "\n " + "Age: "
				+ getage() + "\n " + "Employment Status: " + getEmploymentstatus() + "\n " + "Email: " + getEmail()
				+ "\n " + "Phone No: " + getPhonenumber());
	}

	@Override
	public String toString() {
		return "Customer [ customerid=" + CustId + ", name=" + name + ", dob=" + dob + ", employmentstatus="
				+ employmentstatus + ", email=" + email + ", phonenumber=" + phonenumber + "]";
	}

	public EmploymentStatus getEmploymentstatus() {
		return employmentstatus;
	}

	public void setEmploymentstatus(EmploymentStatus employmentstatus) {
//			throws IllegalEmploymentStatusException {
//		for (EmploymentStatus s : EmploymentStatus.values()) {
//			if (s.)) {
//        }
//		    }
		this.employmentstatus = employmentstatus;
	}

	public long getCustId() {
		return CustId;
	}

	public void setCustId(long custId) {
		CustId = custId;
	}

}

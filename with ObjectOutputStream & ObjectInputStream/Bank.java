package application;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Bank {

	String currencyCode = "INR";
	Currency currency = Currency.getInstance(currencyCode);

	float interest;
	float interest_rate; // divide by 100
	Frequency compound_frequency;
	int years;
	double deposit;
	double maturity_amount, fixed_periodic_payment; // interest earned or the total amount in the end

	HashMap<Long, Customer> customers;
	HashMap<Long, HashMap<AddressType, Address>> customers_address;

	HashMap<String, SavingsAccount> savings;
	HashMap<Long, HashMap<String, SavingsAccount>> accounts_Mainsavings;

	HashMap<String, CurrentAccount> current;
	HashMap<Long, HashMap<String, CurrentAccount>> accounts_Maincurrent;

	HashMap<String, FixedDepositAccount> fixeddeposit;
	HashMap<Long, HashMap<String, FixedDepositAccount>> accounts_Mainfixeddeposit;

	HashMap<String, VehicleHomeLoan> loan;
	HashMap<Long, HashMap<String, VehicleHomeLoan>> loan_Mainloan;

	HashMap<String, TreeMap<LocalDateTime, TransactionHistory>> recorded__transactionhistory;
	
	HashMap<String, TreeMap<LocalDateTime, ClosedAccount>> closed_accounthistory;
	HashMap<String, TreeMap<LocalDateTime, ClosedLoan>> closed_loanhistory;
	
	HashMap<String, TreeMap<LocalDate, LoanPayment>> loan_paymenthistory;
	
	HashMap<Long,String> closed_accountS;
	HashMap<Long,String> closed_accountC;
	


	Scanner scan = new Scanner(System.in);

	Bank() {
		customers = new HashMap<Long, Customer>();

		customers_address = new HashMap<Long, HashMap<AddressType, Address>>();

		savings = new HashMap<String, SavingsAccount>();
		accounts_Mainsavings = new HashMap<Long, HashMap<String, SavingsAccount>>();

		current = new HashMap<String, CurrentAccount>();
		accounts_Maincurrent = new HashMap<Long, HashMap<String, CurrentAccount>>();

		fixeddeposit = new HashMap<String, FixedDepositAccount>();
		accounts_Mainfixeddeposit = new HashMap<Long, HashMap<String, FixedDepositAccount>>();

		loan = new HashMap<String, VehicleHomeLoan>();
		loan_Mainloan = new HashMap<Long, HashMap<String, VehicleHomeLoan>>();

		recorded__transactionhistory = new HashMap<String, TreeMap<LocalDateTime, TransactionHistory>>();

		closed_accounthistory = new HashMap<String, TreeMap<LocalDateTime, ClosedAccount>>();
		closed_loanhistory =  new HashMap<String, TreeMap<LocalDateTime, ClosedLoan>>();
		
		loan_paymenthistory = new HashMap<String, TreeMap<LocalDate, LoanPayment>>();
		
		closed_accountS = new HashMap<Long,String>();
		closed_accountC = new HashMap<Long,String>();
	}

	// Adding Customers to customers HashMap
	public void addCustomer(Long CustID, Customer Customers) {
		if(customers.containsKey(CustID)) {
			System.out.println("Duplicate Account !!!");
		} else {
			customers.put(CustID, Customers);
		}
	}

	//adding multiple address
	public void addCustomerAddress(Long CustID, AddressType addressType, Address address) {
		
		if (customers_address.containsKey(CustID)) {
			customers_address.get(CustID).put(addressType, address);
			//StoreIntoTxt.storeCutomersAddress(customers_address);
		} else {
			customers_address.put(CustID, new HashMap<AddressType, Address>());
			customers_address.get(CustID).put(addressType, address);
			//StoreIntoTxt.storeCutomersAddress(customers_address);
		}
	}

	// Adding savings accounts to savings account HashMap
	public void addSavingsAccounts(long CustID, String accountno, SavingsAccount savaccount) {
		// if (customers.containsKey(CustID)) {
		if (accounts_Mainsavings.containsKey(CustID)) {
			accounts_Mainsavings.get(CustID).put(accountno, savaccount); // main savings account list
			StoreIntoTxt.storeSavingsAccount(accounts_Mainsavings);
		} else {
			accounts_Mainsavings.put(CustID, new HashMap<String, SavingsAccount>());
			accounts_Mainsavings.get(CustID).put(accountno, savaccount);
			StoreIntoTxt.storeSavingsAccount(accounts_Mainsavings);
		}
	}

	// Adding current accounts to current account HashMap
	public void addCurrentAccounts(long CustID, String accountno, CurrentAccount curaccount) {
		if (accounts_Maincurrent.containsKey(CustID)) {
			accounts_Maincurrent.get(CustID).put(accountno, curaccount);
			StoreIntoTxt.storeCurrentAccount(accounts_Maincurrent);
		} else {
			accounts_Maincurrent.put(CustID, new HashMap<String, CurrentAccount>());
			accounts_Maincurrent.get(CustID).put(accountno, curaccount);
			StoreIntoTxt.storeCurrentAccount(accounts_Maincurrent);
		}
	}

	// Adding FD accounts to FD account HashMap
	public void addFixedDepositAccount(long CustID, String accountno, FixedDepositAccount fdaccount) {
		// if (customers.containsKey(CustID)) {
		if (accounts_Mainfixeddeposit.containsKey(CustID)) {
			accounts_Mainfixeddeposit.get(CustID).put(accountno, fdaccount);
			StoreIntoTxt.storeFDAccount(accounts_Mainfixeddeposit);
		} else {
			accounts_Mainfixeddeposit.put(CustID, new HashMap<String, FixedDepositAccount>());
			accounts_Mainfixeddeposit.get(CustID).put(accountno, fdaccount);
			StoreIntoTxt.storeFDAccount(accounts_Mainfixeddeposit);
		}
	}

	// Adding loan to main HashMap
	public void addVehicleHomeLoan(long CustID, String accountno, VehicleHomeLoan vhloan) {
		// if (customers.containsKey(CustID)) {
		if (loan_Mainloan.containsKey(CustID)) {
			loan_Mainloan.get(CustID).put(accountno, vhloan); // main savings account list
			StoreIntoTxt.storeLoan(loan_Mainloan);
		} else {
			loan_Mainloan.put(CustID, new HashMap<String, VehicleHomeLoan>());
			loan_Mainloan.get(CustID).put(accountno, vhloan);
			loan_paymenthistory.put(accountno, new TreeMap<LocalDate, LoanPayment>());
			StoreIntoTxt.storeLoan(loan_Mainloan);
		}
	}

	//keeping a record of all transaction done by a account
	public void addRecordedTransaction(String accountno, LocalDateTime datetime,
			TransactionHistory transactionhistory) {
		if (recorded__transactionhistory.containsKey(accountno)) {
			recorded__transactionhistory.get(accountno).put(datetime, transactionhistory); // main savings account list
			StoreIntoTxt.storeRecordedTransaction(recorded__transactionhistory);
		} else {
			recorded__transactionhistory.put(accountno, new TreeMap<LocalDateTime, TransactionHistory>());
			recorded__transactionhistory.get(accountno).put(datetime, transactionhistory);
			StoreIntoTxt.storeRecordedTransaction(recorded__transactionhistory);
		}
	}
	
	//making a list of all closed accounts
	public void addClosedAccount(String accountno, LocalDateTime datetime,
			ClosedAccount closedAccount) {
		if (closed_accounthistory.containsKey(accountno)) {
			closed_accounthistory.get(accountno).put(datetime, closedAccount); 
		} else {
			closed_accounthistory.put(accountno, new TreeMap<LocalDateTime, ClosedAccount>());
			closed_accounthistory.get(accountno).put(datetime, closedAccount);
		}
	}
	
	//making a list of all closed loans 
	public void addClosedLoan(String accountno, LocalDateTime datetime,
			ClosedLoan closedLoan) {
		if (closed_loanhistory.containsKey(accountno)) {
			closed_loanhistory.get(accountno).put(datetime, closedLoan); 
		} else {
			closed_loanhistory.put(accountno, new TreeMap<LocalDateTime, ClosedLoan>());
			closed_loanhistory.get(accountno).put(datetime, closedLoan);
		}
	}
	
	//making a listing of loan payment according to account number
	public void addLoanPaymentRecord(String accountno, LocalDate dueDate,
			LoanPayment loanpayment) {
		if (loan_paymenthistory.containsKey(accountno)) {
			loan_paymenthistory.get(accountno).put(dueDate, loanpayment); 
		} else {
			loan_paymenthistory.put(accountno, new TreeMap<LocalDate, LoanPayment>());
			loan_paymenthistory.get(accountno).put(dueDate, loanpayment);
		}
	}

	// get a particular customer's Details
	public void getCustomerDetails(long custID) {

		if (customers.containsKey(custID)) {
			customers.get(custID).displayCustomerDetails();
			for (Map.Entry<Long, HashMap<AddressType, Address>> entry : customers_address.entrySet()) {
				HashMap<AddressType, Address> sub_address = entry.getValue();
				if (entry.getKey().equals(custID)) {
					// AddressType key = entry.getKey();
					for (Map.Entry<AddressType, Address> tMap : sub_address.entrySet()) {
						System.out.println(tMap.getKey() + ":");
						tMap.getValue().displayAddress();
					}
				}
			}
		} else {
			System.out.println("Invalid Customer ID !");
			//System.out.println(customers);
		}
	}

	// get all address of a person
	public void getAddressOnly(long custID) {
		for (Map.Entry<Long, HashMap<AddressType, Address>> entry : customers_address.entrySet()) {
			HashMap<AddressType, Address> sub_address = entry.getValue();
			if (entry.getKey().equals(custID)) {
				// AddressType key = entry.getKey();
				int count = 1;
				for (Map.Entry<AddressType, Address> tMap : sub_address.entrySet()) {
					System.out.println(count + "." + tMap.getKey() + ":");
					count++;
					tMap.getValue().displayAddress();
				}
			}
		}
	}

	// calculating maturity amount for fixed deposit account
	public double calcuateMaturityamount(double deposit, float interest, Frequency compound_frequency, int years) {
		this.deposit = deposit;
		this.interest = interest;
		this.compound_frequency = compound_frequency;
		this.years = years;

		interest_rate = interest / 100;
		double p;
		p = deposit;

		int number_freq;
		number_freq = compound_frequency.getfrequency();

		maturity_amount = p * Math.pow((1 + interest_rate / number_freq), years * number_freq);
		// System.out.print(" Maturity Amount: " + Math.round(maturity_amount) + "\n ");
		return Math.round(maturity_amount);
	}

	// calculating fixed_periodic_payment for loan account
	public double calcuateFixedPeriodicPayment(double deposit, float interest, Frequency compound_frequency,
			int years) {
		this.deposit = deposit;
		this.interest = interest;
		this.compound_frequency = compound_frequency;
		this.years = years;

		interest_rate = interest / 100;
		double p;
		p = deposit;

		int number_freq;
		number_freq = compound_frequency.getfrequency();

		fixed_periodic_payment = (p * (interest_rate / number_freq)
				* Math.pow((1 + (interest_rate / number_freq)), years * number_freq))
				/ (Math.pow(1 + (interest_rate / number_freq), years * number_freq) - 1);
		// System.out.print(" Maturity Amount: " + Math.round(maturity_amount) + "\n ");
		return Math.round(fixed_periodic_payment);
	}

	// get a particular customer's all Account Details
	public void getCustomerAccountDetails(long custID) {
		// savings
		if (accounts_Mainsavings.containsKey(custID)) {
			Object[] keyByIndex = accounts_Mainsavings.get(custID).keySet().toArray();
			for (int i = 0; i < accounts_Mainsavings.get(custID).keySet().size(); i++) {
				System.out.print(" Account No: " + keyByIndex[i]);
				accounts_Mainsavings.get(custID).get(keyByIndex[i]).displaySavingsAccountDeatils();
			}
		}
		// current
		if (accounts_Maincurrent.containsKey(custID)) {
			Object[] keyByIndex = accounts_Maincurrent.get(custID).keySet().toArray();
			for (int i = 0; i < accounts_Maincurrent.get(custID).keySet().size(); i++) {
				System.out.print(" Account No: " + keyByIndex[i]);
				accounts_Maincurrent.get(custID).get(keyByIndex[i]).displayCurrentAccountDeatils();
			}
		}
		// FD
		if (accounts_Mainfixeddeposit.containsKey(custID)) {
			Object[] keyByIndex = accounts_Mainfixeddeposit.get(custID).keySet().toArray();
			for (int i = 0; i < accounts_Mainfixeddeposit.get(custID).keySet().size(); i++) {
				System.out.print(" Account No: " + keyByIndex[i]);
				accounts_Mainfixeddeposit.get(custID).get(keyByIndex[i]).displayFixedDepositDeatils();
				System.out.println(" Maturity Amount: " + currency.getSymbol()
						+ calcuateMaturityamount(
								accounts_Mainfixeddeposit.get(custID).get(keyByIndex[i]).getInvestment(),
								accounts_Mainfixeddeposit.get(custID).get(keyByIndex[i]).getInterest(),
								accounts_Mainfixeddeposit.get(custID).get(keyByIndex[i]).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(keyByIndex[i]).getyears()));
			}
		}
	}

	// get a particular customer's all Loan Details
	public void getCustomerLoanDetails(long custID) {
		// savings
		if (loan_Mainloan.containsKey(custID)) {
			Object[] keyByIndex = loan_Mainloan.get(custID).keySet().toArray();
			for (int i = 0; i < loan_Mainloan.get(custID).keySet().size(); i++) {
				System.out.print(" Account No: " + keyByIndex[i]);
				loan_Mainloan.get(custID).get(keyByIndex[i]).displayVLoan();
				// double deposit, float interest, Frequency compound_frequency, int years
				System.out.println(" Fixed Periodic Payment: " + "\n");
			}

		}
	}

	// get a transaction history of a account
	public void getRecordedTransactionHistory(String accono) {
		if (recorded__transactionhistory.containsKey(accono)) {
			for (Map.Entry<String, TreeMap<LocalDateTime, TransactionHistory>> entry : recorded__transactionhistory
					.entrySet()) {
				if (entry.getKey().equals(accono)) {
					System.out.printf("%19s %20s %10s %15s %15s", "DATE & TIME", "DESCRIPTION", "ACTION", "AMOUNT",
							"TOTAL");
					System.out.println();
					TreeMap<LocalDateTime, TransactionHistory> treeMap = new TreeMap<>(Collections.reverseOrder());

					TreeMap<LocalDateTime, TransactionHistory> addMap = entry.getValue();
					for (Map.Entry<LocalDateTime, TransactionHistory> entry1 : addMap.entrySet()) {
						treeMap.put(entry1.getKey(), entry1.getValue());
					}
					for (Map.Entry<LocalDateTime, TransactionHistory> tMap : treeMap.entrySet()) {
						tMap.getValue().displayTransactionHistory();
					}
				}
			}
		}
	}

	//get record of all closed accounts in the bank
	public void getAllClosedAccount() {
			for (Map.Entry<String, TreeMap<LocalDateTime, ClosedAccount>> entry : closed_accounthistory
					.entrySet()) {
					TreeMap<LocalDateTime, ClosedAccount> treeMap = new TreeMap<>(Collections.reverseOrder());

					TreeMap<LocalDateTime, ClosedAccount> addMap = entry.getValue();
					for (Map.Entry<LocalDateTime, ClosedAccount> entry1 : addMap.entrySet()) {
						treeMap.put(entry1.getKey(), entry1.getValue());
					}
					for (Map.Entry<LocalDateTime, ClosedAccount> tMap : treeMap.entrySet()) {
						tMap.getValue().displayClosedAccountDetails();
					}
			}
	}
	
	//get record of all closed loan in the bank
	public void getAllClosedLoan() {
			for (Map.Entry<String, TreeMap<LocalDateTime, ClosedLoan>> entry : closed_loanhistory
					.entrySet()) {
					TreeMap<LocalDateTime, ClosedLoan> treeMap = new TreeMap<>(Collections.reverseOrder());

					TreeMap<LocalDateTime, ClosedLoan> addMap = entry.getValue();
					for (Map.Entry<LocalDateTime, ClosedLoan> entry1 : addMap.entrySet()) {
						treeMap.put(entry1.getKey(), entry1.getValue());
					}
					for (Map.Entry<LocalDateTime, ClosedLoan> tMap : treeMap.entrySet()) {
						tMap.getValue().displayClosedLoanDetails();
					}
			}
	}
	
	// get a loan payment history of a loan account
	public void getRecordedLoanPayment(String accono) {
		if (loan_paymenthistory.containsKey(accono)) {
			for (Map.Entry<String, TreeMap<LocalDate, LoanPayment>> entry : loan_paymenthistory
					.entrySet()) {
				if (entry.getKey().equals(accono)) {
					System.out.printf("%15s %15s %15s %20s", "PAID DATE", "DUE DATE", "AMOUNT PAYED",
							"TOTAL AMOUNT PAID");
					System.out.println();
					TreeMap<LocalDate, LoanPayment> treeMap = new TreeMap<>(Collections.reverseOrder());

					TreeMap<LocalDate, LoanPayment> addMap = entry.getValue();
					for (Map.Entry<LocalDate, LoanPayment> entry1 : addMap.entrySet()) {
						treeMap.put(entry1.getKey(), entry1.getValue());
					}
					for (Map.Entry<LocalDate, LoanPayment> tMap : treeMap.entrySet()) {
						tMap.getValue().displayLoanPaymentDetails();
						//System.out.println(tMap.getValue());
					}
				}
			}
		}
	}

	
	// removing a particular savings account
	public void removeSavingsAccount(long custID, String accono) {
		if (accounts_Mainsavings.get(custID).containsKey(accono)) {
			ClosedAccount closedAccountS = new ClosedAccount(custID, accono, AccountType.Savings, LocalDateTime.now());
			addClosedAccount(accono, LocalDateTime.now(), closedAccountS);
			StoreIntoTxt.storeClosedAccount(closedAccountS);
			accounts_Mainsavings.get(custID).remove(accono);
			System.out.println(" Savings Account " + accono + " Closed !");
		} else {
			System.out.println("Invalid Savings Account Number !");
		}
	}

	// removing a particular current account;
	public void removeCurrentAccount(long custID, String accono) {
		if (accounts_Maincurrent.get(custID).containsKey(accono)) {
			ClosedAccount closedAccountC = new ClosedAccount(custID, accono, AccountType.Current, LocalDateTime.now());
			addClosedAccount(accono, LocalDateTime.now(), closedAccountC);
			StoreIntoTxt.storeClosedAccount(closedAccountC);
			accounts_Maincurrent.get(custID).remove(accono);
			System.out.println(" Current Account " + accono + " Closed !");
		} else {
			System.out.println("Invalid Current Account Number !");
		}
	}

	// removing a particular FD account
	public void removeFixedDepositAccount(long custID, String accono) {

		double amount = calcuateMaturityamount(accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(), 2.0f,
				accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
				accounts_Mainfixeddeposit.get(custID).get(accono).getyears());

		if (accounts_Mainfixeddeposit.get(custID).containsKey(accono)) {
			// if we are closing account before maturity
			if (LocalDate.now().isBefore(accounts_Mainfixeddeposit.get(custID).get(accono).maturityDate())) {

				System.out.println(" Early Maturity Amount: " + currency.getSymbol()
						+ calcuateMaturityamount(accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(),
								2.0f, accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears()));

				System.out.println(" Actual Maturity Amount: " + currency.getSymbol()
						+ calcuateMaturityamount(accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getInterest(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears()));

				System.out.println();
				System.out.println(" Closing FD before Maturity !");
				System.out.println();
				System.out.println("    1. Transfer to Savings");
				System.out.println("    2. Transfer to Current");
				System.out.println("    3. Withdraw");
				int choice1;

				System.out.print("Enter your choice:");
				choice1 = scan.nextInt();
				scan.nextLine();

				switch (choice1) {
				case 1:
					System.out.print(" Enter Account number: ");
					String aa = scan.nextLine();
					if (accounts_Mainsavings.get(custID).containsKey(aa)) {
						depositToSavingsFD(custID, aa, amount);

						double balance = accounts_Mainsavings.get(custID).get(aa).getBalance();
						LocalDateTime dTime = LocalDateTime.now();
						double amm = calcuateMaturityamount(
								accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(), 2.0f,
								accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears());
						TransactionHistory tHistory = new TransactionHistory(dTime, "FD Amount", "Credit", amm,
								balance);
						// addTransaction(accono, tHistory);
						addRecordedTransaction(aa, dTime, tHistory);
						accounts_Mainfixeddeposit.get(custID).remove(accono);
						System.out.println(" Fixed Deposit Account " + accono + " Closed !");
						
						ClosedAccount closedAccountFD = new ClosedAccount(custID, accono, AccountType.FixedDeposit, LocalDateTime.now());
						StoreIntoTxt.storeClosedAccount(closedAccountFD);
						addClosedAccount(accono, LocalDateTime.now(), closedAccountFD);
						
					} else {
						System.out.println("Invalid Savings Account Number !");
					}
					break;

				case 2:
					System.out.print(" Enter Account number: ");
					String a1 = scan.nextLine();
					if (accounts_Maincurrent.get(custID).containsKey(a1)) {
						depositToCurrentFD(custID, a1, amount);

						double balance = accounts_Maincurrent.get(custID).get(a1).getBalance();
						LocalDateTime dTime = LocalDateTime.now();
						double amm = calcuateMaturityamount(
								accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(), 2.0f,
								accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears());
						TransactionHistory tHistory = new TransactionHistory(dTime, "FD Amount", "Credit", amm,
								balance);
						// addTransaction(accono, tHistory);
						addRecordedTransaction(a1, dTime, tHistory);
						accounts_Mainfixeddeposit.get(custID).remove(accono);
						System.out.println(" Fixed Deposit Account " + accono + " Closed !");
						
						ClosedAccount closedAccountFD = new ClosedAccount(custID, accono, AccountType.FixedDeposit, LocalDateTime.now());
						addClosedAccount(accono, LocalDateTime.now(), closedAccountFD);
						StoreIntoTxt.storeClosedAccount(closedAccountFD);
					} else {
						System.out.println("Invalid Current Account Number !");
					}

					break;

				case 3:
					accounts_Mainfixeddeposit.get(custID).remove(accono);
					System.out.println(" Fixed Deposit Account " + accono + " Closed !");
					
					ClosedAccount closedAccountFD = new ClosedAccount(custID, accono, AccountType.FixedDeposit, LocalDateTime.now());
					addClosedAccount(accono, LocalDateTime.now(), closedAccountFD);
					StoreIntoTxt.storeClosedAccount(closedAccountFD);
					break;

				default:
					System.out.println("\n" + "Invalid choice! " + "\n");
					break;
				}

			}

			// if maturity date is equal to current date
			else if (LocalDate.now().isEqual(accounts_Mainfixeddeposit.get(custID).get(accono).maturityDate())) {
				// if(LocalDate.of(2025, 05,
				// 05).isEqual(accounts_Mainfixeddeposit.get(custID).get(accono).maturityDate()))
				// {
				System.out.println(" Maturity Amount: " + currency.getSymbol()
						+ calcuateMaturityamount(accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getInterest(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears()));
				System.out.println();

				System.out.println("    1. Transfer to Savings");
				System.out.println("    2. Transfer to Current");
				System.out.println("    3. Withdraw");
				int choice1;

				System.out.print("Enter your choice:");
				choice1 = scan.nextInt();
				scan.nextLine();

				// double amount;
				switch (choice1) {
				case 1:
					System.out.print(" Enter Account number: ");
					String aa = scan.nextLine();
					if (accounts_Mainsavings.get(custID).containsKey(aa)) {
						depositToSavingsFD(custID, aa, amount);

						double balance = accounts_Mainsavings.get(custID).get(aa).getBalance();
						LocalDateTime dTime = LocalDateTime.now();
						double amm = calcuateMaturityamount(
								accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getInterest(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears());
						TransactionHistory tHistory = new TransactionHistory(dTime, "FD Amount", "Credit", amm,
								balance);
						// addTransaction(accono, tHistory);
						addRecordedTransaction(aa, dTime, tHistory);
						accounts_Mainfixeddeposit.get(custID).remove(accono);
						System.out.println(" Fixed Deposit Account " + accono + " Closed !");
						
						ClosedAccount closedAccountFD = new ClosedAccount(custID, accono, AccountType.FixedDeposit, LocalDateTime.now());
						addClosedAccount(accono, LocalDateTime.now(), closedAccountFD);
						StoreIntoTxt.storeClosedAccount(closedAccountFD);
					} else {
						System.out.println("Invalid Savings Account Number !");
					}
					break;

				case 2:
					System.out.print(" Enter Account number: ");
					String a1 = scan.nextLine();
					if (accounts_Maincurrent.get(custID).containsKey(a1)) {
						depositToCurrentFD(custID, a1, amount);

						double balance = accounts_Maincurrent.get(custID).get(a1).getBalance();
						LocalDateTime dTime = LocalDateTime.now();
						double amm = calcuateMaturityamount(
								accounts_Mainfixeddeposit.get(custID).get(accono).getInvestment(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getInterest(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getcompoundfrequency(),
								accounts_Mainfixeddeposit.get(custID).get(accono).getyears());
						TransactionHistory tHistory = new TransactionHistory(dTime, "FD Amount", "Credit", amm,
								balance);
						// addTransaction(accono, tHistory);
						addRecordedTransaction(a1, dTime, tHistory);
						accounts_Mainfixeddeposit.get(custID).remove(accono);
						System.out.println(" Fixed Deposit Account " + accono + " Closed !");
						
						ClosedAccount closedAccountFD = new ClosedAccount(custID, accono, AccountType.FixedDeposit, LocalDateTime.now());
						addClosedAccount(accono, LocalDateTime.now(), closedAccountFD);
						StoreIntoTxt.storeClosedAccount(closedAccountFD);
					} else {
						System.out.println("Invalid Current Account Number !");
					}

					break;

				case 3:
					accounts_Mainfixeddeposit.get(custID).remove(accono);
					System.out.println(" Fixed Deposit Account " + accono + " Closed !");
					
					ClosedAccount closedAccountFD = new ClosedAccount(custID, accono, AccountType.FixedDeposit, LocalDateTime.now());
					addClosedAccount(accono, LocalDateTime.now(), closedAccountFD);
					StoreIntoTxt.storeClosedAccount(closedAccountFD);
					break;

				default:
					System.out.println("\n" + "Invalid choice! " + "\n");
					break;
				}
//        		accounts_Mainfixeddeposit.get(custID).remove(accono);
//        		System.out.println(" Fixed Deposit Account "+accono+" Closed !");
			}

		} else {
			System.out.println("Invalid Fixed Deposit Account Number !");
		}

	}

	// add amount to savings account
	public void depositToSavings(long custID, String accono, double ammount) {
		accounts_Mainsavings.get(custID).get(accono).deposit(ammount);
		//System.out.println("Successfully Deposited !!!");
		StoreIntoTxt.storedepositToSavings(new Deposit(custID, accono, ammount));
//		System.out.println(
//				"New Balance: " + currency.getSymbol() + accounts_Mainsavings.get(custID).get(accono).getBalance());
		double balance = accounts_Mainsavings.get(custID).get(accono).getBalance();
		//LocalDateTime dTime = LocalDateTime.now();
		double amm = ammount;
		TransactionHistory tHistory = new TransactionHistory(LocalDateTime.now(), "Self-Deposit", "Credit", amm, balance);
		// addTransaction(accono, tHistory);
		addRecordedTransaction(accono, LocalDateTime.now(), tHistory);
	}

	// add amount to current account
	public void depositToCurrent(long custID, String accono, double ammount) {
		accounts_Maincurrent.get(custID).get(accono).deposit(ammount);
		StoreIntoTxt.storedepositToCurrent(new Deposit(custID, accono, ammount));
		System.out.println("Successfully Deposited !!!");
		System.out.println(
				"New Balance: " + currency.getSymbol() + accounts_Maincurrent.get(custID).get(accono).getBalance());
		double balance = accounts_Maincurrent.get(custID).get(accono).getBalance();
		LocalDateTime dTime = LocalDateTime.now();
		double amm = ammount;
		TransactionHistory tHistory = new TransactionHistory(LocalDateTime.now(), "Self-Deposit", "Credit", amm, balance);
		// addTransaction(accono, tHistory);
		addRecordedTransaction(accono, LocalDateTime.now(), tHistory);
	}

	// add amount to savings account
	public void depositToSavingsFD(long custID, String accono, double ammount) {
		accounts_Mainsavings.get(custID).get(accono).deposit(ammount);
		System.out.println("Successfully Deposited !!!");
	}

	// add amount to current account
	public void depositToCurrentFD(long custID, String accono, double ammount) {
		accounts_Maincurrent.get(custID).get(accono).deposit(ammount);
	}

	// withdraw amount from savings account
	public void withdrawFromSavings(long custID, String accono, double ammount) {

		if (ammount < accounts_Mainsavings.get(custID).get(accono).getBalance()) {
			accounts_Mainsavings.get(custID).get(accono).withdraw(ammount);
			StoreIntoTxt.storeWithdrawFromSavings(new Deposit(custID, accono, ammount));
			System.out.println("Successfully Withdrawn !!!");
			System.out.println(
					"New Balance: " + currency.getSymbol() + accounts_Mainsavings.get(custID).get(accono).getBalance());
			double balance = accounts_Mainsavings.get(custID).get(accono).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistory = new TransactionHistory(LocalDateTime.now(), "Self-Withdraw", "Debit", amm, balance);
			// addTransaction(accono, tHistory);
			addRecordedTransaction(accono, LocalDateTime.now(), tHistory);
		} else {
			System.out.print(" Insufficient Balance !");
		}
	}

	// withdraw amount from current account
	public void withdrawFromCurrent(long custID, String accono, double ammount) {
		if (ammount < accounts_Maincurrent.get(custID).get(accono).getBalance()) {
			accounts_Maincurrent.get(custID).get(accono).withdraw(ammount);
			StoreIntoTxt.storeWithdrawFromCurrent(new Deposit(custID, accono, ammount));
			System.out.println("Successfully Withdrawn !!!");
			System.out.println(
					"New Balance: " + currency.getSymbol() + accounts_Maincurrent.get(custID).get(accono).getBalance());
			double balance = accounts_Maincurrent.get(custID).get(accono).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistory = new TransactionHistory(LocalDateTime.now(), "Self-Withdraw", "Debit", amm, balance);
			// addTransaction(accono, tHistory);
			addRecordedTransaction(accono, LocalDateTime.now(), tHistory);
		} else {
			System.out.print(" Insufficient Balance !");
		}
	}

	// withdraw amount from savings account for loan
	public void withdrawFromSavingsLoan(long custID, String accono, double ammount, String loanAccono) {

		if (ammount < accounts_Mainsavings.get(custID).get(accono).getBalance()) {
			accounts_Mainsavings.get(custID).get(accono).withdraw(ammount);
			System.out.println("\nLoan Amount Payed !");
			// System.out.println("Successfully Withdrawn !!!");
			// System.out.println(
			// "New Balance: " + currency.getSymbol() +
			// accounts_Mainsavings.get(custID).get(accono).getBalance());
			double balance = accounts_Mainsavings.get(custID).get(accono).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistory = new TransactionHistory(dTime, "Loan Amount", "Debit", amm, balance);
			addRecordedTransaction(accono, dTime, tHistory);
			LoanPayment loanPayment = new LoanPayment(LocalDate.now(),loan_Mainloan.get(custID).get(loanAccono).loanDueDate(), amm);
			addLoanPaymentRecord(loanAccono, loan_Mainloan.get(custID).get(loanAccono).loanDueDate(), loanPayment);

		} else {
			System.out.print(" Insufficient Balance !");
		}
	}

	// withdraw amount from current account for laon
	public void withdrawFromCurrentLoan(long custID, String accono, double ammount, String loanAccono) {
		if (ammount < accounts_Maincurrent.get(custID).get(accono).getBalance()) {
			accounts_Maincurrent.get(custID).get(accono).withdraw(ammount);
			System.out.println("\nLoan Amount Payed !");
			// System.out.println("Successfully Withdrawn !!!");
			// System.out.println(
			// "New Balance: " + currency.getSymbol() +
			// accounts_Maincurrent.get(custID).get(accono).getBalance());
			double balance = accounts_Maincurrent.get(custID).get(accono).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistory = new TransactionHistory(dTime, "Loan Amount", "Debit", amm, balance);
			// addTransaction(accono, tHistory);
			addRecordedTransaction(accono, dTime, tHistory);
			LoanPayment loanPayment = new LoanPayment(LocalDate.now(),loan_Mainloan.get(custID).get(loanAccono).loanDueDate(), amm);
			addLoanPaymentRecord(loanAccono, loan_Mainloan.get(custID).get(loanAccono).loanDueDate(), loanPayment);
		} else {
			System.out.print(" Insufficient Balance !");
		}
	}

	public void updateCustomerName(long custID, String new_name) {
		customers.get(custID).setName(new_name);
	}

	public void updateCustomerAddress(long custID, String new_address) {
		customers.get(custID).setAddress(new_address);
	}

	public void updateCustomerEmail(long custID, String new_email) {
		customers.get(custID).setEmail(new_email);
	}

	public void updateCustomerPhoneNumber(long custID, String new_phoneno) {
		try {
			customers.get(custID).setPhonenumber(new_phoneno);
			System.out.println("Phone Number Updated!");
			System.out.println("\n" + "Updated Profile: ");
			getCustomerDetails(custID);
		} catch (IllegalPhoneNumberException e) {
			System.out.println(e);
		}
	}

	public void updateCustomerEmploymentStatus(long custID, EmploymentStatus new_empstat) {
		customers.get(custID).setEmploymentstatus(new_empstat);
	}

	public void checkSavingsBalance(long custID, String accono) {
		System.out.println("Available Balance: " + currency.getSymbol()
				+ accounts_Mainsavings.get(custID).get(accono).getBalance());
	}

	public void checkCurrentBalance(long custID, String accono) {
		System.out.println("Available Balance: " + currency.getSymbol()
				+ accounts_Maincurrent.get(custID).get(accono).getBalance());
	}

	public void transferFromSavingsAccounttoSavingsAccount(long custIDSender, String sendingAccountno,
			long custIDReciver, String receivingAccountno, double ammount, String description)
			throws IllegalTransferAmountException {
		if (ammount > accounts_Mainsavings.get(custIDSender).get(sendingAccountno).getBalance()) {
			throw new IllegalTransferAmountException("Insufficient Balance !");
		} else {
			accounts_Mainsavings.get(custIDSender).get(sendingAccountno).withdraw(ammount);
			StoreIntoTxt.storeWithdrawFromSavings(new Deposit(custIDSender, sendingAccountno, ammount));
			accounts_Mainsavings.get(custIDReciver).get(receivingAccountno).deposit(ammount);
			StoreIntoTxt.storedepositToSavings(new Deposit(custIDReciver, receivingAccountno, ammount));

			double balanceSender = accounts_Mainsavings.get(custIDSender).get(sendingAccountno).getBalance();
			double balanceReciver = accounts_Mainsavings.get(custIDReciver).get(receivingAccountno).getBalance();
		//LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistorySender = new TransactionHistory(LocalDateTime.now(), description, "Debit", ammount, accounts_Mainsavings.get(custIDSender).get(sendingAccountno).getBalance());
			TransactionHistory tHistoryReciver = new TransactionHistory(LocalDateTime.now(), description, "Credit", ammount,
					accounts_Mainsavings.get(custIDReciver).get(receivingAccountno).getBalance());
			addRecordedTransaction(sendingAccountno, LocalDateTime.now(), tHistorySender);
			addRecordedTransaction(receivingAccountno, LocalDateTime.now(), tHistoryReciver);
		}
	}

	public void transferFromSavingsAccounttoCurrentAccount(long custIDSender, String sendingAccountno,
			long custIDReciver, String receivingAccountno, double ammount, String description)
			throws IllegalTransferAmountException {
		if (ammount > accounts_Mainsavings.get(custIDSender).get(sendingAccountno).getBalance()) {
			throw new IllegalTransferAmountException("Insufficient Balance !");
		} else {
			accounts_Mainsavings.get(custIDSender).get(sendingAccountno).withdraw(ammount);
			StoreIntoTxt.storeWithdrawFromSavings(new Deposit(custIDSender, sendingAccountno, ammount));
			accounts_Maincurrent.get(custIDReciver).get(receivingAccountno).deposit(ammount);
			StoreIntoTxt.storedepositToCurrent(new Deposit(custIDReciver, receivingAccountno, ammount));

			double balanceSender = accounts_Mainsavings.get(custIDSender).get(sendingAccountno).getBalance();
			double balanceReciver = accounts_Maincurrent.get(custIDReciver).get(receivingAccountno).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistorySender = new TransactionHistory(LocalDateTime.now(), description, "Debit", amm, balanceSender);
			TransactionHistory tHistoryReciver = new TransactionHistory(LocalDateTime.now(), description, "Credit", amm,
					balanceReciver);
			addRecordedTransaction(sendingAccountno, LocalDateTime.now(), tHistorySender);
			addRecordedTransaction(receivingAccountno, LocalDateTime.now(), tHistoryReciver);
		}
	}

	public void transferFromCurrentAccounttoSavingsAccount(long custIDSender, String sendingAccountno,
			long custIDReciver, String receivingAccountno, double ammount, String description)
			throws IllegalTransferAmountException {
		if (ammount > accounts_Maincurrent.get(custIDSender).get(sendingAccountno).getBalance()) {
			throw new IllegalTransferAmountException("Insufficient Balance !");
		} else {
			accounts_Maincurrent.get(custIDSender).get(sendingAccountno).withdraw(ammount);
			//StoreIntoTxt.storeWithdrawFromCurrent(new Deposit(custIDSender, sendingAccountno, ammount));
			accounts_Mainsavings.get(custIDReciver).get(receivingAccountno).deposit(ammount);
			//StoreIntoTxt.storedepositToSavings(new Deposit(custIDReciver, receivingAccountno, ammount));

			double balanceSender = accounts_Maincurrent.get(custIDSender).get(sendingAccountno).getBalance();
			double balanceReciver = accounts_Mainsavings.get(custIDReciver).get(receivingAccountno).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistorySender = new TransactionHistory(LocalDateTime.now(), description, "Debit", amm, balanceSender);
			TransactionHistory tHistoryReciver = new TransactionHistory(LocalDateTime.now(), description, "Credit", amm,
					balanceReciver);
			addRecordedTransaction(sendingAccountno, LocalDateTime.now(), tHistorySender);
			addRecordedTransaction(receivingAccountno, LocalDateTime.now(), tHistoryReciver);
		}
	}

	public void transferFromCurrentAccounttoCurrentAccount(long custIDSender, String sendingAccountno,
			long custIDReciver, String receivingAccountno, double ammount, String description)
			throws IllegalTransferAmountException {
		if (ammount > accounts_Maincurrent.get(custIDSender).get(sendingAccountno).getBalance()) {
			throw new IllegalTransferAmountException("Insufficient Balance !");
		} else {
			accounts_Maincurrent.get(custIDSender).get(sendingAccountno).withdraw(ammount);
			//StoreIntoTxt.storeWithdrawFromCurrent(new Deposit(custIDSender, sendingAccountno, ammount));
			accounts_Maincurrent.get(custIDReciver).get(receivingAccountno).deposit(ammount);
			//StoreIntoTxt.storedepositToCurrent(new Deposit(custIDReciver, receivingAccountno, ammount));

			double balanceSender = accounts_Maincurrent.get(custIDSender).get(sendingAccountno).getBalance();
			double balanceReciver = accounts_Maincurrent.get(custIDReciver).get(receivingAccountno).getBalance();
			LocalDateTime dTime = LocalDateTime.now();
			double amm = ammount;
			TransactionHistory tHistorySender = new TransactionHistory(LocalDateTime.now(), description, "Debit", amm, balanceSender);
			TransactionHistory tHistoryReciver = new TransactionHistory(LocalDateTime.now(), description, "Credit", amm,
					balanceReciver);
			addRecordedTransaction(sendingAccountno, LocalDateTime.now(), tHistorySender);
			addRecordedTransaction(receivingAccountno, LocalDateTime.now(), tHistoryReciver);
		}
	}

	public void payLoan(long custID, String loanAccono) {
		
		System.out.println("\nName: " + customers.get(custID).getName());
		System.out.println("Loan Type: " + loan_Mainloan.get(custID).get(loanAccono).getLoanType());
		System.out.println("Loan Intrest: " + loan_Mainloan.get(custID).get(loanAccono).getInterest() + "%");
		System.out.println();
		System.out.println("Installment: " + loan_Mainloan.get(custID).get(loanAccono).getCompound_frequency() + " ["
				+ loan_Mainloan.get(custID).get(loanAccono).getNumbercompoundfrequency() + "]" + "\t" + "Year: "
				+ loan_Mainloan.get(custID).get(loanAccono).getYears());

		if (loan_Mainloan.get(custID).get(loanAccono).loanLastDate().isBefore(LocalDate.now())) {
			if(loan_paymenthistory.containsKey(loanAccono)) {
				ClosedLoan closedLoan = new ClosedLoan(custID, loanAccono, loan_Mainloan.get(custID).get(loanAccono).getLoanType(),loan_Mainloan.get(custID).get(loanAccono).getLoan_amount(), LocalDateTime.now());
				addClosedLoan(loanAccono, LocalDateTime.now(), closedLoan);
				loan_Mainloan.get(custID).remove(loanAccono);
				System.out.println("Loan Closed!");
			} else {
				System.out.println("\nPayment Due Date: " + loan_Mainloan.get(custID).get(loanAccono).loanDueDate());
				System.out.println("Past Due Date!!");
				double ammountL = calcuateFixedPeriodicPayment(loan_Mainloan.get(custID).get(loanAccono).getLoan_amount(),
						loan_Mainloan.get(custID).get(loanAccono).getInterest() + 1,
						loan_Mainloan.get(custID).get(loanAccono).getCompound_frequency(),
						loan_Mainloan.get(custID).get(loanAccono).getYears());
				System.out.println("Fixed Periodic Payment with Intrest: " + currency.getSymbol() + ammountL);
				payLoanAmmount(custID, loanAccono, ammountL, loanAccono);
			}
		} else {
			LocalDate currDueDate = loan_Mainloan.get(custID).get(loanAccono).loanDueDate();
			if(loan_paymenthistory.get(loanAccono).containsKey(currDueDate)) {
				System.out.println("\nCurrent Payment Due Date: PAID current Installment !"  + "\t\tNext Due Date: " + loan_Mainloan.get(custID).get(loanAccono).loanDueDateNext());
			}else {
				System.out.println("\nCurrent Payment Due Date: " + loan_Mainloan.get(custID).get(loanAccono).loanDueDate() + "\t\tNext Due Date: " + loan_Mainloan.get(custID).get(loanAccono).loanDueDateNext());
			}
			

			if (LocalDate.now().isBefore(loan_Mainloan.get(custID).get(loanAccono).loanDueDate())) {
				double ammountL = calcuateFixedPeriodicPayment(loan_Mainloan.get(custID).get(loanAccono).getLoan_amount(),
						loan_Mainloan.get(custID).get(loanAccono).getInterest(),
						loan_Mainloan.get(custID).get(loanAccono).getCompound_frequency(),
						loan_Mainloan.get(custID).get(loanAccono).getYears());
				System.out.println("Fixed Periodic Payment: " + currency.getSymbol() + ammountL);
				payLoanAmmount(custID, loanAccono, ammountL, loanAccono);

			} else {
				System.out.println("Past Due Date!!");
				double ammountL = calcuateFixedPeriodicPayment(loan_Mainloan.get(custID).get(loanAccono).getLoan_amount(),
						loan_Mainloan.get(custID).get(loanAccono).getInterest() + 1,
						loan_Mainloan.get(custID).get(loanAccono).getCompound_frequency(),
						loan_Mainloan.get(custID).get(loanAccono).getYears());
				System.out.println("Fixed Periodic Payment with Intrest: " + currency.getSymbol() + ammountL);
				payLoanAmmount(custID, loanAccono, ammountL, loanAccono);
			}
		}
	}

	private void payLoanAmmount(long custID, String accono, double ammountL, String loanAccono) {
		System.out.println();
		System.out.println("   1. Pay Due Amount");
		System.out.println("   2. Payment History");
		System.out.println("   3. Back");
		System.out.print("Enter your choice: ");
		int key = scan.nextInt();
		int count = 0;
		switch (key) {
		case 1:

			System.out.println("\n" + "--- Payment Mode ---");
			System.out.println("1. Savings");
			System.out.println("2. Current");
			System.out.println("3. Deposit");

			System.out.print("Enter your choice: ");
			int key1 = scan.nextInt();
			scan.nextLine();
			switch (key1) {
			case 1:
				if (accounts_Mainsavings.containsKey(custID)) {
					System.out.print("Enter Account No: ");
					String sendingAccountno = scan.nextLine();
					System.out.print("Amount: " + currency.getSymbol() + ammountL);
					withdrawFromSavingsLoan(custID, sendingAccountno, ammountL,loanAccono);
					count++;
				}
				break;

			case 2:
				if (accounts_Maincurrent.containsKey(custID)) {
					System.out.print("Enter Account No: ");
					String sendingAccountno = scan.nextLine();
					System.out.print("Amount: " + currency.getSymbol() + ammountL);
					withdrawFromCurrentLoan(custID, sendingAccountno, ammountL,loanAccono);
					count++;
				}
				break;
			
			case 3:
				LoanPayment loanPayment = new LoanPayment(LocalDate.now(),loan_Mainloan.get(custID).get(accono).loanDueDate(), ammountL);
				addLoanPaymentRecord(loanAccono, loan_Mainloan.get(custID).get(loanAccono).loanDueDate(), loanPayment);
				break;

			default:
				System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
				break;
			}
			break;

		case 2:
			getRecordedLoanPayment(loanAccono);
			break;
			
		case 3:
			break;

		default:
			System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
		}

	}

	public void getActiveCustomer() {
		Object[] keyByIndex = customers.keySet().toArray();
		for (int i = 0; i < customers.keySet().size(); i++) {
			if (accounts_Mainsavings.containsKey(keyByIndex[i])) {
				System.out.printf("%11s %20s", keyByIndex[i], customers.get(keyByIndex[i]).getName());
				System.out.println();
			} else if (accounts_Maincurrent.containsKey(keyByIndex[i])) {
				System.out.printf("%11s %20s", keyByIndex[i], customers.get(keyByIndex[i]).getName());
				System.out.println();
			} else if (accounts_Mainfixeddeposit.containsKey(keyByIndex[i])) {
				System.out.printf("%11s %20s", keyByIndex[i], customers.get(keyByIndex[i]).getName());
				System.out.println();
			}
		}
	}

	public void getUnActiveCustomer() {
		Object[] keyByIndex = customers.keySet().toArray();
		for (int i = 0; i < customers.keySet().size(); i++) {
			if (accounts_Mainsavings.containsKey(keyByIndex[i])) {
			} else if (accounts_Maincurrent.containsKey(keyByIndex[i])) {
			} else if (accounts_Mainfixeddeposit.containsKey(keyByIndex[i])) {
			} else {
				System.out.printf("%11s %20s", keyByIndex[i], customers.get(keyByIndex[i]).getName());
				System.out.println();
				// System.out.println(keyByIndex[i]);
			}
		}
	}

	public void getActiveSavings() {
		Object[] keyByIndex = accounts_Mainsavings.keySet().toArray();
		for (int i = 0; i < accounts_Mainsavings.keySet().size(); i++) {
			Object[] keyByIndex1 = accounts_Mainsavings.get(keyByIndex[i]).keySet().toArray();
			for (int j = 0; j < accounts_Mainsavings.get(keyByIndex[i]).keySet().size(); j++) {
				System.out.printf("%11s %16s %20s", keyByIndex[i], keyByIndex1[j],
						customers.get(keyByIndex[i]).getName());
				System.out.println();
			}
		}
	}

	public void getActiveCurrent() {
		Object[] keyByIndex = accounts_Maincurrent.keySet().toArray();
		for (int i = 0; i < accounts_Maincurrent.keySet().size(); i++) {
			Object[] keyByIndex1 = accounts_Maincurrent.get(keyByIndex[i]).keySet().toArray();
			for (int j = 0; j < accounts_Maincurrent.get(keyByIndex[i]).keySet().size(); j++) {
				System.out.printf("%11s %16s %20s", keyByIndex[i], keyByIndex1[j],
						customers.get(keyByIndex[i]).getName());
				System.out.println();
			}
		}
	}

	public void getActiveFD() {
		Object[] keyByIndex = accounts_Mainfixeddeposit.keySet().toArray();
		for (int i = 0; i < accounts_Mainfixeddeposit.keySet().size(); i++) {
			Object[] keyByIndex1 = accounts_Mainfixeddeposit.get(keyByIndex[i]).keySet().toArray();
			for (int j = 0; j < accounts_Mainfixeddeposit.get(keyByIndex[i]).keySet().size(); j++) {
				System.out.printf("%11s %16s %20s", keyByIndex[i], keyByIndex1[j],
						customers.get(keyByIndex[i]).getName());
				System.out.println();
			}
		}
	}

	public void getActiveLoan() {
		Object[] keyByIndex = loan_Mainloan.keySet().toArray();
		for (int i = 0; i < loan_Mainloan.keySet().size(); i++) {
			Object[] keyByIndex1 = loan_Mainloan.get(keyByIndex[i]).keySet().toArray();
			for (int j = 0; j < loan_Mainloan.get(keyByIndex[i]).keySet().size(); j++) {
				System.out.printf("%11s %16s %20s", keyByIndex[i], keyByIndex1[j],
						customers.get(keyByIndex[i]).getName());
				System.out.println();
			}
		}
	}

}

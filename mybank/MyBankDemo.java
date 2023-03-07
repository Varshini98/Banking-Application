package mybank;

import java.time.*;
import java.util.Scanner;

class MyBankDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Bank bank = new Bank();

		try {
//Customer 1 ------------------------------------------------>
			Customer c0 = new Customer(2023100l, "Varshini", "1998-01-01", EmploymentStatus.Employee,
					"varshini@gmail.com", "9656772795");
			Address a0 = new Address(2023100l, AddressType.HomeAddress, "Block 102, Desai Chambers", "127/129 Modi Street", "Mumbai", "Maharashtra",
					"400001");
			Address w0 = new Address(2023100l, AddressType.WorkAddress,"SM Ent.", "Thakur Arcade", "Mumbai", "Maharashtra", "445671");
			bank.addCustomer(2023100l, c0);
			bank.addCustomerAddress(2023100l, AddressType.HomeAddress, a0);
			bank.addCustomerAddress(2023100l, AddressType.WorkAddress, w0);
			
				
			SavingsAccount s0 = new SavingsAccount(AccountType.Savings, 500000000, LocalDate.of(2020, 05, 01));
			SavingsAccount s1 = new SavingsAccount(AccountType.Savings, 8000, LocalDate.now());
			VehicleHomeLoan vh0 = new VehicleHomeLoan(LoanType.HomeLoan, 100000, 3.3f, LocalDate.now(),
					Frequency.monthly, 5, 24);
			VehicleHomeLoan vh1 = new VehicleHomeLoan(LoanType.Vehicleloan, 500000, 4.3f, LocalDate.of(2022, 04, 03),
					Frequency.yearly, 1, 24);
			bank.addSavingsAccounts(2023100l, "100SA1", s0);
			bank.addSavingsAccounts(2023100l, "100SA2", s1);
			bank.addVehicleHomeLoan(2023100l, "100VH1", vh0);
			bank.addVehicleHomeLoan(2023100l, "100VH2", vh1);
			
			
			
//Customer 2 ------------------------------------------------>
			Customer c1 = new Customer(2023101l, "Janmitha", "2000-02-02", EmploymentStatus.UnEmployed,
					"janmitha26@gmail.com", "9865345021");
			Address a1 = new Address(2023101l, AddressType.HomeAddress,"ABC Appartmaent", "2nd Cross", "Banglore", "Karnataka", "414001");
			bank.addCustomer(2023101l, c1);
			bank.addCustomerAddress(2023101l, AddressType.HomeAddress, a1);
			
			SavingsAccount s2 = new SavingsAccount(AccountType.Savings, 800000, LocalDate.now());
			CurrentAccount ca0 = new CurrentAccount(AccountType.Current, 10000, LocalDate.now());
			CurrentAccount ca1 = new CurrentAccount(AccountType.Current, 5500, LocalDate.now());
			FixedDepositAccount fd0 = new FixedDepositAccount(AccountType.FixedDeposit, 100000, 5.2f, LocalDate.now(),
					Frequency.monthly, 3);
			bank.addSavingsAccounts(2023101l, "101SA1", s2);
			bank.addCurrentAccounts(2023101l, "101CA1", ca0);
			bank.addCurrentAccounts(2023101l, "101CA2", ca1);
			bank.addFixedDepositAccount(2023101l, "101FD1", fd0);
			
			//bank.depositToSavings(2023101l, "101SA1", 1000);
			//bank.depositToSavings(2023101l, "101SA1", 3400);
			//bank.depositToSavings(2023101l, "101SA1", 100);
		    //bank.withdrawFromSavings(2023101l, "101SA1", 1000);
			//bank.transferFromSavingsAccounttoSavingsAccount(2023101l, "101SA1", 2023100l, "100SA2", 50000, "Rent");
			//bank.transferFromSavingsAccounttoSavingsAccount(2023101l, "101SA1", 2023100l, "100SA2", 800, "Food");
			
//Customer 3 ------------------------------------------------>
			Customer c2 = new Customer(2023102l, "Ten", "1996-02-27", EmploymentStatus.UnEmployed, "ten@gmail.com",
					"9865345021");
			Address a2 = new Address(2023102l, AddressType.HomeAddress,"Plot No 19", "Gauri Complex", "Udupi", "Karnataka", "424501");
			bank.addCustomer(2023102l, c2);
			bank.addCustomerAddress(2023102l, AddressType.HomeAddress, a2);
			
			FixedDepositAccount fd1 = new FixedDepositAccount(AccountType.FixedDeposit, 500000, 6.6f,
					LocalDate.of(2020, 05, 05), Frequency.monthly, 5);
			
			VehicleHomeLoan vh2 = new VehicleHomeLoan(LoanType.Vehicleloan, 500000, 4.3f, LocalDate.of(2023, 01, 01),
					Frequency.monthly, 5, 24);
			
			bank.addFixedDepositAccount(2023102l, "102FD1", fd1);
			bank.addVehicleHomeLoan(2023102l, "102VH2", vh2);
			
//Customer 4 ------------------------------------------------>
			Customer c3 = new Customer(2023103l, "Saint", "1998-03-27", EmploymentStatus.Employee, "saint@gmail.com",
					"9865345021");
			Address a3 = new Address(2023103l, AddressType.HomeAddress,"ABC Appartmaent", "2nd Cross", "Banglore", "Karnataka", "414001");
			Address w3 = new Address(2023103l, AddressType.WorkAddress, "XYZ Corp", "XXX Road", "Banglore", "Karnataka", "985001");
			bank.addCustomer(2023103l, c3);
			bank.addCustomerAddress(2023103l, AddressType.HomeAddress, a3);
			bank.addCustomerAddress(2023103l, AddressType.WorkAddress, w3);

//Customer 5 ------------------------------------------------>
			Customer c4 = new Customer(2023104l, "Neema", "1998-03-27", EmploymentStatus.Employee, "zee@gmail.com",
					"9865345021");
			Address a4 = new Address(2023104l, AddressType.HomeAddress,"vvv Appartmaent", "2nd Cross", "Banglore", "Karnataka", "414001");
			Address w4 = new Address(2023104l, AddressType.WorkAddress,"XvZ Corp", "v Road", "Banglore", "Karnataka", "985001");
			bank.addCustomer(2023104l, c4);
			bank.addCustomerAddress(2023104l, AddressType.HomeAddress, a4);
			bank.addCustomerAddress(2023104l, AddressType.WorkAddress, w4);

		}   catch (IllegalDOBException e) {
			System.out.println(e);
		} catch (IllegalEmailIDException e) {
			System.out.println(e);
		} catch (IllegalPhoneNumberException e) {
			System.out.println(e);
		} catch (IllegalDepositException e) {
			System.out.println(e);
		} catch (IllegalAgeException e) {
			System.out.println(e);
		}


		try (Scanner sc = new Scanner(System.in)) {
			int choice1, choice2, choice3, choice4, choice10;

			do {
				System.out.println();
				System.out.println("--- Bank Help ---");
				System.out.println("1. New customer");
				System.out.println("2. Existing customer");
				System.out.println("3. Bank Log");
				System.out.println("4. Exit");

				System.out.print("Enter your choice:");
				choice1 = sc.nextInt();
				sc.nextLine();

				switch (choice1) {
				case 1: // New customer ----------------------------------------------> Main case1
					System.out.println("\n" + "--- New Customer ---");
					long CustID;
					String name;
					String dob;
					EmploymentStatus empstat = null;
					String email;
					String phonenumber;

					//CustID += 1;

					System.out.print("Enter CustomerID: ");
					CustID = sc.nextLong();
					sc.nextLine();
					if(bank.customers.containsKey(CustID)) {
						System.out.println("This customer ID already Exist in the system !!");
					} else {
					System.out.print("Enter Name: ");
					name = sc.nextLine();

					System.out.print("Enter DOB(yyyy-mm-dd): ");
					dob = sc.nextLine();

					try {
						System.out.print("Employment Status (Worker/Employee/SelfEmployed/UnEmployed): ");
						empstat = EmploymentStatus.valueOf(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Please type valid Employment Status.");
						break;
					}
					
					System.out.print("Enter Email: ");
					email = sc.nextLine();
					try {
					System.out.print("Enter Phone Number: ");
					phonenumber = sc.nextLine();
					
						Customer c = new Customer(CustID, name, dob, empstat, email, phonenumber);
						bank.addCustomer(CustID, c);

					// address
					System.out.println("Enter Home Address");

					String buildingname;
					String streetAddress;
					String city;
					String state;
					String zipCode;

					System.out.print("Enter Buiding Name: ");
					buildingname = sc.nextLine();
					System.out.print("Enter Street Name: ");
					streetAddress = sc.nextLine();
					System.out.print("Enter City: ");
					city = sc.nextLine();
					System.out.print("Enter State: ");
					state = sc.nextLine();
					System.out.print("Enter PIN: ");
					zipCode = sc.nextLine();

					Address address = new Address(CustID, AddressType.HomeAddress,buildingname, streetAddress, city, state, zipCode);
					bank.addCustomerAddress(CustID, AddressType.HomeAddress, address);
					//StoreIntoTxt.storeCutomersAddress(address);

					if (empstat.equals(EmploymentStatus.Employee)) {
						System.out.println("Enter Work Address");

						String workbuildingname;
						String workstreetAddress;
						String workcity;
						String workstate;
						String workzipCode;

						System.out.print("Enter Company Name: ");
						workbuildingname = sc.nextLine();
						System.out.print("Enter Street Name: ");
						workstreetAddress = sc.nextLine();
						System.out.print("Enter City: ");
						workcity = sc.nextLine();
						System.out.print("Enter State: ");
						workstate = sc.nextLine();
						System.out.print("Enter PIN: ");
						workzipCode = sc.nextLine();

						Address workaddress = new Address(CustID, AddressType.WorkAddress,workbuildingname, workstreetAddress, workcity, workstate,
								workzipCode);
						bank.addCustomerAddress(CustID, AddressType.WorkAddress, workaddress);
					}

					System.out.println();
					System.out.println("Profile successfully created !");
					System.out.println("Your CustomerID is " + CustID);
					
					}   catch (IllegalDOBException e) {
						System.out.println(e);
					} catch (IllegalEmailIDException e) {
						System.out.println(e);
					} catch (IllegalPhoneNumberException e) {
						System.out.println(e);
					}
				}
					
					break;

				case 2: // Existing customer----------------------------------------------> Main case2

					do {
						System.out.println();
						System.out.println("--- Customer Help ---");
						System.out.println("1. View Customer Details");
						System.out.println("2. Add New Account");
						System.out.println("3. View Account Details");
						System.out.println("4. New Loan");
						System.out.println("5. View Loan Details");
						System.out.println("6. Deposit");
						System.out.println("7. Withdraw");
						System.out.println("8. Transfer Money");
						System.out.println("9. Check Balance");
						System.out.println("10. Transaction history");
						System.out.println("11. Loan Payment");
						System.out.println("12. Edit Profile");
						System.out.println("13. Close Account");
						System.out.println("14. Back ");
						
						System.out.print("Enter your choice:");
						choice2 = sc.nextInt();
						sc.nextLine();

						switch (choice2) {
						case 1: // view customer details---------------------> Main case2 -> case1
							System.out.print("Enter Customer ID: ");
							long custid1 = sc.nextLong();
							// CustomerID cid1 = new CustomerID(custid1);
							bank.getCustomerDetails(custid1);									
							break;

						case 2: // add new account---------------------> Main case2 -> case2
							System.out.println("\n" + "--- Add New Account---");
							System.out.println("   1. Savings Account");
							System.out.println("   2. Current Account");
							System.out.println("   3. Fixed Deposit Account");
							System.out.println("   4. Back");

							System.out.print("Enter your choice:");
							choice3 = sc.nextInt();
							sc.nextLine();

							switch (choice3) {

							case 1: // add new savings account---------------------> Main case2 -> case2 -> case1
								System.out.println("--- Savings Account ---");

								long custid;
								String accno;
								double deposit;

								System.out.print("Enter Customer ID: ");
								custid = sc.nextLong();
								sc.nextLine();

								if (bank.customers.containsKey(custid)) {
									System.out.print("Enter Account no: ");
									accno = sc.nextLine();
									System.out.print("Deposit Amount: ");
									deposit = sc.nextDouble();
									try {
										SavingsAccount s = new SavingsAccount(AccountType.Savings, deposit,
												LocalDate.now());
										bank.addSavingsAccounts(custid, accno, s);
										System.out.println();
										System.out.println("Savings Account successfully created !");
									} catch (IllegalDepositException e) {
										System.out.println(e);
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 2: // add new current account---------------------> Main case2 -> case2 -> case2
								System.out.println("--- Current Account ---");
								long custid2;
								String accno1;
								double deposit1;

								System.out.print("Enter Customer ID: ");
								custid2 = sc.nextLong();
								sc.nextLine();

								if (bank.customers.containsKey(custid2)) {
									System.out.print("Enter Account no: ");
									accno1 = sc.nextLine();
									System.out.print("Deposit Amount: ");
									deposit1 = sc.nextDouble();
									try {
										CurrentAccount c = new CurrentAccount(AccountType.Savings, deposit1,
												LocalDate.now());
										bank.addCurrentAccounts(custid2, accno1, c);
										System.out.println();
										System.out.println("Current Account successfully created !");
									} catch (IllegalDepositException e) {
										System.out.println(e);
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}

								break;

							case 3: // add new fd account---------------------> Main case2 -> case2 -> case3
								System.out.println("--- Fixed Deposit Account ---");
								long custid3;
								String accno3;
								double deposit3;
								Frequency compound_frequency;
								int years1;
								float interest;

								System.out.print("Enter Customer ID: ");
								custid3 = sc.nextLong();
								sc.nextLine();

								if (bank.customers.containsKey(custid3)) {
									System.out.print("Enter Account no: ");
									accno3 = sc.nextLine();
									System.out.print("Deposit Amount: ");
									deposit3 = sc.nextDouble();
									System.out.print("Intrest Rate: ");
									interest = sc.nextFloat();
									sc.nextLine();
									System.out.print("Compound Frequency: ");
									compound_frequency = Frequency.valueOf(sc.nextLine());
									System.out.print("Years: ");
									years1 = sc.nextInt();
									try {
										FixedDepositAccount fd = new FixedDepositAccount(AccountType.FixedDeposit,
												deposit3, interest, LocalDate.now(), compound_frequency, years1);
										bank.addFixedDepositAccount(custid3, accno3, fd);
										System.out.println();
										System.out.println("Fixed Deposit Account successfully created !");
									} catch (IllegalDepositException e) {
										System.out.println(e);
									}
								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 4: // exit---------------------> Main case2 -> case2 -> case4
								break;

							default:// ---------------------> Main case2 -> case2 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 3: // view account details-------------------------------------------> Main case2
								// -> case3
							System.out.println("\n" + "--- View Account Details ---");
							System.out.print("Enter Customer ID: ");
							long custid3 = sc.nextLong();
							if (bank.customers.containsKey(custid3)) {
								bank.getCustomerAccountDetails(custid3);
							} else {
								System.out.println("Invalid Customer ID !");
							}
							break;

						case 4: // new loan-------------------------------------------> Main case2 -> case4
							System.out.println("\n" + "--- Add New Loan ---");
							System.out.println("   1. Vehicle Loan");
							System.out.println("   2. Home Loan");
							System.out.println("   3. Back");

							System.out.print("Enter your choice:");
							choice3 = sc.nextInt();
							sc.nextLine();

							switch (choice3) {

							case 1: // add new Vehicle Loan---------------------> Main case2 -> case4 -> case1
								System.out.println("--- Vehicle Loan ---");

								long custid;
								String accno;
								double deposit;
								Frequency compound_frequency;
								int years1;
								float interest;

								System.out.print("Enter Customer ID: ");
								custid = sc.nextLong();
								sc.nextLine();

								if (bank.customers.containsKey(custid)) {
									System.out.print("Enter Account no: ");
									accno = sc.nextLine();
									System.out.print("Loan Amount: ");
									deposit = sc.nextDouble();
									System.out.print("Intrest Rate: ");
									interest = sc.nextFloat();
									sc.nextLine();
									System.out.print("Compound Frequency: ");
									compound_frequency = Frequency.valueOf(sc.nextLine());
									System.out.print("Years: ");
									years1 = sc.nextInt();
									try {
										VehicleHomeLoan vh2 = new VehicleHomeLoan(LoanType.Vehicleloan, deposit,
												interest, LocalDate.now(), compound_frequency, years1,
												bank.customers.get(custid).getage());
										bank.addVehicleHomeLoan(custid, accno, vh2);
										System.out.println();
										System.out.println("Loan approved !");
									} catch (IllegalAgeException e) {
										System.out.println(e);
									}
								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 2: // add new Home Loan---------------------> Main case2 -> case4 -> case2
								System.out.println("--- Home Loan ---");

								long custid11;
								String accno1;
								double deposit1;
								Frequency compound_frequency1;
								int years11;
								float interest1;

								System.out.print("Enter Customer ID: ");
								custid11 = sc.nextLong();
								sc.nextLine();

								if (bank.customers.containsKey(custid11)) {
									System.out.print("Enter Account no: ");
									accno1 = sc.nextLine();
									System.out.print("Loan Amount: ");
									deposit1 = sc.nextDouble();
									System.out.print("Intrest Rate: ");
									interest1 = sc.nextFloat();
									sc.nextLine();
									System.out.print("Compound Frequency: ");
									compound_frequency1 = Frequency.valueOf(sc.nextLine());
									System.out.print("Years: ");
									years11 = sc.nextInt();
									try {
										VehicleHomeLoan vh2 = new VehicleHomeLoan(LoanType.HomeLoan, deposit1,
												interest1, LocalDate.now(), compound_frequency1, years11,
												bank.customers.get(custid11).getage());
										bank.addVehicleHomeLoan(custid11, accno1, vh2);
										System.out.println();
										System.out.println("Loan approved !");
									} catch (IllegalAgeException e) {
										System.out.println(e);
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 3: // exit---------------------> Main case2 -> case4 -> case3
								break;

							default:// ---------------------> Main case2 -> case4 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 5: // view loan detail-------------------------------------------> Main case2
								// ->case5
							System.out.println("\n" + "--- View Loan Details ---");
							System.out.print("Enter Customer ID: ");
							long custid21 = sc.nextLong();
							System.out.println();
							if (bank.customers.containsKey(custid21)) {
								bank.getCustomerLoanDetails(custid21);
							} else {
								System.out.println("Invalid Customer ID !");
							}
							break;

						case 6: // deposit money-------------------------------------------> Main case2 -> case6
							System.out.println("--- Deposit Money ---");
							System.out.println("   1. Savings");
							System.out.println("   2. Current");
							System.out.println("   3. Back");

							System.out.print("Enter your choice:");
							choice4 = sc.nextInt();

							long custid5;

							switch (choice4) {

							case 1:// Deposit to savings--------------------->Main case2 -> case6 -> case1
								System.out.println("--- Savings ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid5 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainsavings.containsKey(custid5)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Mainsavings.get(custid5).containsKey(accono2)) {
										System.out.print("Enter Deposit Amount: ");
										double amount = sc.nextDouble();
										bank.depositToSavings(custid5, accono2, amount);

										// System.out.print(" Savings Account "+accono2+" Closed !");
									} else {
										System.out.println("Invalid Savings Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
//		                                       
								break;

							case 2: // Deposit to current---------------------> Main case2 -> case6 -> case2
								System.out.println("--- Current ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid5 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Maincurrent.containsKey(custid5)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Maincurrent.get(custid5).containsKey(accono2)) {
										System.out.print("Enter Deposit Amount: ");
										double amount = sc.nextDouble();
										bank.depositToCurrent(custid5, accono2, amount);
										// System.out.print(" Savings Account "+accono2+" Closed !");
									} else {
										System.out.println("Invalid Current Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 3:// exit---------------------> Main case2 -> case6 -> case3
								break;

							default: // ---------------------> Main case2 -> case6 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 7: // Withdraw money-------------------------------------------> Main case2 ->
								// case7
							System.out.println("--- Withdraw Money ---");
							System.out.println("   1. Savings");
							System.out.println("   2. Current");
							System.out.println("   3. Back");

							System.out.print("Enter your choice:");
							choice4 = sc.nextInt();

							long custid51;

							switch (choice4) {

							case 1:// Withdraw from savings---------------------> Main case2 -> case7 -> case1
								System.out.println("--- Savings ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid51 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainsavings.containsKey(custid51)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Mainsavings.get(custid51).containsKey(accono2)) {
										System.out.print("Enter Withdraw Amount: ");
										double amount = sc.nextDouble();
										bank.withdrawFromSavings(custid51, accono2, amount);
									} else {
										System.out.println("Invalid Savings Account Number !");
									}
								} else {
									System.out.println("Invalid Customer ID !");
								}
//		                                       
								break;

							case 2: // Withdraw from current---------------------> Main case2 -> case7 -> case2
								System.out.println("--- Current ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid51 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Maincurrent.containsKey(custid51)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Maincurrent.get(custid51).containsKey(accono2)) {
										System.out.print("Enter Withdraw Amount: ");
										double amount = sc.nextDouble();
										bank.withdrawFromCurrent(custid51, accono2, amount);
									} else {
										System.out.println("Invalid Current Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 3:// exit---------------------> Main case2 -> case7 -> case3
								break;

							default:// ---------------------> Main case2 -> case7 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 8: // Transfer Money to other account ------------------------------------------->
								// Main case2 -> case8
							System.out.println("--- Transfer Amount ---");
							System.out.println("   1. Savings");
							System.out.println("   2. Current");
							System.out.println("   3. Back");

							System.out.print("Enter your choice:");
							choice4 = sc.nextInt();

							long custid10;

							switch (choice4) {

							case 1:// Transfer from savings---------------------> Main case2 -> case8 -> case1
								System.out.println("--- Savings Account ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid10 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainsavings.containsKey(custid10)) {
									System.out.print("Enter Account No: ");
									String sendingAccountno = sc.nextLine();
									if (bank.accounts_Mainsavings.get(custid10).containsKey(sendingAccountno)) {
										System.out.print("Beneficiary Account Number :");
										String receivingAccountno = sc.nextLine();
										// boolean s,c;
										Object[] keyByIndexS = bank.accounts_Mainsavings.keySet().toArray();
										Object[] keyByIndexC = bank.accounts_Maincurrent.keySet().toArray();

										for (int i = 0; i < bank.accounts_Mainsavings.keySet().size(); i++) {

											if (bank.accounts_Mainsavings.get(keyByIndexS[i])
													.containsKey(receivingAccountno)) {
												System.out.print("Amount :");
												double amount = sc.nextDouble();
												sc.nextLine();
												System.out.print("Description :");
												String description = sc.nextLine();
												long c1 = (long) keyByIndexS[i];
												try {

													bank.transferFromSavingsAccounttoSavingsAccount(custid10,
															sendingAccountno, c1, receivingAccountno, amount,
															description);
													System.out.println("Transaction Successful !");
												} catch (IllegalTransferAmountException e) {
													System.out.println(e);
												}
											} else {
												//System.out.println("Invalid Account Number!1");
											}
										}

										for (int i = 0; i < bank.accounts_Maincurrent.keySet().size(); i++) {

											if (bank.accounts_Maincurrent.get(keyByIndexC[i])
													.containsKey(receivingAccountno)) {
												System.out.print("Amount :");
												double amount = sc.nextDouble();
												sc.nextLine();
												System.out.print("Description :");
												String description = sc.nextLine();
												long c1 = (long) keyByIndexC[i];
												try {

													bank.transferFromSavingsAccounttoCurrentAccount(custid10,
															sendingAccountno, c1, receivingAccountno, amount,
															description);
													System.out.println("Transaction Successful !");
												} catch (IllegalTransferAmountException e) {
													System.out.println(e);
												}
											} else {
												//System.out.println("Invalid Account Number2!");
											}
										}

									} else {
										System.out.println("Invalid Savings Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 2: // Transfer from current---------------------> Main case2 -> case8 -> case2
								System.out.println("--- Current Account ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid10 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Maincurrent.containsKey(custid10)) {
									System.out.print("Enter Account No: ");
									String sendingAccountno = sc.nextLine();
									if (bank.accounts_Maincurrent.get(custid10).containsKey(sendingAccountno)) {
										System.out.print("Beneficiary Account Number :");
										String receivingAccountno = sc.nextLine();
										// boolean s,c;
										Object[] keyByIndexS = bank.accounts_Mainsavings.keySet().toArray();
										Object[] keyByIndexC = bank.accounts_Maincurrent.keySet().toArray();

										for (int i = 0; i < bank.accounts_Mainsavings.keySet().size(); i++) {

											if (bank.accounts_Mainsavings.get(keyByIndexS[i])
													.containsKey(receivingAccountno)) {
												System.out.print("Amount :");
												double amount = sc.nextDouble();
												sc.nextLine();
												System.out.print("Description :");
												String description = sc.nextLine();
												long c1 = (long) keyByIndexS[i];
												try {

													bank.transferFromCurrentAccounttoSavingsAccount(custid10,
															sendingAccountno, c1, receivingAccountno, amount,
															description);
													System.out.println("Transaction Successful !");
												} catch (IllegalTransferAmountException e) {
													System.out.println(e);
												}
											}
										}

										for (int i = 0; i < bank.accounts_Maincurrent.keySet().size(); i++) {

											if (bank.accounts_Maincurrent.get(keyByIndexC[i])
													.containsKey(receivingAccountno)) {
												System.out.print("Amount :");
												double amount = sc.nextDouble();
												sc.nextLine();
												System.out.print("Description :");
												String description = sc.nextLine();
												long c1 = (long) keyByIndexC[i];
												try {

													bank.transferFromCurrentAccounttoCurrentAccount(custid10,
															sendingAccountno, c1, receivingAccountno, amount,
															description);

													System.out.println("Transaction Successful !");
												} catch (IllegalTransferAmountException e) {
													System.out.println(e);
												}
											}
										}

									} else {
										System.out.println("Invalid Current Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 3:// exit---------------------> Main case2 -> case9 -> case3
								break;

							default: // ---------------------> Main case2 -> case9 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 9: // Check account balance -------------------------------------------> Main case2
								// -> case9
							System.out.println("--- Check Balance ---");
							System.out.println("   1. Savings");
							System.out.println("   2. Current");
							System.out.println("   3. Back");

							System.out.print("Enter your choice:");
							choice4 = sc.nextInt();

							long custid11;

							switch (choice4) {

							case 1:// Check savings---------------------> Main case2 -> case9 -> case1
								System.out.println("--- Check Savings ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid11 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainsavings.containsKey(custid11)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Mainsavings.get(custid11).containsKey(accono2)) {
										bank.checkSavingsBalance(custid11, accono2);
									} else {
										System.out.println("Invalid Savings Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;
							case 2: // check balance current---------------------> Main case2 -> case9 -> case2
								System.out.println("--- Check Current ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid5 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Maincurrent.containsKey(custid5)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Maincurrent.get(custid5).containsKey(accono2)) {
										bank.checkCurrentBalance(custid5, accono2);
									} else {
										System.out.println("Invalid Current Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 3:// exit---------------------> Main case2 -> case9 -> case3
								break;

							default: // ---------------------> Main case2 -> case9 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 10: // Transaction history -------------------------------------------> Main case2
									// -> case10
							System.out.println("--- Transaction History ---");
							System.out.println("   1. Savings");
							System.out.println("   2. Current");
							System.out.println("   3. Back");

							System.out.print("Enter your choice:");
							choice4 = sc.nextInt();

							switch (choice4) {

							case 1:// Transaction History savings---------------------> Main case2 -> case10 ->
									// case1
								System.out.println("--- Savings Transaction History ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								long custid20 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainsavings.containsKey(custid20)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Mainsavings.get(custid20).containsKey(accono2)) {
										// bank.getTransactionHistory(accono2);
										bank.getRecordedTransactionHistory(accono2);
									} else {
										System.out.println("Invalid Savings Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;
							case 2: // Transaction History current---------------------> Main case2 -> case10 ->
									// case2
								System.out.println("--- Current Transaction History ---");
								sc.nextLine();
								System.out.print("Enter Customer ID: ");
								custid5 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Maincurrent.containsKey(custid5)) {
									System.out.print("Enter Account No: ");
									String accono2 = sc.nextLine();
									if (bank.accounts_Maincurrent.get(custid5).containsKey(accono2)) {
										bank.getRecordedTransactionHistory(accono2);
									} else {
										System.out.println("Invalid Current Account Number !");
									}

								} else {
									System.out.println("Invalid Customer ID !");
								}
								break;

							case 3:// exit---------------------> Main case2 -> case10 -> case3
								break;

							default: // ---------------------> Main case2 -> case10 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 11: // Loan payment -------------------------------------------> Main case2 ->
									// case11
							System.out.println("--- Loan Payment ---");
							// sc.nextLine();
							System.out.print("Enter Customer ID: ");
							custid5 = sc.nextLong();
							sc.nextLine();
							if (bank.loan_Mainloan.containsKey(custid5)) {
								System.out.print("Enter Loan No: ");
								String accono2 = sc.nextLine();
								if (bank.loan_Mainloan.get(custid5).containsKey(accono2)) {
									bank.payLoan(custid5, accono2);

								} else {
									System.out.println("Invalid Loan Number !");
								}

							} else {
								System.out.println("Invalid Customer ID !");
							}
							break;

						case 12: // Edit Profile -------------------------------------------> Main case2 ->
									// case12
							System.out.println("--- Edit Profile ---");
							System.out.print("Enter Customer ID: ");
							long custid7 = sc.nextLong();
							if (bank.customers.containsKey(custid7)) {
								System.out.println();
								System.out.println("--- Profile ---");
								bank.getCustomerDetails(custid7);
								int choice9;
								do {
									System.out.println("\n" + "Update: ");
									System.out.println("    1. Name");
									System.out.println("    2. Address");
									System.out.println("    3. Email");
									System.out.println("    4. Phone Number");
									System.out.println("    5. Employment Status");
									System.out.println("    6. Exit");

									System.out.print("Enter your choice:");
									choice9 = sc.nextInt();
									sc.nextLine();
									switch (choice9) {

									case 1: // Edit name -------------------------------------------> Main case2 ->
											// case12 -> case1
										System.out.print("New Name: ");
										String new_name = sc.nextLine();
										bank.updateCustomerName(custid7, new_name);
										System.out.println("Name Updated!");
										System.out.println("\n" + "Updated Profile: ");
										bank.getCustomerDetails(custid7);
										break;

									case 2: // Edit address -------------------------------------------> Main case2 ->
											// case12 -> case2
										System.out.println(" Address: ");
										bank.getAddressOnly(custid7);
										System.out.println();
										System.out.print("Edit(1 or 2): ");
										int edit = sc.nextInt();
										sc.nextLine();
										if (edit == 1) {
											System.out.println("Enter New Home Address");

											System.out.print("Enter Buiding Name: ");
											String new_buildingname = sc.nextLine();
											System.out.print("Enter Street Name: ");
											String new_streetAddress = sc.nextLine();
											System.out.print("Enter City: ");
											String new_city = sc.nextLine();
											System.out.print("Enter State: ");
											String new_state = sc.nextLine();
											System.out.print("Enter PIN: ");
											String new_zipCode = sc.nextLine();

											Address new_homeaddress = new Address(custid7, AddressType.HomeAddress,new_buildingname, new_streetAddress,
													new_city, new_state, new_zipCode);
											bank.addCustomerAddress(custid7, AddressType.HomeAddress, new_homeaddress);
										} else if (edit == 2) {
											System.out.println("Enter New Work Address");

											System.out.print("Enter Company Name: ");
											String new_workbuildingname = sc.nextLine();
											System.out.print("Enter Street Name: ");
											String new_workstreetAddress = sc.nextLine();
											System.out.print("Enter City: ");
											String new_workcity = sc.nextLine();
											System.out.print("Enter State: ");
											String new_workstate = sc.nextLine();
											System.out.print("Enter PIN: ");
											String new_workzipCode = sc.nextLine();

											Address new_workaddress = new Address(custid7, AddressType.WorkAddress,new_workbuildingname,
													new_workstreetAddress, new_workcity, new_workstate,
													new_workzipCode);
											bank.addCustomerAddress(custid7, AddressType.WorkAddress, new_workaddress);
										} else {
											System.out.println("Invalid!");
										}

										System.out.println("Address Updated!");
										System.out.println("\n" + "Updated Profile: ");
										bank.getCustomerDetails(custid7);
										break;

									case 3: // Edit email -------------------------------------------> Main case2 ->
											// case12 -> case3
										System.out.print("New Email: ");
										String new_email = sc.nextLine();
										bank.updateCustomerEmail(custid7, new_email);
										System.out.println("Email Updated!");
										System.out.println("\n" + "Updated Profile: ");
										bank.getCustomerDetails(custid7);
										break;

									case 4: // Edit phone no -------------------------------------------> Main case2 ->
											// case12 -> case4
										System.out.print("New Phone Number: ");
										String new_phoneno = sc.nextLine();
										bank.updateCustomerPhoneNumber(custid7, new_phoneno);
										break;

									case 5: // Edit Employment Status -------------------------------------------> Main
											// case2 -> case12 -> case5
										EmploymentStatus new_empstat=null;
										try {
											System.out.print("New Employment Status (Worker/Employee/SelfEmployed/UnEmployed): ");
											new_empstat = EmploymentStatus.valueOf(sc.nextLine());
										} catch (Exception e) {
											System.out.println("Please type valid Employment Status.");
											break;
										}

										if (new_empstat.equals(EmploymentStatus.Employee)) {
											System.out.println("Enter New Work Address");

											System.out.print("Enter Company Name: ");
											String new_workbuildingname = sc.nextLine();
											System.out.print("Enter Street Name: ");
											String new_workstreetAddress = sc.nextLine();
											System.out.print("Enter City: ");
											String new_workcity = sc.nextLine();
											System.out.print("Enter State: ");
											String new_workstate = sc.nextLine();
											System.out.print("Enter PIN: ");
											String new_workzipCode = sc.nextLine();

											Address workaddress = new Address(custid7, AddressType.WorkAddress,new_workbuildingname,
													new_workstreetAddress, new_workcity, new_workstate,
													new_workzipCode);
											bank.addCustomerAddress(custid7, AddressType.WorkAddress, workaddress);
										}

										EmploymentStatus old_empstat = bank.customers.get(custid7)
												.getEmploymentstatus();

										if (old_empstat.equals(EmploymentStatus.Employee)
												&& new_empstat.equals(EmploymentStatus.UnEmployed)) {
											bank.customers_address.get(custid7).remove(AddressType.WorkAddress);
										}

										bank.updateCustomerEmploymentStatus(custid7, new_empstat);
										System.out.println("Employment Status Updated!");
										System.out.println("\n" + "Updated Profile: ");
										bank.getCustomerDetails(custid7);
										break;

									case 6: // exit -------------------------------------------> Main case2 -> case12 ->
											// case6
										break;

									default: // -------------------------------------------> Main case2 -> case12 ->
												// default
										System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
										break;
									}
								} while (choice9 != 6);

							} else {
								System.out.println("Invalid Customer ID !");
							}
							break;

						case 13: // Close/remove account -------------------------------------------> Main case2
									// -> case13
							System.out.println("--- Close Account ---");
							System.out.println("    1. Savings");
							System.out.println("    2. Current");
							System.out.println("    3. FD");
							System.out.println("    4. Back");

							System.out.print("Enter your choice:");
							choice10 = sc.nextInt();
							sc.nextLine();

							long custid4;

							switch (choice10) {
							case 1: // close savings---------------------> Main case2 -> case13 -> case1
								System.out.println("--- Close Savings ---");
								System.out.print("Enter Customer ID: ");
								custid4 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainsavings.containsKey(custid4)
										& (bank.accounts_Mainsavings.get(custid4).keySet().size() > 0)) {
									System.out.print("Enter Account No: ");
									String accono1 = sc.nextLine();
									bank.removeSavingsAccount(custid4, accono1);
								} else {
									System.out.println("Invalid Customer ID / You have no Savings Account !");
								}
								break;

							case 2: // close current---------------------> Main case2 -> case13 -> case2
								System.out.println("--- Close Current ---");
								System.out.print("Enter Customer ID: ");
								custid4 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Maincurrent.containsKey(custid4)
										& (bank.accounts_Maincurrent.get(custid4).keySet().size() > 0)) {
									System.out.print("Enter Account No: ");
									String accono1 = sc.nextLine();
									bank.removeCurrentAccount(custid4, accono1);
								} else {
									System.out.println("Invalid Customer ID  / You have no Current Account !");
								}
								break;

							case 3: // close fd---------------------> Main case2 -> case13 -> case3
								System.out.println("--- Close FD ---");
								System.out.print("Enter Customer ID: ");
								custid4 = sc.nextLong();
								sc.nextLine();
								if (bank.accounts_Mainfixeddeposit.containsKey(custid4)
										& (bank.accounts_Mainfixeddeposit.get(custid4).keySet().size() > 0)) {
									System.out.print("Enter Account No: ");
									String accono1 = sc.nextLine();
									bank.removeFixedDepositAccount(custid4, accono1);
								} else {
									System.out.println("Invalid Customer ID / You have no FD Account  !");
								}
								break;

							case 4:// exit---------------------> Main case2 -> case13 -> case4
								break;

							default: // ---------------------> Main case2 -> case12 -> default
								System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
								break;
							}
							break;

						case 14:// exit case2-------------------------------------------> Main case2 -> case14
							break;

						default:
							System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
							break;
						}

					} while (choice2 != 14);
					break;

				case 3: // Bank log----------------------------------------------> Main case3
					int choice16;
					do {
						System.out.println("\n--- Bank Log List ---");
						System.out.println("1. Active Customers");
						System.out.println("2. Inactive Customers");
						System.out.println("3. Active Savings Account");
						System.out.println("4. Active Current Account");
						System.out.println("5. Active FD Account");
						System.out.println("6. Active Loan Account");
						System.out.println("7. Closed Account");
						System.out.println("8. Exit");

						System.out.println();
						System.out.print("Enter your choice:");
						choice16 = sc.nextInt();
						sc.nextLine();

						switch (choice16) {
						case 1: // ------------------------------------------> Main case3 -> case1
							System.out.println("--- Active Customers ---");
							System.out.printf("\n%11s %20s", "CUSTOMER ID", "CUSTOMER NAME");
							System.out.println();
							bank.getActiveCustomer();
							System.out.println();
							break;
						case 2:// ------------------------------------------> Main case3 -> case2
							System.out.println("--- Inactive Customers ---");
							System.out.printf("\n%11s %20s", "CUSTOMER ID", "CUSTOMER NAME");
							System.out.println();
							bank.getUnActiveCustomer();
							System.out.println();
							break;
						case 3:// ------------------------------------------> Main case3 -> case3
							System.out.println("--- Active Savings Account ---");
							System.out.printf("\n%11s %16s %20s", "CUSTOMER ID", "ACCOUNT NUMBER", "CUSTOMER NAME");
							System.out.println();
							bank.getActiveSavings();
							System.out.println();
							break;
						case 4:// ------------------------------------------> Main case3 -> case4
							System.out.println("--- Active Current Account ---");
							System.out.printf("\n%11s %16s %20s", "CUSTOMER ID", "ACCOUNT NUMBER", "CUSTOMER NAME");
							System.out.println();
							bank.getActiveCurrent();
							System.out.println();
							break;
						case 5:// ------------------------------------------> Main case3 -> case5
							System.out.println("--- Active FD Account ---");
							System.out.printf("\n%11s %16s %20s", "CUSTOMER ID", "ACCOUNT NUMBER", "CUSTOMER NAME");
							System.out.println();
							bank.getActiveFD();
							System.out.println();
							break;
						case 6:// ------------------------------------------> Main case3 -> case6
							System.out.println("--- Active Loan Account ---");
							System.out.printf("\n%11s %16s %20s", "CUSTOMER ID", "ACCOUNT NUMBER", "CUSTOMER NAME");
							System.out.println();
							bank.getActiveLoan();
							System.out.println();
							break;
			                case 7:// ------------------------------------------> Main case3 -> case7
			                    System.out.println("--- Closed Account ---");
			                    System.out.println("    1. Account");
								System.out.println("    2. Loans");
								System.out.println("    3. Back");

								System.out.print("Enter your choice:");
								int choice19 = sc.nextInt();
								sc.nextLine();

								switch (choice19) {
								case 1: // all closed accounts(savings/current/fd)---------------------> Main case3 -> case7 -> case1
									System.out.printf("\n%11s %16s %15s %25s", "CUSTOMER ID", "ACCOUNT NUMBER","ACCOUNT TYPE", "DATE & TIME");
									System.out.println();
									bank.getAllClosedAccount();
									break;

								case 2: // all closed loan---------------------> Main case3 -> case7 -> case2
									System.out.printf("\n%11s %16s %15s %15s %25s", "CUSTOMER ID", "ACCOUNT NUMBER","ACCOUNT TYPE", "LOAN AMOUNT","DATE & TIME");
									System.out.println();
									bank.getAllClosedLoan();
									break;

								case 3:// exit---------------------> Main case3 -> case7 -> exit
									break;

								default: // ---------------------> Main case3 -> case7 -> default
									System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
									break;
								}
								break;
//			                    System.out.printf("\n%11s %16s %15s %19s", "CUSTOMER ID", "ACCOUNT NUMBER","ACCOUNT TYPE", "DATE & TIME");
//			                    System.out.println();
//			                    bank.getClosedAccountList();
//			                    System.out.println();
						case 8:// ------------------------------------------> Main case3 -> exit
							break;

						default:// ------------------------------------------> Main case3 -> default
							System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
							break;
						}

					} while (choice16 != 8);
					break;

				case 4: // Exit----------------------------------------------> Main case4 EXIT
					System.out.println();
					System.out.println("\n" + "Thanks for using the bank!" + "\n");
					break;

				default: // default----------------------------------------------> Main case default

					System.out.println("\n" + "Invalid choice! Choose Again." + "\n");
				}

			} while (choice1 != 4);
		}
	}

}

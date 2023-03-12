package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class StoreIntoTxt {


	public static void storeCutomers(Customer customers) {

		 File custPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\CustomerDetails.txt");
	     boolean append = custPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	            oout.writeObject(customers); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
		 
//		 try {
//		 FileOutputStream fout = new FileOutputStream(custPath);
//	        ObjectOutputStream oot = new ObjectOutputStream(fout);
//	
//	         
//	        //illustrating annotateClass(Class<?> cl) method
//	        
//				oot.writeObject(customers);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
		//try with data

//			try {
//				FileInputStream fis = new FileInputStream(custPath);
//				ObjectInputStream ois = new ObjectInputStream(fis);
//				//while (fis.available() > 0) {
//					//@SuppressWarnings("unchecked")
//					Customer cs = (Customer) ois.readObject();
//					if(cs.getCustId()==customers.getCustId()) {	
//					} else {
//						oout.writeObject(customers);
//					}
//				ois.close();
//				fis.close();
//			//}
//			}catch (IOException | ClassCastException |
//					ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		
		//end with data

	}
	
	public static void storeCutomersAddress(Address address) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\CustomerAddress.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	            oout.writeObject(address); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 
//		 try {
//		 FileOutputStream fout = new FileOutputStream(custAddPath);
//	        ObjectOutputStream oot = new ObjectOutputStream(fout);
//	
//	         
//	        //illustrating annotateClass(Class<?> cl) method
//	        
//				oot.writeObject(address);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
		 
	}

	public static void storeSavingsAccount(HashMap<Long, HashMap<String, SavingsAccount>> accounts_Mainsavings) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\SavingsAccount.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(accounts_Mainsavings); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeCurrentAccount(HashMap<Long, HashMap<String, CurrentAccount>> accounts_Maincurrent) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\CurrentAccount.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(accounts_Maincurrent); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeFDAccount(HashMap<Long, HashMap<String, FixedDepositAccount>> accounts_Mainfixeddeposit) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\FDAccount.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(accounts_Mainfixeddeposit); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeLoan(HashMap<Long, HashMap<String, VehicleHomeLoan>> loan_Mainloan) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\Loan.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(loan_Mainloan); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeClosedAccount(ClosedAccount closedAccount) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\ClosedAccount.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(closedAccount); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeClosedLoan(ClosedLoan closedLoan) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\ClosedLoan.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(closedLoan); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeRecordedTransaction(HashMap<String, TreeMap<LocalDateTime, TransactionHistory>> recorded__transactionhistory) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\RecordedTransaction.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	          // oout.writeObject(recorded__transactionhistory); 
				for (Map.Entry<String, TreeMap<LocalDateTime, TransactionHistory>> entry : recorded__transactionhistory.entrySet()) {
					oout.writeObject(entry.getKey());
					oout.writeObject(entry.getValue());	
					}
//					oos.writeObject(entry.getKey());
//					oos.writeObject(entry.getValue());				
				//}
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storedepositToSavings(Deposit deposit) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\depositToSavings.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(deposit); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storedepositToCurrent(Deposit deposit) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\depositToCurrent.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(deposit); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeWithdrawFromSavings(Deposit deposit) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\WithdrawFromSavings.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(deposit); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void storeWithdrawFromCurrent(Deposit deposit) {

		 File custAddPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\WithdrawFromCurrent.txt");
	        boolean append = custAddPath.exists(); // if file exists then append, otherwise create new

	        try (
	            FileOutputStream fout = new FileOutputStream(custAddPath, append);
	            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
	        ) {
	           oout.writeObject(deposit); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		 
	}
	
	public static void editCutomersEditedName(Customer customers) {

		 File custPath = new File(
				"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\CustomerDetails.txt");
	     boolean append = custPath.exists(); // if file exists then append, otherwise create new

	     //System.out.println("came inisde function");
	     try (
		            FileOutputStream fout = new FileOutputStream(custPath, append);
		            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
		        ) {
	    	// System.out.println("came inisde try");
				FileInputStream fis = new FileInputStream(custPath);
				ObjectInputStream ois = new ObjectInputStream(fis);
				while (fis.available() > 0) {
					//@SuppressWarnings("unchecked")
					Customer cs = (Customer) ois.readObject();
					if(cs.getCustId()==customers.getCustId()) {
							//System.out.println("indide loop");
						String nString = cs.getName();
						nString = customers.getName();
						//System.out.println(customers);
						//oout.writeObject(customers);
						oout.reset();
						oout.writeObject(customers);
						break;
					} else {
						
					}
				}
				ois.close();
				fis.close();
			
			}catch (IOException | ClassCastException |
					ClassNotFoundException e) {
				e.printStackTrace();
			}	
	}

	public static void editCutomersEditedEmail(Customer customers) {
		 File custPath = new File(
					"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\CustomerDetails.txt");
		     boolean append = custPath.exists(); // if file exists then append, otherwise create new

		     //System.out.println("came inisde function");
		     try (
			            FileOutputStream fout = new FileOutputStream(custPath, append);
			            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
			        ) {
		    	// System.out.println("came inisde try");
					FileInputStream fis = new FileInputStream(custPath);
					ObjectInputStream ois = new ObjectInputStream(fis);
					while (fis.available() > 0) {
						//@SuppressWarnings("unchecked")
						Customer cs = (Customer) ois.readObject();
						if(cs.getCustId()==customers.getCustId()) {
								//System.out.println("indide loop");
							//String nString = cs.getName();
							//nString = customers.getName();
							//System.out.println(customers);
							//oout.writeObject(customers);
							oout.reset();
							oout.writeObject(customers);
							break;
						} else {
							
						}
					}
					ois.close();
					fis.close();
				
				}catch (IOException | ClassCastException |
						ClassNotFoundException e) {
					e.printStackTrace();
				}	
		
	}

	public static void editCutomersEditedPhone(Customer customers) {
		 File custPath = new File(
					"C:\\Users\\asus\\OneDrive\\Desktop\\mybanktxt-dup\\CustomerDetails.txt");
		     boolean append = custPath.exists(); // if file exists then append, otherwise create new

		     //System.out.println("came inisde function");
		     try (
			            FileOutputStream fout = new FileOutputStream(custPath, append);
			            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
			        ) {
		    	// System.out.println("came inisde try");
					FileInputStream fis = new FileInputStream(custPath);
					ObjectInputStream ois = new ObjectInputStream(fis);
					while (fis.available() > 0) {
						//@SuppressWarnings("unchecked")
						Customer cs = (Customer) ois.readObject();
						if(cs.getCustId()==customers.getCustId()) {
								//System.out.println("indide loop");
							//String nString = cs.getName();
							//nString = customers.getName();
							//System.out.println(customers);
							//oout.writeObject(customers);
							oout.reset();
							oout.writeObject(customers);
							break;
						} else {
							
						}
					}
					ois.close();
					fis.close();
				
				}catch (IOException | ClassCastException |
						ClassNotFoundException e) {
					e.printStackTrace();
				}	
		
	}




}

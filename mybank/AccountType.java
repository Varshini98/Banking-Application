package mybank;

public enum AccountType {
	Savings(5.0f), Current(6.0f), FixedDeposit(7.0f);

	float t;

	AccountType(float t) {
		this.t = t;
	}

	float getAccountInterest() {
		return t;
	}

}

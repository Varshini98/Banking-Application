package application;

public enum Frequency {
	    yearly(1), halfyearly(2), quarterly(6), monthly(12);

	    int f;

	    Frequency(int f) {
	        this.f = f;
	    }

	    int getfrequency() {
	        return f;
	    }

	}
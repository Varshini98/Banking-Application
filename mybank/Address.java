package mybank;

public class Address {
	
	private long CustID;
	private AddressType addressType;
	private String buildingname;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
	
    Address(long CustID, AddressType addressType,String buildingname, String streetAddress, String city, String state, String zipCode) {
		this.buildingname = buildingname;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}


	
	@Override
	public String toString() {
		return "Address [CustID=" + CustID + ", addressType=" + addressType + ", buildingname=" + buildingname
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ "]";
	}



	public void displayAddress() {
		System.out.println(" " +getBuildingname() + "\n " + getStreetAddress() + "\n "+getCity()
	                        + ", " + getState() + ", "+ getZipCode());
	}

	public String getBuildingname() {
		return buildingname;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public long getCustID() {
		return CustID;
	}

	public AddressType getAddressType() {
		return addressType;
	}

}

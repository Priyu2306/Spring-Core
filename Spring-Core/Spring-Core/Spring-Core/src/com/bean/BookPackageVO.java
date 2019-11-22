package com.bean;

import java.util.Date;

public class BookPackageVO {
	
	private int bookingId;
	private int customerId;
	private String packageId;
	private int noOfAdults;
	private int noOfKids;
	private Date checkin;
	private Date checkout;
	private String season;
	private float totalTariff;
	private int noOfNights;
	
	public int getNoOfNights() {
		return noOfNights;
	}
	public void setNoOfNights(int noOfNights) {
		this.noOfNights = noOfNights;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfKids() {
		return noOfKids;
	}
	public void setNoOfKids(int noOfKids) {
		this.noOfKids = noOfKids;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public float getTotalTariff() {
		return totalTariff;
	}
	public void setTotalTariff(float totalTariff) {
		this.totalTariff = totalTariff;
	}
	
	
	

}

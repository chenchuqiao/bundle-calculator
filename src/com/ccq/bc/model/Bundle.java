/**
 *  @ClassName Bundle
 *  @Description Define Bundle entity.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.model;

public class Bundle {
	
	private String formatCode;
	private int bundleNumber;
	private double price;
	
	public Bundle(String formatCode, int bundleNumber, double price) {
		this.formatCode = formatCode;
		this.bundleNumber = bundleNumber;
		this.price = price;
	}

	public Bundle() {
		// TODO Auto-generated constructor stub
	}

	public String getFormatCode() {
		return formatCode;
	}

	public void setFormatCode(String formatCode) {
		this.formatCode = formatCode;
	}

	public int getBundleNumber() {
		return bundleNumber;
	}

	public void setBundleNumber(int bundleNumber) {
		this.bundleNumber = bundleNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "" + formatCode + " " + bundleNumber + " @ $" + price;
	}
	
}

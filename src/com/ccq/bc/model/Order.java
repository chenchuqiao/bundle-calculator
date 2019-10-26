/**
 *  @ClassName Order
 *  @Description Define Order entity.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.model;

public class Order {
	
	private static final double INITIAL_PRICE = 0.0;
	
	private int number;
	private String formatCode;
	private double price;

	public Order(int number, String formatCode) {
		this.number = number;
		this.formatCode = formatCode;
		this.price = INITIAL_PRICE;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public String getFormatCode() {
		return formatCode;
	}
	
	public void setFormatCode(String formatCode) {
		this.formatCode = formatCode;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		if (price == INITIAL_PRICE) {
			return "" + number + " " + formatCode;
		} else {
			return "" + number + " " + formatCode + " " + price;
		}
	}
	
}

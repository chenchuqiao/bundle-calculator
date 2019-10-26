/**
 *  @ClassName OrderedBundles
 *  @Description Define OrderedBundles entity.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.model;

import com.ccq.bc.model.Bundle;

public class OrderedBundles {
	
	private Bundle bundle;
	private int number;
	private double price;
	
	public OrderedBundles(Bundle bundle, int number) {
		this.bundle = bundle;
		this.number = number;
		this.price = getTotalPirce();
	}
	
	public OrderedBundles() {
		// TODO Auto-generated constructor stub
	}

	private double getTotalPirce() {
		return number * bundle.getPrice();
	}

	public Bundle getBundle() {
		return bundle;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
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
		return "  " + number + " × " + bundle.getBundleNumber() + " $" +  price;
	}
	
	
	
}

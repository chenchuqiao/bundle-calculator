/**
 *  @ClassName Calculator
 *  @Description The key process of bundle calculator. Give orders and calculate the bundles that each order contains.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.biz;

import com.ccq.bc.dao.BundleDao;
import com.ccq.bc.model.Bundle;
import com.ccq.bc.model.Order;
import com.ccq.bc.model.OrderedBundles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Calculator {
	
	private static final double INITIAL_PRICE = 0.0;
	
	public HashMap<Order, List<OrderedBundles>> calculate(List<Order> orders) {
		
		if (orders == null || orders.isEmpty()) {
			return new HashMap<>();
		}
		
		HashMap<Order, List<OrderedBundles>> allOrderBundelsPairs= new HashMap<>();
		BundleDao bundleDao = new BundleDao();
		for(Order order : orders) {
			List<Bundle> bundles = getSubBundleDao(order, bundleDao.getBundles());
			List<OrderedBundles> orderedBundles = getOptimalOrderedBundles(order, bundles);
			setTotalPrice(order, orderedBundles);
			allOrderBundelsPairs.put(order, orderedBundles);
		}
		return allOrderBundelsPairs;
	}
	
	private List<OrderedBundles> getOptimalOrderedBundles(Order order, List<Bundle> bundles) {
		List<OrderedBundles> orderedBundles = new ArrayList<>();
		int maxNumbers = 0;
		int minBundles = 0;
		for (int i = 0; i < bundles.size() ; i ++) {
			List<OrderedBundles> currentOrderedBundles = getOrderedBundles(order.getNumber(), bundles.subList(i, bundles.size()));
			int totalNumbers = 0;
			int totalBundles = 0;
			for (OrderedBundles ob : currentOrderedBundles) {
				totalBundles += ob.getNumber();
				totalNumbers += ob.getNumber() * ob.getBundle().getBundleNumber();
			}
			if (totalNumbers > maxNumbers) {
				maxNumbers = totalNumbers;
				minBundles = totalBundles;
				orderedBundles = currentOrderedBundles;
			} else if (totalNumbers == maxNumbers && totalBundles < minBundles) {
				minBundles = totalBundles;
				orderedBundles = currentOrderedBundles;
			}
		}
		return orderedBundles;
	}
	
	private List<OrderedBundles> getOrderedBundles(int totalOrderNumber, List<Bundle> bundles) {
		List<OrderedBundles> orderedBundles = new ArrayList<>();		
		for(Bundle bundle : bundles) {
			if (totalOrderNumber >= bundle.getBundleNumber()) {
				int orderNumbers = totalOrderNumber / bundle.getBundleNumber(); 
				orderedBundles.add(new OrderedBundles(bundle, orderNumbers));
				totalOrderNumber -= orderNumbers * bundle.getBundleNumber();
			}
		}
		return orderedBundles;
	}
	
	private List<Bundle> getSubBundleDao(Order order, List<Bundle> bundleDao) {
		List<Bundle> bundles = new ArrayList<>();
		for (Bundle bundle : bundleDao) {
			if ((bundle.getFormatCode()).equals(order.getFormatCode())) {
				bundles.add(bundle);
			}
		}
		Collections.sort(bundles, new Comparator<Bundle>() {
			public int compare(Bundle h1, Bundle h2) {
				return ((Integer)h2.getBundleNumber()).compareTo(((Integer)h1.getBundleNumber()));
				}
			});
		return bundles;
	}
	
	private void setTotalPrice(Order order, List<OrderedBundles> orderedBundles) {
		double price = INITIAL_PRICE;
		for (OrderedBundles ob : orderedBundles) {
			price += ob.getPrice();
		}
		order.setPrice(price);
	}
}

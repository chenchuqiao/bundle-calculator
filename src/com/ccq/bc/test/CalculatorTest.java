package com.ccq.bc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.ccq.bc.biz.Calculator;
import com.ccq.bc.biz.Printer;
import com.ccq.bc.model.Order;
import com.ccq.bc.model.OrderedBundles;

public class CalculatorTest {

	public static void main(String[] args) {
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(10, "IMG"));
		orders.add(new Order(15, "FLAC"));
		orders.add(new Order(13, "VID"));
		
		Calculator calculator = new Calculator();
		HashMap<Order, List<OrderedBundles>> allOrderBundelsPairs = calculator.calculate(orders);
		
		for (Entry<Order, List<OrderedBundles>> entry : allOrderBundelsPairs.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}

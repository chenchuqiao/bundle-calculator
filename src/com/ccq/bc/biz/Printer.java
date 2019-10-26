/**
 *  @ClassName Printer
 *  @Description The output format of the orders and detailed bundles.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.biz;

import java.util.HashMap;
import java.util.List;

import com.ccq.bc.model.Order;
import com.ccq.bc.model.OrderedBundles;

public class Printer {

	public void print(List<Order> orders, HashMap<Order, List<OrderedBundles>> allPairs) {
		
		if (orders == null || orders.isEmpty()) {
			System.out.println("Printer get wrong orders.");
		}
		if (allPairs == null || allPairs.isEmpty()) {
			System.out.println("Printer get wrong allPairs.");
		}
		
		for (Order order : orders) {
			List<OrderedBundles> orderedBundles = allPairs.get(order);
			System.out.println(order);
			for (OrderedBundles orderedBundle : orderedBundles) {
				System.out.println(orderedBundle);
			}
		}
	}
}

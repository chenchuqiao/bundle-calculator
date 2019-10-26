/**
 *  @ClassName Main
 *  @Description Run the bundle calculator by using console as input and output.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.main;

import com.ccq.bc.biz.Calculator;
import com.ccq.bc.biz.Printer;
import com.ccq.bc.model.Order;
import com.ccq.bc.model.OrderedBundles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		
		String PATTERN = "([0-9]+)\\s(IMG|FLAC|VID)";
		List<Order> orders = new ArrayList<Order>();
		
		try (Scanner sc = new Scanner(System.in)) {
			String line;
			while(sc.hasNextLine() && ! (line = sc.nextLine()).isEmpty()) {
				Pattern pattern = Pattern.compile(PATTERN);
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches()) {
					String[] lineItems = line.split("\\s");
					orders.add(new Order(Integer.parseInt(lineItems[0]), lineItems[1]));
				} else {
					System.out.println("Wrong format input!\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Calculator calculator = new Calculator();
		HashMap<Order, List<OrderedBundles>> allOrderBundelsPairs = calculator.calculate(orders);
		Printer printer = new Printer();
		printer.print(orders, allOrderBundelsPairs);
	}

}

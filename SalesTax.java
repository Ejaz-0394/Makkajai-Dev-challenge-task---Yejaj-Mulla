package MakkajaiProblem1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;

//import com.sun.tools.classfile.Opcode.Set;

public class SalesTax {
	Scanner sc = new Scanner(System.in);
	Double price, total, calc = 0.0, finalbill = 0.0, totaltaxcharged = 0.0;
	int taxOnProduct;
	String s, product, cartproduct, input;
	Map<String, Integer> productList = new LinkedHashMap<String, Integer>();
	Map<String, Double> cart = new LinkedHashMap<String, Double>();
	ArrayList<String> list = new ArrayList<String>();
	DecimalFormat decimalFormat = new DecimalFormat("##.##");

	SalesTax() {

		productList.put("Box", 5);
		productList.put("Book", 0);
		productList.put("Music", 10);
		productList.put("Chocolate", 0);
		productList.put("Imported", 15);
		productList.put("Pills", 0);
		productList.put("Perfume", 10);
		

	}

	void getInput() {
		System.out.println("Input : ");

		boolean loop = true;
		while (loop) {
			input = sc.nextLine();
			s = input;
			if (s.equals("") || s.equals("pl exit")) {

				break;
			} else {

				createCart();

			}
		}

	}

	void createCart() {

		String priceS = s.substring(s.lastIndexOf("at") + 3);
		price = Double.parseDouble(priceS);

		Set plset = productList.entrySet();
		Iterator plitr = plset.iterator();
		s = s.toLowerCase();

		while (plitr.hasNext()) {

			Map.Entry plmentry = (Map.Entry) plitr.next();
			String pro = (String) plmentry.getKey();

			if (s.contains(pro.toLowerCase())) {

				cartproduct = (String) plmentry.getKey();
				cart.put(cartproduct, price);
				taxOnProduct = (int) plmentry.getValue();

				Set cartset = cart.entrySet();
				Iterator cartitr = cartset.iterator();

				if (taxOnProduct == 0) {
					total = price;
					String newinput = input.substring(0, input.length() - 5);
					newinput = newinput + ":";
					newinput += total;
					list.add(newinput);
				}

				else {

					calc = price * taxOnProduct / 100;

					calc = (double) Math.round(calc * 20) / 20;

					totaltaxcharged += calc;

					calc = Math.round(calc * 20.0) / 20.0;

					total = calc + price;

					String totals = String.format("%.2f", total);

					total = Double.parseDouble(totals);

					getProduct();
					while (cartitr.hasNext()) {
						Map.Entry cartentry = (Map.Entry) cartitr.next();

						if (cartentry.getKey() == product) {
							cartentry.setValue(total);

							String newinput = input.substring(0, input.length() - 5);
							String nv = String.format("%.2f", cartentry.getValue());
							nv = ":" + nv;

							newinput += nv;
							list.add(newinput);

						}
					}

				}

				break;
			}
		}

	}		

	void getProduct() {

		Set s1 = productList.entrySet();
		Iterator itr = s1.iterator();

		s = s.toLowerCase();

		while (itr.hasNext()) {
			Map.Entry m1 = (Map.Entry) itr.next();
			String pro = (String) m1.getKey();

			if (cartproduct.equals(pro)) { // (cartproduct == pro)

				product = (String) m1.getKey();

				taxOnProduct = (int) m1.getValue();

			}

		}

	}

	void showOutput() {
		System.out.println("Output :");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("Sales Taxes:" + String.format("%.2f", totaltaxcharged));
		System.out.println("Total:" + String.format("%.2f", finalbill));
	}

	void calculateTax() {
		Set s1 = cart.entrySet();
		Iterator itr = s1.iterator();
		while (itr.hasNext()) {
			Map.Entry m1 = (Map.Entry) itr.next();

			double tmp = (double) m1.getValue();
			finalbill = finalbill + tmp;

		}

	}

	public static void main(String[] args) {

		SalesTax salestax = new SalesTax();
		salestax.getInput();
		salestax.calculateTax();
		salestax.showOutput();

	}

}

package Conference;

import java.util.*;




public class SalesTax extends ProductDatabase {
	Scanner sc = new Scanner(System.in);
	//Double finalbill = 0.0, totaltaxcharged = 0.0;
	int taxOnProduct;
	String product;
	//static String s;
	
	
	SalesTax() {
			super();
			}

 void getInput() 
{
	 System.out.println("get input called");
		System.out.println("Input : ");

		boolean loop = true;
		while (loop) {
						input = sc.nextLine();
						s = input;
						if (s.equals("") || s.equals("pl exit")) 
						{
						  break;
						} else 
						{
							String priceS = s.substring(s.lastIndexOf("at") + 3);
							s = s.toLowerCase();
							try {
							price = Double.parseDouble(priceS);
							}catch(Exception e) {
								System.out.println("Wrong input!!!");
								System.exit(0);
							}
							getTaxOnProduct(s,price);
						}
					}
		}




	void showOutput() {
		
		System.out.println("Output :");
		for (int i = 0; i < list.size(); i++){System.out.println(list.get(i));} 
		System.out.println("Sales Taxes:" + String.format("%.2f", totaltaxcharged));
		System.out.println("Total:" + String.format("%.2f", finalbill));
					}
	
	public static void main(String[] args) {

		SalesTax salestax = new SalesTax();
		salestax.getInput();
		salestax.showOutput();

	}

}

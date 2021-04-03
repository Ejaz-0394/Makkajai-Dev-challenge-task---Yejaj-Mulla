package Conference;

public class Calculation {
	double price,total,finalbill=0.0,totaltaxcharged=0.0,calc=0.0;
	 int taxOnProduct;
	 

	public void calculateTax(double dd,int ii ){
		
		price=dd;
		taxOnProduct=ii;
		
	  	calc = price * taxOnProduct / 100;
	  	calc = (double) Math.round(calc * 20) / 20;
	  	totaltaxcharged += calc;
	  	total = calc + price;
	  	
  					}
}

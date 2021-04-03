package Conference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ProductDatabase extends Calculation{
	Map<String, Integer> productList = new LinkedHashMap<String, Integer>();
	ArrayList<String> list = new ArrayList<String>();
	String s,input;
	double price;
	
	ProductDatabase(){
		
		productList.put("Box", 5);
		productList.put("Book", 0);
		productList.put("Music", 10);
		productList.put("Chocolate", 0);
		productList.put("Imported", 15);
		productList.put("Pills", 0);
		productList.put("Perfume", 10);
	
	}
	
	public void getTaxOnProduct(String s,double price){
		s=s;
		price=price;
		
		Set plset = productList.entrySet();
		Iterator plitr = plset.iterator();
		while (plitr.hasNext()) 
	{
			Map.Entry plmentry = (Map.Entry) plitr.next();
			String pro = (String) plmentry.getKey();
			
		if (s.contains(pro.toLowerCase())) 
			{
			taxOnProduct = (int) plmentry.getValue();
			if (taxOnProduct == 0) 
				{
					total = price;
					addtoArrlist(total);
				}else {
					calculateTax(price, taxOnProduct);
				    addtoArrlist(total);
					   }  
				break;
			}
		}
	}
	
	void  addtoArrlist(Double dtotal){
		
	  	String newinput = s.substring(0, s.length() - 5);
	  	finalbill+=total;
		String ttlstr = String.format("%.2f",total);
		newinput = newinput + ":"+ttlstr;
		list.add(newinput);
		
	  							}
}

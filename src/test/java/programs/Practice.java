package programs;

import java.util.ArrayList;

import org.junit.Test;

public class Practice {
	
	
	@Test
	public void q() {
		
		System.out.println(example(1,333));
		System.out.println(example(1,2));
		System.out.println(example(1,6));

		
		
	}
	
	
	
	
	
	
	
	
	
	public String example(int numerator, int denominator) {
		  
		
		   double frac = Double.parseDouble(String.valueOf(numerator))/Double.parseDouble(String.valueOf(denominator));
	        
		   
		   
		   String text = String.valueOf(frac);
	        
	         String[] f = text.split("\\.");
	        
	       // System.out.println(text);
	        
	         if(f[1].equals("0"))
				text = f[0];
	         
	        
	        char[] ch = f[1].toCharArray();
	        
	        int count =0;
	        
	        String fr="",ans="";
	   
	   ArrayList<String> str = new ArrayList<String>();   
	        
	        for(int i=0;i<ch.length;i++){
	            
	        	if(!str.contains(String.valueOf(ch[i])))
	        	
	        	str.add(String.valueOf(ch[i]));
	        	
	        	else 
	        		count++;
	        		
	        	
	            if(count==str.size() && i==count+str.size()-1) {
	            	
	            	for(String a:str){
	            		
	            		ans+=a;
	            	}
	            	
	    	        fr = "(" + ans + ")";

	            	
	            	
	            	
	            }else if (str.get(str.size()-1).equals(String.valueOf(ch[i])) && str.size()==i){
	        		
                    for(int k=0;k<str.size()-1;k++)
                    {
                   	 fr+=str.get(k);
                    }
	        		ans =String.valueOf(ch[i]);
	        		fr += "(" + ans + ")";  
	        		return f[0]+ "." +fr;
	        	}
	        	
	            
	        }    
	        
	            
	        if(!fr.isEmpty())
	        return f[0]+ "." +fr;
	       
	        return text;
		
	}
	
	

}

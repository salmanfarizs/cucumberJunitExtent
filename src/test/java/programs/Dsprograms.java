package programs;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.Test;

public class Dsprograms {

	ArrayList<String> list = new ArrayList<String>();

	//@Test
	public void example() {

		String Pattern = "\\d{4}[abc]{1}\\d{4}";
		String text = "1234abc1234";
		System.out.println(match(text, Pattern));

	}

	private boolean match(String text, String pattern) {

		return Pattern.matches(pattern, text);

	}

	
	
	

	@Test
	public void count() {

		int nums[] = {3,0,6,2,4,7,0,0};
		System.out.println(count(nums));

	}

	private int count(int[] nums) {
		
		
		
	    
        int count =1;
        int max = 1;
    for(int i=0;i<nums.length-1;i++){
        
        if(nums[i+1]>nums[i]){
            count = count +1;
        
            
        }else {
            max = Math.max(max,count);;

            count=1;
        }
        
        
    }
        
        return Math.max(max,count);
        
        
        
		
		
		
		
		
		
		
		
		


	}
	
	
	
	
	
	
	
}

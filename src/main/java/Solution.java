import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public Solution(){
    }

    /**
     * Takes in an array of strings, and returns an array of answers
     * @param s - string input array
     * @return - array of int answers of how many powers of five fit into each string in the array
     */
    public int[] getMin(String[] s){
        int result[]=new int[s.length];
    	int k;
    	for(int i=0;i<s.length;i++)
    	{
    		k=find(s[i]);
    		result[i]=k;
    	}
    	
		return result;
    }

   private int find(String s) {
	   Integer i=0;
	   String temp;
	   BigInteger number,b2,b3;
	   
	   while(i<s.length())
	   {
		   if(s.charAt(i)=='0')
		   {
			   i++;
		   }
		   else
			   break;
	   }
	   
	   if(i!=0)
	   {
		   s=s.substring(i);
	   }
	   
	   if(s.equals(""))
	   {
		   return -1;
	   }
	   
	   number=new BigInteger(s, 2);
	   b2=new BigInteger("5");
	   b3=new BigInteger("1");
	   
	   i=b3.compareTo(number);
	   while(i==-1 || i==0)
	   {
		   if(i==0)
			   return 1;
		   b3=b3.multiply(b2);
		   i=b3.compareTo(number);
	   }
	   
	   
	   b2=new BigInteger("5");
	   b3=new BigInteger("1");
	   
	   i=b3.compareTo(number);
	   while(i==-1 || i==0)
	   {
		   temp=b3.toString(2);
		   if(Pattern.matches("("+temp+")*", s))
		   {
			   return temp.length();
		   }
		   b3=b3.multiply(b2);
		   i=b3.compareTo(number);
	   }
	   
	   return -1;
	}

   public static void main(String args[])
   {
	   String[] input = {"10110001101000101011110000101110110001010", "10110001101000101011110000101110110001011"};
	   new Solution().getMin(input);
	/*String s="101";
	boolean b3 = Pattern.matches("("+s+")*", "101101");  
	System.out.println(b3);*/
   }

    }



}
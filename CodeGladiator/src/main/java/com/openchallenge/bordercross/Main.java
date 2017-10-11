package com.openchallenge.bordercross;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int x = appearanceCount(4, 11, "cAda", "AbrAcadAbRa");
		int y = appearanceCount(4, 11, "MexIco", "MexIcobMexIcobFILbMexIcobMexIcobjMexIcobvMexIcobMexIcobMexIcobgMexIcobdMexIcobZVMexIcobMexIcobaMexIcob");
		// Sample output for x:2 & y:13
		System.out.println(x);
		System.out.println(y);
	}
	

	public static int appearanceCount(int input1,int input2,String input3,String input4) {
		int res = 0;
		List<String> glyphs = setTotList(new StringPermutation().permutationFinder(input3));
		List<String> sublist1 = null;
		List<String> sublist2 = null;
		List<String> sublist3 = null;
		List<String> sublist4 = null;
		List<String> sublist5 = null;
		
		Integer counter1 = new Integer(0);
		Integer counter2 = new Integer(0);
		Integer counter3 = new Integer(0);
		Integer counter4 = new Integer(0);
		Integer counter5 = new Integer(0);
		
		int diff = glyphs.size()/5;
		sublist1 = glyphs.subList(0, diff-1);
		sublist2 = glyphs.subList(diff, (2*diff)-1);
		sublist3 = glyphs.subList((2*diff), (3*diff)-1);
		sublist4 = glyphs.subList((3*diff), (4*diff)-1);
		sublist5 = glyphs.subList((4*diff), glyphs.size()-1);
		
		Thread t1 = new Thread(new GlyphsCalculatorThread(sublist1, input4, counter1), "Thread1");
		Thread t2 = new Thread(new GlyphsCalculatorThread(sublist2, input4, counter2), "Thread2");
		Thread t3 = new Thread(new GlyphsCalculatorThread(sublist3, input4, counter3), "Thread3");
		Thread t4 = new Thread(new GlyphsCalculatorThread(sublist4, input4, counter4), "Thread4");
		Thread t5 = new Thread(new GlyphsCalculatorThread(sublist5, input4, counter5), "Thread5");
		
		t1.start();t2.start();t3.start();t4.start();t5.start();
		
		res = counter1 + counter2 + counter3 + counter4 + counter5; 
		return res;
    }
	
    private static List<String> setTotList(Set<String> set) {
    	Iterator<String> it = set.iterator();
    	List<String> list = new ArrayList<>();
    	while(it.hasNext())
    		list.add(it.next());
    	return list;
    }
}

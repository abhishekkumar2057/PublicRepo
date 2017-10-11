package com.openchallenge.bordercross;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CandidateCode {

	public static int appearanceCount(int input1,int input2,String input3,String input4) {
		int res = 0;
		
		Set<String> glyphs = permutationFinder(input3);
		/*Iterator<String> it = glyphs.iterator();
		//int count = 0;
		while(it.hasNext()) {
			String target = input4;
			String token = it.next();
			if(target.contains(token)) {
				target = target.replaceAll(token, "0");
			}
			if(target.charAt(target.length()-1)=='0')
				target = target.concat("x");
			res += target.split("0").length-1;
		}*/
		String target = input4;
		List<String> data = glyphs
						.stream()
						.filter(s -> input4.contains(s))
						.collect(Collectors.toList());
		for(String s : data) {
			target = target.replaceAll(s, "0");
			if(target.charAt(target.length()-1)=='0')
				target = target.concat("x");
			res += target.split("0").length-1;
		}
		return res;
    }
	
	public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
    
	public static void main(String[] args) {
		int x = appearanceCount(4, 11, "cAda", "AbrAcadAbRa");
		int y = appearanceCount(4, 11, "MexIco", "MexIcobMexIcobFILbMexIcobMexIcobjMexIcobvMexIcobMexIcobMexIcobgMexIcobdMexIcobZVMexIcobMexIcobaMexIcob");
		// Sample output for x:2 & y:13
		System.out.println(x);
		System.out.println(y);
	}
}

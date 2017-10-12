package com.openchallenge.magicsquare;

public class CandidateCode {
/*
	public static int solveMagicSquare(int[][] input1) {
        int res = 0;
        int len = input1[0].length;
        int[][] solution = Arrays.copyOf(input1, len);
        List<String> permutations = setTotList(permutationFinder(numToString(len)));
        //Set<String> permutations = permutationFinder(numToString(len));
        for(int i=0; i<len; i++)
        	solution[i] = stringToIntArray(permutations.get(i));
        for(int i=len; i<permutations.size(); i++) {
        	if(valid(solution)) {
        		break;
        	}
        	solution[i] = stringToIntArray(permutations.get(i));
        	
        }
        return res;
    }
	
	private static boolean valid(int[][] arr) {
		boolean flag = false;
		
		return flag;
	}
	
	private static Set<String> permutationFinder(String str) {
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

	private static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
    
    private static String numToString(int n) {
    	StringBuffer sb = new StringBuffer();
    	for(int i=65; i<(n+65); i++) {
    		sb.append((char)i);
    	}
    	
    	return sb.toString();
    }
    
    private static int[] stringToIntArray(String str) {
    	int[] arr = new int[str.length()];
    	for(int i=0; i<str.length(); i++) {
    		arr[i] = (int)str.charAt(i) - 64;
    	}
    	return arr;
    }
    
    private static int arrayAdder(int[] arr) {
    	int sum = 0;
    	for(int i : arr)
    		sum += i;
    	return sum;
    }
    
    private static List<String> setTotList(Set<String> set) {
    	Iterator<String> it = set.iterator();
    	List<String> list = new ArrayList<>();
    	while(it.hasNext())
    		list.add(it.next());
    	return list;
    }*/
}

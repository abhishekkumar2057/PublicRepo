package com.openchallenge.jailbreak;

/**
 * PROBLEM STATEMENT
 * THERE IS A PRISONER IN THE JAIL. HE CAN JUMP UPTO HEIGHT 'h' METERS. AFTER THE JUMP HE SLIPS DOWN 'n' METERS.
 * THERE ARE COUPLE OF WALLS HE NEED TO JUMP. ONCE CROSSING ALL THE WALLS, THEN ONLY HE CAN ESCAPE.
 * CALCULATE MINIMUM NUMBER OF JUMPS REQUIRED FOR THE PRISONER TO CROSS THE WALL. THE API METHOD ACCEPTS THREE
 * ARGUMENTS FIRST ARGUMENT IS THE HIGHEST JUMP HE CAN MAKE, SECOND ARGUMENT IS THE VALUE HE SLIPS DOWN AND
 * THIRD ARGUMENT IS THE INTEGER ARRAY WHICH CONSISTS THE WALL INFORMATION, i.e., WALLS WITH HEIGHT.
 * 
 * TEST
 * CASE 1: ARGUMENTS ARE 10, 1, {10}. PRISONER CAN JUMP UP TO 10 METERS, HE SLIPS DOWN BY 1 METER AND ONLY ONE
 * WALL IS THERE OF HEIGHT 10 METERS. SO, IN ONLY ONE JUMP HE CAN ESCAPE.
 * 
 * CASE 2: ARGUMENTS ARE 5, 1, {9, 10}. PRISONER CAN JUMP UP TO 5 METERS, HE SLIPS DOWN BY 1 METER AND TWO
 * WALL ARE THERE OF HEIGHT 9 & 10 METERS RESPECTIVELY. SO, IN TOTAL 5 JUMPS HE CAN ESCAPE.
 */

/**
 * @author Abhishek Kumar
 * The Class CandidateCode.
 */
public class CandidateCode {

    /**
     * Gets the jump count.
     *
     * @param input1 the input 1
     * @param input2 the input 2
     * @param input3 the input 3
     * @return the jump count
     */
    public static int getJumpCount(int input1,int input2,int[] input3) {
        int totalAttempts = 0;
        
        if(input1 <= input2) {
        	totalAttempts = Integer.MAX_VALUE;
        } else {
        	for(int wallHeight : input3) {
        		//int height = (wallHeight - input2);
            	totalAttempts += Math.round(Math.ceil((double)(wallHeight - input2)/(input1 - input2)));
            	if((wallHeight - input2)%(input1-input2) > 0)
            		totalAttempts += 1;
        	}
        }
        
		return totalAttempts;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    	//int[] walls = {10};
    	int[] walls = {9, 10};
    	//int x = getJumpCount(10, 1, walls);
    	long start = System.nanoTime();
		int x = getJumpCount(5, 1, walls);
		long end = System.nanoTime();
		System.out.println(x);
		System.out.println((end-start));
	}
}

/**
 * 
 */
package com.omototest.algorithms;

/**
 * @author Atrijit
 *
 */
public class AlgorithmTest {
	int [] inputArr;
	
	/**
	 * 
	 */
	public AlgorithmTest() {
		inputArr = new int[6];
		inputArr[0] = 1;
		inputArr[1] = 2;
		inputArr[2] = 3;
		inputArr[3] = 4;
		inputArr[4] = 5;
		inputArr[5] = 4;
	}
	
//	Find out duplicate number between 1 to N numbers.
	public void findDuplicateNumber(){
		int highestNumber = inputArr.length - 1;
		int sum = 0;
        for(int i = 0; i < inputArr.length ; i++){
            sum += inputArr[i];
        }
        int duplicate = sum - (highestNumber*(highestNumber+1)/2);
		System.out.println("\n Duplicate Number : "+duplicate);
	}
	
	//Write a program to create deadlock between two threads.
	public void createDeadLock(){
		final String str1 = "Customer";
		final String str2 = "Guru";
		Thread thrd1 = new Thread("Thread1"){
		public void run(){
			while(true){
				synchronized(str1){
					synchronized(str2){
						System.out.println(str1 + str2);
						}
					}
				}
			}
		};
		Thread thrd2 = new Thread("Thread2"){
		public void run(){
			while(true){
				synchronized(str2){
					synchronized(str1){
						System.out.println(str2 + str1);
						}
					}
				}
			}
		};
		thrd1.start();
		thrd2.start();
	}
	
	//Write a program to find the given number is Armstrong number or not.
	public void isArmstrongNumber(int number){
		int temp = number ;
		int sum = 0 ;
		while(temp != 0) {
			int lastDigit = temp % 10;
			sum += lastDigit * lastDigit * lastDigit;
			temp /= 10;
		}
		if(sum == number) {
			System.out.println("\n" + number + "  is Armstrong number\n");
		}
		else {
			System.out.println("\n" + number + "  is not an Armstrong number\n");
		}
	}
	
	//Write a program to convert string to number without using Integer.parseInt() method.
	public void convertStringtoNumber(){
		String input = "12302";
		int num = 0;
		for(int i = 0 ; i < input.length(); i++) {
			int val = input.charAt(i);
			if(val >= 48 && val <= 57 ) {
				num = num * 10 + (val - 48);
			}
			else {
				throw new NumberFormatException("Number is not convertable");
			}
		}
		System.out.println("Number after conversion is -- "+ num);
	}
	
	//Get distinct elements from an array by avoiding duplicate elements.
	public static void printDistinctElements(int[] arr){ 
		for(int i=0;i<arr.length;i++){
            boolean isDistinct = false;
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct){
                System.out.print(arr[i]+" ");
            }
        }
	}
	
	//Write a program to swap or exchange two numbers. You should not use any temporary or third variable to swap.
	public void swapTwoNumbers(int x, int y) {
		x = x + y;  
		y = x - y;  
		x = x - y; 
		System.out.print("x = "+x);
		System.out.print("y = "+y);
	}
	
	//Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	//For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the problem constraint.
	public void minSubArrayLen(int s, int[] nums) {
		int arrLength = nums.length ;
		int minLength = arrLength + 1;
 
    	for (int start=0; start < arrLength; start++) {
			int curr_sum = nums[start];
			if(curr_sum > s) {
				System.out.print("min length  = 1");
				return;
			}
			for (int end=start+1; end < arrLength; end++)	{
				curr_sum += nums[end];
				if (curr_sum > s && (end - start + 1) < minLength)
					minLength = (end - start + 1);
			}
		} 
		System.out.print("min length  = "+minLength);
	}
	
	/*
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	For example, given the following matrix:
             [
                  [ 1, 2, 3 ],
                  [ 4, 5, 6 ],
                  [ 7, 8, 9 ]
             ]
             You should return [1,2,3,6,9,8,7,4,5].
	 */
	public void spiralOrder(int[][] matrix,int m,int n) {
		int i;
		int k = 0;
		int l = 0;
 
 
		while (k < m && l < n) 
		{
			for (i = l; i < n; ++i)
			{
				System.out.println(matrix[k][i]);
			}
			k++;
	 
			for (i = k; i < m; ++i)
			{
				System.out.println(matrix[i][n-1]);
			}
			n--;
	 
			if ( k < m)
			{
				for (i = n-1; i >= l; --i)
				{
					System.out.println(matrix[m-1][i]);
				}
				m--;
			}
	 
			if (l < n)
			{
				for (i = m-1; i >= k; --i)
				{
					System.out.println(matrix[i][l]);
				}
				l++;    
			}        
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n In main ........... \n");
		AlgorithmTest test = new AlgorithmTest();
		
		System.out.println("\nFind Duplicate Number ........... \n");
		test.findDuplicateNumber();
		
		System.out.println("\n\nCheck Armstrong number ........... \n");
		test.isArmstrongNumber(153);
		
		System.out.println("\nString to Number Conversion........... \n");
		test.convertStringtoNumber();
		
		System.out.println("\n\nPrint Distinct Numbers ........... \n");
		int[] nums = {4,2,4,2,4,1,9,2,3};
		printDistinctElements(nums);
		
		System.out.println("\n\nSwap Numbers ........... \n");
		test.swapTwoNumbers(10,15);
		
		System.out.println("\n\nMinimum Subarray ........... \n");
		int[ ] aryNums = { 3, 10, 7, 2 , 5};
		test.minSubArrayLen(9,aryNums);
	
		System.out.println("\n\nCreate Deadlock Condition ........... \n");
		//test.createDeadLock();
	
		System.out.println("\n\nSpiral Order Traversal ........... \n");
		int a[][] = { { 1, 2, 3 }, { 4,5,6 },{ 7,8,9 } };
		test.spiralOrder(a,3,3);

	}

}

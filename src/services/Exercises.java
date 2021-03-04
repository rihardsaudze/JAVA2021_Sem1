package services;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Exercises {
	
	public static void exer0() {
		String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
		int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
		
		for (int i = 0; i < names.length; i++) {
			System.out.println("["+names[i]+", "+times[i]+"]");
		}
	}
	
	public static double positionCalc(double gravity, double initialVelocity, double initialPosition, double fallingTime) {
		return 0.5 * gravity * fallingTime*fallingTime + initialVelocity * fallingTime + initialPosition;
	}
	
	public static int factorialForLoop(int N) {
		if (N < 0) {
			return 0;
		}
		int result = N;
		for (N=N-1; N > 1; N--) {
			result *= N;
		}
		return result;
	}
	
	public static int factorialRecursive(int N) {
		if (N < 0) {
			return 0;
		}
	    if (N >= 1)
	        return N * factorialRecursive(N - 1);
	    else
	        return 1;
	}
	
	public static double[] generateArray(int N, double lower, double upper) {
		double[] array = new double[N];
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			array[i] = lower + rand.nextDouble() * (upper - lower);
		}
		return array;
	}
	
	public static double getMean(double[] array) {
		double result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		return result/array.length;
	}
	
	public static double getMin(double[] array) {
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	public static double getMax(double[] array) {
		double max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	public static double[] arraySort(double[] array) {
	    int n = array.length; 
	    for (int i = 0; i < n - 1; i++) { 
	        for (int j = 0; j < n - i - 1; j++) { 
	            if (array[j] > array[j + 1]) {  
	                double temp = array[j]; 
	                array[j] = array[j + 1]; 
	                array[j + 1] = temp; 
	            } 
	        }
	    }
	    return array;
	}
	
	public static double[][] generateMatrix(int N) {
		double[][] matrix = new double[N][N];
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = rand.nextDouble();
			}
		}
		return matrix;
	}
	
	public static double getProduct(double[][] matrix, int i, int j) {
		double result = 0;
		for (int k = 0; k < matrix[0].length; k++) {
			result += matrix[i][k] * matrix[k][j];
		}
		return result;
	}
	
	public static double[] coinFlip(int N) {
		double[] result = new double[3];
		Random rand = new Random();
		double flip;
		for (int i = 0; i < N; i++) {
			flip = rand.nextDouble();
			if (flip > 0.5) {
				result[0] += 1;
			} else {
				result[1] += 1;
			}
		}
		result[2] = result[0] / result[1];
		return result;
	}
	
	public static int[] rollDice(int N) {
		int[] result = new int[6];
		Random rand = new Random();
		int flip;
		for (int i = 0; i < N; i++) {
			flip = rand.nextInt(6) + 1;
			result[flip-1] += 1;
		}
		return result;
	}	
	
	public static int roll2Dices() {
		int tries = 0, dice1 = 0, dice2 = 0;
		Random rand = new Random();
		while(true) {
			tries++;
			dice1 = rand.nextInt(6) + 1;
			dice2 = rand.nextInt(6) + 1;
			if (dice1 + dice2 == 12) {
				break;
			}
		}
		return tries;
	}
	
	public static String getTextFromBytes(byte[] array) {
		return new String(array);
	}
	
	public static String pascalsTriangle(int level) {
		String result = new String();      
		result += "[1, ";
		for (int i = 1; i < level; i++) {
			int res = factorialForLoop(level) / (factorialForLoop(i) * factorialForLoop(level - i));
		    result += "" + res + ", ";
		}        
		result += "1]";
        return result; 
	}

	public static double executeStringEquation(String inputEquation) {
		double res = 0;
		char c = 0;			//current char from string
		boolean orderImportant = false;		//true when multiplication/division is required
		int len = inputEquation.length(), oldindex, i, numLen = 0, numsIndex = 0, signIndex = 0;
		int[] nums = new int[len/2+1];		//array of numbers from string
		char[] signs = new char[len/2];		//array of signs from string
		
		for (i=0; i < len; i++) {			//parse string
		    c = inputEquation.charAt(i);
		    if (c < '0' || c > '9') {		//if current char not a number
		        signs[signIndex] = c;		
		        signIndex++;
		        continue;
		    }
		    numLen = 1;
		    oldindex = i;
		    while(i < len-1) {				//read length of number
		    	c = inputEquation.charAt(i+1);
		    	if (c >= '0' && c <= '9') {
		    		numLen++;
		    		i++;
		    	} else {
		    		break;
		    	}
		    }
		    i = oldindex;
		    for (int j=numLen-1; j >= 0; j--) {		//calculate number from number string length
		    	nums[numsIndex] += (int)((inputEquation.charAt(i) - '0') * Math.pow(10, j));
		    	i++;
		    }
		    i--;
		    numsIndex++;
		}
		//PARSING DONE, STARTING CALCULATIONS
		
		for (i=0; i < signs.length; i++) {		//check if equation contains multiplication/division
		    if (signs[i] == '*' || signs[i] == '/') {
		        orderImportant = true;
		        break;
		    }
		}
		
		if(orderImportant==false) {				//CALCULATE
    		res = nums[0];
    		for (i=0; i < nums.length-1; i++) {
    		    if (signs[i] == '+') {
    		        res += nums[i+1];
    		    } else {
    		        res -= nums[i+1];
    		    }
    		}
		} else {
		    if (signs[i] == '*') {
		        res = nums[i] * nums[i+1];
		        nums[i] = 0;
		        nums[i+1] = 0;
		        signs[i] = '+';
		    } else {
		        res = nums[i] / nums[i+1];
		        nums[i] = 0;
		        nums[i+1] = 0;
		        signs[i] = '+';
		    }
		    res += nums[0];
		    for (i=0; i < nums.length-1; i++) {
    		    if (signs[i] == '+') {
    		        res += nums[i+1];
    		    } else if (signs[i] == '-') {
    		        res -= nums[i+1];
    		    }
    		}
		}
		
		return res;
	}
	
	public static String setOperations(String input) {
		String result = "";
		int i;
		ArrayList<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>(), arrResult = new ArrayList<>();
		char c, mode = 0;
		
		for (i = 0; i < input.length(); i++) {			// fill up 1st array with values and detect mode
			c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				arr1.add(c - '0');
			} else if (c == '+' || c == '-' || c == '*') {
				mode = c;
				break;
			}
		}
		
		for ( ; i < input.length(); i++) {			// fill up 2nd array with values
			c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				arr2.add(c - '0');
			}
		}
		System.out.println(arr1);
		System.out.println(arr2);
		System.out.println(mode);
		if (mode == '+') {
			arrResult.add(arr1.get(0));
			for (i = 1; i < arr1.size(); i++) {
				if (arrResult.contains(arr1.get(i))) {
					continue;
				} else {
					arrResult.add(arr1.get(i));
				}
			}
			//System.out.println(arr1);
			for (i = 0; i < arr2.size(); i++) {
				if (arrResult.contains(arr2.get(i))) {
					continue;
				} else {
					arrResult.add(arr2.get(i));
				}
			}
			arrResult.sort(null);
		} else if (mode == '-') {
			arrResult.add(arr1.get(0));
			for (i = 1; i < arr1.size(); i++) {
				if (arr2.contains(arr1.get(i))) {
					continue;
				} else {
					arrResult.add(arr1.get(i));
				}
			}
			for (i = 0; i < arr2.size(); i++) {
				if (arr1.contains(arr2.get(i))) {
					continue;
				} else {
					arrResult.add(arr2.get(i));
				}
			}
		} else if (mode == '*') {
			for(i = 0; i < arr1.size(); i++) {
				if(arr2.contains(arr1.get(i))) {
					arrResult.add(arr1.get(i));
				}
			}
		}
		//System.out.println(arr2);
		result += "[" + arrResult.get(0);
		for(i = 1; i < arrResult.size(); i++) {
			result += ", " + arrResult.get(i); 
		}
		result += "]";
		return result;
	}
	
}

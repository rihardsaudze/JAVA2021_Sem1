package services;

public class HelloWorld {

	public static void main(String[] args) {		
		//Exercises.exer0();												//0
		
		//System.out.println(Exercises.positionCalc(-9.81, 0, 0, 10));		//1
		
		//System.out.println(Exercises.factorialForLoop(5));				//2.1
		//System.out.println(Exercises.factorialRecursive(5));				//2.2
		
		//double[] genArray = Exercises.generateArray(5, 10, 20);			//3.1
		//for (int i = 0; i < 5; i++) {
		//	System.out.print(genArray[i]+" ");								
		//}
		//System.out.println("\nMin: "+Exercises.getMin(genArray));			//3.2
		//System.out.println("Max: "+Exercises.getMax(genArray));			//3.3
		//System.out.println("Mean: "+Exercises.getMean(genArray));			//3.4
		//double[] sortedArray = Exercises.arraySort(genArray);				//3.5
		//for (int i = 0; i < 5; i++) {
		//	System.out.print(sortedArray[i]+" ");								
		//}
		
		//double[][] genMatrix = Exercises.generateMatrix(5);				//4.1
		//for (int i = 0; i < 5; i++) {
		//	for (int j = 0; j < 5; j++) {
		//		System.out.print(genMatrix[i][j]+" ");
		//	}
		//	System.out.println("");
		//}
		//double dotProduct = Exercises.getProduct(genMatrix, 2, 4);		//4.2
		//System.out.println("Dot product (2;4): "+dotProduct);
		
		//double[] result = Exercises.coinFlip(100);						//5.1
		//System.out.println("Heads: "+result[0]+"\nTails: "+result[1]+"\nRatio (h/t): "+result[2]);
		//int[] result = Exercises.rollDice(100);							//5.2
		//for (int i = 0; i < 6; i++) {
		//	System.out.println((i+1)+" : "+result[i]);
		//}
		//int result = Exercises.roll2Dices();								//5.3
		//System.out.println("Tries to get a 6&6 roll: "+result);
		
		//byte[] array = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101,32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
		//System.out.println(Exercises.getTextFromBytes(array));			//6
		
		//System.out.println(Exercises.pascalsTriangle(6));					//7
		
		//System.out.println(Exercises.executeStringEquation("20+5*2+70"));	//8
		
		System.out.println(Exercises.setOperations("[1, 2, 3, 4, 5, 6] * [3, 4, 5]"));
	}
}

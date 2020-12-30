package chapter3.basiccalc;

public class BasicCalculator {
	private static int[] tempVars; //act as an array of temp. variables 
	private static int result;
	
	public void add(int n) {
		result += n; 
	}
	
	public void subtract(int n) {
		result -= n;
	}
	
	public void addResultToTempAt(int index) {
		tempVars[index] = result; //BUG: tempVars was not initialized properly
	}
	
	public void squareRoot(int n) {
		//not implemented yet
	}
	
	public void divide(int n) {
		result /= n;
	}
	
	public void multiply(int n) {
		result *= n;
	}
	
	public void clear() {
		result = 0;
	}
	
	public void clearTemps() {
		for (int i =0; i < tempVars.length; i++) {
			tempVars[i] = 0;
		}
	}
	
	public int getResult() {
		return result;
	}

	public int[] getTemps() {
		return tempVars;
	}

}

package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {

	if( a > 0 && b > 0 ) {
		return a + b;
		
	} else { 
		throw new IllegalArgumentException  ("Both parameters must be positive!");
		
	}
	}
	


	
		

	public int addThreeToNumber(int e) {
		if( e > 0 ) {
			return e + 3;
			
		} else { 
			throw new IllegalArgumentException  ("Both parameters must be positive!");
			
		}
	}

	public int getRandomInt() {
	    Random random = new Random();

	    return random.nextInt(10) + 1;

			
	}

	public int randomNumberSquared() {
//		Random random = new Random();
        int number = getRandomInt();
        return number * number; // Returns the square of the number
    
	}
	
	
}


package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;



import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.promineotech.TestDemo;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	
	

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")


	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {

			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);

			} else {
				assertThatThrownBy(() ->

		    testDemo.addPositive(a, b))

		        .isInstanceOf(IllegalArgumentException.class);
			}
	}
	
	
	void assertThatNumberPlusThree (int e, int expected , boolean expectException){
		
		if(!expectException) {

			  assertThat(testDemo.addThreeToNumber(e)).isEqualTo(expected);

			} assertThatThrownBy(() ->

		    testDemo.addThreeToNumber(e))

		        .isInstanceOf(IllegalArgumentException.class);}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(-5, 4, -1, true),
				arguments(-5, 4564, 4559, true),
				arguments(0, 0, 0, true),
				arguments(5, 78, 83, false),
				arguments(-2, -5, -7, true)
				);
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);

		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		
	}
	
	@Test
	void assertThatNumberPlusThree() {
		assertThat(testDemo.addThreeToNumber(4)).isEqualTo(7);
		assertThat(testDemo.addThreeToNumber(5)).isEqualTo(8);
		assertThat(testDemo.addThreeToNumber(97)).isEqualTo(100);

	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);

	}
	

}

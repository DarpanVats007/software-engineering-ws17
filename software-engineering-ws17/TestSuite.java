import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {
	
	@Test
	public static void converterSingletonTest() {
		
		/**  Exercise 4:  
		 *   TEST : if anticipated Converter subclass Object null:
		 *			[null -> expected appropriate Converter subclass Object] 
		 *			and assert not null where; assertNotNull causes Test case to fail. IF NULL
		 * 
		 *******************************************************************************************/
		String stringInstance_1  = "KilometersToMiles";
		String stringInstance_2 = "OuncesToGrams";

		UnitConverter converterInstance_1 = ConverterFactory.getInstance(stringInstance_1);
		assertNotNull(converterInstance_1);
		
		/**  Exercise 4:  
		 *   TEST : if anticipated Converter subclass Object has been instantiated and not null:
		 *			[retain current Object]
		 *			and assert same where; assertSame causes Test case to fail. IF OBJECTS ARE NOT THE SAME
		 * 
		 *******************************************************************************************/	
		UnitConverter converterInstance_2 = ConverterFactory.getInstance(stringInstance_2);
		assertSame(converterInstance_1, converterInstance_2);
	}
	
	
	/**  Exercise 4: 
	 *   ConverterFactory Testing  
	 *   
	 *   TEST : createConverter(String newConverterType) 
	 *          is tested with a string as an input, and is expected to return an object 
	 *          of the appropriate Converter subclass (**specified by the string key input)
	 * 
	 *******************************************************************************************/
	@Test
	public static void converterFactoryTest() {

		String case_1 = "KilometersToMiles";
		String case_2 = "MilesToKilometers";	
		String case_3 = "DollarToEuro";
		String case_4 = "EuroToDollar";		
		String case_5 = "GramsToOunces";
		String case_6 = "OuncesToGrams";
		String case_7 = "300";
		String case_8 = "cash converter";
		String case_9 = "3000*@$asx%^%&*";
	
		UnitConverter converterCase_1 = ConverterFactory.createConverter(case_1);
		UnitConverter converterCase_2 = ConverterFactory.createConverter(case_2);
		UnitConverter converterCase_3 = ConverterFactory.createConverter(case_3);
		UnitConverter converterCase_4 = ConverterFactory.createConverter(case_4);
		UnitConverter converterCase_5 = ConverterFactory.createConverter(case_5);
		UnitConverter converterCase_6 = ConverterFactory.createConverter(case_6);
		UnitConverter converterCase_7 = ConverterFactory.createConverter(case_7);
		UnitConverter converterCase_8 = ConverterFactory.createConverter(case_8);
		UnitConverter converterCase_9 = ConverterFactory.createConverter(case_9);

		/** Exercise 4:  
		 *  TEST : assertNotNull 
		 *   
		 *   		If  an object of an appropriate  Converter subclass is returned
		 *          the converter object will not be null.
		 *          
		 *          assertNotNull causes Test case to fail. IF NULL
		 * 
		 *******************************************************************************************/		
		assertNotNull(converterCase_1);
		assertNotNull(converterCase_2);
		assertNotNull(converterCase_3);
		assertNotNull(converterCase_4);
		assertNotNull(converterCase_5);
		assertNotNull(converterCase_6);		
		
		/** Exercise 4:   
		 *  TEST : assertNull 
		 *   
		 *   		No object is returned for object unspecified string arguments
		 *          in this case, assertNull causes Test case to fail. IF NOT NULL
		 * 
		 *******************************************************************************************/	
		assertNull(converterCase_7);
		assertNull(converterCase_8);
		assertNull(converterCase_9);
	}
	
	
	/**
	 * • Exercise 2: Converter Test Cases
	 * 
	 *******************************************************************************************/
	@Test 
	public static void toGramstest() {
		MassConverter case_1 = new OuncesToGramsConverter();
		MassConverter case_2 = new OuncesToGramsConverter();
		MassConverter case_3 = new OuncesToGramsConverter();
						
		double result_1 = case_1.convert(1);
		assertEquals(28.3495, result_1,0.0001);
		
		double result_2 = case_2.convert(0);
		assertEquals(0, result_2, 0.1);
		
		double result_3 = case_3.convert(-1);
		assertEquals(-28.3495, result_3, 0.0001);		

	}
	
	@Test
	public static void toOuncestest() {
		MassConverter case_1 = new GramsToOuncesConverter();
		MassConverter case_2 = new GramsToOuncesConverter();
		MassConverter case_3 = new GramsToOuncesConverter();
		MassConverter case_4 = new GramsToOuncesConverter();
						
		double result_1 = case_1.convert(1);
		assertEquals(0.035274, result_1,0.001);
		
		double result_2 = case_2.convert(0);
		assertEquals(0, result_2, 0.1);
		
		double result_3 = case_3.convert(-1);
		assertEquals(-0.035274, result_3, 0.000001);
		
		double result_4 = case_4.convert(100000000);
		assertEquals(3527400, result_4, 0.1);
	}
	
	@Test
	public static void toKilometerstest() {
		LengthConverter case_1 = new MilesToKilometersConverter();
		LengthConverter case_2 = new MilesToKilometersConverter();
		LengthConverter case_3 = new MilesToKilometersConverter();
		LengthConverter case_4 = new MilesToKilometersConverter();
						
		double result_1 = case_1.convert(1);
		assertEquals(1.60934, result_1,0.00001);
		
		double result_2 = case_2.convert(0);
		assertEquals(0, result_2, 0.00001);
		
		double result_3 = case_3.convert(-1);
		assertEquals(-1.60934, result_3, 0.00001);
		
		double result_4 = case_4.convert(100000000);
		assertEquals(160934000, result_4, 0.00001);

	
	}
	@Test
	public static void toMilestest() {
		LengthConverter case_1 = new KilometersToMilesConverter();
		LengthConverter case_2 = new KilometersToMilesConverter();
		LengthConverter case_3 = new KilometersToMilesConverter();
		LengthConverter case_4 = new KilometersToMilesConverter();
						
		double result_1 = case_1.convert(1);
		assertEquals(0.621371, result_1,0.000001);
		
		double result_2 = case_2.convert(0);
		assertEquals(0, result_2, 0.000001);
		
		double result_3 = case_3.convert(-1);
		assertEquals(-0.621371, result_3, 0.000001);
		
		double result_4 = case_4.convert(100000000);
		assertEquals(62137100, result_4, 0.000001);
	}
	
	@Test
	public static void toDollar_test() {
		CurrencyConverter case_1 = new EuroToDollarConverter();
		CurrencyConverter case_2 = new EuroToDollarConverter();
		CurrencyConverter case_3 = new EuroToDollarConverter();
		CurrencyConverter case_4 = new EuroToDollarConverter();
						
		double result_1 = case_1.convert(1);
		assertEquals(1.1765, result_1,0.0001);
		
		double result_2 = case_2.convert(0);
		assertEquals(0, result_2, 0.0001);
		
		double result_3 = case_3.convert(-1);
		assertEquals(-1.1765, result_3, 0.0001);
		
		double result_4 = case_4.convert(100000000);
		assertEquals(117650000, result_4, 0.0001);		
	 
	}
	@Test
	public static void toEuro_test() {
		CurrencyConverter case_1 = new DollarToEuroConverter();
		CurrencyConverter case_2 = new DollarToEuroConverter();
		CurrencyConverter case_3 = new DollarToEuroConverter();
		CurrencyConverter case_4 = new DollarToEuroConverter();
						
		double result_1 = case_1.convert(1);
		assertEquals(0.85, result_1,0.0001);
		
		double result_2 = case_2.convert(0);
		assertEquals(0, result_2, 0.0001);
		
		double result_3 = case_3.convert(-1);
		assertEquals(-0.85, result_3, 0.0001);
		
		double result_4 = case_4.convert(100000000);
		assertEquals(85000000, result_4, 0.0001);
	
	}

}

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * • This Converter Factory encapsulates converter creation: - enabling dynamic
 *   instantiation - while providing a single (factory) to implement logic
 * 
 *******************************************************************************************/
public class ConverterFactory {

	protected ConverterFactory() {
	}

	private static HashMap<String, UnitConverter> converterMap = new LinkedHashMap<>();

	public static UnitConverter createConverter(String newConverterType) {

		UnitConverter converter = null;

		converterMap.put("DollarToEuro", new DollarToEuroConverter());
		converterMap.put("EuroToDollar", new EuroToDollarConverter());
		converterMap.put("GramsToOunces", new GramsToOuncesConverter());
		converterMap.put("OuncesToGrams", new OuncesToGramsConverter());
		converterMap.put("KilometersToMiles", new KilometersToMilesConverter());
		converterMap.put("MilesToKilometers", new MilesToKilometersConverter());

		// Validate key : Checking if string arg specified from main is valid 
		if (converterMap.containsKey(newConverterType)) {
			converter = converterMap.get(newConverterType);
		} 
		else {
			converter = null;
		}
		return converter;
	}
	/**
	 * • A Hash Map is also utilized to assign converter units based on the string argument  
	 *   specified from Main
	 * 
	 *******************************************************************************************/
	private static HashMap<String, String[]> converterUnitMap = new HashMap<String, String[]>();
	public static String[] getConverterUnits(String specifiedConverterType) {

		converterUnitMap.put("DollarToEuro", new String[] { "dollars", "euros" });
		converterUnitMap.put("EuroToDollar", new String[] { "euros", "dollars" });
		converterUnitMap.put("GramsToOunces", new String[] { "grams", "ounces" });
		converterUnitMap.put("OuncesToGrams", new String[] { "ounces", "grams" });
		converterUnitMap.put("KilometersToMiles", new String[] { "kilometers", "miles" });
		converterUnitMap.put("MilesToKilometers", new String[] { "miles", "kilometers" });
		
		return converterUnitMap.get(specifiedConverterType);
	}
	/**
	 * • The Singleton pattern is utilized to ensure a single instance of the
	 *   ConverterFactory Class
	 * 
	 *******************************************************************************************/
	private static UnitConverter converterInstance = null;
	public static UnitConverter getInstance(String converterType) {

		if (converterInstance == null) {
			converterInstance = ConverterFactory.createConverter(converterType);
		}
		return converterInstance;
	}
}

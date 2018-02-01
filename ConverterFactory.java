import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * HashMap for *(command execution inputs) implements “type safety” 
 */
public class ConverterFactory {

	protected ConverterFactory() {
		
	}
	private static HashMap<String, UnitConverter> converterMap = new LinkedHashMap<>();
	
	public static UnitConverter createConverter(String newConverterType) {

		UnitConverter converter = null;

		converterMap.put("DollarToEuro", new DollarToEuroConverter());
		converterMap.put("EuroToDollar", new EuroToDollarConverter());
		converterMap.put("OuncesToGrams", new OuncesToGramsConverter());
		converterMap.put("GramsToOunces", new GramsToOuncesConverter());
		converterMap.put("MilesToKilometers", new MilesToKilometersConverter());
		converterMap.put("KilometersToMiles", new KilometersToMilesConverter());
		
		converterMap.put("invertDollarToEuro", new invertConverterDecorator(new DollarToEuroConverter()));
		converterMap.put("invertEuroToDollar", new invertConverterDecorator(new EuroToDollarConverter()));
		converterMap.put("invertOuncesToGrams", new invertConverterDecorator(new OuncesToGramsConverter()));
		converterMap.put("invertGramsToOunces", new invertConverterDecorator(new GramsToOuncesConverter()));
		converterMap.put("invertMilesToKilometers", new invertConverterDecorator(new MilesToKilometersConverter()));
		converterMap.put("invertKilometersToMiles", new invertConverterDecorator(new KilometersToMilesConverter()));

		converterMap.put("toGrain", new toGrainDecorator(new OuncesToGramsConverter()));		
		converterMap.put("toYards", new toYardsDecorator(new MilesToKilometersConverter()));
		converterMap.put("TroyOunce", new toTroyOunceDecorator(new GramsToOuncesConverter()));
		converterMap.put("newExchangeRate", new newExchangeRateDecorator(new DollarToEuroConverter()));
		converterMap.put("toNauticalMiles", new toNauticalMilesDecorator(new KilometersToMilesConverter()));
		converterMap.put("toAustralianDollar", new toAustralianDollarDecorator(new EuroToDollarConverter()));
		
		if (converterMap.containsKey(newConverterType)) {
			converter = converterMap.get(newConverterType);
		} else {
			converter = null;		
		}
		return converter;
	}
}

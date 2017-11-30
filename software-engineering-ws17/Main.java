class Main {
	
	public static void main(String[] args) {	
		 
		String specificationPrompt      = '\n' + "Please specify conveter and numeric value in the format : " 
										  + '\n' + '\n' + '\t'  + '\t' + '\t' + "KilometersToMiles 100 " + '\n'
										  + '\n' + "Available unit converters are listed below:" + '\n' + '\n'
										  + "1. DollarToEuro" + '\n' +  "2. EuroToDollar" + '\n' +  "3. KilometersToMiles" + '\n' 
										  + "4. MilesToKilometers" + '\n' +  "5. GramsToOunces" + '\n' +  "6. OuncesToGrams"  + '\n'+ '\n';
		
		// • initialize converter to null 
		UnitConverter Converter = null;

		// • Check user input
		if (args.length == 0) {
			System.out.print(specificationPrompt);
		}
		
		// • Check user input
		if (args.length > 0) {

			String typeOfConverter = args[0];
			double value = Double.parseDouble(args[1]);

			// dynamically instantiate specified class
			Converter = ConverterFactory.getInstance(typeOfConverter);

			// mapping converter units
			String conversionUnits[] = ConverterFactory.getConverterUnits(typeOfConverter);

			// verify new converter instance from ConverterFactory  
			if (Converter != null) {
				double convertedOutput = Converter.convert(value);
				System.out.print('\n' + "Converted " + value + " " + conversionUnits[0] + "  to  " + convertedOutput
						+ " " + conversionUnits[1] + " using the  " + typeOfConverter + " Converter" + '\n');
			}
			// warning :: prompt acceptable inputs
			else {
				System.out.print('\n' + "This string key  *[" + args[0] + "] is Unrecognized" + '\n');
				System.out.print(specificationPrompt);
			}
		}
	}
};

public class toEuroCommand implements ICommand {

	public String key;
	public double numericValue;
	public UnitConverter Converter;

	public toEuroCommand(UnitConverter converter) {
		Converter = converter;
	}

	@Override
	public void executeCommand() {
				
		Converter = ConverterFactory.createConverter(key);
		if (Converter != null) {

			double convertedOutput = Converter.convert(numericValue);
			System.out.print("Converted " + numericValue + "  to  " + convertedOutput + '\t' + " using the  "
					+ Converter.toString() + '\n');
		}
	}

	@Override
	public void setKey(String newKey) {
		key = newKey;
		
	}

	@Override
	public void setValue(double newNumericValue) {
		numericValue = newNumericValue;
		
	}
}

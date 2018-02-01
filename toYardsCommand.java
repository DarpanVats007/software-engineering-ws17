
public class toYardsCommand implements ICommand {

	public String key;
	public double numericValue;
	public UnitConverter Converter;

	public toYardsCommand(UnitConverter converter) {
		Converter = converter;
	}

	@Override
	public void executeCommand() {
				
		Converter = ConverterFactory.createConverter(key);
		if (Converter != null) {

			double convertedOutput = Converter.convert(numericValue);
			System.out.print("Converted " + numericValue + "  to  " + convertedOutput + " using the  "
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

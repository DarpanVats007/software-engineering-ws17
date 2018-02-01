

//- inherit elements and methods from CurrencyConverter
public class EuroToDollarConverter extends CurrencyConverter {

	public EuroToDollarConverter() {
	}

	public double convert(double inEuro) {
		// try catch if invalue is negative or null vale exception 
		
		return inEuro * 1.1765;
	}

	public String toString() {
		return " >> Euro to Dollar Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new EuroToDollarConverter () ;
	}

	@Override
	public double invetertConverter(double inValue) {
		return inValue / 1.1765;
	}
};


//- inherit elements and methods from;
public class DollarToEuroConverter extends CurrencyConverter {

	public DollarToEuroConverter() {
	}

	public double convert(double inDollars) {
		
		// try catch if invalue is negative or null vale exception 
		return inDollars * 0.85;
	}

	public String toString() {
		return " >> Dollar to Euro Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new DollarToEuroConverter () ;
	}

	@Override
	public double invetertConverter(double inValue) {
		return inValue / 0.85;
	}
};

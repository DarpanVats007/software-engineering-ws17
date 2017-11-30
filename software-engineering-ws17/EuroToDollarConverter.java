

//- inherit elements and methods from CurrencyConverter
public class EuroToDollarConverter extends CurrencyConverter {

	public EuroToDollarConverter() {
	}

	public double convert(double inEuro) {
		return inEuro * 1.1765;
	}

	public String toString() {
		return "Euro to Dollar Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new EuroToDollarConverter () ;
	}
};
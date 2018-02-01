

//- inherit elements and methods from MassConverter
public class OuncesToGramsConverter extends MassConverter {

	public OuncesToGramsConverter() {
	}

	public double convert(double inOunces) {
		return inOunces * 28.3495;
	}

	public String toString() {
		return " >> Ounces To Grams Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new OuncesToGramsConverter () ;
	}

	@Override
	public double invetertConverter(double inValue) {
		return inValue * 28.3495;
	}
};

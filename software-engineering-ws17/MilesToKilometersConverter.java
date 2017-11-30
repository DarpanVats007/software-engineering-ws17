

//- inherit elements and methods from LengthConverter
public class MilesToKilometersConverter extends LengthConverter {

	public MilesToKilometersConverter() {
	}

	public double convert(double inMiles) {
		return inMiles * 1.60934;
	}

	public String toString() {
		return "Miles To Kilometers Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new MilesToKilometersConverter () ;
	}
};
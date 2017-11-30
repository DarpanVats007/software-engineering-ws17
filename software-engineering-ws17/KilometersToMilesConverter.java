

//- inherit elements and methods from LengthConverter
public class KilometersToMilesConverter extends LengthConverter {

	public KilometersToMilesConverter() {
	}

	public double convert(double inKilometers) {
		return inKilometers * 0.621371;
	}

	public String toString() {
		return "Kilometers To Miles Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new KilometersToMilesConverter () ;
	}
};
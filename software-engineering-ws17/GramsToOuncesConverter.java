

public class GramsToOuncesConverter extends MassConverter { // - inherit elements and methods from MassConverter

	public GramsToOuncesConverter() {
	}

	public double convert(double inGrams) {
		return inGrams * 0.035274;
	}

	public String toString() {
		return "Grams To Ounces Converter";
	}

	public void print() {
		System.out.println(toString());
	}
	public static UnitConverter create() {
		return new GramsToOuncesConverter () ;
	}
};
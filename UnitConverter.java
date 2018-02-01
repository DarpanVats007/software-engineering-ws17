

public abstract class UnitConverter {
	
	public UnitConverter() {
	}
	
	public static UnitConverter create() {
		return null;
	}

	public abstract double invetertConverter(double inValue);
	
	public abstract double convert(double inValue);

	public abstract String toString();

	public abstract void print();
};

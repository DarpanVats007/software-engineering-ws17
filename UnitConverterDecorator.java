
public abstract class UnitConverterDecorator extends UnitConverter {

	protected UnitConverter tempUnitConverter;

	public UnitConverterDecorator(UnitConverter newUnitConverter) {
		tempUnitConverter = newUnitConverter;
	}

	public double convert(double inValue) {
		return tempUnitConverter.convert(inValue);
	}

	public String toString() {
		return tempUnitConverter.toString();
	}

	public void print() {
		tempUnitConverter.print();
	}
}

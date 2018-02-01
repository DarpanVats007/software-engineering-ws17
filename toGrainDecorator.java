
public class toGrainDecorator extends UnitConverterDecorator   {

	public toGrainDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
	}
	
	public double convert(double inValue) {
		return tempUnitConverter.convert(inValue) * 15.4324 ; 
	}

	public String toString() {
		return tempUnitConverter.toString() + " + Grams to Grains Decorator"; 
	}

	@Override
	public double invetertConverter(double inValue) {
		return tempUnitConverter.convert(inValue) / 15.4324 ; 
	}	
}
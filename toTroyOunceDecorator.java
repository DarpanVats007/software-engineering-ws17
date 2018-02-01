
public class toTroyOunceDecorator extends UnitConverterDecorator  {

	public toTroyOunceDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
	}
	
	public double convert(double inValue) {
		return tempUnitConverter.convert(inValue) * 0.911458 ; 
	}

	public String toString() {
		return tempUnitConverter.toString() + " + Troy Ounce Decorator"; 
	}

	@Override
	public double invetertConverter(double inValue) {
		return tempUnitConverter.invetertConverter(inValue) / 0.911458 ;
	}	
}
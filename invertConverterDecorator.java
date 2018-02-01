/**
 * invertConverterDecorator implements an invetertConverter
 * create in Unite converter to reverse all conversion computations 
 */
public class invertConverterDecorator extends UnitConverterDecorator  {

	public invertConverterDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
	}
	
	//inverter function in invertConverterDecorator Class
	public double invetertConverter(double inValue) {
		return tempUnitConverter.convert(inValue) ; 
	}

	public String toString() {
		return tempUnitConverter.toString() + " : Conversion Inverted ! "; 
	}	
}
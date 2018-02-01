
public class toAustralianDollarDecorator extends UnitConverterDecorator {

	public toAustralianDollarDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
		}
		
		public double convert(double inValue) {
			return tempUnitConverter.convert(inValue) * 1.33 ; 
		}

		public String toString() {
			return tempUnitConverter.toString() + " + American Dollar to Australian Dollar Decorator"; 
		}

		@Override
		public double invetertConverter(double inValue) {
			return tempUnitConverter.invetertConverter(inValue) / 1.33 ; 
		}	
	}

public class newExchangeRateDecorator extends UnitConverterDecorator  {

	public newExchangeRateDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
		}
		
		public double convert(double inValue) {
			return tempUnitConverter.convert(inValue) * 1.015 ; 
		}

		public String toString() {
			return tempUnitConverter.toString() + " + new Exchange-Rate Decorator"; 
		}

		@Override
		public double invetertConverter(double inValue) {
			return tempUnitConverter.invetertConverter(inValue) / 1.015 ;
		}	
	}
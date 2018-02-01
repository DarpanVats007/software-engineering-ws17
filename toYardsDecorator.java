
public class toYardsDecorator extends UnitConverterDecorator  {

	public toYardsDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
		}
		
		public double convert(double inValue) {
			return tempUnitConverter.convert(inValue) * 1093.61 ; 
		}

		public String toString() {
			return tempUnitConverter.toString() + " + Kilometers to Yards Decorator"; 
		}

		@Override
		public double invetertConverter(double inValue) {
			return tempUnitConverter.invetertConverter(inValue) / 1093.61 ;
		}	
	}
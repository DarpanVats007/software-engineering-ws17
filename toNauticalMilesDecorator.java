
public class toNauticalMilesDecorator extends UnitConverterDecorator  {

	public toNauticalMilesDecorator(UnitConverter newUnitConverter) {
		super(newUnitConverter);
		}
		
		public double convert(double inValue) {
			return tempUnitConverter.convert(inValue) / 0.869 ; 
		}

		public String toString() {
			return tempUnitConverter.toString() + " + Statute Miles to Nautical Miles Decorator"; 
		}

		@Override
		public double invetertConverter(double inValue) {
			return tempUnitConverter.convert(inValue) * 0.869 ;
		}	
	}
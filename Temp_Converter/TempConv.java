
public class TempConv {
	private static double ConvFromCelToFah(double celVal) {
		return celVal * (double)9 / (double)5 + (double)32;
	}
	
	private static double ConvFromCelToKel(double celVal) {
		return celVal + (double)273.15;
	}
	
	private static double ConvFromFahToCel(double fahVal) {
		return (fahVal - (double)32) * (double)5 / (double)9;
	}
	
	private static double ConvFromFahToKel(double fahVal) {
		return (fahVal + (double)459.67) * (double)5 / (double)9;
	}
	
	private static double ConvFromKelToCel(double kelVal) {
		return kelVal - (double)273.15;
	}
	
	private static double ConvFromKelToFah(double kelVal) {
		return kelVal * (double)9 / (double)5 - (double)459.67;
	}
	
	public static double ConvertTemperature(double inputTempVal, int fromTempUnit, int toTempUnit) {
		if (fromTempUnit == 0) {
			if (toTempUnit == 0) {
				return inputTempVal;
			} else if (toTempUnit == 1) {
				return ConvFromCelToFah(inputTempVal);
			} else {
				return ConvFromCelToKel(inputTempVal);
			}
		} else if (fromTempUnit == 1) {
			if (toTempUnit == 0) {
				return ConvFromFahToCel(inputTempVal);
			} else if (toTempUnit == 1) {
				return inputTempVal;
			} else {
				return ConvFromFahToKel(inputTempVal);
			}
			
		} else {
			if (toTempUnit == 0) {
				return ConvFromKelToCel(inputTempVal);
			} else if (toTempUnit == 1) {
				return ConvFromKelToFah(inputTempVal);
			} else {
				return inputTempVal;
			}			
		}
	}
}

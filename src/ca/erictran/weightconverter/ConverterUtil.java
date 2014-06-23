package ca.erictran.weightconverter;

public class ConverterUtil {
	
	//utility functions used to convert weight values
	
	public static double convertKilogramToPound(double kilogram) {
		return kilogram*2.20462;
	}
	
	public static double convertPoundToKilogram(double pound) {
		return pound*0.453592;
	}
	
	public static double convertUnits(long unit1, long unit2, double value) {
		
		if (unit1 == unit2)
			return value;
		else if (unit1 == 0 && unit2 == 1)
			return convertPoundToKilogram(value);
		else
			return convertKilogramToPound(value);

	}

}

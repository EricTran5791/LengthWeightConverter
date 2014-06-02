package ca.erictran.weightconverter;

public class ConverterUtil {
	
	//utility functions used to convert weight values
	
	public static double convertKilogramToPound(double kilogram) {
		return kilogram*2.20462;
	}
	
	public static double convertPoundToKilogram(double pound) {
		return pound*0.453592;
	}

}

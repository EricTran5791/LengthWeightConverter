package ca.erictran.weightconverter;

public class ConverterUtil {
	
	//converts units to pounds then to the conversion unit
	
	public static double convertUnits(long unit1, long unit2, double value) {
		
		if (unit1 == unit2)
			return value;

		return convertFromPounds(unit2, convertToPounds(unit1, value));

	}
	
	//converts all units to pounds, thus using pounds as a base unit
	
	public static double convertToPounds(long unit, double value) {
		
		int unitInt = (int) unit;
		
		switch (unitInt) {
		case 0: //pounds
			return value;
		case 1: //kilograms
			return value*2.20462;
		case 2: //stone
			return value*14;
		case 3: //ounces
			return value*0.0625;
		case 4: //grams
			return value*0.00220462;
		default:
			return value;
		}
	}
	
	//converts from pounds to other units
	
	public static double convertFromPounds(long unit, double value) {
		
		int unitInt = (int) unit;
		
		switch (unitInt) {
		case 0: //pounds
			return value;
		case 1: //kilograms
			return value*0.453592;
		case 2: //stone
			return value*0.0714286;
		case 3: //ounces
			return value*16;
		case 4: //grams
			return value*453.592;
		default:
			return value;
		}
	}

}

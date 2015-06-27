package ca.erictran.lengthweightconverter;

//ConverterUtil: utility class for converting length and weight units

public class ConverterUtil {
	
	//convertLength: converts units to centimetres then to the conversion unit
	
	public static double convertLength(long unit1, long unit2, double value) {
		
		if (unit1 == unit2)
			return value;

		return convertFromCentimetres(unit2, convertToCentimetres(unit1, value));

	}
	
	//convertToCentimetres: converts all units to centimetres (thus using centimetres as a base unit)
	
	public static double convertToCentimetres(long unit, double value) {
		int unitInt = (int) unit;

        switch (unitInt) {
            case 0: //inches
                return value*2.54;
            case 1: //millimetres
                return value*0.1;
            case 2: //centimetres
                return value;
            case 3: //metres
                return value*100;
            case 4: //feet
                return value*30.48;
            case 5: //yards
                return value*91.44;
            case 6: //kilometres
                return value*100000;
            case 7: //miles
                return value*160934.4;
            default:
                return value;
        }
	}
	
	//convertFromCentimetres: converts from centimetres to other units
	
	public static double convertFromCentimetres(long unit, double value) {
		int unitInt = (int) unit;

        switch (unitInt) {
            case 0: //inches
                return value*0.393701;
            case 1: //millimetres
                return value*10;
            case 2: //centimetres
                return value;
            case 3: //metres
                return value*0.01;
            case 4: //feet
                return value*0.03280839895;
            case 5: //yards
                return value*0.010936132983;
            case 6: //kilometres
                return value*0.00001;
            case 7: //miles
                return value*0.0000062137119224;
            default:
                return value;
		}
	}
	
	//convertWeight: converts units to pounds then to the conversion unit
	
	public static double convertWeight(long unit1, long unit2, double value) {
		
		if (unit1 == unit2)
			return value;

		return convertFromPounds(unit2, convertToPounds(unit1, value));

	}
	
	//convertToPounds: converts all units to pounds (thus using pounds as a base unit)
	
	public static double convertToPounds(long unit, double value) {
		int unitInt = (int) unit;
		
		switch (unitInt) {
		case 0: //pounds
			return value;
		case 1: //kilograms
			return value*2.2046226218;
		case 2: //stone
			return value*14;
		case 3: //ounces
			return value*0.0625;
		case 4: //grams
			return value*0.00220462;
        case 5: //milligrams
			return value*0.0000022046226218;
		default:
			return value;
		}
	}
	
	//convertFromPounds: converts from pounds to other units
	
	public static double convertFromPounds(long unit, double value) {
		int unitInt = (int) unit;
		
		switch (unitInt) {
		case 0: //pounds
			return value;
		case 1: //kilograms
			return value*0.45359237;
		case 2: //stone
			return value*0.0714286;
		case 3: //ounces
			return value*16;
		case 4: //grams
			return value*453.592;
        case 5: //milligrams
			return value*453592.37;
		default:
			return value;
		}
	}

}

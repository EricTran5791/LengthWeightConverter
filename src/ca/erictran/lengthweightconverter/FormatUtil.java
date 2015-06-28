package ca.erictran.lengthweightconverter;

import android.util.Log;

import java.text.DecimalFormat;

//FormatUtil: utility class for formatting numbers and number strings

public class FormatUtil {
	
	// extractNonDecimal: returns the non-decimal portion of a number string
	
	public static String extractNonDecimal(double s) {
    	DecimalFormat df = new DecimalFormat("#,###");

		return df.format(Math.round(s - 0.5f));
	}
	
	// extractDecimal: returns the decimal portion of a number string (including the decimal)
	
	public static String extractDecimal(String s) {
		String result = "";
		
		for (int i = s.length() - 1; i >= 0; --i) {

			result = s.charAt(i) + result;

			if (s.charAt(i) == '.') {
				break;
			}
		}

		return result;
	}
	
	// formatNumber: formats a number to include commas and up to 10 decimal places
	
	public static String formatNumber(double s) {
        DecimalFormat df;

        if (s > 1000000000 || s < 0.000000001 && s != 0) {
            df = new DecimalFormat("@@###E0");
        } else {
            df = new DecimalFormat("#,##0.#########");
        }

        return df.format(s);
    }

}

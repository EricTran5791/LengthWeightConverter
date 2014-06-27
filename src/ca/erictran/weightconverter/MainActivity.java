package ca.erictran.weightconverter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.*;

import android.R.string;
import android.app.Activity;
import android.view.inputmethod.*;

public class MainActivity extends ActionBarActivity {
	
	private String input;
	private TextView output, output2;
	
	private Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        input = "0";
        output = (TextView) findViewById(R.id.textView2);
        output2 = (TextView) findViewById(R.id.textView3);
        
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(1);
    }
    
    //static method used to hide the keyboard
    
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    
    public void onClick(View view) {
    	
    	switch (view.getId()) {
    	case R.id.Button1:
    		input = input + "1";
    		break;
    	case R.id.Button2:
    		input = input + "2";
    		break;
    	case R.id.Button3:
    		input = input + "3";
    		break;
    	case R.id.Button4:
    		input = input + "4";
    		break;
    	case R.id.Button5:
    		input = input + "5";
    		break;
    	case R.id.Button6:
    		input = input + "6";
    		break;
    	case R.id.Button7:
    		input = input + "7";
    		break;
    	case R.id.Button8:
    		input = input + "8";
    		break;
    	case R.id.Button9:
    		input = input + "9";
    		break;
    	case R.id.Button0:
    		input = input + "0";
    		break;
    	case R.id.Button04:
        	if (input.length() == 0) {
        		Toast.makeText(this, "Please enter a number.", Toast.LENGTH_LONG).show();
        		return;
        	}

    		if (input == null || input.length() == 1) {
    			input = "0";
    			return;
    		}
    		else
    			input = input.substring(0, input.length()-1);
    		break;
    	case R.id.Button08:
    		int tempId = (int)spinner.getSelectedItemId();
    		spinner.setSelection((int)spinner2.getSelectedItemId());
    		spinner2.setSelection(tempId);
    		break;
    	}
    	
    	double inputValue = Double.parseDouble(input);
    	double inputValue2 = ConverterUtil.convertUnits(spinner.getSelectedItemId(), spinner2.getSelectedItemId(), inputValue);
    	DecimalFormat df = new DecimalFormat("#,###.##########");
    	
    	output.setText(df.format(inputValue));
		output2.setText(df.format(inputValue2));    	
    	
//    	output.setText(df.format(inputValue));
//		output2.setText(df.format(ConverterUtil.convertUnits(spinner.getSelectedItemId(), spinner2.getSelectedItemId(), inputValue)));
    }

}

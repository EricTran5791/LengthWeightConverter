package ca.erictran.weightconverter;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {
	
	private String input = "0";
	private TextView output, output2;
	private boolean decimalEntered, enteredAfterDecimal;
	
	private Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = this.getResources().getConfiguration().orientation;
        
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
        else {
        	setContentView(R.layout.activity_landscape);
        }
        
        output = (TextView) findViewById(R.id.textView2);
        output2 = (TextView) findViewById(R.id.textView3);
        
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(1);
        spinner2.setOnItemSelectedListener(this);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    	MenuInflater inflater = getMenuInflater ();
    	inflater.inflate(R.menu.main, menu);
    	
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {

    	super.onSaveInstanceState(outState);
    	
    	outState.putString("input", input);
    	outState.putBoolean("decimalEntered", decimalEntered);
    	outState.putBoolean("enteredAfterDecimal", enteredAfterDecimal);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

    	super.onRestoreInstanceState(savedInstanceState);
    	
    	input = savedInstanceState.getString("input");
    	decimalEntered = savedInstanceState.getBoolean("decimalEntered");
    	enteredAfterDecimal = savedInstanceState.getBoolean("enteredAfterDecimal");
    }
    
    public void onClick(View view) {
    	
    	if (view == null)
    		return;
    	
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
    	case R.id.ButtonDecimal:
    		if (!decimalEntered) {
    			decimalEntered = true;
    			enteredAfterDecimal = false;
    			input = input + ".";
    		}
    		break;
    	case R.id.ButtonClear:
    		input = "0";
    		decimalEntered = false;
    		enteredAfterDecimal = false;
    		break;
    	case R.id.ButtonBackspace:
        	if (input.length() == 0) {
        		Toast.makeText(this, "Please enter a number.", Toast.LENGTH_LONG).show();
        		return;
        	}

    		if (input == null || input.length() == 1) {
    			input = "0";
    			return;
    		}
    		else {
    			if (input.charAt(input.length() - 1) == '.') {
    				decimalEntered = false;
    				enteredAfterDecimal = false;
    			}
    			input = input.substring(0, input.length()-1);
    		}
    		break;
    	case R.id.ButtonSwitch:
    		int tempId = (int)spinner.getSelectedItemId();
    		spinner.setSelection((int)spinner2.getSelectedItemId());
    		spinner2.setSelection(tempId);
    		break;
    	}
    	
    	double inputValue;
    	if (input.charAt(input.length() - 1) == '.') { //remove decimal from parse if it is trailing
    		inputValue = Double.parseDouble(input.substring(0, input.length()-1));
    	}
    	else {
    		inputValue = Double.parseDouble(input);
    	}
    	
    	double outputValue = ConverterUtil.convertUnits(spinner.getSelectedItemId(), spinner2.getSelectedItemId(), inputValue);

    	
    	if (decimalEntered && !enteredAfterDecimal && input.charAt(input.length() - 1) != '.') { //if flag false and last char not a decimal
    		enteredAfterDecimal = true;
    	}
    	    
    	
    	if (decimalEntered) {
    		output.setText(FormatUtil.extractNonDecimal(inputValue) + FormatUtil.extractDecimal(input));
    	}
    	else {
    		output.setText(FormatUtil.formatNumber(inputValue));
    	}
    	output2.setText(FormatUtil.formatNumber(outputValue));  
    	
    }

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		onClick(view);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}

}

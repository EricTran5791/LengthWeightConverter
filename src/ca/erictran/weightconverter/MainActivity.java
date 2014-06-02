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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;
import java.text.*;
import android.app.Activity;
import android.view.inputmethod.*;

public class MainActivity extends ActionBarActivity {
	
	private EditText input;
	private TextView output;
	private TextView output2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        input = (EditText) findViewById(R.id.editText1);
        output = (TextView) findViewById(R.id.textView2);
        output2 = (TextView) findViewById(R.id.textView3);
    }
    
    //static method used to hide the keyboard
    
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    
    public void onClick(View view) {
    	
    	hideSoftKeyboard(this);
    	
    	if (input.getText().length() == 0) {
    		Toast.makeText(this, "Please enter a number.", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	
    	double inputValue = Double.parseDouble(input.getText().toString());
    	DecimalFormat df = new DecimalFormat("#.00");
    	switch (view.getId()) {
    	case R.id.button1:
    		output.setText(df.format(inputValue) + " kg =");
    		output2.setText(df.format(ConverterUtil.convertKilogramToPound(inputValue)) + " lb");
    		return;
    	case R.id.button2:
    		output.setText(df.format(inputValue) + " lb = ");
    		output2.setText(df.format(ConverterUtil.convertPoundToKilogram(inputValue)) + " kg");
    		return;
    	}
    }

}

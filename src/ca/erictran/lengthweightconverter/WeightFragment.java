package ca.erictran.lengthweightconverter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;

public class WeightFragment extends SherlockFragment implements OnItemSelectedListener, View.OnClickListener {
	
	private String input = "0";
	private TextView output, output2;
	private boolean decimalEntered, enteredAfterDecimal;
	
	private Spinner spinner, spinner2;
	
	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
	private Button buttonDecimal;
	private ImageButton buttonClear, buttonBackspace, buttonSwitch;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view;
		
        int orientation = this.getResources().getConfiguration().orientation;
        //check orientation and assign appropriate layout
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        	view = inflater.inflate(R.layout.fragment_portrait, container, false);
        }
        else {
        	view = inflater.inflate(R.layout.fragment_landscape, container, false);
        }
		
		button1 = (Button) view.findViewById(R.id.Button1);
		button1.setOnClickListener(this);
		button2 = (Button) view.findViewById(R.id.Button2);
		button2.setOnClickListener(this);
		button3 = (Button) view.findViewById(R.id.Button3);
		button3.setOnClickListener(this);
		button4 = (Button) view.findViewById(R.id.Button4);
		button4.setOnClickListener(this);
		button5 = (Button) view.findViewById(R.id.Button5);
		button5.setOnClickListener(this);
		button6 = (Button) view.findViewById(R.id.Button6);
		button6.setOnClickListener(this);
		button7 = (Button) view.findViewById(R.id.Button7);
		button7.setOnClickListener(this);
		button8 = (Button) view.findViewById(R.id.Button8);
		button8.setOnClickListener(this);
		button9 = (Button) view.findViewById(R.id.Button9);
		button9.setOnClickListener(this);
		button0 = (Button) view.findViewById(R.id.Button0);
		button0.setOnClickListener(this);
		buttonDecimal = (Button) view.findViewById(R.id.ButtonDecimal);
		buttonDecimal.setOnClickListener(this);
		buttonClear = (ImageButton) view.findViewById(R.id.ButtonClear);
		buttonClear.setOnClickListener(this);
		buttonBackspace = (ImageButton) view.findViewById(R.id.ButtonBackspace);
		buttonBackspace.setOnClickListener(this);
		buttonSwitch = (ImageButton) view.findViewById(R.id.ButtonSwitch);
		buttonSwitch.setOnClickListener(this);
		
        output = (TextView) view.findViewById(R.id.textView2);
        output2 = (TextView) view.findViewById(R.id.textView3);
        
        spinner = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.weight_array, R.layout.centered_spinner_item);
        adapter.setDropDownViewResource(R.layout.centered_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.weight_array, R.layout.centered_spinner_item);
        adapter2.setDropDownViewResource(R.layout.centered_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(1);
        spinner2.setOnItemSelectedListener(this);

		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		if (savedInstanceState != null) {
	    	input = savedInstanceState.getString("input");
	    	decimalEntered = savedInstanceState.getBoolean("decimalEntered");
	    	enteredAfterDecimal = savedInstanceState.getBoolean("enteredAfterDecimal");
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	
    	outState.putString("input", input);
    	outState.putBoolean("decimalEntered", decimalEntered);
    	outState.putBoolean("enteredAfterDecimal", enteredAfterDecimal);
    }
	
    @Override
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
    	
    	double outputValue = ConverterUtil.convertWeight(spinner.getSelectedItemId(), spinner2.getSelectedItemId(), inputValue);

    	
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

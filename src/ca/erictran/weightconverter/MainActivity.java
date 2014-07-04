package ca.erictran.weightconverter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	private WeightFragment weightfragment;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
    	
        if (savedInstanceState == null) { //restore the fragment's instance
        	weightfragment = new WeightFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, weightfragment);
            transaction.commit();
        }
        else {
        	weightfragment = (WeightFragment) getFragmentManager().getFragment(savedInstanceState, "weightfragment");
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	   	
    	if (weightfragment != null) { //save the fragment's instance
        	getFragmentManager().putFragment(outState, "weightfragment", weightfragment);
    	}

    }
    
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//    	MenuInflater inflater = getMenuInflater ();
//    	inflater.inflate(R.menu.main, menu);
//    	
//    	return super.onCreateOptionsMenu(menu);
//    }
    
}

package ca.erictran.lengthweightconverter;

import android.support.v4.app.FragmentTransaction;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;

import android.os.Bundle;

public class MainActivity extends SherlockFragmentActivity {

    private ActionBar actionBar;
    private ActionBar.Tab lengthTab, weightTab;
    private LengthFragment lengthFragment;
    private WeightFragment weightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int curTabPos = 0;

        if (savedInstanceState == null) { //restore the fragments' instance
            lengthFragment = new LengthFragment();
            weightFragment = new WeightFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(lengthFragment,"lengthFragment");
            ft.add(weightFragment,"weightFragment");
            ft.commit();
        }
        else {
            lengthFragment = (LengthFragment) getSupportFragmentManager().getFragment(savedInstanceState, "lengthFragment");
            weightFragment = (WeightFragment) getSupportFragmentManager().getFragment(savedInstanceState, "weightFragment");
            curTabPos = savedInstanceState.getInt("curTabPos");
        }

        //create actionbar with tabs
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //set tab titles
        lengthTab = actionBar.newTab().setText("Length");
        weightTab = actionBar.newTab().setText("Weight");

        //set tab listeners
        lengthTab.setTabListener(new TabListener(this, lengthFragment));
        weightTab.setTabListener(new TabListener(this, weightFragment));

        //add tabs to actionbar
        actionBar.addTab(lengthTab, 0);
        actionBar.addTab(weightTab, 1);

        // set selected tab
        if (curTabPos == 0) {
            actionBar.selectTab(weightTab);
            actionBar.selectTab(lengthTab);
        }
        else {
            actionBar.selectTab(lengthTab);
            actionBar.selectTab(weightTab);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (lengthFragment != null) { //save the lengthFragment instance
            getSupportFragmentManager().putFragment(outState, "lengthFragment", lengthFragment);
        }
        if (weightFragment != null) { //save the weightFragment instance
            getSupportFragmentManager().putFragment(outState, "weightFragment", weightFragment);
        }

        //save the current tab position
        outState.putInt("curTabPos", actionBar.getSelectedNavigationIndex());

    }


}

package ca.erictran.weightconverter;

import android.support.v4.app.FragmentTransaction;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class TabListener implements ActionBar.TabListener {

    private SherlockFragmentActivity activity;
    private SherlockFragment fragment;

    public TabListener(SherlockFragmentActivity activity, SherlockFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ft.attach(fragment);
        ft.add(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.detach(fragment);
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }

}

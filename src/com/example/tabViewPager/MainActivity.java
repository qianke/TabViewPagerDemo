package com.example.tabViewPager;

import java.util.ArrayList;

import Menu.TabItem;
import Menu.Tabs;
import Menu.TabsAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private ArrayList<TabItem> mTabs;
	private TabHost mTabHost;
	private TabsAdapter mTabsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initTabs();
		
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
		
		mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);
		
		for(int i=0;i<mTabs.size();i++){
			mTabsAdapter.addTab(mTabHost.newTabSpec("Tag" + i).setIndicator("Tag" + i));
		}
	}

	private void initTabs() {
		// TODO Auto-generated method stub

		mTabs = Tabs.getTabs();	
		
		TabItem tabInfo1 = new TabItem();
		tabInfo1.setTitle("tab1");
		tabInfo1.setFrament(new fragment1());		
		mTabs.add(tabInfo1);
		
		TabItem tabInfo2 = new TabItem();
		tabInfo2.setTitle("tab2");
		tabInfo2.setFrament(new fragment2());		
		mTabs.add(tabInfo2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

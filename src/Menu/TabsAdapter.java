package Menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;

public class TabsAdapter extends FragmentPagerAdapter implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener  {

	private FragmentManager fm;
	private FragmentActivity mContext;
	private TabHost mTabHost;
	private ViewPager mViewPager;
	
	
	class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }
	
	

	public TabsAdapter(FragmentActivity activity,TabHost tabHost,ViewPager viewpager) {
		super(activity.getSupportFragmentManager());
		
		fm = activity.getSupportFragmentManager();
		mContext = activity;
        mTabHost = tabHost;		
        mViewPager = viewpager;
        mTabHost.setOnTabChangedListener(this);
        mViewPager.setAdapter(this);
        mViewPager.setOnPageChangeListener(this);
	}
	
	public void addTab(TabHost.TabSpec tabSpec) {
		
        tabSpec.setContent(new DummyTabFactory(mContext));

        mTabHost.addTab(tabSpec);
        notifyDataSetChanged();
    }

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		
		return Tabs.getTabs().get(position).getFrament();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub		
		int size = Tabs.getTabs().size();
		return size;
	}

	@Override
	public void onPageScrollStateChanged(int state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		Log.d("xiong","onPageSelected" + position);
		// TODO Auto-generated method stub
		mTabHost.setCurrentTab(position);
	}

	@Override
	public void onTabChanged(String TabId) {
		// TODO Auto-generated method stub
		int position = mTabHost.getCurrentTab();
		mViewPager.setCurrentItem(position);
	}

}

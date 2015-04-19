package Menu;

import android.support.v4.app.Fragment;

public class TabItem {
	private String mTitle;
	private Fragment mFrament;
	
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String title) {
		mTitle = title;
	}
	public Fragment getFrament() {
		return mFrament;
	}
	public void setFrament(Fragment frament) {
		mFrament = frament;
	}
	
	
}

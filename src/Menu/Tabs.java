package Menu;

import java.util.ArrayList;

public class Tabs {

	private static ArrayList<TabItem> sTabs;

	public static ArrayList<TabItem> getTabs() {

		if (sTabs == null) {
			sTabs = new ArrayList<TabItem>();
		}

		return sTabs;
	}

	public void addItem(TabItem item) {
		sTabs.add(item);
	}
}

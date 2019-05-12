package ddc.boundary;

import ddc.boundary.helper.UIHelper;
import ddc.control.IPageRoute;

public class QuitUI implements IPageRoute {
	UIHelper ui = new UIHelper();
	
	@Override
	public void run() {
		ui.writeTitle("QUIT");
		ui.writeFormHeader("bye-bye");
		ui.writeFooter();
	}

}

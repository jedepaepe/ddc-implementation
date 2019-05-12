package ddc.boundary;

import ddc.boundary.helper.UIHelper;
import ddc.router.Route;

public class QuitUI extends IPageUI {
	UIHelper ui = new UIHelper();
	
	@Override
	public Route run(Object bag) {
		ui.writeTitle("QUIT");
		ui.writeFormHeader("bye-bye");
		ui.writeFooter();
		return new Route();
	}

}

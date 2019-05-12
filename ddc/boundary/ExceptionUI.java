package ddc.boundary;

import ddc.router.Route;

public class ExceptionUI extends IPageUI {

	@Override
	public Route run(Object bag) {
		ui.writeTitle("EXCEPTION PAGE");
		ui.writeFormHeader("Une exception s'est produite");
		
		try {
			Exception ex = (Exception) bag;
			ui.writeException(ex);
		} catch(Exception ex) {
			ui.writeTextLeft("Une exception non reconnue a été levée");
		}
		ui.writeFooter();
		return new Route(Route.PRINCIPAL_PAGE);
	}

}

package ddc.boundary;

import ddc.boundary.helper.UIHelper;
import ddc.router.Route;

public abstract class IPageUI {
	// référence sur la classe UIHelper (TODO => singleton)
	public UIHelper ui = UIHelper.instance;

	/**
	 * affiche la page & active ses dialogues
	 * @param bag contient des paramètres à communiquer à la page
	 * @return un nom de route
	 */
	public abstract Route run(Object bag);
}

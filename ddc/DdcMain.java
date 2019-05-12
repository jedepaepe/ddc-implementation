package ddc;
import ddc.entity.EmployeListe;
import ddc.router.Router;

public class DdcMain {
	public static void main(String[] args) throws Exception {
		init();
		new Router().run();
	}

	private static void init() {
		// initialise la liste des employés avec des données fake
		EmployeListe.instance.initFake();
	}
}

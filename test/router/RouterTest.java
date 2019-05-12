package test.router;

import org.junit.jupiter.api.Test;

import ddc.router.Route;
import ddc.router.Router;

public class RouterTest {

	@Test
	public void testRun() throws Exception {
		Router router = new Router();
		router.startRoute = new Route(Route.QUIT_PAGE);
		router.run();
	}

}

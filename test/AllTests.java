// NE FONCTIONNE PAS
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.boundary.DemandeCongeUITest;
import test.boundary.PrincipalUITest;

@RunWith(Suite.class)
@SuiteClasses({DemandeCongeUITest.class, PrincipalUITest.class})
public class AllTests {

}

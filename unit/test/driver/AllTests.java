package test.driver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.game.actor.*;
import test.game.map.*;

@RunWith(Suite.class)
@SuiteClasses({
	TestActorId.class,
	TestPositionBehavior2DId.class,
	TestPositionBehavior2DAdjacentToAndOnTop.class
})
public class AllTests {
}

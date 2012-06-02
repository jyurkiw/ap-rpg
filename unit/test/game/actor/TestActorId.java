package test.game.actor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rpg.game.actor.Actor;
import rpg.game.actor.behavior.*;

import java.util.EnumMap;

import junit.framework.TestCase;

public class TestActorId extends TestCase {
	private Actor testActor;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		
		testActor = null;
	}

	@Test
	public void testActor() {
		testActor = new Actor();
		assertEquals(-1, testActor.getId());
	}

	@Test
	public void testActorInt() {
		testActor = new Actor(13);
		assertEquals(13, testActor.getId());
	}
	
	@Test
	public void testActorIntEnumMap() {
		int id = 64;
		EnumMap<BehaviorType, Behavior> behaviorMap = new EnumMap<BehaviorType, Behavior>(BehaviorType.class);
		testActor = new Actor(id, behaviorMap);
		
		assertEquals(id, testActor.getId());
	}

	@Test
	public void testSetId() {
		int id = 42;
		testActor = new Actor();
		testActor.setId(id);
		assertEquals(id, testActor.getId());
	}

}

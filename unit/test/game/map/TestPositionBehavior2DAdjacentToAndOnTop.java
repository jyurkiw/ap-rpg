package test.game.map;

import static org.junit.Assert.*;

import rpg.game.map.PositionBehavior2D;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestPositionBehavior2DAdjacentToAndOnTop {
	private PositionBehavior2D a;
	private PositionBehavior2D[] b;
	
	private int mapId;
	private int x, y;

	public TestPositionBehavior2DAdjacentToAndOnTop(int x, int y) {
		this.x = x;
		this.y = y;
		mapId = 0;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{3, 2}, {78, 4}, {3, 89}, {77, 69}};
		
		return Arrays.asList(data);
	}
	
	@Before
	public void setUp() throws Exception {
		a = new PositionBehavior2D(mapId, x, y);
		
		b = new PositionBehavior2D[8];
		b[0] = new PositionBehavior2D(mapId, x-1, y-1);
		b[1] = new PositionBehavior2D(mapId, x, y-1);
		b[2] = new PositionBehavior2D(mapId, x+1, y-1);
		b[3] = new PositionBehavior2D(mapId, x-1, y);
		b[4] = new PositionBehavior2D(mapId, x+1, y);
		b[5] = new PositionBehavior2D(mapId, x-1, y+1);
		b[6] = new PositionBehavior2D(mapId, x, y+1);
		b[7] = new PositionBehavior2D(mapId, x+1, y+1);
	}

	@After
	public void tearDown() throws Exception {
	}

	private void compare(PositionBehavior2D other) {
		assertEquals(mapId, other.getMapId());
		assertEquals(x, other.getxCoord());
		assertEquals(y, other.getyCoord());
	}
	
	@Test
	public void testPositionBehavior2DIntIntInt() {
		PositionBehavior2D other = new PositionBehavior2D(mapId, x, y);
		compare(other);
		
		assertTrue(a.onTopOf(other));
		assertTrue(other.onTopOf(a));
	}
	
	@Test
	public void testAdjacentTo360() {
		assertFalse(a.adjacentTo(b[0]));
		assertTrue(a.adjacentTo(b[1]));
		assertFalse(a.adjacentTo(b[2]));
		
		assertTrue(a.adjacentTo(b[3]));
		assertTrue(a.adjacentTo(b[4]));
		
		assertFalse(a.adjacentTo(b[5]));
		assertTrue(a.adjacentTo(b[6]));
		assertFalse(a.adjacentTo(b[7]));
		
		for (PositionBehavior2D other : b)
			assertFalse("\n" + a.toString() + "\n" + other.toString(), other.onTopOf(a));
	}
}

package test.game.map;

import static org.junit.Assert.*;

import rpg.game.map.PositionBehavior2D;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPositionBehavior2DId {
	private PositionBehavior2D pos;
	private int mapId;
	private int x;
	private int y;
	
	@Before
	public void setUp() throws Exception {
		mapId = Math.round((float)Math.random() * 100f);
		x = Math.round((float)Math.random() * 100f);
		y = Math.round((float)Math.random() * 100f);
		pos = new PositionBehavior2D(mapId, x, y);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositionBehavior2D() {
		assertEquals(mapId, pos.getMapId());
	}

	@Test
	public void testCompareToBadPassedType() {
		assertEquals(-1, pos.compareTo(new Integer(mapId)));
	}
	
	@Test
	public void testCompareToBadMapId() {
		PositionBehavior2D other = new PositionBehavior2D(mapId + 1, x, y);
		
		assertEquals(-1, pos.compareTo(other));
	}
	
	@Test
	public void testCompareToSuccess() {
		PositionBehavior2D other = new PositionBehavior2D(mapId, x, y);
		
		assertEquals(0, pos.compareTo(other));
	}

	@Test
	public void testSetMapId() {
		pos.setMapId(mapId + 1);
		
		assertEquals(mapId + 1, pos.getMapId());
	}

}

package rpg.game.map;

import rpg.game.actor.Actor;
import rpg.game.actor.behavior.BaseBehaviorComponent;
import rpg.game.actor.behavior.BehaviorType;

/**
 * Behavior component that represents an actor with a visible position on a map.
 * @author master
 */
public class PositionBehavior2D extends BaseBehaviorComponent implements Position {
	protected int mapId;
	protected int xCoord;
	protected int yCoord;
	
	public PositionBehavior2D(int mapId) {
		super(BehaviorType.POSITION);
		
		this.mapId = mapId;
		xCoord = 0;
		yCoord = 0;
	}
	
	public PositionBehavior2D(int mapId, int xCoord, int yCoord) {
		super(BehaviorType.POSITION);
		
		this.mapId = mapId;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	@Override
	public int compareTo(Object arg0) {
		if (arg0 instanceof PositionBehavior2D) {
			PositionBehavior2D other = (PositionBehavior2D)arg0;
			
			if (mapId == other.getMapId() && xCoord == other.getxCoord() && yCoord == other.getyCoord())
				return 0;
		}
		
		return -1;
	}

	/**
	 * Tests to see if the passed position is adjacent to this position.
	 * In this case "adjacent" means in a square of the map where it can be interacted with. Therefore, diagonal does not count.
	 */
	@Override
	public boolean adjacentTo(Position p) {
		if (p instanceof PositionBehavior2D) {
			PositionBehavior2D other = (PositionBehavior2D)p;
			
			return Math.abs((xCoord + yCoord) - (other.xCoord + other.yCoord)) == 1;
		}
		return false;
	}

	@Override
	public boolean onTopOf(Position p) {
		if (p instanceof PositionBehavior2D) {
			PositionBehavior2D other = (PositionBehavior2D)p;
			
			return compareTo(other) == 0;
		}
		return false;
	}

	/**
	 * Perform self act operations.
	 * PositionBehavior2D objects don't act on their own.
	 */
	@Override
	public boolean act(int id) {
		//PositionBehavior does not act
		return false;
	}

	/**
	 * Draw the Actor's icon on the map.
	 * @param other Map actor to draw on.
	 */
	@Override
	public boolean actOn(int id, Actor other) {
		if (other.hasBehavior(BehaviorType.MAP)) {
			//TODO Position behavior should draw itself on the map Actor.
			return true;
		}
		return false;
	}

	/**
	 * @return the mapId
	 */
	public int getMapId() {
		return mapId;
	}

	/**
	 * @return the xCoord
	 */
	public int getxCoord() {
		return xCoord;
	}

	/**
	 * @return the yCoord
	 */
	public int getyCoord() {
		return yCoord;
	}

	/**
	 * @param mapId the mapId to set
	 */
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	/**
	 * @param yCoord the yCoord to set
	 */
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PositionBehavior2D [mapId=" + mapId + ", xCoord=" + xCoord
				+ ", yCoord=" + yCoord + "]";
	}
}

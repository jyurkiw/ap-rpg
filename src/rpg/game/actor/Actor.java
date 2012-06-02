package rpg.game.actor;

import rpg.game.actor.behavior.Behavior;
import rpg.game.actor.behavior.BehaviorType;
import java.util.EnumMap;

/**
 * Represents an actor in an RPG.
 * An actor consists of three things:
 * <ol>
 * 	<li>An identity to tell one actor from another</li>
 * 	<li>A collection of behaviors</li>
 * </ol>
 * An actor is a base object for a <a src="http://cowboyprogramming.com/2007/01/05/evolve-your-heirachy/">componentized behavior system</a>.
 * @author master
 */
public class Actor {
	protected int id;
	protected EnumMap<BehaviorType, Behavior> behaviorMap;
	
	/**
	 * Create an empty Actor.
	 */
	public Actor() {
		id = -1;
		behaviorMap = new EnumMap<BehaviorType, Behavior>(BehaviorType.class);
	}
	
	/**
	 * Create an Actor with the passed id and an empty behavior map.
	 * @param id The Actor's id.
	 */
	public Actor(int id) {
		this.id = id;
		behaviorMap = new EnumMap<BehaviorType, Behavior>(BehaviorType.class);
	}
	
	/**
	 * Create an Actor with the passed id and behavoir map.
	 * @param id The Actor's id.
	 * @param behaviorMap The Actor's behavior map.
	 */
	public Actor(int id, EnumMap<BehaviorType, Behavior> behaviorMap) {
		this.id = id;
		this.behaviorMap = new EnumMap<BehaviorType, Behavior>(behaviorMap);
	}
	
	/**
	 * Does this actor have the passed behavior in its behavior map?
	 * @param b The behavior to check for.
	 * @return True if yes, false if no.
	 */
	public boolean hasBehavior(BehaviorType b) {
		return behaviorMap.containsKey(b);
	}
	
	/* GETTERS */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the behaviorMap
	 */
	public EnumMap<BehaviorType, Behavior> getBehaviorMap() {
		return behaviorMap;
	}
	
	
	/* SETTERS */
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param behaviorMap the behaviorMap to set
	 */
	public void setBehaviorMap(EnumMap<BehaviorType, Behavior> behaviorMap) {
		this.behaviorMap = behaviorMap;
	}
}

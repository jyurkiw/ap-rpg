package rpg.game.actor.behavior;

import rpg.game.actor.Actor;

import java.util.ArrayList;

/**
 * Represents the base functionality and data required to represent a behavior.
 * @author master
 *
 */
public abstract class BaseBehaviorComponent implements Behavior {
	protected ArrayList<BehaviorType> type;

	public BaseBehaviorComponent(BehaviorType type) {
		this.type = new ArrayList<BehaviorType>();
		this.type.add(type);
	}
	
	public BaseBehaviorComponent(BehaviorType[] typeList) {
		type = new ArrayList<BehaviorType>();
		
		for (BehaviorType b : typeList)
			type.add(b);
	}
	
	public BaseBehaviorComponent(ArrayList<BehaviorType> typeList) {
		type = new ArrayList<BehaviorType>(typeList);
	}
	
	/**
	 * @return the type
	 */
	public ArrayList<BehaviorType> getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ArrayList<BehaviorType> type) {
		this.type = type;
	}

	/**
	 * Required method from the Behavior interface.
	 * Determines if this behavior is of the passed type.
	 * 
	 * @param BehaviorType b The BehaviorType to compare to.
	 * @return boolean True if yes, False if no.
	 */
	@Override
	public boolean isBehaviorType(BehaviorType b) {
		return type.contains(b);
	}

	/**
	 * Required method from the Behavior interface.
	 * Causes the behavior to do whatever it does.
	 * 
	 * @return boolean True if the behavior was a success, and false otherwise. Purpose of the return depends on the system calling act().
	 */
	@Override
	public abstract boolean act(int id);

	/**
	 * Required method from the Behavior interface.
	 * Causes the behavior to do whatever it does to the passed actor.
	 * 
	 * @return boolean True if the behavior was a success, and false otherwise. Purpose of the return depends on the system calling act().
	 */
	@Override
	public abstract boolean actOn(int id, Actor other);
}

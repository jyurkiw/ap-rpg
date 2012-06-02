package rpg.game.actor.behavior;

import rpg.game.actor.Actor;

public interface Behavior {
	public boolean isBehaviorType(BehaviorType b);
	public boolean act(int id);
	public boolean actOn(int id, Actor other);
}

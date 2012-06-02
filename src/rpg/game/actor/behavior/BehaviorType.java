package rpg.game.actor.behavior;

public enum BehaviorType {
	COMBAT,				//The actor can act in combat
	ADVANCABLE,			//The actor can improve over time
	POSITION,			//The actor has a position on the map
	MOBILE,				//The actor is mobile on the map
	MERCHANT,			//The actor will open a store when interacted with
	CONVERSATION,		//The actor will display dialogue when interacted with
	MAP					//The actor is a map that can be drawn on by position actors
}

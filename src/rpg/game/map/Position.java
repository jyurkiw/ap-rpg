package rpg.game.map;

import java.lang.Comparable;

public interface Position extends Comparable<Object> {
	public boolean adjacentTo(Position p);
	public boolean onTopOf(Position p);
}

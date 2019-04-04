package exercise05;

/**
 * Represents an Object that can occupy a Tile.
 *
 * This way, several types of Objects can easily be implemented
 * to be able to occupy Tiles.
 *
 * Used inside the {@link Tile} class Constructor.
 */
public interface TileOccupier {

    /**
     * Boolean flag for identifying the implementing class.
     *
     * @return boolean true if the Object is a Player
     */
    boolean isPlayer();

    /**
     * Boolean flag for identifying the implementing class.
     *
     * @return boolean true if the Object is a Wall
     */
    boolean isWall();

}

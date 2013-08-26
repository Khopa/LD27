package khopa.ld27.game.views.common;

/**
 * Interface for stage 
 * (only in order to respect some conventions in function naming)
 * 
 * @author Clément Perreau
 *
 */
public interface ILayer {

	/**
	 * Init every actors or layer
	 */
	public abstract void initActors();
	
	/**
	 * Organize layers (implicit Z-AXIS)
	 */
	public abstract void layersZ();
	
	/**
	 * Put on the right position
	 */
	public abstract void layout();
	
}

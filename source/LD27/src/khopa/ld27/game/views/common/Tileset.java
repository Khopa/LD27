package khopa.ld27.game.views.common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

/**
 * 
 * Class used to store set of images
 * Cut a texture into several texture region
 * 
 * @author Clément Perreau
 * 
 */
public class Tileset implements Disposable{
	
	
	/**
	 * Tiles size
	 */
	protected int [] tileSize;

	/**
	 * Image
	 */
	private Texture imgdata;
	
	/**
	 * Tiles list
	 */
	protected TextureRegion[] data;
	
	/**
	 * Line size, in tile
	 */
	protected int lineSize;
	
	
	/**
	 * Create a tileset from an image
	 * 
	 * @param path        image path
	 * @param tileXSize   tile x size
	 * @param tileYSize   tile y size
	 */
	public Tileset(String path, int tileXSize, int tileYSize){
		imgdata = new Texture(path);
		tileSize = new int[2];
		tileSize[0] = tileXSize;
		tileSize[1] = tileYSize; 
		System.out.println("Loading : " + path);
		this.prepareData();
	}
	
	/*
	 * Cut the tileset in several texture region
	 */
	private void prepareData(){
		
		int width = this.imgdata.getWidth();
		int height = this.imgdata.getHeight();
		
		lineSize = width/tileSize[0];
		
		// Allocation Mémoire
		data = new TextureRegion[width/tileSize[0]*height/tileSize[1]];
		
		// Creation à partir de l'image
		for(int i = 0; i < width/tileSize[0]; i++){
			for(int j = 0; j < height/tileSize[1]; j++){
				//System.out.println(j*height/tileSize[1] + i);
				data[j*width/tileSize[0] + i] = new TextureRegion(this.imgdata, i*tileSize[0],  j*tileSize[1],  tileSize[0], tileSize[1]);
			}
		}
	
	}
	
	/**
	 * Get a tile according to id
	 * @param id tile's id
	 * @return
	 */
	public TextureRegion getTile(int id){
		return this.data[id];
	}
	
	/**
	 * Tile count
	 * @return
	 */
	public int getTileCount(){
		return this.data.length;
	}

	public int getTileHeight() {
		return tileSize[1];
	}
	
	public int getTileWidth() {
		return tileSize[0];
	}
	
	public void dispose(){
		this.data = null;
		this.imgdata.dispose();
	}


	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}
	
	public Texture getImgdata() {
		return imgdata;
	}

	
}

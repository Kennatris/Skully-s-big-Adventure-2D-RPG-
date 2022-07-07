package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[] [];
	public int number_sprite = 0;
	public int stage = 0;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int [gp.maxWorldCol] [gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/worldV2.txt");
	}
	
	public void getTileImage() {
			
		if(stage == 0) {
						// PLACEHOLDER
						setup(0, "Test", false, false);
						setup(1, "Test", false, false);
						setup(2, "Test", false, false);
						setup(3, "Test", false, false);
						setup(4, "Test", false, false);
						setup(5, "Test", false, false);
						setup(6, "Test", false, false);
						setup(7, "Test", false, false);
						setup(8, "Test", false, false);
						setup(9, "Test", false, false);
						// PLACEHOLDER
						
						setup(10, "Test_1", false, true);
						setup(11, "Test", false, true);
						setup(12, "Test", false, false);
						setup(13, "Test", false, false);
						setup(14, "Test", false, false);
						setup(15, "Test", false, false);
						setup(16, "Test", false, false);
						setup(17, "Test", false, false);
						setup(18, "Test", false, false);
						setup(19, "Test", false, false);
						setup(20, "Test", false, false);
						setup(21, "Test", false, false);
						setup(22, "Test", false, false);
						setup(23, "Test", false, false);
						setup(24, "Test", false, false);
						setup(25, "Test", false, false);
						setup(26, "Test", false, false);
						setup(27, "Test", false, false);
						setup(28, "Test", false, false);
						setup(29, "Test", false, false);
						setup(30, "Test", false, false);
						setup(31, "Test", false, false);
						setup(32, "Test", false, false);
						setup(33, "Test", false, false);
						setup(34, "Test", false, false);
						setup(35, "Test", false, false);
						setup(36, "Test", false, false);
						setup(37, "Test", false, false);
						setup(38, "Test", false, false);
						setup(39, "Test", false, false);
						setup(40, "Test", false, false);
						setup(41, "Test", false, false);
		} else if (stage == 1){
						// PLACEHOLDER
						setup(0, "Test", false, false);
						setup(1, "Test", false, false);
						setup(2, "Test", false, false);
						setup(3, "Test", false, false);
						setup(4, "Test", false, false);
						setup(5, "Test", false, false);
						setup(6, "Test", false, false);
						setup(7, "Test", false, false);
						setup(8, "Test", false, false);
						setup(9, "Test", false, false);
						// PLACEHOLDER
						
						setup(10, "Test_2", false, true);
						setup(11, "Test", false, true);
						setup(12, "Test", false, false);
						setup(13, "Test", false, false);
						setup(14, "Test", false, false);
						setup(15, "Test", false, false);
						setup(16, "Test", false, false);
						setup(17, "Test", false, false);
						setup(18, "Test", false, false);
						setup(19, "Test", false, false);
						setup(20, "Test", false, false);
						setup(21, "Test", false, false);
						setup(22, "Test", false, false);
						setup(23, "Test", false, false);
						setup(24, "Test", false, false);
						setup(25, "Test", false, false);
						setup(26, "Test", false, false);
						setup(27, "Test", false, false);
						setup(28, "Test", false, false);
						setup(29, "Test", false, false);
						setup(30, "Test", false, false);
						setup(31, "Test", false, false);
						setup(32, "Test", false, false);
						setup(33, "Test", false, false);
						setup(34, "Test", false, false);
						setup(35, "Test", false, false);
						setup(36, "Test", false, false);
						setup(37, "Test", false, false);
						setup(38, "Test", false, false);
						setup(39, "Test", false, false);
						setup(40, "Test", false, false);
						setup(41, "Test", false, false);
		}
		
			
		
	}
	
	public void setup(int index, String imageName, boolean collision, boolean animated) {
		
		UtilityTool uTool = new UtilityTool();
		
		try {
			
			tile [index] = new Tile();
			tile [index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName +".png"));
			tile [index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile [index].collision = collision;
			tile [index].animated = animated;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
public void loadMap (String filePath) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
			   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			}
			
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
		
	}
}

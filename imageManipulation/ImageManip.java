// garbage file i made when i was bored
// demonstrates imageio and image editing

package imageManipulation;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageManip {
	public static void main(String[] args) throws Exception {

		BufferedImage boi = ImageIO
				.read(new File("imageManipulation/,,14.jpg"));
		// Do not look at raw image, it is ugly
		BufferedImage gurl = new BufferedImage(boi.getWidth(), boi.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		int color, alpha, red, green, blue;

		for (int i = 0; i < boi.getWidth(); i++) {
			for (int j = 0; j < boi.getHeight(); j++) {
				color = boi.getRGB(i, j);
				alpha = getAlpha(color);
				red = getRed(color);
				green = getGreen(color);
				blue = getBlue(color);

				int color2 = alpha << 24 | red << 16 | green << 8 | blue << 0; // bitshift
																				// process
				int color3 = alpha << 24 | blue << 16 | green << 8 | red << 0;
				gurl.setRGB(i, j, color3);

			}

		}
		ImageIO.write(gurl, "gif", new File("imageManipulation/kokonut.gif"));

	}

	public static int getAlpha(int color) {
		int mask = 0b11111111000000000000000000000000;
		return ((color & mask) >>> 24);
	}

	public static int getRed(int color) {
		int mask = 0b00000000111111110000000000000000;
		return ((color & mask) >> 16);
	}

	public static int getGreen(int color) {
		int mask = 0b00000000000000001111111100000000;
		return ((color & mask) >> 8);
	}

	public static int getBlue(int color) {
		int mask = 0b00000000000000000000000011111111;
		return (color & mask);// same way as using binary???
	}
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String... args) {

        try {

            File input = new File("./src/200001.bmp");
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(
                    image.getWidth()+30,
                    image.getHeight()+30,
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            for (int i = 0; i < result.getHeight(); i++) {
                for (int j = 0; j < result.getWidth(); j++) {
                    result.setRGB(j, i, Color.RED.getRGB());
                }
            }
            graphic.drawImage(image, 15, 15, Color.WHITE, null);

            File output = new File("2.bmp");
            ImageIO.write(result, "bmp", output);

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

}
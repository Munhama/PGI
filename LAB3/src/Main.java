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
                    image.getHeight(),
                    image.getWidth(),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.translate((image.getHeight() - image.getWidth()) / 2, (image.getHeight() - image.getWidth()) / 2);
            graphic.rotate(Math.PI / 2, image.getHeight() / 2, image.getWidth() / 2);
            graphic.drawRenderedImage(image, null);

            File output = new File("3.bmp");
            ImageIO.write(result, "bmp", output);

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

}
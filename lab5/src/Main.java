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
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            File logo = new File("./src/java-duke.bmp");
            BufferedImage logoImage = ImageIO.read(logo);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);

            graphic.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) .5));

            graphic.drawImage(logoImage, 450, 10, null, null);

            graphic.dispose();
            File output = new File("5.bmp");
            ImageIO.write(result, "bmp", output);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}





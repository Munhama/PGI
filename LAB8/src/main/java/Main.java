import net.sf.image4j.util.ConvertUtil;
import org.apache.commons.imaging.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ImageWriteException, ImageReadException {
        File file = new File("./src/main/java/TC.bmp");
        toBMP(file);
    }

    public static void toBMP(File file) throws IOException, ImageWriteException, ImageReadException {
        BufferedImage bf = ImageIO.read(file);
        BufferedImage out8bit = ConvertUtil.convert8(bf);
        File outFile = new File("new.bmp");
        ImageIO.write(out8bit, "bmp", outFile);
    }
}

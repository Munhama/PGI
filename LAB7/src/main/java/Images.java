import javafx.scene.transform.Scale;
import net.sf.image4j.util.ConvertUtil;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    public BufferedImage bf;

    public Images() throws IOException {
        File file = new File("./src/main/java/200001.PCX");
        bf = ImageIO.read(file);
        System.out.println(bf);
    }

}

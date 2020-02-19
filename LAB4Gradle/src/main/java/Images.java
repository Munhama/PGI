import javafx.scene.transform.Scale;
import net.sf.image4j.util.ConvertUtil;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    public BufferedImage out4bit;
    public BufferedImage out8bit;
    public BufferedImage out24bit;
    public BufferedImage scaled;

    public Images(double coef) throws IOException {
        final File inFile = new File("./src/main/java/200001.bmp");
        final File outFile = new File("4.bmp");
        final File outFile2 = new File("5.bmp");
        final File outFile3 = new File("6.bmp");

        BufferedImage inImage = ImageIO.read(inFile);
        out4bit = ConvertUtil.convert4(inImage);
        out8bit = ConvertUtil.convert8(inImage);
        out24bit = ConvertUtil.convert24(inImage);

        final int w = out8bit.getWidth();
        final int h = out8bit.getHeight();
        scaled = new BufferedImage((w),(h), BufferedImage.TYPE_INT_ARGB);
        final AffineTransform at = AffineTransform.getScaleInstance(coef, coef);
        final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        scaled = ato.filter(out8bit, scaled);

        ImageIO.write(out4bit, "bmp", outFile);
        ImageIO.write(out8bit, "bmp", outFile2);
        ImageIO.write(out24bit, "bmp", outFile3);

    }

}

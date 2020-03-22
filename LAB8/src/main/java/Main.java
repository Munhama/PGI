import net.sf.image4j.util.ConvertUtil;
import org.apache.commons.imaging.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ImageWriteException {
        File file = new File("./src/main/java/256.bmp");
        toPCX(file);
    }

    public static void toPCX(File file) throws IOException, ImageWriteException {
            BufferedImage bf = ImageIO.read(file);
            BufferedImage out4bit = ConvertUtil.convert4(bf);
            FileOutputStream fos=new FileOutputStream("new.pcx");
            byte[] buffer = imageWriteExample(out4bit);
            fos.write(buffer, 0, buffer.length);
    }

    public static byte[] imageWriteExample(final BufferedImage file) throws ImageWriteException, IOException {
        final ImageFormat format = ImageFormats.PCX;
        final Map<String, Object> params = new HashMap<>();
        return Imaging.writeImageToBytes(file, format, params);
    }
}

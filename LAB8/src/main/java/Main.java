import org.apache.commons.imaging.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ImageWriteException, ImageReadException {
        System.out.println("Converter PCX->BMP or BMP->PCX");
        System.out.println("Enter file name: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        File file = new File("./src/main/java/"+inputString);
        if (inputString.endsWith("pcx") || inputString.endsWith("PCX")){
            toBMP(file);
        }else if (inputString.endsWith("bmp") || inputString.endsWith("BMP")){
            toPCX(file);
        }else System.out.println("File not BMP or PCX!!!");
    }

    public static void toBMP(File file) throws IOException, ImageWriteException, ImageReadException {
//        BufferedImage bf = ImageIO.read(file);
//        File output = new File("new.bmp");
//        ImageIO.write(bf, "bmp", output);
        FileOutputStream fos=new FileOutputStream("new.bmp");
// перевод строки в байты
        byte[] buffer = imageWriteBMP(file);

        fos.write(buffer, 0, buffer.length);
    }

    public static void toPCX(File file) throws IOException, ImageWriteException, ImageReadException {
        BufferedImage bf = ImageIO.read(file);
        File output = new File("new.pcx");
        FileOutputStream fos=new FileOutputStream("new.pcx");
// перевод строки в байты
byte[] buffer = imageWriteExample(file);

fos.write(buffer, 0, buffer.length);

    }

    public static byte[] imageWriteExample(final File file)
            throws ImageReadException, ImageWriteException, IOException {
        // read image
        final BufferedImage image = Imaging.getBufferedImage(file);

        final ImageFormat format = ImageFormats.PCX;
        final Map<String, Object> params = new HashMap<>();

        // set optional parameters if you like
        //params.put(ImagingConstants.PARAM_KEY_COMPRESSION, Integer.valueOf(ImagingConstants.));

        final byte[] bytes = Imaging.writeImageToBytes(image, format, params);

        return bytes;
    }

    public static byte[] imageWriteBMP(final File file)
            throws ImageReadException, ImageWriteException, IOException {
        // read image
        final BufferedImage image = Imaging.getBufferedImage(file);

        final ImageFormat format = ImageFormats.BMP;
        final Map<String, Object> params = new HashMap<>();

        // set optional parameters if you like
        //params.put(ImagingConstants.PARAM_KEY_COMPRESSION, Integer.valueOf(ImagingConstants.));

        final byte[] bytes = Imaging.writeImageToBytes(image, format, params);

        return bytes;
    }
}

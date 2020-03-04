/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import javax.swing.text.html.ImageView;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="CanvasFirst"
    private Canvas CanvasFirst; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
        Images images = new Images();
        drawImage(images.bf, CanvasFirst);
    }

    void drawImage(BufferedImage result, Canvas obj) {

        GraphicsContext gc = obj.getGraphicsContext2D();
        PixelWriter pw = gc.getPixelWriter();

        for (int i = 0; i < result.getHeight(); i++) {
            for (int j = 0; j < result.getWidth(); j++) {
                int clr = result.getRGB(j, i);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                pw.setColor(j, i, Color.rgb(red, green, blue));
            }
        }
        gc.stroke();
    }
}

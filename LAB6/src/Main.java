import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        Steganography st = new Steganography();



        st.encode("E:\\PGI\\LAB6\\src", "200001", "bmp", "lab6", readUsingFiles("./src/input.txt"));

        try(FileWriter writer = new FileWriter("./src/output.txt", false))
        {
            // запись всей строки
            String text = st.decode("E:\\PGI\\LAB6\\src","lab6");
            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}

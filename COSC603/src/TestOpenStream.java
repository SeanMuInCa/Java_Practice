import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Purpose:             PACKAGE_NAME<br />
 * Data Submitted:      2024/3/18 <br />
 * Assignment Number:    PACKAGE_NAME<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestOpenStream
{
    public static void main(String[] args) {
        try {
            URL url = new URL("https://qwantz.com");
            InputStream inputStream = url.openStream();

            // 读取输入流中的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭输入流
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

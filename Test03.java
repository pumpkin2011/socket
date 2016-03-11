// 通过 URL 来读取网页内容
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test03 {
  public static void main(String args[]) {
    try {
      URL url = new URL("http://www.baidu.com");
      // 通过 URL 的openStream方法获取 URL 对象所表示的资源的字节输入流
      InputStream is = url.openStream();
      // 将字节输入流转换为字符输入流
      InputStreamReader isr = new InputStreamReader(is, "utf-8");
      // 为字符输入流添加缓冲
      BufferedReader br = new BufferedReader(isr);
      // 读取数据
      String data = br.readLine();
      while(data != null) {
        System.out.println(data);
        data = br.readLine();
      }
      br.close();
      isr.close();
      is.close();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

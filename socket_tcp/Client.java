/*
 *  客户端
 */
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
  public static void main(String[] args) {
    try {
      // 1.创建客户端Socket，执行服务器地址和端口号
      Socket socket = new Socket("localhost", 8888);
      // 2.获取输出流，用来向服务器端发送信息
      OutputStream os = socket.getOutputStream(); // 字节输出流
      PrintWriter pw = new PrintWriter(os);  // 将输出流包装为打印流
      pw.write("username: admin; password: 123");
      pw.flush();  // 刷新缓存，向服务器输出信息
      socket.shutdownOutput(); // 关闭输出流
      // 3. 获取输入流，用来读取服务器端的响应信息
      InputStream is = socket.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String info = null;
      while((info = br.readLine()) != null) {
        System.out.println("i am client: " + info);
      }
      // 4. 关闭相关资源
      br.close();
      is.close();
      pw.close();
      os.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // catch (UnknownHostException e) {
  //    e.printStackTrace();
  //  }

  }
}

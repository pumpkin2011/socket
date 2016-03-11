/*
 * 服务器端线程处理类
 */
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class ServerThread extends Thread {
  // 和本线程相关的 Socket
  Socket socket = null;
  public ServerThread(Socket socket) {
    this.socket = socket;
  }

  // 线程执行操作，响应客户端请求
  public void run() {
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    OutputStream os = null;
    PrintWriter pw = null;
    try {
    // 获取输入流，用来读取客户端提交的登录信息
      is = socket.getInputStream();
      isr = new InputStreamReader(is); // 将字节流包装成字符流提高读取性能
      br = new BufferedReader(isr);  // 为输入流添加缓冲
      String info = null;
      while((info=br.readLine()) != null) {
        System.out.println("info from client：" + info);
      }
      // 获取输出流，响应客户端的请求
      os = socket.getOutputStream();
       pw = new PrintWriter(os); // 包装为打印流
      pw.write("welcome");
      pw.flush(); //刷新缓存，输出
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 关闭相关资源
      try {
        if (pw != null)
          pw.close();
        if (os != null)
          os.close();
        if (br != null)
          br.close();
        if (isr != null)
          isr.close();
        if (is != null)
          is.close();
        if (socket != null)
          socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}

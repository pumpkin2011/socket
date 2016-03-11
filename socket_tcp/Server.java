/*
 *  基于 TCP 协议的 Socket 通信，实现用户登录
 *  服务器端
 */
import java.net.ServerSocket;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;

public class Server {
  public static void main(String[] args) {
    try {
      // 1.创建一个服务器端 Socket，即 ServerSocket,指定绑定的端口，并监听此端口
      ServerSocket serverSocket = new ServerSocket(8888);
      Socket socket = null;
      // 记录客户端的数量
      int count = 0;
      // 2.创建 accept() 方法开始监听，等待客户端的连接
      System.out.println("***server will start***");
      // 循环监听等待客户端的连接
      while(true) {
        // 调用accept() 方法开始监听，等待客户端的连接
        socket = serverSocket.accept();
        // 创建一个新线程
        ServerThread serverThread = new ServerThread(socket);
        serverThread.start();
        count ++;  // 统计客户端的数量
        System.out.println("the count is : " + count);
        InetAddress address = socket.getInetAddress();
        System.out.println("current ip address is :" + address);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

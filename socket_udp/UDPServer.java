/*
 * 服务器端，实现基于UDP的用户登录
 */
import java.net.SocketException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;

public class UDPServer {
  public static void main(String[] args) throws SocketException, IOException {
    // 1.创建服务器端 DatagramSocket，指定端口
    DatagramSocket socket = new DatagramSocket(8800);
    // 2.创建数据报，用于接受客户端发送的数据
    byte[] data = new byte[1024];
    DatagramPacket packet = new DatagramPacket(data, data.length);
    // 3.接受客户端发送的数据
    socket.receive(packet); // 保存到packet中，此方法在接受到数据报之前会一直阻塞
    // 4.读取数据
    String info = new String(data, 0, packet.getLength());
    System.out.println("I am server, client says:" + info);
  }
}

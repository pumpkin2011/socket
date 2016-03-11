/*
 * 客户端
 */
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
  public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
    // 1.定义服务器地址、端口号、数据
    InetAddress address = InetAddress.getByName("localhost");
    int port = 8800;
    byte[] data = "username:admin; password: 123".getBytes();
    // 2.创建数据报，包含发送的数据信息
    DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
    // 3.创建DatagramSocket 对象
    DatagramSocket socket = new DatagramSocket();
    // 4.向服务器端发送数据报
    socket.send(packet);
  }
}

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) throws UnknownHostException {
		// 获取本机的InetAddress 实例
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		byte[] bytes = address.getAddress(); // 获取字节数组形式的IP地址
		System.out.println(bytes);
		System.out.println(address); // 直接输出InetAddress 对象

		// 根据机器名获取 InetAddress 实例
	  //	InetAddress address2 = InetAddress.getByBane('LeeZhenhuans-MacBook-Pro.local');
		InetAddress address2 = InetAddress.getByName("192.168.1.13");
		System.out.println("com name" + address2.getHostName());
		System.out.println("ip address" + address2.getHostAddress());

	}
}

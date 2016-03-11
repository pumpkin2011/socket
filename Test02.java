import java.net.URL;
import java.net.MalformedURLException;

public class Test02 {
	public static void main(String[] args) {
		try {
			URL imooc = new URL("http://www.imooc.com");
			URL url = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("协议：" + url.getProtocol()); // 协议：http
			System.out.println("主机：" + url.getHost());  // 主机：www.imooc.com
			// 如果未指定端口号，则使用默认的端口号，此时，getPort() 方法返回值是 -1
			System.out.println("端口：" + url.getPort());  // 端口：-1
			System.out.println("文件路径：" + url.getPath());  // 文件路径：/index.html
			System.out.println("文件名称：" + url.getFile());  // 文件名称：/index.html?username=tom
			System.out.println("相对路径：" + url.getRef());  // 相对路径：test
			System.out.println("查询字符串：" + url.getQuery());  // 查询字符串：username=tom
		} catch(MalformedURLException e) {
				e.printStackTrace();
		}
	}
}

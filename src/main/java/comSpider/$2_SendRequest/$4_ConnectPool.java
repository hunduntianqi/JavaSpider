package comSpider.$2_SendRequest;
/*
    使用连接池管理HttpClient对象:
        1. 创建连接池对象:
            PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
        2. 使用HttpClients.customer()方法创建HttpClient对象并设置连接池
            CloseableHttpClient httpobject = HttpClients.custom().setConnectionManager(cm).build();
        3. 创建请求对象
        4. 发送请求
        5. 打印结果
        6. 关闭Response对象
            注意: 使用连接池不需要关闭HttpClient对象
 */

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class $4_ConnectPool {
    public static void main(String[] args) throws Exception {
        // 创建连接池对象
        PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
        // 使用连接池创建HttpClient对象
        CloseableHttpClient httpobject = HttpClients.custom().setConnectionManager(cm).build();
        // 创建请求对象
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        // 发送请求获取响应对象
        CloseableHttpResponse response = httpobject.execute(httpget);
        // 打印响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println("响应状态码:" + code);
        // 打印页面源码
        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        // 关闭响应对象
        response.close();
    }
}

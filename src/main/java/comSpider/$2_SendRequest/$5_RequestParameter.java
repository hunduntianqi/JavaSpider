package comSpider.$2_SendRequest;

/*
    请求参数设置:
        RequestConfig config = RequestConfig.custom().setConnectTimeout(numTime).build(); ==> 设置创建连接的最长时间, 单位是毫秒
        RequestConfig config = RequestConfig.custom().setConnectRequestTimeout(numTime).build();
            ==> 设置获取连接的最长时间, 单位是毫秒
        RequestConfig config = RequestConfig.custom().setSocketTimeout(numTime).build(); ==> 设置数据传输的最长时间, 单位是毫秒
    请求对象添加请求信息 ==> httpGet.setConfig(config)
 */

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class $5_RequestParameter {
    public static void main(String[] args) throws Exception{
        // 创建一个HTTPClient对象(CloseableHttpClient), 使用工具类-HttpClients创建对象, 相当于打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建一个HttpClient对象
        // 创建一个HttpGet对象
        HttpGet httpget = new HttpGet("https://www.itcast.cn/");
        // 设置请求头, 进行UA伪装
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
        // 创建请求参数配置对象
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000).setConnectionRequestTimeout(1000).build();
        httpget.setConfig(config);
        // 使用HttpClient对象发送请求, 获得http响应对象
        CloseableHttpResponse response = httpClient.execute(httpget);
        // 得到服务端响应, 获取服务端状态码
        StatusLine statusLine = response.getStatusLine();
        System.out.println(statusLine);
        int statuscode = statusLine.getStatusCode(); // 获取状态响应码
        // 打印状态码
        System.out.println("响应状态码:" + statuscode);
        // 获取服务端响应内容
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity, "utf-8");
        // 打印Html
        System.out.println(html);
        // 关闭流
        response.close();
        httpClient.close();
    }
}

package comSpider.$2_SendRequest;

/*
    发送带参数Get请求:
        1. 创建一个HTTPClient对象(CloseableHttpClient)
            使用工具类-HttpClients创建对象, 相当于打开一个浏览器
                CloseableHttpClient httpClient = HttpClients.createDefault()
        2. 创建 URIBuilder 对象, 设置参数:
            URIBuilder uriBuilder = new URIBuilder("url")
            设置参数 ==> uriBuilder.setParameter("ParameterName", "ParameterValue")
        3. 创建一个HTTPGet请求对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            添加请求头数据:
                httpGet.setHeader("name", "value")
        4. 使用HttpClient对象发送请求, 获得响应对象
            CloseableHttpResponse response = httpClient.execute(httpget);
        5. 得到服务端响应, 获取响应数据
            StatusLine statusLine = response.getStatusLine();
            System.out.println(statusLine);
            int statuscode = statusLine.getStatusCode(); // 获取状态响应码
            // 打印状态码
            System.out.println(statuscode);
            // 获取服务端响应内容
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "utf-8");
            // 打印Html
            System.out.println(html);
        6. 关闭流
            response.close(); ==> 关闭响应对象
            httpClient.close(); ==> 关闭HTTPClient对象
 */

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class $2_GetRequestParameter {
    public static void main(String[] args) throws Exception {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建URIBuilder对象, 设置请求参数
        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com/s");
        // 设置请求参数
        uriBuilder.setParameter("wd", "气功");
        System.out.println(uriBuilder);
        // 创建HttpGet对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
        // 发送请求, 获取响应对象
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println("响应状态码 ==> " + response.getStatusLine().getStatusCode());
        // 获取页面html内容
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity, "utf-8");
        System.out.println(html);
        // 关闭响应对象
        response.close();
        // 关闭客户端对象
        httpClient.close();
    }
}

package comSpider.$2_SendRequest;

/*
    发送Post请求:
        1. 创建HttpClient对象
            HttpClient httpPost = HttpClients.createDefault();
        2. 创建一个HttpPost对象
            HttpPost post = new HttpPost("url");
        3. 创建HttpEntity对象, 相当于post请求提交的表单(HttpEntity为接口, 需使用对应实现类UrlEncodedFormEntity创建对象)
            HttpEntity entity = new UrlEncodedFormEntity(List<? extends NameValuePair> parameters, String charset)
            3.1 创建一个List集合, 添加请求参数
                ArrayList<NameValuePair> form = new ArrayList<NameValuePair>();
            3.2 向集合中添加NameValuePair实现类BasicNameValuePair对象
                form.add(new BasicNameValuePair("ParameterName", "ParameterValue"));
            3.3 集合创建完成并添加相应表单数据后, 创建HttpEntity实现类对象
                HttpEntity entity = new UrlEncodedFormEntity(form, "utf-8");
            3.4. 把表单添加到HttpPost对象中
                post.setEntity(entity);
        5. 发送post请求
            CloseableHttpResponse response = httppost.execute(post);
        6. 接收服务端响应数据
        7. 打印输出响应数据
        8. 关闭响应流对象和客户端对象
 */

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

public class $3_PostRequest {
    public static void main(String[] args) throws Exception {
        // 创建httpclient对象
        CloseableHttpClient httpPost = HttpClients.createDefault();
        // 创建post请求对象
        HttpPost post = new HttpPost("https://mail.qq.com/cgi-bin/frame_html");
        // 创建一个List集合, 添加请求参数
        ArrayList<NameValuePair> form = new ArrayList<NameValuePair>();
        // 向集合中添加NameValuePair实现类BasicNameValuePair对象
        form.add(new BasicNameValuePair("sid", "QI3qz1oGgJ2EAWYE"));
        form.add(new BasicNameValuePair("r", "0e28d19eb9eb58654c23ad2243a0ae73"));
        // 创建HttpEntity对象
        HttpEntity entity = new UrlEncodedFormEntity(form, "utf-8");
        // 将HttpEntity对象添加到post请求对象中
        post.setEntity(entity);
        // 设置请求头信息
        post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
        // 发送post请求l, 获取响应对象
        CloseableHttpResponse response = httpPost.execute(post);
        // 接收响应数据, 打印响应状态码
        StatusLine status = response.getStatusLine();
        int statuscode = status.getStatusCode();
        System.out.println("响应状态码:" + statuscode);
        // 打印页面源码
        HttpEntity entity_Html = response.getEntity();
        System.out.println(EntityUtils.toString(entity_Html, "gb18030"));
        // 关闭响应对象
        response.close();
        // 关闭httpclient对象
        httpPost.close();
    }
}

package comSpider.$4_ParseDataExample;

/*
    Xpath解析数据
 */

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class $2_XpathParseExample {
    public static void main(String[] args) throws Exception {
        // 创建连接池对象
        PoolingHttpClientConnectionManager poolClient = new PoolingHttpClientConnectionManager();
        // 创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolClient).build();
        // 定义变量, 存储url
        String url = "";
        // 定义变量, 作为计数器
        int num = 1;
        // 定义变量, 控制循环是否结束
        boolean flag = true;
        while (flag) {
            if (num == 1) {
                url = "https://m.bcoderss.com/tag/%E7%BE%8E%E5%A5%B3/";
            } else {
                url = "https://m.bcoderss.com/tag/%e7%be%8e%e5%a5%b3/page/" + num + "/";
            }
            // 创建请求对象
            HttpGet httpGet = new HttpGet(url);
            // 设置请求头
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
            // 发送请求, 获取响应数据
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println("响应状态码 ==> " + response.getStatusLine().getStatusCode());
            // 获取响应内容
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "utf-8");
            // 调用方法, 解析数据
            xpathParse(html, num);
            // 判断是否存在下一页
            if (html.contains("加载更多")) {
                System.out.println("存在下一页数据, 继续抓取中~~~");
            } else {
                System.out.println("数据抓取完毕!!");
                flag = false;
            }
//            if (num == 3) {
//                flag = false;
//            }
            // 关闭响应对象
            response.close();
            // 计数器加一
            num++;
        }
    }

    // 定义方法, 解析数据
    public static void xpathParse(String html, int page) throws Exception {
        // 创建Document对象
        Document document = Jsoup.parse(html);
        Elements liList = document.selectXpath("//*[@id=\"main\"]/li");
        for (int i= 0; i < liList.size(); i++) {
            System.out.println("href = " + liList.get(i).selectXpath("./a").attr("href"));
            System.out.println("title = " + liList.get(i).selectXpath("./a").attr("title"));
            System.out.println("============================");
        }
        System.out.printf("第 %s 页数据抓取完毕!!\n", page);
    }
}

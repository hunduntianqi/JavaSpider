package comSpider.$4_ParseDataExample;

/*
    正则表达式解析数据:
        抓取豆瓣Top250电影信息
 */

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class $3_RegexParseExample {
    public static void main(String[] args) throws Exception {
        // 创建连接池对象
        PoolingHttpClientConnectionManager poolClient = new PoolingHttpClientConnectionManager();
        // 创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolClient).build();
        for (int i = 0; i < 10; i++) {
            // 定义URL
            String url = "https://movie.douban.com/top250?start=%s".formatted(i * 25);
            // 创建请求对象
            HttpGet httpGet = new HttpGet(url);
            // 添加请求头
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
            // 发送请求, 获取响应数据
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println("响应连接状态为 ==> %s".formatted(response.getStatusLine().getStatusCode()));
            // 获取响应内容
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "utf-8");
            // System.out.println(html);
            // 调用方法, 解析数据
            parseHtml(html);
            // 关闭响应对象
            response.close();
        }
    }

    // 定义方法, 使用正则表达式解析数据
    public static void parseHtml(String html) {
        // 创建集合, 存储数据
        ArrayList<TreeMap<String, String>> list = new ArrayList<>();
        // 去除文本中的换行符
        html = html.replaceAll("\n", "").replaceAll("&nbsp;/&nbsp;", "").
                replaceAll("&nbsp;", "");
        System.out.println(html);
        // 定义正则表达式
        String regex = "<div class=\"item\">.*?<a href=\"(.*?)\">.*?<div class=\"hd\">.*?<span class=\"title\">(.*?)</span>" +
                ".*?<span class=\"title\">(.*?)</span>.*?<div class=\"bd\">.*?<p class=\"\">.*?<br>(.*?)</p>.*?" +
                "class=\"rating_num\" property=\"v:average\">(.*?)</span>.*?<span>(.*?)</span>.*?<span class=\"inq\">(.*?)</span> ";
        // 定义匹配规则对象
        Pattern pattern = Pattern.compile(regex);
        // 获取匹配数据对象
        Matcher matcher = pattern.matcher(html);
        // 读取匹配器匹配的信息
        while (matcher.find()) {
            // 定义HashMap集合
            TreeMap<String, String> map = new TreeMap<>();
            // System.out.println("电影链接 ==> " + matcher.group(1).strip());
            map.put("电影链接", matcher.group(1).strip());
            // System.out.println("电影中文名称 ==> " + matcher.group(2).strip());
            map.put("电影中文名称", matcher.group(2).strip());
            // System.out.println("电影英文名称 ==> " + matcher.group(3).strip());
            map.put("电影英文名称", matcher.group(3).strip());
            // System.out.println("电影主题与上映时间 ==> " + matcher.group(4).strip());
            map.put("电影导演与主演", matcher.group(4).strip());
            // System.out.println("电影评分 ==> " + matcher.group(5).strip());
            map.put("电影评分", matcher.group(5).strip());
            // System.out.println("电影评价人数 ==> " + matcher.group(6).strip());
            map.put("电影评价人数", matcher.group(6).strip());
            // System.out.println("电影主题思想 ==> " + matcher.group(7).strip());
            map.put("电影主题思想", matcher.group(7).strip());
            // System.out.println("==============================");
            // map加入list集合
            list.add(map);
        }
        // 遍历集合
        for (TreeMap<String, String> map : list) {
            System.out.println(map);
        }
    }
}

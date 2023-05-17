package comSpider.$5_JsonParse;

/*
    json解析豆瓣排行榜电影信息
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class $4_DouBanDataParse {
    public static void main(String[] args) throws Exception {
        // 定义变量, 存储Excel文件路径
        String filePath = "src/main/java/comSpider/$5_JsonParse/豆瓣电影信息.xlsx";
        // 创建List集合, 存储Excel模板对象
        List<ExcelTemplateClass> listTemp = new ArrayList<>();
        // 创建连接池对象
        PoolingHttpClientConnectionManager poolClient = new PoolingHttpClientConnectionManager();
        // 获取客户端对象
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(poolClient).build();
        // 定义变量, 记录抓取页数
        int page = 1;
        // 定义变量, 控制循环是否结束
        boolean flag = true;
        // 循环抓取数据
        while (flag) {
            // 创建 URIBuilder 对象
            URIBuilder uriBuilder = new URIBuilder("https://movie.douban.com/j/chart/top_list?interval_id=100%3A90");
            // 添加请求参数
            uriBuilder.setParameter("type", "11");
            // uriBuilder.setParameter("interval_id", "100%3A90");
            uriBuilder.setParameter("action", "11");
            uriBuilder.setParameter("start", Integer.toString((page - 1) * 20));
            uriBuilder.setParameter("limit", "20");
            System.out.println(uriBuilder);
            // 创建 Get 请求对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            // 添加请求头参数
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
            // 发送请求获取响应数据
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseData = EntityUtils.toString(entity, "utf-8");

            // 判断循环是否结束
            if (responseData.equals("[]")) {
                System.out.println("数据抓取完毕, 结束循环");
                flag = false;
            } else {
                // 调用解析方法, 解析 json 数据
                ArrayList<HashMap<String, Object>> list = parseJson(responseData);
                // 遍历集合
                for (HashMap<String, Object> hashMap : list) {
                    System.out.printf("rank: %s, videoTitle:%s, types: %s, url: %s, regions: %s, release_date: %s, score: %s, " +
                                    "actors: %s\n", hashMap.get("rank"), hashMap.get("title"), hashMap.get("types"),
                            hashMap.get("url"), hashMap.get("regions"), hashMap.get("release_date"), hashMap.get("score"), hashMap.get("actors"));
                    ExcelTemplateClass excelTemp = new ExcelTemplateClass((Integer) hashMap.get("rank"), hashMap.get("title") + "",
                            (hashMap.get("types") + "").replace("\"", "").replace("[", "").replace("]", ""),
                            hashMap.get("url") + "", (hashMap.get("regions") + "").replace("\"", "").replace("[", "").replace("]", ""),
                            hashMap.get("release_date") + "", Float.parseFloat((String) hashMap.get("score")), (hashMap.get("actors")+"").replace("\"", "").replace("[", "").replace("]", ""));
                    listTemp.add(excelTemp);
                }
                System.out.printf("第 %s 页数据抓取完毕!!%n", page);
            }
            // 关闭响应对象
            response.close();
            page++;
        }
        // 将数据写入Excel
        EasyExcel.write(filePath, ExcelTemplateClass.class).sheet("影片信息").doWrite(listTemp);
    }

    // 定义方法, 使用 FastJson 解析json数据
    public static ArrayList<HashMap<String, Object>> parseJson(String responseData) {
        // 解析 json 数据为 ArrayList<HashMap<String, Object>> 对象
        return JSON.parseObject(responseData,
                new TypeReference<ArrayList<HashMap<String, Object>>>() {
                }.getType());
    }
}

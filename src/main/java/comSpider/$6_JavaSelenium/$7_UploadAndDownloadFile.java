package comSpider.$6_JavaSelenium;

/*
    Selenium 上传和下载文件:
        上传文件思路:
            sendKeys 实现文件上传:
                1. 找到上传文件的 input 标签, 定位文件上传按钮
                2. 使用sendKeys()方法, 输入要上传文件的绝对路径上传文件
        下载文件到指定路径:
            1. 创建 ChromeOptions 对象, 设置启动参数 ==> ChromeOptions options = new ChromeOptions()
            2. 创建Map集合, 添加保存文件的路径元素 ==> Map<String, Object> mapName = new HashMap<>()
                添加元素 ==> mapName.put(Key, Value):
                    Key: "download.default_directory"; Value: 保存下载文件的路径
            3. 调用方法 ==> options.setExperimentalOption("prefs", mapName), 修改默认文件下载路径
            4. 创建 DesiredCapabilities 对象 ==> DesiredCapabilities caps = new DesiredCapabilities()
            5. 调用方法 ==> caps.setCapability(ChromeOptions.CAPABILITY, options)
            6. 创建 ChromeDriver 对象, ChromeDriver driver = new ChromeDriver(options)
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class $7_UploadAndDownloadFile {

    // 定义测试方法, 实现上传文件功能
    @Test
    public void uploadFile() throws Exception{
        // 创建ChromeOptions对象
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置启动参数
        chromeOptions.addArguments("--remote-allow-origins=*", "--start-maximized");
        // 创建浏览器驱动对象
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        // 打开网页
        chromeDriver.get("file:///E:/Users/Administrator/IdeaProjects/WebFrontEnd/1_html/num_1_htmlstudy/num_2_html_tag_study/num_12_form_tag.html");
        Thread.sleep(2000);
        // 定位上传文件按钮
        chromeDriver.findElement(By.xpath("/html/body/form/p[7]/input"))
                .sendKeys("E:\\Users\\Administrator\\IdeaProjects\\Pictures\\pickure\\1675088424171-234394110.jpg");

    }

    // 定义测试方法, 下载文件到指定路径
    @Test
    public void downloadFile() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--remote-allow-origins=*",
                "--start-maximized"
        );
        setDownloadsPath("E:\\Users\\Administrator\\Desktop", options);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://pypi.Python.org/pypi/selenium");
        // 点击下载文件
        driver.findElement(By.xpath("//*[@id=\"files-tab\"]")).click();
        // 下载文件
        driver.findElement(By.xpath("//*[@id=\"files\"]/div[1]/div[2]/a[1]")).click();
    }

    // 定义方法, 设置文件下载路径
    public void setDownloadsPath(String path, ChromeOptions options) {

        Map<String, Object> chromePrefs = new HashMap<>();

        chromePrefs.put("download.default_directory", path);

        options.setExperimentalOption("prefs", chromePrefs);

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(ChromeOptions.CAPABILITY, options);
    }
}

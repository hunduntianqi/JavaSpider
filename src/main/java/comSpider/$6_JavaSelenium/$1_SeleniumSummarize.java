package comSpider.$6_JavaSelenium;

/*
    Selenium:
        一种自动化测试工具, 可以打开浏览器, 然后像人一样操作浏览器, 程序员可以从selenium中直接提取网页上的各种信息
    Selenium引入:
        添加Maven依赖:
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-api</artifactId>
                <version>3.141.59</version>
            </dependency>

            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-chrome-driver</artifactId>
                <version>3.14.0</version>
            </dependency>
        简单使用, 以Chrome为例:
            创建参数设置对象 ==>  ChromeOptions options = new ChromeOptions();
            添加启动参数 ==> options.addArguments("启动参数");
                常见启动参数:
                    --user-agent="" ==> 设置请求头的User-Agent
                    --window-size=1366,768 ==> 设置浏览器分辨率（窗口大小）
                    --headless ==> 无界面运行（无窗口）
                    --start-maximized ==> 最大化运行（全屏窗口）
                    --incognito ==> 隐身模式（无痕模式）
                    --disable-javascript ==> 禁用javascript
                    --disable-infobars ==> 禁用浏览器正在被自动化程序控制的提示
                    --remote-allow-origins=* ==> 解决启动时的 java.io.IOException: Invalid Status code=403 text=Forbidden 异常
            创建WebDriver对象 ==> WebDriver webDriver = new ChromeDriver(options);
            打开网页 ==> webDriver.get(String url);
            定位元素:
                webDriver.findElement(By.xx()) ==> 定位单个元素
                webDriver.findElements(By.xx()) ==> 定位多个元素
                    webDriver.findElement(By.id()) ==> 通过标签 id 定位元素
                    webDriver.findElement((By.name()) ==> 通过标签 name 属性定位元素
                    webDriver.findElement(By.className()) ==> 通过标签 类名 定位元素
                    webDriver.findElement((By.tagName()) ==> 通过 标签名 定位元素
                    webDriver.findElement(By.linkText("text")) ==> 通过 a 标签的文本内容定位元素
                    webDriver.findElement(By.partialLinkText()) ==> 通过 a 标签的文本内容的一部分定位元素
                    webDriver.findElement(By.xpath()) ==> 通过xpath表达式定位元素
                    webDriver.findElement(By.cssSelector()) ==> 通过css选择器定位元素
            清空输入框 ==> webDriver.findElement(By.xx()).clear()
            输入框输入文本 ==> webDriver.findElement(By.xx()).sendKeys(text)
            点击动作 ==> webDriver.findElement(By.xx()).click()
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class $1_SeleniumSummarize {
    public static void main(String[] args) throws Exception {
        // 创建ChromOptions对象
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // 设置窗口最大化
        options.addArguments("--start-maximized");
        // 创建WebDriver对象
        WebDriver webDriver = new ChromeDriver(options);
        // 打开网页
        webDriver.get("https://www.baidu.com");
        // Xpath定位元素
        webDriver.findElement(By.xpath("//*[@id=\"kw\"]")).clear();
        webDriver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("炁体源流");
        webDriver.findElement(By.xpath("//*[@id=\"su\"]")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}

package comSpider.$6_JavaSelenium;

/*
    表单和窗口切换:
        表单切换:
            1. 定位表单元素 ==> WebElement frameTag = webDriver.findElement(By.xx())
            2. 切换表单 ==> webDriver.switchTo.frame(frameTag)
            3. 操作表单元素
            4. 退出表单 ==> webDriver.switchTo.defaultContent()
        窗口切换:
            webDriver.switchTo.window() 方法可以实现不同窗口之间的相互切换
            获取当前窗口句柄 ==> String handle = webDriver.getWindowHandle()
            获取所有窗口句柄 ==> Set<String> handles = webDriver.getWindowHandles()
            切换到指定句柄窗口 ==> webDriver.switchTo.window(handle)
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class $5_WindowAndFrameSwitch {

    // 定义测试方法, 执行表单切换
    @Test
    public void switchToFrame() throws Exception{
        // 创建ChromeOptions对象
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        // 创建WebDriver对象
        WebDriver chromeDriver = new ChromeDriver(options);
        // 打开网页
        chromeDriver.get("https://mail.qq.com/?cancel_login=true&from=session_timeout");
        Thread.sleep(3000);
        // 选择QQ登录
        chromeDriver.findElement(By.xpath("//*[@id=\"QQMailSdkTool_login_loginBox_tab_item_qq\"]")).click();
        // 获取第一层表单标签
        WebElement frameTag1 = chromeDriver.findElement(By.xpath("//*[@id=\"QQMailSdkTool_login_loginBox_qq\"]/iframe"));
        // 切换表单
        chromeDriver.switchTo().frame(frameTag1);
        // 获取第二层表单标签
        WebElement frameTag2 = chromeDriver.findElement(By.xpath("//*[@id=\"ptlogin_iframe\"]"));
        // 切换表单
        chromeDriver.switchTo().frame(frameTag2);
        // 选择密码输入
        chromeDriver.findElement(By.xpath("//*[@id=\"switcher_plogin\"]")).click();
        // 输入用户名
        chromeDriver.findElement(By.xpath("//*[@id=\"u\"]")).clear();
        chromeDriver.findElement(By.xpath("//*[@id=\"u\"]")).sendKeys("xxx");
        // 输入密码
        chromeDriver.findElement(By.xpath("//*[@id=\"p\"]")).clear();
        chromeDriver.findElement(By.xpath("//*[@id=\"p\"]")).sendKeys("xxxx");
        // 提交表单
        chromeDriver.findElement(By.xpath("//*[@id=\"login_button\"]")).submit();
        // 退出表单
        chromeDriver.switchTo().defaultContent();
        chromeDriver.switchTo().defaultContent();
    }

    // 定义测试方法, 执行窗口切换
    @Test
    public void switchToWindow() throws Exception{
        // 创建ChromeOptions对象
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        // 创建WebDriver对象
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://www.baidu.com");
        //获得当前窗口句柄
        String search_handle = chromeDriver.getWindowHandle();
        System.out.println(search_handle);
        //打开百度注册窗口
        chromeDriver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        chromeDriver.findElement(By.linkText("立即注册")).click();
        // 获取所有窗口句柄
        Set<String> handles = chromeDriver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(search_handle)) {
                // 切换窗口, 获取窗口标题
                System.out.println(chromeDriver.switchTo().window(handle).getTitle());
                // 关闭当前窗口, 将窗口切换回来
                chromeDriver.close();
                chromeDriver.switchTo().window(search_handle);
            }
        }
    }
}

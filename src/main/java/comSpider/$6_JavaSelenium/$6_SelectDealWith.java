package comSpider.$6_JavaSelenium;

/*
    下拉框处理:
        Selenium 专门提供了 Select 类处理下拉框
        处理步骤:
            1. 定位下拉框标签 ==> WebElement selectElement = webDriver.findElement(By.xx(xx))
            2. 创建 Select 对象 ==> Select sel = new Select(selectElement)
            3. 定位下拉框元素:
                sel.selectByValue("2") ==> 根据下拉框内容 value 属性值选择元素
                sel.selectByIndex(0) ==> 根据下拉框内容索引选择元素, 索引从0开始
                sel.selectByVisibleText("洛阳") ==> 根据下拉框文本内容选择元素
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class $6_SelectDealWith {
    public static void main(String[] args) throws Exception{
        // 创建ChromeOptions对象
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置启动参数
        chromeOptions.addArguments("--remote-allow-origins=*", "--start-maximized");
        // 创建浏览器驱动对象
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        // 打开网页
        chromeDriver.get("file:///E:/Users/Administrator/IdeaProjects/WebFrontEnd/1_html/num_1_htmlstudy/num_2_html_tag_study/num_12_form_tag.html");
        // 定位下拉框元素
        WebElement selectElement = chromeDriver.findElement(By.xpath("/html/body/form/p[9]/select"));
        Select sel = new Select(selectElement);
        sel.selectByValue("2");
        Thread.sleep(2000);
        sel.selectByIndex(0);
        Thread.sleep(2000);
        sel.selectByVisibleText("洛阳");
        Thread.sleep(2000);
    }
}

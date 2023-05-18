package comSpider.$6_JavaSelenium;

/*
    设置元素等待:
        自定义元素超时:
            1. 定义方法, 判断元素是否存在, 存在返回true, 不存在返回false
            2. 主程序中通过循环和Thread.sleep()方法设置检测间隔时间, 指定检测时间内没有检测到等待元素, 提示超时
        显示元素等待:
            WebDriverWait ==> 可以针对某个元素等待
            创建WebDriverWait对象:
                WebDriverWait wait = new WebDriverWait(webDriver,timeOut,step);
                    webDriver ==> WebDriver对象
                    timeout ==> 超时时间, 默认单位为秒
                    step ==> 检测间隔时间, 默认为0.5s

 */

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class $4_SetElementWait {
    // 检测元素是否存在方法
    private boolean isElementPresent(WebDriver driver, By el) {
        try {
            driver.findElement(el);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    // 自定义元素超时检测测试主方法
    @Test
    public  void test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        //循环判断某元素是否存在
        By el = By.id("kw");
        for (int second = 1; second <= 10; second++) {
            System.out.println(second);
            //调用 isElementPresent 方法，判断元素是否在
            if (isElementPresent(driver, el)) {
                break;
            } else {
                Thread.sleep(1000);
            }
            if (second == 10) {
                System.out.println("timeout");
            }
        }
        driver.findElement(el).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        driver.quit();
        System.out.println("end selenium");
    }
}

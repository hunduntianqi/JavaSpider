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
                调用 until 方法, 使用匿名内部类, 重写 apply() 方法, 例:
                    wait.until(new ExpectedCondition<WebElement>() {
                        @Override
                        public WebElement apply(WebDriver webDriver) {
                            return webDriver.findElement(By.id("kw"));
                        }
                    }) ==> 该例会返回一个 WebElement 对象
        隐式等待方法:
            webDriver.manage().timeouts().pageLoadTimeout(Duration timeout) ==> 设置页面加载时的超时时间, 超时未加载页面会抛出异常
            webDriver.manage().timeouts().implicitlyWait(Duration timeout) ==> 设置识别对象时的超时时间, 超时未找到对象会抛出异常
            webDriver.manage().timeouts().scriptTimeout(Duration timeout) ==> 设置异步脚本返回结果的超时时间, 超时会抛出异常

 */

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
    public void test1() throws InterruptedException {
        // 创建ChromOptions对象
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // 设置窗口最大化
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
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

    // 设置元素显示等待测试方法
    @Test
    public void elementDisplayWait() throws Exception {
        // 创建ChromOptions对象
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // 创建WebDriver对象
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://www.baidu.com");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10L));
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.id("kw"));
            }
        }).sendKeys("selenium");
        chromeDriver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        chromeDriver.quit();
    }

    // 设置元素隐式等待测试方法
    @Test
    public void elementHideWait() {
        // 创建ChromOptions对象
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //页面加载超时时间设置为 5s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.baidu.com/");
        //定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("kw")).sendKeys("selenium");
        //异步脚本的超时时间设置成 3s
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
        driver.quit();
    }
}

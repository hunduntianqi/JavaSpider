package comSpider.$1_SpiderSummarize;

/*
    http协议 ==> 超文本传输协议:
        介绍：现在允许传输任意类型的数据, 传输HTTP协议格式的数据基于TCP传输协议, 发送数据之前需要先建立链接
        作用：规定了浏览器和Web服务器通信数据的格式, 浏览器和Web服务器通信需要使用HTTP协议
    两种架构模式:
        1. CS架构: 客户端-服务器通信
        2. BS架构: 浏览器-服务器通信(CS包含BS)
    浏览器访问Web服务器的通信过程:
        1. 通过DNS(域名解析服务器)将域名解析成IP地址
        2. 获取到服务器IP地址信息
        3. 浏览器与服务器建立连接(TCP协议)
        4. 发送Http请求数据(http协议)
        5. Web服务器根据浏览器请求从服务器主机获取资源
        6. 服务器主机返回资源数据给Web服务器
        7. Web服务器将http请求资源数据返回响应给浏览器
    URL ==> 统一资源定位符, 即网络资源地址, 网址:
        例: https://news.163.com/18/1122/10/E178J2O4000189FH.html
        解释:
            协议部分: 'https://', 除此之外还有'http://', 'ftp://'
            域名部分: news.163.com (域名是 ip 地址的别名, 使用域名是为了方便记住主机的ip地址)
            资源路径部分: /18/1122/10/E178J2O4000189FH.2022-1-12-html
        扩展:
            url = https://news.163.com/hello.html?page=1&count=10
            参数部分: ?page=1&count=10
            参数说明: '?' 后面的类似 'page=1' 这种以键值形式存在的数据, 多个参数之间使用 '&' 符号连接
    网页开发者工具：
        Elements:网页前端代码
        Console:代码调试工具
        Sources:资源存放位置
        Network:记录浏览器中所有的网络通讯信息
 */

public class $2_HttpAgreement {
}
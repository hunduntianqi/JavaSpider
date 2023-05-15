package comSpider.$3_ParseData;

/*
    jsoup:
        可以解析html的工具包
        1. 使用方法:
            1. 添加jar包, Maven工程可以直接导入jar包坐标
                <dependency>
                    <groupId>org.jsoup</groupId>
                    <artifactId>jsoup</artifactId>
                    <version>1.15.3</version>
                </dependency>
            2. Jsoup.parse()方法获取Document对象
                Document document = Jsoup.parse(url / filePath / htmlString)
                参数:
                    可以是url:使用的不多 ==> url
                    可以是本地的文件路径 ==> filePath
                    可以是String类型变量 ==> htmlString
            3. 使用Document的方法进行页面的解析
                通过css选择器或xpath解析, 获取对应节点标签, 再提取对应属性值或文本内容
        2. 解析html的方法:
            CSS选择器:
                document.getElementsByXxx:
                    标签选择器 ==> document.getElementsByTag("tagName")
                    id选择器 ==> document.getElementByID("idValue")
                    类选择器 ==> document.getElementsByClass("className")
                    指定属性获取对应标签 ==> document.getElementsByAttribute("AttrName")
                    指定属性名和属性值获取对应标签 ==> document.getElementsByAttribute("AttrName", "AttrValue")
                select方法:
                    Elements tagList = document.select("指定 CSS 选择器类型")
                    标签选择器 ==> document.select("tagName")
                    id选择器 ==> document.select("#idValue")
                    类选择器 ==> document.select(".className")
                    标签选择器 ==> document.select("tagName")
                    子选择器 ==> document.select("tagName1 > tagName2") ==> 指定匹配 tagName1 的直接子标签 tagName2
                    后代选择器 ==> document.select("tagName1 tagName2") ==> 指定匹配 tagName1 的所有子标签 tagName2
                    属性选择器 ==> document.select("[AttrName]")
                    属性值选择器 ==> document.select("[AttrName=AttrValue]")
                    组合选择器 ==> document.select("选择器1选择器2...") ==> 例: document.select("div.container > a > h3")
                        ==> 匹配类名为container的div标签中直接a标签下的h3标签
            Xpath解析:
                Elements tagList = document.selectXpath("xpath表达式")
                获取一个符合xpath表达式的 List<Element> 集合
            使用Document自带的方法解析页面:
                element.text(): 取出该节点的文本内容
                element.attr("属性名"): 获取该节点对应的属性值
 */

public class $1_JsoupParse {
}

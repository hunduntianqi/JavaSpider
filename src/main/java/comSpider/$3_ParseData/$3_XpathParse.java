package comSpider.$3_ParseData;

/*
    XML解析技术:
        使用程序读取XML文件中的数据
        1. SAX解析: 读取一行解析一行
        2. DOM解析: 先将数据一次性加载到内存中, 根据树形结构解析
            DOM解析文档对象模型:
                加载数据获取Document对象代表整个xml文件
                Document对象: 整个xml文档
                Element对象: 标签
                Attribute对象: 属性
                Text对象: 文本内容
            DOM解析常用技术框架:
                Dom4j:
                    1. 下载dom4j jar包
                    2. 在类中导入使用
                        SAXReader类:
                            public SAXReader(): 创建Dom4j的解析器对象
                            Document read(String url): 加载XML文件成为Document对象
                        Document类:
                            Element getRootElement(): 获得根元素对象
                            解析XML的元素, 属性, 文本:
                                1. List<Element> elements(): 得到当前元素下的所有子元素
                                2. List<Element> elements(String name): 得到当前元素下指定名字的子元素返回集合
                                3. Element element(String name): 得到当前元素下指定名字的子元素, 如果有很多名字相同的返回第一个
                                4. String getName(): 获得元素名字
                                5. String attributeValue(String name): 通过属性名直接得到属性值
                                6. String elementText(子元素名): 得到指定名称的子元素的文本
                                7. String getText(): 得到文本内容
    XML检索技术-xpath:
        使用Xpath检索XML文件:
         1. 导入jar包(dom4j和jaxen-1.1.2.jar), Xpath技术依赖与Dom4j技术
         2. 通过Dom4j的SAXReader获取Document对象
         3. 利用Xpath提供的API, 结合Xpath的语法完成选取XML元素节点进行解析操作
         4. Document中与Xpath相关的API:
            4.1 Node selectSingNode("表达式"): 获取符合表达式的唯一元素
            4.2 List<Node> selectNodes("表达式"): 获取符合表达式的元素集合
        5. 检索方法:
            5.1 绝对路径: 从根节点开始逐层查找节点列表并打印信息
                /根元素/子元素/孙元素: 从根元素开始一级一级向下查找, 不能跨级
            5.2 相对路径: 先得到根节点, 再采用相对路径获取子节点
                ./子元素/孙元素: 从当前元素开始, 一级一级向下查找, 不能跨级
            5.3 全文搜索: 直接全文搜索相应元素
                //元素: 全文搜索元素
                //元素一/元素二: 全文搜索元素一下面的一级子元素二
                //元素一//元素二: 全文搜索元素一下面的所有子元素二
            5.4 属性查找:
                //@属性名: 全文查找属性对象, 无论是那个元素, 只要包含该属性名
                //元素[@属性名]: 查找元素对象, 全文搜索包含指定属性名的指定元素
                //元素[@属性名=值]: 查找元素对象, 全文搜索指定元素名和属性名, 并且属性值与指定属性值相等
 */

public class $3_XpathParse {
}

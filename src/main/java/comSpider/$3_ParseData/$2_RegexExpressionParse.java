package comSpider.$3_ParseData;

/*
    正则表达式解析数据:
        正则表达式概述:
            对应API文档:Pattern
            用一些规定的字符制定规则, 用来校验数据格式的合法性, 还可以在一段文本中查找满足要求的内容
            字符串对象提供了匹配正则表达式的方法:
                public boolean matches(String regex): 判断是否匹配正则表达式, 匹配返回true, 不匹配返回false
            匹配规则:
                字符类:默认匹配一个字符
                    1.[abc]:只能是a, b 或c
                    2.[^abc]:除了a, b, c之外的任何字符
                    3.[a-zA-z]:a到zA到Z, 包括(范围)
                    4.[a-d[m-p]]:a到d, 或m通过p: ([a-dm-p联合])
                    5.[a-z&&[def]]:d, e或f(交集)
                    6.[a-z&&[^bc]]:a-z, 除了b和c:([ad-z]减法)
                    7.[a-z&&[m-p]]:a到z, 除了m到p:([a-lq-z]减法)
                预定义的字符类(默认匹配一个字符):
                    1. ".": 任意字符
                    2. "\d": 一个数字(0-9)
                    3. "\D": 非数字(^0-9)
                    4. "\s" 一个空白字符(\t \n \x0B \f \r)
                    5. "\S": 非空白字符(^\s)
                    6. "\w": 英文数字下划线(a-z A-Z _ 0-9)
                    7. "\W": 一个非单词字符(^\w)
                贪婪的量词(配合匹配多个字符， X指代正则表达式):
                    1. X? :X , 一次或根本不
                    2. X* :X，零次或多次
                    3. X+ :X , 一次或多次
                    4. X {n} :X，正好n次
                    5. X {n, } :X，至少n次
                    6. X {n,m} :X，至少n但不超过m次
            分组:
                分组就是一个小括号
                捕获分组: 指将一组的数据捕获出来, 再用一次
                    在正则表达式内部使用: \\组号
                    在正则表达式外部使用: $组号
                非捕获分组: 仅仅将数据进行分组, 不需要再次使用
            正则表达式在方法中的应用:
                1.public String[] split(String regex):按照正则表达式匹配的内容进行分割字符串, 返回一个字符串数组
                2.public String replaceAll(String regex, String newStr):按照正则表达式匹配的内容进行替换
        正则表达式爬取信息:
            1. 定义爬取规则:
                String regex = "对应数据解析规则";
            2. 编译正则表达式为一个匹配规则对象
                Pattern pattern = Pattern.compile(regex);
            3. 通过匹配规则对象得到一个匹配数据内容的匹配器对象
                Matcher matcher = pattern.matcher(String);
            4. 通过匹配器从内容中爬取出信息:
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
 */

public class $2_RegexExpressionParse {
}

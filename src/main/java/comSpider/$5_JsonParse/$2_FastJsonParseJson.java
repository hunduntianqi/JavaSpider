package comSpider.$5_JsonParse;

/*
    FastJson: 阿里巴巴的开源Json库, 性能很好
        Maven 依赖:
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>2.0.25</version>
            </dependency>
        解析Json字符串为Java数据类型 ==> JSON.parseXx() 静态方法:
            解析json字符串为指定类型对象
                ==> ClassName object = JSON.parseObject(jsonString, ClassName.class);
                注意: 转换为对象时, json字符串中键名必须与对象属性名完全一致!!
            解析json字符串为List集合:
                ==> List<className> list = JSON.parseArray(jsonString, className.class);
            解析json字符串为ArrayList集合:
                ==> ArrayList<className> list = JSON.parseObject(jsonString, new TypeToken<ArrayList<className>>(){}.getType());
            解析json字符串为HashMap集合:
                ==> HashMap<KeyType, ValueType> hashMap = JSONObject.parseObject(jsonString,
                                                    new TypeToken<HashMap<KeyType, ValueType>>(){}.getType());
        java数据类型转换为json字符串 ==> JSON.toJSONString(Object object):
            指定类型对象转换为json字符串:
                ==> String jsonString = JSON.toJSONString(objectName);
            List集合转换为json字符串:
                ==> String jsonString = JSON.toJSONString(listName);
            Map集合转换为json字符串:
                ==> String jsonString = JSON.toJSONString(mapName);
        java数据类型转换为JSONObject ==> JSON.toJSON(Object object)

 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class $2_FastJsonParseJson {
    // 定义测试方法, 解析json字符串为Java数据类型
    @Test
    public void fastJsonParseData() {
        // 定义一个json字符串
        String jsonString = "{\"id\":1, \"name\":\"郭鹏涛\", \"studentList\":[{\"id\":101,\"name\":\"陈欣妮\", \"age\":25}]}";
        String jsonStudent = "{\"id\":101,\"name\":\"陈欣妮\", \"age\":25}";
        // 定义一个数组形式的字符串
        String arrayString = "[\"北京\", \"天津\", \"杭州\"]";
        // 解析 jsonString 为Grade 对象
        Grade grade = JSON.parseObject(jsonString, Grade.class);
        System.out.println(grade);
        // 解析 jsonStudent 为Student对象
        Student student = JSON.parseObject(jsonStudent, Student.class);
        System.out.println(student);
        // 解析 arrayString 为 List集合
        List<String> list = JSON.parseArray(arrayString, String.class);
        System.out.println(list);
        // // 解析 arrayString 为 ArrayList集合
        ArrayList<String> arrayList = JSON.parseObject(arrayString, new TypeToken<ArrayList<String>>(){}.getType());
        System.out.println(arrayList);
        // // 解析 jsonString 为HashMap
        HashMap<String, Object> hashMap = JSONObject.parseObject(jsonString, new TypeToken<HashMap<String, Object>>(){}.getType());
        System.out.println(hashMap);
    }

    // 定义测试方法, java数据类型转换为Json字符串
    @Test
    public void fastJsonSerializableData() {
        // 创建Student对象
        Student student = new Student(1, "郭鹏涛", 25);
        // 将Student对象转换为json字符串
        System.out.println(JSON.toJSONString(student));
        // 创建一个ArrayList<String>集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "北京", "天津", "杭州");
        // List集合转换为json字符串
        System.out.println(JSON.toJSONString(list));
        // 创建一个HashMap集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("Student", student);
        // Map集合转换为json字符串
        System.out.println(JSON.toJSON(map).getClass());
    }
}

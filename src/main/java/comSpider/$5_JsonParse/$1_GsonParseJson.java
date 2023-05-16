package comSpider.$5_JsonParse;

/*
    json在线格式化网站 ==> https://www.json.cn/
    Gson: 谷歌开发的 JSON 库, 功能十分全面, 可以将 Java 对象序列化为 JSON 字符串, 同样可以将 JSON 字符串反序列化(解析)为匹配的 Java 对象
        Maven 依赖:
            <dependency>
              <groupId>com.google.code.gson</groupId>
              <artifactId>gson</artifactId>
              <version>2.10.1</version>
            </dependency>
        创建Gson对象:
            Gson gson = new Gson();
        解析json字符串为Java数据类型 ==> fromJson():
            解析json字符串为指定类型对象
                ==> ClassName object = gson.fromJson(jsonString, ClassName.class);
                注意: 转换为对象时, json字符串中键名必须与对象属性名完全一致!!
            解析json字符串为List集合:
                ==> List<className> list = gson.fromJson(jsonString, new TypeToken<List<className>>(){}.getType());
            解析json字符串为HashMap集合:
                ==> HashMap<KeyType, ValueType> hashMap = gson.fromJson(jsonString,
                                                        new TypeToken<HashMap<KeyType, ValueType>>(){}.getType());
        java数据类型转换为json字符串 ==> toJson():
            指定类型对象转换为json字符串:
                ==> String jsonString = gson.toJson(objectName);
            List集合转换为json字符串:
                ==> String jsonString = gson.toJson(listName);
            Map集合转换为json字符串:
                ==> String jsonString = gson.toJson(mapName);
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class $1_GsonParseJson {
    // 定义测试方法, json字符串转换为Java数据类型
    @Test
    public void gsonParseData() {
        // 定义一个json字符串
        String jsonString = "{\"id\":1, \"name\":\"郭鹏涛\", \"studentList\":[{\"id\":101,\"name\":\"陈欣妮\", \"age\":25}]}";
        String jsonStudent = "{\"id\":101,\"name\":\"陈欣妮\", \"age\":25}";
        // 定义一个数组形式的字符串
        String arrayString = "[\"北京\", \"天津\", \"杭州\"]";
        // 创建一个Gson对象
        Gson gson = new Gson();
        // 解析json字符串为Grade对象
        Grade grade = gson.fromJson(jsonString, Grade.class);
        System.out.println(grade.getId());
        System.out.println(grade.getName());
        System.out.println(grade.getStudentList());
        // 解析json字符串为Student对象
        Student student = gson.fromJson(jsonStudent, Student.class);
        System.out.println(student);
        // 解析json字符串为 List 集合
        ArrayList<String> list = gson.fromJson(arrayString, new TypeToken<ArrayList<String>>(){}.getType());
        System.out.println(list);
        // 解析json字符串为HashMap
        HashMap<String, Object> hashMap = gson.fromJson(jsonString, new TypeToken<HashMap<String, Object>>(){}.getType());
        System.out.println(hashMap);
    }

    // 定义测试方法, java数据类型转换为Json字符串
    @Test
    public void gsonSerializableData() {
        // 创建Student对象
        Student student = new Student(1, "郭鹏涛", 25);
        // 创建Gson对象
        Gson gson = new Gson();
        // 将Student对象转换为json字符串
        String studentJson = gson.toJson(student);
        System.out.println(studentJson);
        // 创建一个ArrayList<String>集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "北京", "天津", "杭州");
        // List集合转换为json字符串
        System.out.println(gson.toJson(list));
        // 创建一个HashMap集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("Student", student);
        // Map集合转换为json字符串
        System.out.println(gson.toJson(map));
    }
}

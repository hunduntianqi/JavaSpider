package comSpider.$5_JsonParse;

/*
    Jackson: 是当前用的比较广泛的, 用来序列化和反序列化 json 的 Java 的开源框架, 是 Spring MVC 默认的 json 解析器
    Jackson 的核心模块由三部分组成:
        jackson-core: 是核心包, 提供基于"流模式"解析的相关 API, 包括 JsonPaser 和 JsonGenerator
        jackson-annotations: 注解包, 提供标准注解功能
        jackson-databind: 数据绑定包,  提供基于"对象绑定"解析的相关 API (ObjectMapper) 和"树模型"解析相关的 API (JsonNode); 两种
                            API 依赖基于 "流模式的" API
        Maven 依赖:
            <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-core</artifactId>
              <version>2.9.6</version>
            </dependency>

            <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-annotations</artifactId>
              <version>2.9.6</version>
            </dependency>

            <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-databind</artifactId>
              <version>2.9.6</version>
            </dependency>
            可以只添加 jackson-databind 依赖, 也可以三个依赖全部添加
        创建 ObjectMapper 对象:
            ObjectMapper mapper = new ObjectMapper();
        解析Json字符串为Java数据类型 ==> mapper.readValue():
            解析json字符串为指定类型对象
                ==> ClassName object = mapper.readValue(jsonString, ClassName.class);
                注意: 转换为对象时, json字符串中键名必须与对象属性名完全一致!!
            解析json字符串为List集合:
                ==> List<className> list = mapper.readValue(jsonString, new TypeReference<List<className>>(){});
            解析json字符串为ArrayList集合:
                ==> ArrayList<className> list = mapper.readValue(jsonString, new TypeReference<ArrayList<className>>(){});
            解析json字符串为HashMap集合:
                ==> HashMap<KeyType, ValueType> hashMap = mapper.readValue(jsonString,
                                            new TypeReference<HashMap<KeyType, ValueType>>(){});
        java数据类型转换为json字符串 ==> mapper.writeValueAsString(Object object):
            指定类型对象转换为json字符串:
                ==> String jsonString = mapper.writeValueAsString(objectName);
            List集合转换为json字符串:
                ==> String jsonString = mapper.writeValueAsString(listName);
            Map集合转换为json字符串:
                ==> String jsonString = mapper.writeValueAsString(mapName);
 */


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class $3_JacksonParseJson {
    // 定义测试方法, 解析json字符串为Java数据类型
    @Test
    public void jacksonParseData() throws Exception {
        // 定义一个json字符串
        String jsonString = "{\"id\":1, \"name\":\"郭鹏涛\", \"studentList\":[{\"id\":101,\"name\":\"陈欣妮\", \"age\":25}]}";
        String jsonStudent = "{\"id\":101,\"name\":\"陈欣妮\", \"age\":25}";
        // 定义一个数组形式的字符串
        String arrayString = "[\"北京\", \"天津\", \"杭州\"]";
        // 创建一个 ObjectMapper 对象
        ObjectMapper mapper = new ObjectMapper();
        // 解析 jsonString 为 Grade 对象
        Grade grade = mapper.readValue(jsonString, Grade.class);
        System.out.println(grade);
        // 解析 jsonStudent 为 Student 对象
        Student student = mapper.readValue(jsonStudent, Student.class);
        System.out.println(student);
        // 解析 arrayString 为 List集合
        List<String> list = mapper.readValue(arrayString, new TypeReference<List<String>>(){});
        System.out.println(list);
        // 解析 jsonString 为 Map 集合
        HashMap<String, Object> hashMap = mapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>(){});
        System.out.println(hashMap);
    }

    // 定义测试方法, java数据类型转换为Json字符串
    @Test
    public void jackSonSerializableData() throws Exception {
        // 创建 ObjectMapper 对象
        ObjectMapper mapper = new ObjectMapper();
        // 创建Student对象
        Student student = new Student(1, "郭鹏涛", 25);
        // 将Student对象转换为json字符串
        System.out.println(mapper.writeValueAsString(student));
        // 创建一个ArrayList<String>集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "北京", "天津", "杭州");
        // List集合转换为json字符串
        System.out.println(mapper.writeValueAsString(list));
        // 创建一个HashMap集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("Student", student);
        // Map集合转换为json字符串
        System.out.println(mapper.writeValueAsString(map));
    }
}

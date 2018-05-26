package com.hello.world.javacore.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangxing
 */
public class collectTransfor {
    public static void main(String[] args) {
        listToMapAndMaptoList();

        listToSetAndSetToList();

        arrayToListAndListToArray();

        MapToSetAndSetToMap();
    }

    private static void MapToSetAndSetToMap() {
        //List 转化为Map
        List<Student> students = new ArrayList<Student>();
        for (int i=0;i<10;i++){
            Student student = new Student();
            student.setId(String.valueOf(i+1));
            student.setName("zhang {" + i+ "}");
            student.setInfo("class {" + i + "}");
            students.add(student);
        }
        Map<String,Student> studentMap = students.stream().collect(Collectors.toMap(Student::getId, Function.<Student>identity()));

        //map 转化为 set
        Set<String> mapToSetKeys = new HashSet<>(studentMap.keySet());
        Set<Student> mapToSetValues = new HashSet<>(studentMap.values());

        //set 转化为 map
        Map<String,Student> setToMap = mapToSetValues.stream().collect(Collectors.toMap(Student::getId,Function.identity()));



    }

    private static void arrayToListAndListToArray() {
        String[] strings = {"x","ss"};
        List<String> stringList = Arrays.asList(strings);
//        stringList.add("aaa");

        String[] test =(String[]) stringList.toArray();

        System.out.println(test[1]);
    }

    private static void listToSetAndSetToList() {
        //set 转化为list
        Set<String> set = new HashSet<String>();
        set.add("12121");
        set.add("12121");
        set.add("45677");
        set.add("56768");
        List<String> setToList = new ArrayList<>(set);
        System.out.println(setToList);

        //list 转化为set
        Set<String> listToset = new HashSet<>(setToList);
        System.out.println(listToset);



    }

    private static void listToMapAndMaptoList() {
        Student studentNew = new Student();
        studentNew.setId("1");
        studentNew.setName("zhang { }");
        studentNew.setInfo("class { }");

        //List 转化为Map
        List<Student> students = new ArrayList<Student>();
        for (int i=0;i<10;i++){
            Student student = new Student();
            student.setId(String.valueOf(i+1));
            student.setName("zhang {" + i+ "}");
            student.setInfo("class {" + i + "}");
            students.add(student);
        }
        Map<String,Student> studentMap = students.stream().collect(Collectors.toMap(Student::getId, Function.<Student>identity()));
        if (studentMap.containsKey(studentNew.getId())){
            System.out.println("Student is in map " + studentMap.get(studentNew.getId()));
        }


        //Map转化为List
        List<Student> studentList = new ArrayList<>(studentMap.values());
        List<String> stringIds = new ArrayList<>(studentMap.keySet());

        //List 排序
        studentList.sort(Comparator.comparing(Student::getName));
        for (Student s:studentList) {
            System.out.println(s);
        }

        studentList.sort((p1,p2) -> {
            return p1.getId().toLowerCase().compareTo(p2.getId().toLowerCase());
        });

        for (Student s:studentList) {
            System.out.println(s);
        }


        System.out.println("======================");
        //Stream 中的filter功能
        List<Student> studentFilter = studentList.stream().filter( p -> StringUtils.equals(p.getName(),"zhang {1}")).collect(Collectors.toList());

        studentFilter.stream().forEach(p -> {
            System.out.println(p);
        });



        System.out.println("+++++++++++++++++++++++++++");
        //stream 中的 map功能
        List<Student> mapRes = studentList.stream().map(p -> {
            p.setName(p.getName()  + "china");
            return p;
        }).collect(Collectors.toList());

        mapRes.stream().forEach( p -> {
            System.out.println(p);
        });

        System.out.println("-----------------------");
        //返回list中累的某个字段
        List<String> mapResName = studentList.stream().map( p -> {
            p.setName(p.getName() +" USA ");
            return p.getName();
        }).collect(Collectors.toList());
        mapResName.stream().forEach(p -> {
            System.out.println(p);
        });

        System.out.println("-_-___---_------__-__");
        //filter 和 map 结合使用
        List<Student> result = studentList.stream().filter(p -> StringUtils.equals("zhang {0}china USA",p.getName())).map(p ->{
            p.setName(p.getName() + "XXXXX");
            return p;
        }).collect(Collectors.toList());

        result.stream().forEach(p -> {
            System.out.println(p);
        });





    }
}

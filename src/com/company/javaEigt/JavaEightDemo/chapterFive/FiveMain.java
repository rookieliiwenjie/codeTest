package com.company.javaEigt.JavaEightDemo.chapterFive;

import com.company.javaEigt.JavaEightDemo.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wenjie.li
 * @Date: 2022/9/19 11:24 上午
 * @Description:
 */
public class FiveMain {
    public static void main(String[] args) {
//        List<Student> studentList = Student.getStudentList();
//        System.out.println("studentList = " + studentList);
//        List<String> names = new ArrayList<>();
//        names.add("Ram");
//        List<Student> students = studentList
//                .stream()
//                .filter(student -> (names.stream().anyMatch(name -> name.equals(student.getName()))))
//                .collect(Collectors.toList());
//        System.out.println("students = " + students);


        String s = "SELECT * FROM trade_record_detail_000 \t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_001\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_002\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_003\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_004\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_005\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_006\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_007\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_008\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_009\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_010\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_011\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_012\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_013\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_014\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_015\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_016\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_017\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_018\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_019\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_020\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_021\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_022\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_023\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_024\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_025\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_026\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_027\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_028\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_029\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_030\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_031\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_032\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_033\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_034\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_035\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_036\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_037\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_038\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_039\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_040\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_041\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_042\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_043\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_044\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_045\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_046\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_047\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_048\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_049\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_050\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_051\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_052\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_053\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_054\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_055\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_056\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_057\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_058\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_059\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_060\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_061\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_062\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_063\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_064\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_065\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_066\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_067\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_068\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_069\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_070\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_071\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_072\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_073\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_074\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_075\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_076\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_077\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_078\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_079\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_080\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_081\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_082\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_083\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_084\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_085\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_086\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_087\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_088\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_089\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_090\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_091\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_092\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_093\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_094\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_095\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t;\n" +
                "SELECT * FROM trade_record_detail_096\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t;\n" +
                "SELECT * FROM trade_record_detail_097\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_098\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t\n" +
                "SELECT * FROM trade_record_detail_099\t\" WHERE  `third_trade_no`\n" +
                "            = 4200001677202211262967154424 or `third_trade_no`  = 20221126110113130266213469359493;\"\t\t";


        String[] split = s.replaceAll("\"", "").split(";");


        System.out.println("s.re = ");
    }

}

package prop;

import Data.Person;
import Data.Professor;
import Data.Student;
import Data.Subject;
import prop.Parse_data;

import java.io.IOException;

public class Main {
    public static void main(String[] argc) throws IOException {
        Parse_data parseData=new Parse_data();
        Person s=parseData.read_person("201911731",1);
//        System.out.println(s.toString());
        Professor student = new Professor();
        student.setid("20001242");
        student.setName("오흠");
        student.setPwd("1234");
        Subject[] sub = new Subject[2];
        Subject sub1=new Subject();
        sub1.setCode("C123");
        sub1.setName("컴구");
        Subject sub2=new Subject();
        sub2.setCode("C125");
        sub2.setName("컴");
        sub[0]=sub1;
        sub[1]=sub2;
        student.setSubject(sub);
        parseData.write_person(student,2);


    }
}
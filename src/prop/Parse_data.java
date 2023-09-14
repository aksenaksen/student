package prop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import Data.Person;
import Data.Professor;
import Data.Student;
import Data.Subject;
import org.ini4j.Ini;

import javax.imageio.IIOException;

public class Parse_data {
    private static final String DEFALUT_PROPERTIES_PATH= Paths.get("C:","Users","교육생16","Desktop","workspace","student","src","prop").toString();
//    1이면 학생 2면 flag
    private String return_path(int flag){
        if (flag==1){
            return Paths.get(DEFALUT_PROPERTIES_PATH,"student","student_info.ini").toString();
        }
        else{
            return Paths.get(DEFALUT_PROPERTIES_PATH,"professor","professor_info.ini").toString();
        }
    }
    private void auto_write(Person person,Ini ini){
        ini.put(person.getId(),"name",person.getName());
        ini.put(person.getId(),"pwd",person.getPwd());
        ini.put(person.getId(),"dept",person.getDept());
    }
//    private String id;
//    private String pwd;
//    private String name;
//    private String dept;
//  읽는 함수

    public boolean check(String id,int flag) throws IOException{
        String path=return_path(flag);
        Ini ini=new Ini(new File(path));
        if (flag==1){
            try{
                if(ini.get(id)==null) {
                    return true;
                }
                else{
                    return false;
                }
            }
            catch (Exception e){
                return true;
            }
        }
        return true;
    }


    public Person read_person(String id, int flag) throws IOException {
        String path=return_path(flag);
        Ini ini = new Ini(new File(path));
        if (flag==1){
            Student person=new Student();
            person.setid(id);
            person.setName(ini.get(id,"name"));
            person.setPwd(ini.get(id,"pwd"));
            person.setDept(ini.get(id,"dept"));
            person.setYear(Integer.parseInt(ini.get(id,"year")));
            int size=Integer.parseInt(ini.get(id,"sub_size"));
            Subject [] new_sub=new Subject[size];
            for (int i=0;i<size;i++){
                Subject sub=new Subject();
                String [] tmp=ini.get(id,"sub_code"+i).split(" ");
                sub.setCode(tmp[0]);
                sub.setName(tmp[1]);
                sub.setScore(Integer.parseInt(tmp[2]));
                new_sub[i]=sub;
            }
            person.setSubject(new_sub);
            return person;
        }
        else if(flag==2){
            Professor person=new Professor();
            person.setid(id);
            person.setName(ini.get(id,"name"));
            person.setPwd(ini.get(id,"pwd"));
            person.setDept(ini.get(id,"dept"));
            int size=Integer.parseInt(ini.get(id,"sub_size"));
            Subject [] new_sub=new Subject[size];
            for (int i=0;i<size;i++){
                Subject sub=new Subject();
                String [] tmp=ini.get(id,"sub_code"+i).split(" ");
                sub.setCode(tmp[0]);
                sub.setName(tmp[1]);
                new_sub[i]=sub;
            }
            person.setSubject(new_sub);
            return person;
        }
        return null;
    }
//      쓰는함수
    public Person write_person(Person person,int flag) throws IOException {
        String path=return_path(flag);
        Ini ini = new Ini(new File(path));
        if (person instanceof Student){
            auto_write(person,ini);
            ini.put(person.getId(),"year",((Student) person).getYear());
            Subject[]sub=((Student) person).getSubject();
            ini.put(person.getId(),"sub_size",sub.length);
            for(int i=0;i< sub.length;i++){
                ini.put(person.getId(),"sub_code"+i,sub[i].getCode()+" "+sub[i].getName()+" "+sub[i].getScore());
            }
            ini.store();
        } else if (person instanceof Professor) {
            auto_write(person,ini);
            Subject[]sub=((Professor) person).getSubject();
            ini.put(person.getId(),"sub_size",sub.length);
            for(int i=0;i< sub.length;i++){
                ini.put(person.getId(),"sub_code"+i,sub[i].getCode()+" "+sub[i].getName());
            }
            ini.store();
        }
        return person;
    }
}

package Data;

public class Student extends Person{
    private int years;
    private Subject [] subject;
    public int setYear(int year){
        this.years=year;
        return year;
    }
    public Subject[] setSubject(Subject [] sub){
        this.subject=sub;
        return this.subject;
    }
    public int getYear(){
        return this.years;
    }
    public Subject[] getSubject(){
        return this.subject;
    }
    @Override
    public String toString(){
        String s="";
        s+="id="+this.getId()+"name="+this.getName();
        for (int i=0;i<subject.length;i++){
            s+="과목 "+this.subject[i].getName()+this.subject[i].getScore();
        }
        return s;
    }
}

package Data;

public class Subject {
    private String subCode;
    private String name;
    private int score;
    private String grade;
    public String getCode(){
        return this.subCode;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public String getGrade(){
        return this.grade;
    }
    public String setCode(String subCode){
        this.subCode=subCode;
        return this.subCode;
    }
    public String setName(String name){
        this.name=name;
        return this.name;
    }
    public int setScore(int score){
        this.score=score;
        return this.score;
    }
    public String setGrade(String grade){
        this.grade=grade;
        return this.grade;
    }
}

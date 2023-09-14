package Data;

public abstract class Person {
    private String id;
    private String pwd;
    private String name;
    private String dept;
    public String getId(){
        return this.id;
    }
    public String getPwd(){
        return this.pwd;
    }
    public String getName(){
        return this.name;
    }
    public String getDept(){
        return this.dept;
    }
    public String setid(String id){
        this.id=id;
        return this.id;
    }
    public String setPwd(String pwd){
        this.pwd=pwd;
        return this.pwd;
    }
    public String setDept(String dept){
        this.dept=dept;
        return this.dept;
    }
    public String setName(String name){
        this.name=name;
        return name;
    }

}

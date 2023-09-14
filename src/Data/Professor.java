package Data;

public class Professor extends Person{
    private Subject [] subject;

    public Subject[] getSubject() {
        return subject;
    }

    public void setSubject(Subject[] subject) {
        this.subject = subject;
    }
}

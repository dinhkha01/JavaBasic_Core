package bt7;

public class GraduateStudent extends Student {
    private String researchTopic,supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName){
        super(name,id,gpa);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }
    @Override
    public void getDetails(){
        System.out.println( "GraduateStudent [Name: " + getName() + ", ID: " + getId() + ", GPA: " + getGpa() +
                ", Research Topic: " + researchTopic + ", Supervisor: " + supervisorName + "]");
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }
}

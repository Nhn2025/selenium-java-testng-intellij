package javaOOP;

public class Topic_01_Class_Object_Student {
    public int studentID;
    private String studentName;
    private Float knowledgePoint;
    private Float praticePoint;

    private int getStudentID() {
        return studentID;
    }

    private void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    private String getStudentName() {
        return studentName;
    }

    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private Float getKnowledgePoint() {
        return knowledgePoint;
    }

    private void setKnowledgePoint(Float knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    private Float getPraticePoint() {
        return praticePoint;
    }

    private void setPraticePoint(Float praticePoint) {
        this.praticePoint = praticePoint;
    }

    private  Float getAveragePoint() {
        return (this.knowledgePoint + this.praticePoint * 2) / 3;
    }

    private void showStudentInfor() {
        System.out.println("**********************************");
        System.out.println("Student ID = " + getStudentID());
        System.out.println("Student Name = " + getStudentName());
        System.out.println("Student Knowledge Point = " + getKnowledgePoint());
        System.out.println("Student Practice Point = " + getPraticePoint());
        System.out.println("Student Average Point = " + getAveragePoint());
        System.out.println("**********************************");
    }

    public static void main(String[] args) {
        Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();

        // Instance variable
        firstStudent.studentID = 1564564;

        firstStudent.setStudentID(2005206);
        firstStudent.setStudentName("John Terry");
        firstStudent.setKnowledgePoint(8.0f);
        firstStudent.setPraticePoint(7.8f);
        firstStudent.showStudentInfor();

        Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
        firstStudent.setStudentID(2015206);
        firstStudent.setStudentName("Terry");
        firstStudent.setKnowledgePoint(9.0f);
        firstStudent.setPraticePoint(8.8f);
        firstStudent.showStudentInfor();
    }

}

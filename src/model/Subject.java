package model;

public class Subject {
    private String idSubject;
    private String nameSubject;
    private int numberOfCredit;

    public Subject() {
    }

    public Subject(String idSubject) {
        this.idSubject = idSubject;
    }

    public Subject(String idSubject, String nameSubject, int numberOfCredit) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.numberOfCredit = numberOfCredit;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(int numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject='" + idSubject + '\'' +
                ", nameSubject='" + nameSubject + '\'' +
                ", numberOfCredit=" + numberOfCredit +
                '}';
    }
}

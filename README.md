# Java
public class Education {

    String degree, major;
    int research;

    public Education(String degree, String major, int research) {
        this.degree = degree;
        this.major = major;
        this.research = research;
    }

    public Education() {
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getresearch() {
        return research;
    }

    public void setresearch(int research) {
        this.research = research;
    }

}

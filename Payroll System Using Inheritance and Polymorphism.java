//Comparator
import java.util.*;
public class Comparer  implements Comparator<Employee> {
   
    public int compare(Employee o1, Employee o2) {
        return o1.ID().compareTo(o2.ID());
    }
}
//Education
public class Education implements Cloneable{
    private String Degree;
    private String Major;
    private int Research;
    public Education() {
        Degree="";
        Major="";
        Research=0;
    }
  
    public Education(String Degree, String Major, int Research) {
        this.Degree=Degree;
        this.Major=Major;
        this.Research=Research;
    }
  
    public String getDegree() {
        return Degree;
    }
    
    public String getMajor() {
        return Major;
    }
  
    public int getResearch() {
        return Research;
    }
 
    public void setDegree(String Degree) {
        this.Degree=Degree;
    }
  
    public void setMajor(String Major) {
        this.Major=Major;
    }
 
    public void setResearch(int Research) {
        this.Research=Research;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
//Constructor for Employee 
import java.util.*;

public abstract class Employee implements EmployeeInfo,Comparable<Employee>{
    private String lastName;
    private String firstName;
    private String IDnum;
    private String sex;
    private GregorianCalendar hireDate;
  
    public Employee(){
        lastName=" ";
        firstName=" ";
        IDnum=" ";
        sex=" ";
        hireDate=new GregorianCalendar(1957, 5, 25);
    }
   
    public Employee(String ln, String fn, String ID,String sex, GregorianCalendar hireDate) {
        lastName=ln;
        firstName=fn;
        IDnum=ID;
        this.sex=sex;
        this.hireDate=hireDate;
    }
  
    public String getln() {
        return lastName;
    }
    
    public String getfn() {
        return firstName;
    }
  
  //constructor part time which initiates the values
  
  import java.util.*;

public class Partime extends Staff{
    private int hoursworked;
    public Partime() {
        super();
        hoursworked=0;
    }
 
    public Partime(String ln, String fn, String ID, String sex, GregorianCalendar hireDate, int hourlyRate, int hoursworked){
        super(ln,fn,ID,sex,hireDate,hourlyRate);
        this.hoursworked=hoursworked;
    }
   
    public int getHoursWorked() {
        return hoursworked;
    }
    
    public void setHoursWorked(int hoursWorked) {
        this.hoursworked=hoursWorked;
    }
    public double monthlyEarnings() {
        return super.hourlyrate()*hoursworked*4;
    }
    public String toString() {
        return super.toString()+" Hoursworked per month: "+hoursworked*4+" Monthly Salary:$"+monthlyEarnings();
    }
}
   
    public String ID() {
        return IDnum;
    }

    public String sex() {
        return sex;
    }

    public Calendar gethireDate(){
        return hireDate;
    }

    public void setln(String ln) {
        lastName=ln;
    }

    public void setfn(String fn) {
        firstName=fn;
    }
ic void setID(String ID) {
        IDnum=ID;
    }

    public void setSex(String sex) {
        this.sex=sex;
    }
    
    public void sethireDate(GregorianCalendar date){
        hireDate=date;
    }

    public abstract double monthlyEarning();

    public String toString() {
        return " ID Employee number:"+IDnum +" Employee Name: "+firstName+" "+lastName+" Hire date:"+hireDate.get(Calendar.MONTH)+"/"+hireDate.get(Calendar.DAY_OF_MONTH)+"/"+hireDate.get(Calendar.YEAR);
    }
   
    public abstract double monthlyEarnings();
    public int compareTo(Employee obj) {
        if(lastName.compareTo(obj.lastName)==0)
            return 0;
        else if(lastName.compareTo(obj.lastName)>0) {
            return -1;
        }
       else {
            return 1;
        }
    }
}
//Faculty
er();
        import java.util.*;
import java.lang.*;

public class Faculty extends Employee implements Cloneable{
    Education en;
    public enum Level {
        AS,AO,FU
    }
    Level l;
    public Faculty() {
        supen=new Education();
        l=null;
    }

    @Override
    public double monthlyEarning() {
        return 0;
    }


    public Faculty(String ln, String fn, String ID, String sex, GregorianCalendar hireDate,Level l,String Degree, String Major, int Research) {
        super(ln,fn,ID,sex,hireDate);
        this.l=l;
        en=new Education(Degree, Major,Research);
    }
 
    public String leveldetails() {
        switch(l) {
            case AS:
                return"Assistant professor";
            case AO:
                return"Associate professor";
            case FU:
                return"Professor";
            default:
                return "";

        }
    }
 
    public void setLevel(Level lvl) {
        l=lvl;
    }
    public double monthlyEarnings() {
        switch(l) {
            case AS:
                return FACULTY_MONTHLY_SALARY;
            case AO:
                return FACULTY_MONTHLY_SALARY*1.5;
            case FU:
                return FACULTY_MONTHLY_SALARY*2;
            default:
                return 0;
        }
    }
    
    public Education geted() {
        return en;
    }
    
    public void seted(Education en) {
        this.en=en;
    }
    public String toString() {
        return super.toString()+""+leveldetails()+" Monthly Salary: $"+monthlyEarnings();
    }
    public Object clone() throws CloneNotSupportedException{
        Faculty b=(Faculty)super.clone();
        en=(Education) en.clone();
        b.seted(en);
        return b;
    }
}
//Constructor Staff which initiates thevalues

import java.util.*;
public class Staff extends Employee {
    private int HourlyRate;
    public Staff() {
        super();
        HourlyRate=0;
    }

    @Override
    public double monthlyEarning() {
        return 0;
    }

    public Staff(String ln, String fn, String ID, String sex, GregorianCalendar hireDate, int hourlyRate) {
        super(ln,fn,ID,sex,hireDate);
        HourlyRate=hourlyRate;
    }
    public double monthlyEarnings() {
        return HourlyRate*STAFF_MONTHLY_HOURS_WORKED;
    }
  
    public int hourlyrate() {
        return HourlyRate;
    }
    
    public void setHourlyRate(int hr) {
        HourlyRate=hr;
    }
    public String toString() {
        if(this instanceof Partime) {
            return super.toString();
        }
        else
            return super.toString()+" Full Time Monthly Salary:$"+monthlyEarnings();
    }

}
//Testdriver
import java.util.*;
public class Testdriver {
    static double parttimetotal=0;
    static double totalsalary=0;
    static Employee employee[]=new Employee[9];
 
    public static void main(String [] args)throws CloneNotSupportedException {
        employee[0]=new Staff("Allen","Paita","123","M",new GregorianCalendar(2018,2,23),50);
        employee[1]=new Staff("Zapata","Steven","456","F",new GregorianCalendar(2004, 7,12),35);
        employee[2]=new Staff("Rios","Enrique","789","M",new GregorianCalendar(2014, 6,2),40);
        employee[3]=new Faculty("Johnson","Anne", "243", "F", new GregorianCalendar(2018, 4, 27),Faculty.Level.FU,"Ph.D","Engineering",3);
        employee[4]=new Faculty("Bouris","Willian","791","F",new GregorianCalendar(2015, 3,14),Faculty.Level.AO,"Ph.D","English",1);
        employee[5]=new Faculty("Andrade","Christopher","623","F",new GregorianCalendar(1998, 5, 22),Faculty.Level.AS,"MS","PhysicalEducation",0);
        employee[6]=new Partime("Guzman","Augusto", "455", "F", new GregorianCalendar(1987, 8, 10),35,30);
        employee[7]=new Partime("Depirro","Martin", "678", "F", new GregorianCalendar(1997, 9, 15), 30,15);
        employee[8]=new Partime("Aldaco","Marque", "945", "M", new GregorianCalendar(2012, 11, 24), 20,35);
        System.out.println("Staff:");
        for(int i=0;i<3;i++) {
            System.out.println(employee[i].toString());
        }
        System.out.println("Faculty:");
        for(int i=3;i<6;i++) {
            System.out.println(employee[i].toString());
        }
        System.out.println("Part-Time:");
        for(int i=6;i<9;i++) {
            System.out.println(employee[i].toString());
        }
        parttimetotal=totalPartTimeSal();
        totalsalary=totalsal();
        System.out.println(" Totalmonthly salary for all the Part-Time staff:$"+parttimetotal);
        System.out.println("Totalmonthly salary for all employees: $"+totalsalary);
        System.out.println(" Sorting by IDnumber.... ");
        Arrays.sort(employee,new Comparer());
        int j=0;
        while(j<9) {
            Employee obj=(Employee)employee[j++];
            System.out.println(obj.toString());
        }
        System.out.println(" Sorting byLast Name.... ");
        Arrays.sort(employee);
        int i=0;
        while(i<9) {
            Employee obj=(Employee)employee[i++];
            System.out.println(obj.toString());
        }
        System.out.println(" f. Duplicate afaculty object using clone.");
        Faculty fac=new Faculty("Bouris","Willian","791","F",new GregorianCalendar(2015, 3,14),Faculty.Level.AO,"Ph.D","English",1);
        Faculty fac1=(Faculty)fac.clone();
        System.out.println(fac.toString()+"###Cloned Information### "+fac1.toString()+" VerifingDuplication... "+" ###Original Information### "+fac.toString()+"###Cloned Information###");
        fac1.setfn("Ashish");
        fac1.setln("Gare");
        fac1.sethireDate(new GregorianCalendar(1998,4,20));
        fac1.setID("420");
        fac1.setLevel(Faculty.Level.FU);
        System.out.println(fac1.toString());
    }
 
    public static double totalPartTimeSal() {
        for(int i=6;i<9;i++) {
            parttimetotal+=employee[i].monthlyEarnings();
        }
        return parttimetotal;
    }
   
    public static double totalsal() {
        for(int i=0;i<9;i++) {
            totalsalary+=employee[i].monthlyEarnings();
        }
        return totalsalary;
    }
}

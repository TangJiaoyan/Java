//PayrollTest.java

import java.util.ArrayList;

interface EmployeeInfo {
   public final float FACULTY_MONTHLY_SALARY = (float) 5000.00;
   public final int STAFF_MONTHLY_HOURS_WORKED = 160;
}

abstract class Employee implements EmployeeInfo {
   private String last_name, first_name, ID_number;

   public String getLast_name() {
       return last_name;
   }

   public void setLast_name(String last_name) {
       this.last_name = last_name;
   }

   public String getFirst_name() {
       return first_name;
   }

   public void setFirst_name(String first_name) {
       this.first_name = first_name;
   }

   public String getID_number() {
       return ID_number;
   }

   public void setID_number(String iD_number) {
       ID_number = iD_number;
   }

   public Employee() {
       last_name = "NA";
       first_name = "NA";
       ID_number = "NA";
   }

   public Employee(String last_name, String first_name, String ID_number) {
       setFirst_name(first_name);
       setLast_name(last_name);
       setID_number(ID_number);
   }

   @Override
   public String toString() {
       String str = "";
       str = String.format("ID Employee number :%s\n", ID_number);
       str += String.format("Employee name: %s %s\n", first_name, last_name);
       return str;
   }

   public abstract double monthlyEarning();
}

class Staff extends Employee {

   private float hourly_rate;

   public Staff() {
       super();
       setHourly_rate(0);
   }

   public Staff(String last_name, String first_name, String ID_number, float hourly_rate) {
       super(last_name, first_name, ID_number);
       setHourly_rate(hourly_rate);
   }

   @Override
   public double monthlyEarning() {
       return hourly_rate * STAFF_MONTHLY_HOURS_WORKED;
   }

   public float getHourly_rate() {
       return hourly_rate;
   }

   public void setHourly_rate(float hourly_rate) {
       this.hourly_rate = hourly_rate;
   }

   @Override
   public String toString() {
       String str = super.toString();
       str += String.format("Full Time\nMonthly Salary: %.2f\n", monthlyEarning());
       return str;
   }
}

class Education {
   private String Degree, Major;
   private int num_Research;

   public String getDegree() {
       return Degree;
   }

   public void setDegree(String degree) {
       Degree = degree;
   }

   public String getMajor() {
       return Major;
   }

   public void setMajor(String major) {
       Major = major;
   }

   public int getNum_Research() {
       return num_Research;
   }

   public void setNum_Research(int num_Research) {
       this.num_Research = num_Research;
   }

   public Education() {
       setDegree("NA");
       setMajor("NA");
       setNum_Research(0);
   }

   public Education(String Degree, String Major, int num_Research) {
       setDegree(Degree);
       setMajor(Major);
       setNum_Research(num_Research);
   }
}

class Faculty extends Employee {

   enum Level {
       AS, AO, FU, NA;
   }

   private Level level;
   private Education edu;

   public Faculty() {
       super();
       setEdu(new Education());
       level = Level.NA;
   }

   public Faculty(String last_name, String first_name, String ID_number, String Degree, String Major, int num_Research,
           String level) {
       super(last_name, first_name, ID_number);
       setEdu(new Education(Degree, Major, num_Research));
       setLevel(level);
   }

   @Override
   public double monthlyEarning() {
       switch (level) {
       case AO:
           return 1.5 * FACULTY_MONTHLY_SALARY;
       case AS:
           return FACULTY_MONTHLY_SALARY;
       case NA:
           return 0;
       case FU:
           return 2 * FACULTY_MONTHLY_SALARY;
       }
       return 0;
   }

   public Level getLevel() {
       return level;
   }

   public void setLevel(String level) {
       if (level.equals("Assistant"))
           this.level = Level.AS;
       else if (level.equals("Associate"))
           this.level = Level.AO;
       else if (level.equals("Full"))
           this.level = Level.FU;
       else
           this.level = Level.NA;
   }

   @Override
   public String toString() {
       String str = super.toString();
       switch (level) {
       case AO:
           str += "Associate Professor\n";
           break;
       case AS:
           str += "Assistant Professor\n";
           break;
       case FU:
           str += "Full Professor\n";
       default:
           break;
       }
       str += String.format("Monthly Salary: %.2f\n", monthlyEarning());
       return str;
   }

   public Education getEdu() {
       return edu;
   }

   public void setEdu(Education edu) {
       this.edu = edu;
   }

}

class Partime extends Staff {
   private int hours_worked;

   public int getHours_worked() {
       return hours_worked;
   }

   public void setHours_worked(int hours_worked) {
       this.hours_worked = hours_worked;
   }

   public Partime() {
       super();
       hours_worked = 0;
   }

   public Partime(String last_name, String first_name, String ID_number, float hourly_rate, int hours_worked) {
       super(last_name, first_name, ID_number, hourly_rate);
       setHours_worked(hours_worked);
   }

   @Override
   public double monthlyEarning() {
       return getHourly_rate() * hours_worked * 4;
   }

   @Override
   public String toString() {
       String str;
       str = String.format("ID Employee number :%s\n", getID_number());
       str += String.format("Employee name: %s %s\n", getFirst_name(), getLast_name());
       str += String.format("Hours works per month: %d\n", hours_worked);
       str += String.format("Monthly Salary: %.2f\n", monthlyEarning());
       return str;
   }

}

public class PayrollTest {
   public static void main(String[] args) {
       ArrayList<Employee> employees = new ArrayList<Employee>();

       Employee e = new Staff("Alen", "Paita", "123", 50);
       employees.add(e);
       e = new Staff("Zapata", "Steven", "456", 35);
       employees.add(e);
       e = new Staff("Rios", "Enrique", "789", 40);
       employees.add(e);

       e = new Faculty("Johnson", "Anne", "243", "Ph.D", "Engineering", 3, "Full");
       employees.add(e);
       e = new Faculty("Bouris", "William", "791", "Ph.D", "English", 1, "Associate");
       employees.add(e);
       e = new Faculty("Anrade", "Christopher", "623", "MS", "Physical Education", 0, "Assistant");
       employees.add(e);

       e = new Partime("Guzman", "Augusto", "455", 35, 30);
       employees.add(e);
       e = new Partime("Depirro", "Martin", "678", 30, 15);
       employees.add(e);
       e = new Partime("Aldaco", "Marque", "945", 20, 35);
       employees.add(e);

       for (Employee i : employees) {
           System.out.println(i);
       }
   }
}


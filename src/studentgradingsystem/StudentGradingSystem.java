package studentgradingsystem;

/**
 *
 * @author erens
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class StudentGradingSystem {
public static List<Student> students;
public static List<Grades> grades;
public static List<Department> departments;
public static List<Course> courses;
public static List<Attendance> attendance;


  
    public static void main(String[] args) {

        students = new ArrayList();
        grades = new ArrayList();
        departments = new ArrayList();
        courses = new ArrayList();
        attendance = new ArrayList();

        
        testStudent();
        testCourse();
        testDepartment();
        testGrades();
        testAttendance();
    }
    private static void testStudent() {
    add_student(1, "189222", "Ayse", "Cengiz", "F", "Turkey", "28/03/2002");
    add_student(2, "193342", "Philip", "Udoye", "M", "Nigeri", "16/09/2003");
    add_student(3, "189931", "Kemal", "Salih", "M", "TRNC", "17/05/2002");
    add_student(4, "188883", "Fathima", "Mohammad", "F", "Syria", "22/11/2001");
    add_student(5, "189447", "Jasmin", "Faruq", "F", "Egypt", "19/02/2002");
    
    list_all_students();

    edit_student(2, "31515498", "Kadir Mert", "İnce", "Male", "Turkey", "2002-05-01");

    list_all_students();

        Iterator<Student> iterator = students.iterator();


        ArrayList<Student> backupList = backupDataStudent(iterator);


    delete_student(3);


    list_all_students();
    
    System.out.printf("\n");

        students = restoreDataStudent(backupList);
    
        list_all_students();    
    }
    private static void testCourse(){
        add_course(1, 1, "ITEC314", "Multi Platform Programming");
        add_course(2, 1, "ITEC413", "Information Systems Security");
        add_course(3, 2, "ECON101", "Introduction to Economics");
        add_course(4, 3, "BUSS103", "Fundamentals of Business Administration");
        
        list_all_courses();
        
        edit_course(2, 2, "ECON102", "Introduction to Economics");
        
        list_all_courses();
        
        Iterator<Course> iterator = courses.iterator();

        ArrayList<Course> backupList = backupDataCourse(iterator);
        
        delete_course(3);
        
        list_all_courses();
        
        System.out.printf("\n");
        courses = restoreDataCourse(backupList);
    
        list_all_courses();    
    }
    private static void testDepartment(){
        add_department(1, "Information Technologies");
        add_department(2, "Economics");
        add_department(3, "Business");
        
        list_all_departments();
        
        edit_department(2, "Introduction to Economics");
        
        list_all_departments();
        
        Iterator<Department> iterator = departments.iterator();

        ArrayList<Department> backupList = backupDataDepartment(iterator);
        
        delete_department(3);
        
        list_all_departments();
        
        System.out.printf("\n");
        departments = restoreDataDepartment(backupList);
    
        list_all_departments();    
    }
    private static void testGrades(){
        add_grades(1, 1, 1, 90f,88f,96f,"A");
        add_grades(2, 2, 1, 80f,85f,82f,"B+");
        add_grades(3, 3, 2, 75f,80f,77f,"B-");
        add_grades(4, 4, 2, 69f,75f,66f,"C+");
        add_grades(5, 5, 1, 88f,80f,82f,"A-");
        
        list_all_grades();
        
        edit_grades(2,2,1,70f,85f,82f,"C");
        
        list_all_grades();
        
        Iterator<Grades> iterator = grades.iterator();

        ArrayList<Grades> backupList = backupDataGrades(iterator);
        
        delete_grade(3);
        
        list_all_grades();
        
        System.out.printf("\n");
        grades = restoreDataGrades(backupList);
    
        list_all_grades();    
    }
    private static void testAttendance(){
        add_attendance(1, 1, 1,"09/04/2021",true);
        add_attendance(2, 2, 1,"09/04/2021",false);
        add_attendance(3, 3, 2,"09/04/2021",false);
        add_attendance(4, 4, 2,"09/04/2021",true);
        add_attendance(5, 5, 1,"09/04/2021",true);
        add_attendance(6, 1, 1,"12/04/2021",false);
        add_attendance(7, 2, 1,"12/04/2021",false);
        add_attendance(5, 5, 1,"12/04/2021",true);

        
        list_all_attendance();
        
        edit_attendance(2, 2, 1,"15/04/2021",true);
        
        list_all_attendance();
        
        Iterator<Attendance> iterator = attendance.iterator();

        ArrayList<Attendance> backupList = backupDataAttendance(iterator);
        
        delete_attendance(3);
        
        list_all_attendance();
        
        System.out.printf("\n");
        attendance = restoreDataAttendance(backupList);
    
        list_all_attendance();    
    }
        
   
    

    public static void add_student(int std_id, String std_no, String std_name, String std_surname,
            String gender, String nationality, String birthday) {
            Student st =new Student(std_id, std_no, std_name, std_surname,
                                    gender, nationality, birthday);
            students.add(st);
    }
    
      public static void edit_student(int std_id, String std_no, String std_name, 
                               String std_surname, String gender, 
                               String nationality, String birthday) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(std_id==st.getStd_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setStd_no(std_no);
          st.setStd_name(std_name);
          st.setStd_surname(std_surname);
          st.setNationality(nationality);
          st.setGender(gender);
          st.setBirthday(birthday);
      }
      }

public static void delete_student(int std_id) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(std_id==(st.getStd_id())) {
              found=true;
              break;
          }
      }
      if (found) students.remove(st);
      }
    
    public static void draw_line(int num) {
        String ln="";
        for (int i=0; i<num; i++) ln+="=";
        System.out.printf("\n"+ln);
    }
public static ArrayList<Student> backupDataStudent(Iterator<Student> iterator) {
        ArrayList<Student> backupList = new ArrayList<>();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            backupList.add(student);
        }
        return backupList;
    }

    public static ArrayList<Student> restoreDataStudent(ArrayList<Student> backupList) {
        ArrayList<Student> restoredList = new ArrayList<>();
        restoredList.addAll(backupList);
        return restoredList;
    }

    public static void list_student(int std_id) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              "Id", "Student No","Std. Name", "Std. Surname", 
              "Gender","Nationality", "Birthday");
        draw_line(79);
      while (itr.hasNext()) {
          st = itr.next();
          if(std_id==st.getStd_id()) {
              System.out.printf("\n%2d %10s %15s %15s %10s %12s %12s", 
              st.getStd_id(), st.getStd_no(), 
              st.getStd_name(), st.getStd_surname(),
              st.getGender(), st.getNationality(), st.getBirthday());
              found=true;
              break;
          }
      }
    }
    public static void list_all_students() {
      Student st;
      Iterator <Student> itr = students.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              "Id", "Student No","Std. Name", "Std. Surname", 
              "Gender","Nationality", "Birthday");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10s %15s %15s %10s %12s %12s", 
              st.getStd_id(), st.getStd_no(), 
              st.getStd_name(), st.getStd_surname(),
              st.getGender(), st.getNationality(), st.getBirthday());
      }
      draw_line(79);
        
    }
    
    public static void add_course(int id, int dept_id, String crs_code, String crs_name) {
        Course crs =new Course(id, dept_id, crs_code, crs_name);
            courses.add(crs);
    }

    public static void edit_course(int id, int dept_id, String crs_code, String crs_name) {
        Course crs=null;
      Boolean found=false;
      Iterator <Course> itr = courses.iterator();
      while (itr.hasNext()) {
          crs = itr.next(); 
          if(id==crs.getCrs_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          crs.setCrs_id(id);
          crs.setDept_id(dept_id);
          crs.setCrs_code(crs_code);
          crs.setCrs_name(crs_name);
      }
    }

    public static void delete_course(int id) {
        
      Course crs=null;
      Boolean found=false;
      Iterator <Course> itr = courses.iterator();
      while (itr.hasNext()) {
          crs = itr.next(); 
          if(id==(crs.getCrs_id())) {
              found=true;
              break;
          }
      }
      if (found) courses.remove(crs);
      }
    public static void list_course(int id) {
      Course crs=null;
      Boolean found=false;
      Iterator <Course> itr = courses.iterator();
      System.out.printf("\n%2s %10s %15s %15s",
              "Id", "Department id","Course code", "Course name");
        draw_line(79);
      while (itr.hasNext()) {
          crs = itr.next();
          if(id==crs.getCrs_id()) {
              System.out.printf("\n%2d %10s %15s %15s", 
              crs.getCrs_id(), crs.getDept_id(), 
              crs.getCrs_code(), crs.getCrs_name());
              found=true;
              break;
          }
          
      }
    }
    public static void list_all_courses() {
     Course crs;
      Iterator <Course> itr = courses.iterator();
      System.out.printf("\n%2s %10s %15s %15s","Id", "Department id","Course code", "Course name");
        draw_line(79);
        
      while (itr.hasNext()) {
          crs = itr.next(); 
          System.out.printf("\n%2d %10s %15s %15s", 
              crs.getCrs_id(), crs.getDept_id(), 
              crs.getCrs_code(), crs.getCrs_name());
      }
      draw_line(79);
    }

    public void delete_all_courses() {
    courses.clear();
    }
public static ArrayList<Course> backupDataCourse(Iterator<Course> iterator) {
    ArrayList<Course> backupList = new ArrayList<>();
    while (iterator.hasNext()) {
        Course crs = iterator.next();
        backupList.add(new Course(crs.getCrs_id(), crs.getDept_id(), crs.getCrs_code(),crs.getCrs_name()));
    }
    return backupList;
}

public static ArrayList<Course> restoreDataCourse(ArrayList<Course> backupList) {
    ArrayList<Course> restoredList = new ArrayList<>();
    for (Course crs : backupList) {
        restoredList.add(new Course(crs.getCrs_id(), crs.getDept_id(), crs.getCrs_code(),crs.getCrs_name()));
    }
    return restoredList;
}



public static void add_attendance(int att_id, int std_id, int crs_id, String att_date, boolean is_present) {
            Attendance att =new Attendance(att_id, std_id, crs_id, att_date,
                                    is_present);
            attendance.add(att);
    }
    
      public static void edit_attendance(int att_id, int std_id, int crs_id, String att_date, boolean is_present) {
      Attendance att=null;
      Boolean found=false;
      Iterator <Attendance> itr = attendance.iterator();
      while (itr.hasNext()) {
          att = itr.next(); 
          if(std_id==att.getAtt_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          att.setAtt_id(att_id);
          att.setAtt_date(att_date);
          att.setIs_present(is_present);
      }
      }

public static void delete_attendance(int att_id) {
      Attendance att=null;
      Boolean found=false;
      Iterator <Attendance> itr = attendance.iterator();
      while (itr.hasNext()) {
          att = itr.next(); 
          if(att_id==(att.getAtt_id())) {
              found=true;
              break;
          }
      }
      if (found) attendance.remove(att);
      }
    public void delete_all_attendance() {
        attendance.clear();
    }
    public static void list_attendance(int att_id) {
      Attendance att=null;
      Boolean found=false;
      Iterator <Attendance> itr = attendance.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s",
              "Attendance Id", "Student Id","Course Id", "Attendance Date", 
              "Present");
        draw_line(79);
      while (itr.hasNext()) {
          att = itr.next();
          if(att_id==att.getAtt_id()) {
              System.out.printf("\n%2d %10s %15s %15s %10s", 
              att.getAtt_id(), att.getStd_id(), 
              att.getCrs_id(), att.getAtt_date(),
              att.isIs_present());
              found=true;
              break;
          }
      }
    }
    public static void list_all_attendance() {
      Attendance att;
      Iterator <Attendance> itr = attendance.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s",
              "Attendance Id", "Student Id","Course Id", "Attendance Date", 
              "Present");
        draw_line(79);
        
      while (itr.hasNext()) {
          att = itr.next(); 
          System.out.printf("\n%2d %10s %15s %15s %10s", 
              att.getAtt_id(), att.getStd_id(), 
              att.getCrs_id(), att.getAtt_date(),
              att.isIs_present());
      }
      draw_line(79);
    }
public static ArrayList<Attendance> backupDataAttendance(Iterator<Attendance> iterator) {
    ArrayList<Attendance> backupList = new ArrayList<>();
    while (iterator.hasNext()) {
        Attendance att = iterator.next();
        backupList.add(new Attendance(att.getAtt_id(), att.getStd_id(), 
              att.getCrs_id(), att.getAtt_date(),
              att.isIs_present()));
    }
    return backupList;
}

public static ArrayList<Attendance> restoreDataAttendance(ArrayList<Attendance> backupList) {
    ArrayList<Attendance> restoredList = new ArrayList<>();
    for (Attendance att : backupList) {
        restoredList.add(new Attendance(att.getAtt_id(), att.getStd_id(), 
              att.getCrs_id(), att.getAtt_date(),
              att.isIs_present()));
    }
    return restoredList;
}


public static void add_grades(int grd_id, int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, String grd_letter) {
            Grades grd =new Grades(grd_id, std_id, crs_id, grd_mt, grd_hw, grd_final, grd_letter);
            grades.add(grd);
    }
    
      public static void edit_grades(int grd_id, int std_id, int crs_id,float grd_mt, float grd_hw, float grd_final, String grd_letter) {
      Grades grd=null;
      Boolean found=false;
      Iterator <Grades> itr = grades.iterator();
      while (itr.hasNext()) {
          grd = itr.next(); 
          if(grd_id==grd.getGrd_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          grd.setGrd_id(grd_id);
          grd.setStd_id(std_id);
          grd.setCrs_id(crs_id);
          grd.setGrd_mt(grd_mt);
          grd.setGrd_hw(grd_hw);
          grd.setGrd_final(grd_final);
          grd.setGrd_letter(grd_letter);
      }
      }

public static void delete_grade(int grd_id) {
      Grades grd=null;
      Boolean found=false;
      Iterator <Grades> itr = grades.iterator();
      while (itr.hasNext()) {
          grd = itr.next(); 
          if(grd_id==(grd.getGrd_id())) {
              found=true;
              break;
          }
      }
      if (found) grades.remove(grd);
      }
    
    public static void list_grade(int grd_id) {
      Grades grd=null;
      Boolean found=false;
      Iterator <Grades> itr = grades.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              "Grade Id", "Student Id","Course Id", "Midterm Grade", 
              "Homework Grade","Final Grade","Letter Grade");
        draw_line(79);
      while (itr.hasNext()) {
          grd = itr.next();
          if(grd_id==grd.getGrd_id()) {
              System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              grd.getGrd_id(), grd.getStd_id(), 
              grd.getCrs_id(), grd.getGrd_mt(),
              grd.getGrd_hw(),grd.getGrd_final(),grd.getGrd_letter());
              found=true;
              break;
          }
      }
    }
    public static void list_all_grades() {
      Grades grd;
      Iterator <Grades> itr = grades.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              "Grade Id", "Student Id","Course Id", "Midterm Grade", 
              "Homework Grade","Final Grade","Letter Grade");
        draw_line(79);
        
      while (itr.hasNext()) {
          grd = itr.next(); 
          System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              grd.getGrd_id(), grd.getStd_id(), 
              grd.getCrs_id(), grd.getGrd_mt(),
              grd.getGrd_hw(),grd.getGrd_final(),grd.getGrd_letter());
      }
      draw_line(79);
    }
    public static ArrayList<Grades> backupDataGrades(Iterator<Grades> iterator) {
    ArrayList<Grades> backupList = new ArrayList<>();
    while (iterator.hasNext()) {
        Grades grd = iterator.next();
        backupList.add(new Grades(grd.getGrd_id(), grd.getStd_id(), 
              grd.getCrs_id(), grd.getGrd_mt(),
              grd.getGrd_hw(),grd.getGrd_final(),grd.getGrd_letter()));
    }
    return backupList;
}

public static ArrayList<Grades> restoreDataGrades(ArrayList<Grades> backupList) {
    ArrayList<Grades> restoredList = new ArrayList<>();
    for (Grades grd : backupList) {
        restoredList.add(new Grades(grd.getGrd_id(), grd.getStd_id(), 
              grd.getCrs_id(), grd.getGrd_mt(),
              grd.getGrd_hw(),grd.getGrd_final(),grd.getGrd_letter()));
    }
    return restoredList;
}


public static void add_department(int dept_id, String dept_name) {
            Department dpt =new Department(dept_id, dept_name);
            departments.add(dpt);
    }
    
      public static void edit_department(int dept_id, String dept_name) {
      Department dpt=null;
      Boolean found=false;
      Iterator <Department> itr = departments.iterator();
      while (itr.hasNext()) {
          dpt = itr.next(); 
          if(dept_id==dpt.getDept_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          dpt.setDept_id(dept_id);
          dpt.setDept_name(dept_name);
      }
      }

public static void delete_department(int dept_id) {
      Department dpt=null;
      Boolean found=false;
      Iterator <Department> itr = departments.iterator();
      while (itr.hasNext()) {
          dpt = itr.next(); 
          if(dept_id==(dpt.getDept_id())) {
              found=true;
              break;
          }
      }
      if (found) departments.remove(dpt);
      }
    public void delete_all_departments() {
        departments.clear();
    }
    public static void list_department(int dept_id) {
      Department dpt=null;
      Boolean found=false;
      Iterator <Department> itr = departments.iterator();
      System.out.printf("\n%2s %10s",
              "Department Id", "Department name");
        draw_line(79);
      while (itr.hasNext()) {
          dpt = itr.next();
          if(dept_id==dpt.getDept_id()) {
              System.out.printf("\n%2d %10s", 
              dpt.getDept_id(), dpt.getDept_name());
              found=true;
              break;
          }
      }
    }
    public static void list_all_departments() {
      Department dpt;
      Iterator <Department> itr = departments.iterator();
      System.out.printf("\n%2s %10s",
              "Department Id", "Department name");
        draw_line(79);
        
      while (itr.hasNext()) {
          dpt = itr.next(); 
          System.out.printf("\n%2d %10s", 
              dpt.getDept_id(), dpt.getDept_name());
      }
      draw_line(79);
    }
    public static ArrayList<Department> backupDataDepartment(Iterator<Department> iterator) {
    ArrayList<Department> backupList = new ArrayList<>();
    while (iterator.hasNext()) {
        Department dpt = iterator.next();
        backupList.add(new Department(dpt.getDept_id(), dpt.getDept_name()));
    }
    return backupList;
}

public static ArrayList<Department> restoreDataDepartment(ArrayList<Department> backupList) {
    ArrayList<Department> restoredList = new ArrayList<>();
    for (Department dpt : backupList) {
        restoredList.add(new Department(dpt.getDept_id(), dpt.getDept_name()));
    }
    return restoredList;
}

}

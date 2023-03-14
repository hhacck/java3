import java.util.*;

import javax.swing.plaf.basic.BasicTreeUI.TreeToggleAction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
static Session session;
static TreeToggleAction t;
public void connect()
{
Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        session =  sf.openSession();      
        t = session.beginTransaction();
}

    public static void main( String[] args )
    {
    Scanner sc = new Scanner(System.in);
    System.out.println("1. INSERT");
    System.out.println("2. DELETE");
    System.out.println("3. DISPLAY");
    System.out.println("4. SEARCH BY ID");
    System.out.println("5. UPDATE");
    System.out.println("6. EXIT");
   
    App a = null;
    String name;
    int usn,marks;
    Student s1 = new Student();

    while(true)
    {
    System.out.print("Enter your choice : ");
    int ch = sc.nextInt();

    if(ch==1)
    {
    a = new App();
    a.connect();
   
    System.out.print("Enter USN : ");
    usn = sc.nextInt();
    System.out.print("Enter Name : ");
    name = sc.next();
    System.out.print("Enter Marks : ");
    marks = sc.nextInt();
   
           s1.setUsn(usn);
           s1.setName(name);
           s1.setMarks(marks);
           session.save(s1);
           t.commit();
    }
    else if(ch==2)
    {
    a = new App();
    a.connect();
   
    System.out.print("Enter USN to delete: ");
    usn = sc.nextInt();
    s1.setUsn(usn);
    session.remove(s1);
    t.commit();
    }
    else if(ch==3)
    {
    a = new App();
    a.connect();
   
    String query= "from Student";
        List<Student> q = session.createQuery("from Student").list();
        for(Student s:q)
        {
        System.out.println("USN : " + s.getUsn());
        System.out.println("NAME : " + s.getName());
        System.out.println("MARKS : " + s.getMarks());    
        }
        t.commit();
   
    }
    else if(ch==4)
    {
    a = new App();
    a.connect();
   
    System.out.print("Enter USN to search : ");
    usn = sc.nextInt();
    s1 = session.get(Student.class, usn);
   
    System.out.println("USN : " + s1.getUsn());
    System.out.println("NAME : " + s1.getName());
    System.out.println("MARKS : " + s1.getMarks());  
   
    }
    else if(ch==5)
    {
    a = new App();
    a.connect();
   
    System.out.print("Enter USN to update : ");
    usn = sc.nextInt();
   
    System.out.print("Enter Name : ");
    name = sc.next();
    System.out.print("Enter Marks : ");
    marks = sc.nextInt();
   
    s1.setUsn(usn);
    s1.setName(name);
    s1.setMarks(marks);
   
    session.saveOrUpdate(s1);
    t.commit();
   
    }
    else if(ch==6)
    break;
    else
    System.out.println("Invalid choice");
    }    
    }
}

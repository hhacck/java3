

@Entity
public class Student {

@Id
int usn;
int marks;
String name;

public int getUsn() {
return usn;
}

public void setUsn(int usn) {
this.usn = usn;
}

public int getMarks() {
return marks;
}

public void setMarks(int marks) {
this.marks = marks;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}
}

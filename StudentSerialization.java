import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        Student student = new Student(101, "Selim Jahangir", 6.75);

        // Serialize the Student object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Student object has been serialized and saved to student.ser");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file could not be found or created. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred during serialization. " + e.getMessage());
        }

        // Deserialize the Student object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("\nStudent details after deserialization:");
            System.out.println("ID: " + deserializedStudent.getId());
            System.out.println("Name: " + deserializedStudent.getName());
            System.out.println("GPA: " + deserializedStudent.getGpa());
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file student.ser was not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred during deserialization. " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Student class not found. " + e.getMessage());
        }
    }
}
import java.util.ArrayList;

public class AttendanceManager {

    private ArrayList<Student> attendees;

    public AttendanceManager() {
        attendees = new ArrayList<Student>();
    }

    public void markAttendance(Student student) {
        attendees.add(student);
    }

    public void showAttendance() {

        System.out.println(
                "\n===== ATTENDANCE REPORT ====="
        );

        if (attendees.size() == 0) {

            System.out.println(
                    "No Attendance Records"
            );

            return;
        }

        for (Student student : attendees) {

            System.out.println(
                    student.getAnonymousId()
                    + " | "
                    + student.getName()
                    + " | "
                    + student.getRollNo()
            );
        }
    }

    public int getAttendanceCount() {
        return attendees.size();
    }
}
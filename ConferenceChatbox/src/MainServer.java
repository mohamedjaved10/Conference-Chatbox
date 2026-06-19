import java.util.Scanner;

public class MainServer {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    WorkshopManager manager =
            new WorkshopManager();

    Chatroom room =
            manager.getChatroom();

    AttendanceManager attendance =
            manager.getAttendanceManager();

    Host host =
            manager.getHost();

    System.out.println("=================================");
    System.out.println("      WorkshopConnect Server");
    System.out.println("=================================");

    System.out.print("Host Username: ");
    String username = sc.nextLine();

    System.out.print("Host Password: ");
    String password = sc.nextLine();

    if (!host.login(username, password)) {

        System.out.println(
                "Invalid Host Credentials"
        );

        sc.close();
        return;
    }

    System.out.println("\nLogin Successful");

    System.out.print(
            "\nEnter Number Of Students: "
    );

    int count =
            Integer.parseInt(
                    sc.nextLine()
            );

    for (int i = 0; i < count; i++) {

        System.out.println(
                "\nStudent " + (i + 1)
        );

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Roll Number: ");
        String rollNo = sc.nextLine();

        Student student =
                room.addStudent(
                        name,
                        rollNo
                );

        attendance.markAttendance(
                student
        );
    }

    room.showStudents();

    attendance.showAttendance();

    host.announce(
            "Welcome To WorkshopConnect"
    );
    manager.addActivity(
        "Workshop Started"
);

    room.addMessage(
            "HOST",
            "Workshop Started",
            "ANNOUNCEMENT"
    );
  Question q1 =
        new Question(
                "Q1",
                "Student-1",
                "What is Java?"
        );
room.addQuestion(q1);
Poll poll1 =
        new Poll(
                "Which Topic Did You Like?",
                "Java",
                "HTML",
                "JavaScript"
        );

poll1.vote(1);
poll1.vote(1);
poll1.vote(2);

room.addPoll(poll1);

    room.showMessages();

    manager.showActivityLogs();

    room.showQuestions();

    poll1.showResults();

    room.showPollCount();
WorkshopReport report =
        new WorkshopReport(
                room.getStudents().size(),
                attendance.getAttendanceCount(),
                room.getMessages().size(),
                room.getQuestionCount(),
                room.getPollCount()
        );

report.showReport();
    manager.showSystemStatus();


    host.showDashboard();

    sc.close();
}

}

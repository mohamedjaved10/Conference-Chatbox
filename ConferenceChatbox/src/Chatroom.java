import java.util.ArrayList;

public class Chatroom {

    private ArrayList<Student> students;
    private ArrayList<ChatMessage> messages;
    private ArrayList<Question> questions;
    private ArrayList<Poll> polls;

    private int studentCounter;

    public Chatroom() {

        students = new ArrayList<Student>();
        messages = new ArrayList<ChatMessage>();
        questions = new ArrayList<Question>();
        polls = new ArrayList<Poll>();

        studentCounter = 1;
    }

    public Student addStudent(
            String name,
            String rollNo) {

        String id =
                "Student-" +
                studentCounter++;

        Student student =
                new Student(
                        name,
                        rollNo,
                        id
                );

        students.add(student);

        return student;
    }

    public void addMessage(
            String sender,
            String message,
            String type) {

        ChatMessage chatMessage =
                new ChatMessage(
                        sender,
                        message,
                        type
                );

        messages.add(chatMessage);
    }

    public void showStudents() {

        System.out.println(
                "\n===== STUDENTS ====="
        );

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void showMessages() {

        System.out.println(
                "\n===== CHAT HISTORY ====="
        );

        for (ChatMessage message : messages) {
            System.out.println(message);
        }
    }

    public void raiseHand(
            String anonymousId) {

        for (Student student : students) {

            if (student.getAnonymousId()
                    .equals(anonymousId)) {

                student.raiseHand();

                System.out.println(
                        anonymousId
                        + " Raised Hand"
                );

                return;
            }
        }
    }

    public void showRaisedHands() {

        System.out.println(
                "\n===== RAISED HANDS ====="
        );

        for (Student student : students) {

            if (student.isHandRaised()) {

                System.out.println(
                        student.getAnonymousId()
                        + " - "
                        + student.getName()
                );
            }
        }
    }

    public void showStatistics() {

        System.out.println(
                "\n===== WORKSHOP STATS ====="
        );

        System.out.println(
                "Participants : "
                + students.size()
        );

        System.out.println(
                "Messages : "
                + messages.size()
        );
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }
    public void addQuestion(
        Question question) {

    questions.add(question);
}

public void showQuestions() {

    System.out.println(
            "\n===== QUESTIONS ====="
    );

    for (Question question : questions) {
        System.out.println(question);
    }
}

public void addPoll(
        Poll poll) {

    polls.add(poll);
}

public void showPollCount() {

    System.out.println(
            "\nPolls Created : "
            + polls.size()
    );
}

public int getQuestionCount() {
    return questions.size();
}

public int getPollCount() {
    return polls.size();
}
}
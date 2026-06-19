public class WorkshopReport {

    private int participants;
    private int attendance;
    private int messages;
    private int questions;
    private int polls;

    public WorkshopReport(
            int participants,
            int attendance,
            int messages,
            int questions,
            int polls) {

        this.participants = participants;
        this.attendance = attendance;
        this.messages = messages;
        this.questions = questions;
        this.polls = polls;
    }

    public void showReport() {

        System.out.println(
                "\n===== WORKSHOP REPORT ====="
        );

        System.out.println(
                "Participants : "
                + participants
        );

        System.out.println(
                "Attendance : "
                + attendance
        );

        System.out.println(
                "Messages : "
                + messages
        );

        System.out.println(
                "Questions : "
                + questions
        );

        System.out.println(
                "Polls : "
                + polls
        );
    }
}
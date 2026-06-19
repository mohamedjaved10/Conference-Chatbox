public class WorkshopManager {

    private Chatroom chatroom;
    private AttendanceManager attendanceManager;
    private Host host;
    private java.util.ArrayList<ActivityLog> activityLogs;

    public WorkshopManager() {

        chatroom = new Chatroom();
        attendanceManager = new AttendanceManager();

        host = new Host(
                "host",
                "admin123",
                "Workshop Organizer"
        );
        activityLogs =
        new java.util.ArrayList<ActivityLog>();
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public AttendanceManager getAttendanceManager() {
        return attendanceManager;
    }

    public Host getHost() {
        return host;
    }

    public void showSystemStatus() {

        System.out.println(
                "\n===== SYSTEM STATUS ====="
        );

        System.out.println(
                "Participants : "
                + chatroom.getStudents().size()
        );

        System.out.println(
                "Messages : "
                + chatroom.getMessages().size()
        );

        System.out.println(
                "Attendance : "
                + attendanceManager.getAttendanceCount()
        );
    }
    public void addActivity(
        String activity) {

    activityLogs.add(
            new ActivityLog(activity)
    );
}

public void showActivityLogs() {

    System.out.println(
            "\n===== ACTIVITY LOGS ====="
    );

    for (ActivityLog log : activityLogs) {
        System.out.println(log);
    }
}

public int getActivityCount() {
    return activityLogs.size();
}
}
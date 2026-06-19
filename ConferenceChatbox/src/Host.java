public class Host {

    private String username;
    private String password;
    private String hostName;

    private int announcementsSent;

    public Host(
            String username,
            String password,
            String hostName) {

        this.username = username;
        this.password = password;
        this.hostName = hostName;

        this.announcementsSent = 0;
    }

    public boolean login(
            String user,
            String pass) {

        return username.equals(user)
                && password.equals(pass);
    }

    public void startWorkshop() {
        System.out.println("\nWorkshop Started By " + hostName);
    }

    public void endWorkshop() {
        System.out.println("\nWorkshop Ended By " + hostName);
    }

    public void announce(String message) {

        announcementsSent++;

        System.out.println(
                "\n📢 HOST ANNOUNCEMENT"
        );

        System.out.println(
                hostName + ": " + message
        );
    }

    public void showDashboard() {

        System.out.println(
                "\n===== HOST DASHBOARD ====="
        );

        System.out.println(
                "Host Name : " + hostName
        );

        System.out.println(
                "Announcements Sent : "
                        + announcementsSent
        );
    }

    public String getHostName() {
        return hostName;
    }

    public int getAnnouncementsSent() {
        return announcementsSent;
    }
}
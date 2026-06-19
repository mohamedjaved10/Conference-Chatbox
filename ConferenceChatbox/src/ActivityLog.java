import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityLog {

    private String activity;
    private String timestamp;

    public ActivityLog(String activity) {

        this.activity = activity;

        this.timestamp =
                LocalDateTime.now()
                .format(
                        DateTimeFormatter.ofPattern(
                                "dd-MM-yyyy HH:mm:ss"
                        )
                );
    }

    public String getActivity() {
        return activity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        return "[" + timestamp + "] "
                + activity;
    }
}
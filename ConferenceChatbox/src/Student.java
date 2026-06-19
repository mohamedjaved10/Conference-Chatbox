import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {

private String name;
private String rollNo;
private String anonymousId;
private String joinTime;

private boolean attendanceMarked;
private boolean handRaised;
private boolean active;

private int questionsAsked;
private int pollsVoted;

private String lastActivity;

public Student(String name,
               String rollNo,
               String anonymousId) {

    this.name = name;
    this.rollNo = rollNo;
    this.anonymousId = anonymousId;

    this.joinTime =
            LocalDateTime.now()
            .format(
                DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy HH:mm:ss"
                )
            );

    this.lastActivity = joinTime;

    this.attendanceMarked = true;
    this.handRaised = false;
    this.active = true;

    this.questionsAsked = 0;
    this.pollsVoted = 0;
}

public String getName() {
    return name;
}

public String getRollNo() {
    return rollNo;
}

public String getAnonymousId() {
    return anonymousId;
}

public String getJoinTime() {
    return joinTime;
}

public String getLastActivity() {
    return lastActivity;
}

public boolean isAttendanceMarked() {
    return attendanceMarked;
}

public boolean isHandRaised() {
    return handRaised;
}

public boolean isActive() {
    return active;
}

public int getQuestionsAsked() {
    return questionsAsked;
}

public int getPollsVoted() {
    return pollsVoted;
}

public void raiseHand() {
    handRaised = true;
    updateActivity();
}

public void lowerHand() {
    handRaised = false;
    updateActivity();
}

public void askQuestion() {
    questionsAsked++;
    updateActivity();
}

public void votePoll() {
    pollsVoted++;
    updateActivity();
}

public void leaveWorkshop() {
    active = false;
    updateActivity();
}

private void updateActivity() {

    lastActivity =
            LocalDateTime.now()
            .format(
                DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy HH:mm:ss"
                )
            );
}

@Override
public String toString() {

    return anonymousId
            + " | "
            + name
            + " | "
            + rollNo
            + " | Joined: "
            + joinTime;
}


}

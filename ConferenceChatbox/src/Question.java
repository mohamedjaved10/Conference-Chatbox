import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Question {

private String questionId;
private String anonymousId;
private String questionText;
private String timestamp;
private boolean answered;

public Question(
        String questionId,
        String anonymousId,
        String questionText) {

    this.questionId = questionId;
    this.anonymousId = anonymousId;
    this.questionText = questionText;

    this.timestamp =
            LocalDateTime.now()
            .format(
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy HH:mm:ss"
                    )
            );

    this.answered = false;
}

public String getQuestionId() {
    return questionId;
}

public String getAnonymousId() {
    return anonymousId;
}

public String getQuestionText() {
    return questionText;
}

public String getTimestamp() {
    return timestamp;
}

public boolean isAnswered() {
    return answered;
}

public void markAnswered() {
    answered = true;
}

@Override
public String toString() {

    return questionId
            + " | "
            + anonymousId
            + " | "
            + questionText
            + " | "
            + timestamp
            + " | Answered: "
            + answered;
}

}

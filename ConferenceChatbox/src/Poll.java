public class Poll {

    private String pollQuestion;

    private int option1Votes;
    private int option2Votes;
    private int option3Votes;

    private String option1;
    private String option2;
    private String option3;

    public Poll(
            String pollQuestion,
            String option1,
            String option2,
            String option3) {

        this.pollQuestion = pollQuestion;

        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;

        option1Votes = 0;
        option2Votes = 0;
        option3Votes = 0;
    }

    public void vote(int option) {

        if (option == 1) {
            option1Votes++;
        }
        else if (option == 2) {
            option2Votes++;
        }
        else if (option == 3) {
            option3Votes++;
        }
    }

    public void showResults() {

        System.out.println(
                "\n===== POLL RESULTS ====="
        );

        System.out.println(
                pollQuestion
        );

        System.out.println(
                option1 + " : " + option1Votes
        );

        System.out.println(
                option2 + " : " + option2Votes
        );

        System.out.println(
                option3 + " : " + option3Votes
        );
    }
}
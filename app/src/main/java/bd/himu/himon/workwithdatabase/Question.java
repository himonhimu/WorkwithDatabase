package bd.himu.himon.workwithdatabase;

/**
 * Created by Design on 3/24/2018.
 */

public class Question {


    private String question;
    private String[] choice = new String[4];
    private String answer;
    private String section;
    private String sectionb;
    public Question() {

    }
    public Question(String question, String[] choices, String answer, String section, String sectionb) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.choice[2] = choices[2];
        this.choice[3] = choices[3];
        this.answer = answer;
        this.section = section;
        this.sectionb = sectionb;
    }

    public String getQuestion() {
        return question;
    }

    public String getSection() {
        return section;
    }
    public String getSectionb() {
        return sectionb;
    }

    public String getChoice(int i) {
        return choice[i];
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setChoice(int i, String choice) {
        this.choice[i] = choice;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSection(String section) {
        this.section = section;
    }
    public void setSectionb(String sectionb) {
        this.sectionb = sectionb;
    }
}

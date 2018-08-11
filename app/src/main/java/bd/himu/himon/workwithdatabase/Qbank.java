package bd.himu.himon.workwithdatabase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Design on 3/24/2018.
 */

public class Qbank {


    public static String AllText;

    // declare list of Question objects
    List <Question> list = new ArrayList<>();
    MyDbHelper myDataBaseHelper;

    //get subjective and bcs paramiter from on click
    public Qbank(){

    }
public Qbank (String allText){
        AllText = allText;
}
    public static void setAllText(String allText){
        AllText = allText;

    }
    public static String getAllText() {
        return AllText;
    }



    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }

    public String getSection(int a) {
        return list.get(a).getSection();
    }
    public String getSectionb(int a) {
        return list.get(a).getSectionb();
    }

    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDbHelper(context);
        list = myDataBaseHelper.getAllQuestionList();//get questions/choices/answers from database

       /* if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("When did Google acquire Android ?",
                    new String[]{"2001", "2003", "2004", "2005"}, "2005","A","B38"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the name of build toolkit for Android Studio?",
                    new String[]{"JVM", "Gradle", "Dalvik", "HAXM"}, "Gradle","A", "B37"));
            myDataBaseHelper.addInitialQuestion(new Question("What widget can replace any use of radio buttons?",
                    new String[]{"Toggle Button", "Spinner", "Switch Button", "ImageButton"}, "Spinner","B", "B38"));
            myDataBaseHelper.addInitialQuestion(new Question("What is a widget in Android app?",
                    new String[]{"reusable GUI element", "Layout for Activity", "device placed in cans of beer", "build toolkit"}, "reusable GUI element","B", "B37"));

            list = myDataBaseHelper.getAllQuestionList();//get list from database again

        }*/
    }


    public void initQuestionsBySecB(Context context) {
        myDataBaseHelper = new MyDbHelper(context);
        list = myDataBaseHelper.getAllQuestionListBySectionB(getAllText());//get questions/choices/answers from database
    }

      //get questions/choices/answers from database


      public void initQuestionsBySec(Context context) {
            myDataBaseHelper = new MyDbHelper(context);
            list = myDataBaseHelper.getAllQuestionListBySection(getAllText());//get questions/choices/answers from database

        }

   //Random Section

    public void initQuestionsBySecRandom(Context context) {
        myDataBaseHelper = new MyDbHelper(context);
        list = myDataBaseHelper.getAllQuestionListByRandomSection(getAllText());//get questions/choices/answers from database

    }

}
package bd.himu.himon.workwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Design on 3/24/2018.
 */

public class MyDbHelper extends SQLiteOpenHelper {

    public static String getSec() {
        return sec;
    }

    public static void setSec(String sec) {
        MyDbHelper.sec = sec;
    }

    public static String sec;

    Cursor c = null;

    public static String DB_PATH = null;
    public static String DB_NAME = "Qbank";
    private SQLiteDatabase myDataBase;
    private Context myContext;


    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("Qbank", null, null, null, null, null, null);
    }

   /* public long addInitialQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(c.getString(1), question.getQuestion());
        values.put(c.getString(2), question.getChoice(0));
        values.put(c.getString(3), question.getChoice(1));
        values.put(c.getString(4), question.getChoice(2));
        values.put(c.getString(5), question.getChoice(3));
        values.put(c.getString(6), question.getAnswer());
        values.put(c.getString(7), question.getSection());
        values.put(c.getString(8), question.getSectionb());


        long insert = db.insert("Qbank", null, values);
        return insert;

    }*/

    public List<Question> getAllQuestionList() {

        List<Question> questionArrayList = new ArrayList<>();
        try {
            createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        c = myDataBase.query("Qbank", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {

                Question question = new Question();

                String questText = c.getString(1);
                question.setQuestion(questText);

                String choice1Text = c.getString(2);
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(3);
                question.setChoice(1, choice2Text);

                String choice3Text = c.getString(4);
                question.setChoice(2, choice3Text);

                String choice4Text = c.getString(5);
                question.setChoice(3, choice4Text);

                String answerText = c.getString(6);
                question.setAnswer(answerText);

                String SecText = c.getString(7);
                question.setSection(SecText);

                String SecTextb = c.getString(8);
                question.setSectionb(SecTextb);

                // adding to Questions list
                questionArrayList.add(question);
            }
            while (c.moveToNext());
            //Collections.shuffle(questionArrayList);
        }
        return questionArrayList;
    }

    public List<Question> getAllQuestionListBySection(String Section) {

        List<Question> questionArrayList = new ArrayList<>();
        try {
            createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        c = myDataBase.query("Qbank", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {

                Question question = new Question();

                String questText = c.getString(1);
                question.setQuestion(questText);

                String choice1Text = c.getString(2);
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(3);
                question.setChoice(1, choice2Text);

                String choice3Text = c.getString(4);
                question.setChoice(2, choice3Text);

                String choice4Text = c.getString(5);
                question.setChoice(3, choice4Text);

                String answerText = c.getString(6);
                question.setAnswer(answerText);

                String SecText = c.getString(7);
                question.setSection(SecText);

                String SecTextb = c.getString(8);
                question.setSectionb(SecTextb);

                // adding to Questions list
                if (Section.equals(SecText)) {
                    questionArrayList.add(question);
                }
            }
            while (c.moveToNext());
            //Collections.shuffle(questionArrayList);
        }
        return questionArrayList;
    }

    public List<Question> getAllQuestionListByRandomSection(String Section) {

        List<Question> questionArrayList = new ArrayList<>();
        try {
            createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        c = myDataBase.query("Qbank", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {

                Question question = new Question();

                String questText = c.getString(1);
                question.setQuestion(questText);

                String choice1Text = c.getString(2);
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(3);
                question.setChoice(1, choice2Text);

                String choice3Text = c.getString(4);
                question.setChoice(2, choice3Text);

                String choice4Text = c.getString(5);
                question.setChoice(3, choice4Text);

                String answerText = c.getString(6);
                question.setAnswer(answerText);

                String SecText = c.getString(7);
                question.setSection(SecText);

                String SecTextb = c.getString(8);
                question.setSectionb(SecTextb);

                // adding to Questions list
                if (Section.equals(SecText)) {
                    questionArrayList.add(question);
                }
            }
            while (c.moveToNext());
            Collections.shuffle(questionArrayList);
        }
        return questionArrayList;
    }

    public List<Question> getAllQuestionListBySectionB(String Section) {

        List<Question> questionArrayList = new ArrayList<>();
        try {
            createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        c = myDataBase.query("Qbank", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {

                Question question = new Question();

                String questText = c.getString(1);
                question.setQuestion(questText);

                String choice1Text = c.getString(2);
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(3);
                question.setChoice(1, choice2Text);

                String choice3Text = c.getString(4);
                question.setChoice(2, choice3Text);

                String choice4Text = c.getString(5);
                question.setChoice(3, choice4Text);

                String answerText = c.getString(6);
                question.setAnswer(answerText);

                String SecText = c.getString(7);
                question.setSection(SecText);

                String SecTextb = c.getString(8);
                question.setSectionb(SecTextb);

                // adding to Questions list
                if (Section.equals(SecTextb)) {
                    questionArrayList.add(question);
                }
            }
            while (c.moveToNext());
            //Collections.shuffle(questionArrayList);
        }
        return questionArrayList;
    }


}
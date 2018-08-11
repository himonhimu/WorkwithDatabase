package bd.himu.himon.workwithdatabase;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by Design on 4/5/2018.
 */

public class NoUse extends AppCompatActivity {
    protected Qbank mQuestionLibrary = new Qbank();

    public TextView Section;
    public TextView Qnumber;
    private TextView Score;   // view for current total score
    public TextView mQuestionView;  //current question to answer
    public Button mButtonChoice1, Skip, Exit; // multiple choice 1 for mQuestionView
    public Button mButtonChoice2; // multiple choice 2 for mQuestionView
    public Button mButtonChoice3; // multiple choice 3 for mQuestionView
    public Button mButtonChoice4; // multiple choice 4 for mQuestionView

    public String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    protected int mQuestionNumber = 0; // current question number

    public int ButtonClickCount = 1;
    public int number = 1;
    public TextView timer;
    public CountDownTimer Mytimer;
    public int TotalNumber;
    public LinearLayout QLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionpattern);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // setup screen for the first question with four alternative to answer
        //  mScoreView = (TextView)findViewById(R.id.score);

        QLayout = (LinearLayout)findViewById(R.id.Pattern);
        // QLayout.setVisibility(View.INVISIBLE);

        mQuestionView = (TextView) findViewById(R.id.A1);
        mButtonChoice1 = (Button) findViewById(R.id.A);
        mButtonChoice2 = (Button) findViewById(R.id.B);
        mButtonChoice3 = (Button) findViewById(R.id.C);
        mButtonChoice4 = (Button) findViewById(R.id.D);
        Section = (TextView) findViewById(R.id.CATA);
       // Qnumber = (TextView) findViewById(R.id.TotalQ);
        Score = (TextView) findViewById(R.id.Score);

        timer = (TextView) findViewById(R.id.Timer);
        TotalNumber= mQuestionLibrary.getLength();



        Qnumber.setText("Total  Quetoin : " +TotalNumber);
        // number = mygetQnumber;
        updateScore();
        reverseTimers();
        onClicka();
        OnClickSandE();

    }


    public void updateScore() {
        Score.setText("Score : " + mScore +"/"+mQuestionLibrary.getLength());
    }

    public void updateQuestion() {
        // check if we are not outside array bounds for questions
        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            // set the text for new question,
            // and new 4 alternative to answer on four buttons

            mQuestionView.setText(number + ". " + mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            Section.setText(mQuestionLibrary.getSection(mQuestionNumber));
            number++;
            mQuestionNumber++;
            buttonFunction();


            try {
                Mytimer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(NoUse.this, "It was the last question!", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonFunction() {
        mButtonChoice1.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        mButtonChoice2.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        mButtonChoice3.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        mButtonChoice4.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        mButtonChoice1.setTextColor(Color.BLACK);
        mButtonChoice2.setTextColor(Color.BLACK);
        mButtonChoice3.setTextColor(Color.BLACK);
        mButtonChoice4.setTextColor(Color.BLACK);
        mButtonChoice1.setEnabled(true);
        mButtonChoice2.setEnabled(true);
        mButtonChoice3.setEnabled(true);
        mButtonChoice4.setEnabled(true);
    }

    public void onClicka() {
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                if (mButtonChoice1.getText().equals(mAnswer)) {
                    Mytimer.cancel();
                    mScore++;
                    updateScore();
                    reverseTimer();
                    colorw();
                } else {
                    mScore--;
                    updateScore();
                    colorw();
                    reverseTimer();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                if (mButtonChoice2.getText().equals(mAnswer)) {
                    mScore++;
                    updateScore();
                    Mytimer.cancel();
                    reverseTimer();
                    colorw();
                } else {
                    colorw();
                    mScore--;
                    updateScore();
                    reverseTimer();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                if (mButtonChoice3.getText().equals(mAnswer)) {
                    mScore++;
                    updateScore();
                    Mytimer.cancel();
                    reverseTimer();
                    colorw();
                } else {
                    colorw();
                    mScore--;
                    updateScore();
                    reverseTimer();
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                if (mButtonChoice4.getText().equals(mAnswer)) {
                    mScore++;
                    updateScore();
                    Mytimer.cancel();
                    reverseTimer();
                } else {
                    colorw();
                    mScore--;
                    updateScore();
                    reverseTimer();
                }
            }
        });


    }

    public void reverseTimer() {

        CountDownTimer startTimer = new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

                long sec = (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                if (sec == 1) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        }
                    }, 1000);
                }


            }

            public void onFinish() {
                updateQuestion();

            }
        }.start();
    }

    public void reverseTimers() {

        Mytimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {

                long sec = (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                timer.setText(String.format("( %02d SEC )", sec));
                if (sec == 1) {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            timer.setText("( 00 SEC )");
                        }
                    }, 1000);
                }


            }

            public void onFinish() {


                if (mQuestionNumber < mQuestionLibrary.getLength()) {
                    updateQuestion();

                }

            }

        }.start();

    }

    private void color() {
        if (mButtonChoice1.getText().equals(mAnswer)) {
            mButtonChoice1.setBackgroundColor(Color.parseColor("#076e04"));
            mButtonChoice1.setTextColor(Color.WHITE);
        } else if (mButtonChoice2.getText().equals(mAnswer)) {
            mButtonChoice2.setBackgroundColor(Color.parseColor("#076e04"));
            mButtonChoice2.setTextColor(Color.WHITE);
        } else if (mButtonChoice3.getText().equals(mAnswer)) {
            mButtonChoice3.setBackgroundColor(Color.parseColor("#076e04"));
            mButtonChoice3.setTextColor(Color.WHITE);
        } else if (mButtonChoice4.getText().equals(mAnswer)) {
            mButtonChoice4.setBackgroundColor(Color.parseColor("#076e04"));
            mButtonChoice4.setTextColor(Color.WHITE);
        }
    }

    private void colorw() {

        if (mButtonChoice1.isPressed() && !mButtonChoice1.getText().equals(mAnswer)) {
            mButtonChoice1.setBackgroundColor(Color.parseColor("#9e1807"));
            mButtonChoice1.setTextColor(Color.YELLOW);

        } else if (mButtonChoice2.isPressed() && !mButtonChoice2.getText().equals(mAnswer)) {
            mButtonChoice2.setBackgroundColor(Color.parseColor("#9e1807"));
            mButtonChoice2.setTextColor(Color.YELLOW);

        } else if (mButtonChoice3.isPressed() && !mButtonChoice3.getText().equals(mAnswer)) {
            mButtonChoice3.setBackgroundColor(Color.parseColor("#9e1807"));
            mButtonChoice3.setTextColor(Color.YELLOW);
        } else if (mButtonChoice4.isPressed() && !mButtonChoice4.getText().equals(mAnswer)) {
            mButtonChoice4.setBackgroundColor(Color.parseColor("#9e1807"));
            mButtonChoice4.setTextColor(Color.YELLOW);
        }
        if (mButtonChoice1.isPressed() || mButtonChoice2.isPressed() || mButtonChoice3.isPressed() || mButtonChoice4.isPressed()) {
            Mytimer.cancel();
            mButtonChoice1.setEnabled(false);
            mButtonChoice2.setEnabled(false);
            mButtonChoice3.setEnabled(false);
            mButtonChoice4.setEnabled(false);

        }

    }

    public void OnClickSandE() {
        Skip = (Button) findViewById(R.id.Skip);
        Exit = (Button) findViewById(R.id.Exit);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Skip.setText("Skip ( "+ ButtonClickCount+" )");
                if (ButtonClickCount < 20) {
                    updateQuestion();
                    ButtonClickCount++;
                } else {
                    Toast.makeText(NoUse.this, "You Used all this Skip", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}



   /* AlertDialog.Builder myBuilder = new AlertDialog.Builder(MyCusting.this, R.style.Theme_AppCompat_Light_Dialog);
                myBuilder.setTitle("Do You Want To Exit?!!")

                        .setMessage("Total Question : "+mQuestionLibrary.getLength() + "\n"+"Your Score : "+mScore+"\n"+"Your Answered : "+answerNumber )

               *//* myBuilder.setMessage("Total Question : "+mQuestionLibrary.getLength());
                myBuilder.setMessage("Your Score : "+mScore);
                myBuilder.setMessage("Your Answered : "+answerNumber)*//*
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialogInterface, int i) {

        finish();
        }
        })
        .setNegativeButton("No",
        new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        }
        });
        AlertDialog alert = myBuilder.create();
        alert.show();
        Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setTextColor(Color.parseColor("#FF028A94"));
        Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setTextColor(Color.parseColor("#FF028A94"));*/




       /*  if (c.getCount() == 0) {
                 Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
                 } else {
                 while (c.moveToNext()) {

                 String Q = c.getString(1);
                 String A = c.getString(6);
                 String B = c.getString(3);
                 String C = c.getString(4);
                 String D = c.getString(5);
                 String S = c.getString(7);

                 theList.add(Q);
                 theList.add(A);
                 ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, theList);
        listView.setAdapter(listAdapter);*/
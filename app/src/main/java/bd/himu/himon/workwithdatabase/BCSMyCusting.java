package bd.himu.himon.workwithdatabase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

public class BCSMyCusting extends AppCompatActivity {
    protected Qbank mQuestionLibrary = new Qbank();

    public TextView Section, Qtime;
    private TextView Score;   // view for current total score
    public TextView mQuestionView;  //current question to answer
    public Button mButtonChoice1, Skip, Exit; // multiple choice 1 for mQuestionView
    public Button mButtonChoice2; // multiple choice 2 for mQuestionView
    public Button mButtonChoice3; // multiple choice 3 for mQuestionView
    public Button mButtonChoice4; // multiple choice 4 for mQuestionView

    public String mAnswer;  // correct answer for question in mQuestionView
    private double mScore = 0;  // current total score
    private double wrongScore = 0.5;
    protected int mQuestionNumber = 0; // current question number

    public int ButtonClickCount;
    public int number = 1;
    public TextView timer;
    public CountDownTimer Mytimer, startTimer;
    public LinearLayout QLayout;
    public int answerNumber, CurrectAns, WrongAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionpattertwo);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // setup screen for the first question with four alternative to answer
        //  mScoreView = (TextView)findViewById(R.id.score);

        QLayout = (LinearLayout) findViewById(R.id.Pattern);
        Qtime = (TextView) findViewById(R.id.QTime);
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
        //Qnumber.setVisibility(View.GONE);

        // number = mygetQnumber;
        reverseTimers();
        onClicka();
        OnClickSandE();

    }


    public void updateScore() {
        Score.setText("Score : " + mScore + "/" + mQuestionLibrary.getLength());
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
            Qtime.setText(mQuestionLibrary.getSectionb(mQuestionNumber));
            updateScore();
            number++;
            mQuestionNumber++;
            buttonFunction();

        } else {
            Toast.makeText(BCSMyCusting.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            dialogset();
            Mytimer.cancel();

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
                isPressed();
                if (mButtonChoice1.getText().equals(mAnswer)) {
                    mScore++;
                    CurrectAns++;
                    updateScore();
                    reverseTimer();
                    colorw();
                } else {
                    mScore=mScore-wrongScore;
                    WrongAns++;
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
                isPressed();
                if (mButtonChoice2.getText().equals(mAnswer)) {
                    mScore++;
                    CurrectAns++;
                    updateScore();
                    reverseTimer();
                    colorw();
                } else {
                    colorw();
                    WrongAns++;
                    mScore=mScore-wrongScore;
                    updateScore();
                    reverseTimer();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                isPressed();
                if (mButtonChoice3.getText().equals(mAnswer)) {
                    mScore++;
                    CurrectAns++;
                    updateScore();
                    reverseTimer();
                    colorw();
                } else {
                    colorw();
                    WrongAns++;
                    mScore=mScore-wrongScore;
                    updateScore();
                    reverseTimer();
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                isPressed();
                if (mButtonChoice4.getText().equals(mAnswer)) {
                    mScore++;
                    CurrectAns++;
                    updateScore();
                    reverseTimer();
                } else {
                    colorw();
                    WrongAns++;
                    mScore=mScore-wrongScore;
                    updateScore();
                    reverseTimer();
                }
            }
        });


    }

    public void reverseTimer() {

        startTimer = new CountDownTimer(2000, 1000) {

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

        Mytimer = new CountDownTimer(5400000, 1000) {

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;

                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));


                timer.setText(String.format(hms));
                if (millis == 1) {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            timer.setText("( 00:00:00 )");
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

    }

    private void isPressed() {
        if (mButtonChoice1.isPressed() || mButtonChoice2.isPressed() || mButtonChoice3.isPressed() || mButtonChoice4.isPressed()) {
            answerNumber++;
            mButtonChoice1.setEnabled(false);
            mButtonChoice2.setEnabled(false);
            mButtonChoice3.setEnabled(false);
            mButtonChoice4.setEnabled(false);
            if (!mButtonChoice1.getText().equals(mAnswer)&&!mButtonChoice2.getText().equals(mAnswer)
                    && !mButtonChoice3.getText().equals(mAnswer)&& !mButtonChoice4.getText().equals(mAnswer)){
                Toast.makeText(BCSMyCusting.this, ""+mAnswer, Toast.LENGTH_SHORT).show();

            }

        }
    }

    public void OnClickSandE() {
        Skip = (Button) findViewById(R.id.Skip);
        Exit = (Button) findViewById(R.id.Exit);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    startTimer.cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (ButtonClickCount < mQuestionLibrary.getLength()) {
                    ButtonClickCount++;
                        updateQuestion();

                    } else {
                    Toast.makeText(BCSMyCusting.this, "You Used all this Skip", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogset();
            }
        });
    }

    public void onBackPressed() {
        dialogset();
    }

    private void dialogset() {
        final CustomDialog2 CD2 = new CustomDialog2(BCSMyCusting.this);
        CD2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        CD2.setCancelable(false);
        CD2.show();
        CD2.TotalQNo.setText("Total Question : " + mQuestionLibrary.getLength());
        CD2.CurrectAns.setText("Your Currect Answer : " + CurrectAns);
        CD2.WrongAns.setText("Your Wrong Answer : " + WrongAns);
        CD2.YouSkiped.setText("Your Skipped : " + ButtonClickCount);
        CD2.YouAnserd.setText("You Answered : " + answerNumber);
        CD2.YourScore.setText("Your Score : " + mScore);

        CD2.YES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        CD2.NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CD2.dismiss();
            }
        });
    }
}

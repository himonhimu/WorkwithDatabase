package bd.himu.himon.workwithdatabase.SubjectiveClass;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;

import bd.himu.himon.workwithdatabase.CustomDialog;
import bd.himu.himon.workwithdatabase.MyCusting;

/**
 * Created by Design on 4/5/2018.
 */

public class SujectiveAll extends MyCusting {

    public static int myInt =0;


    public static int getMyQint() {
        return MyQint;
    }

    public static void setMyQint(int myQint) {
        MyQint = myQint;
    }

    public static int MyQint;

    public static void setMyInt(int myInt) {
        SujectiveAll.myInt = myInt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mQuestionNumber = MyQint;


        if (myInt ==1){
            parseInt = 1;
            mQuestionLibrary.initQuestionsBySec(getApplicationContext());
            updateQuestion();
        }else if (myInt==2){
            parseInt = 1;
            mQuestionLibrary.initQuestionsBySecRandom(getApplicationContext());
            updateQuestion();
        }else if (myInt==3){
            parseInt =2;
            mQuestionLibrary.initQuestionsBySec(getApplicationContext());
            updateQuestion();
        }




    }

    }


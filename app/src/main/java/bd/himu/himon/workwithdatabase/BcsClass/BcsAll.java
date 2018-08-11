package bd.himu.himon.workwithdatabase.BcsClass;


import android.os.Bundle;

import bd.himu.himon.workwithdatabase.BCSMyCusting;
import bd.himu.himon.workwithdatabase.MyCusting;


/**
 * Created by Design on 4/5/2018.
 */

public class BcsAll extends BCSMyCusting {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQuestionLibrary.initQuestionsBySecB(getApplicationContext());
        updateQuestion();
    }
}
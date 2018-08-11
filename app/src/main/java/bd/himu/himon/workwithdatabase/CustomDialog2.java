package bd.himu.himon.workwithdatabase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Design on 4/30/2018.
 */

public class CustomDialog2 extends Dialog implements View.OnClickListener  {

    public Activity B;
    public Dialog d;
    public  TextView TotalQNo,CurrectAns, WrongAns, YouAnserd,YouSkiped,YourScore;
    public Button YES, NO;

    public CustomDialog2(Activity C) {
        super(C);
        this.B = C;
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.customdialog2);

        TotalQNo = (TextView)findViewById(R.id.TotalQN);
        CurrectAns = (TextView)findViewById(R.id.Cans);
        WrongAns = (TextView)findViewById(R.id.Wans);
        YouAnserd = (TextView)findViewById(R.id.YouAns);
        YouSkiped = (TextView)findViewById(R.id.YouSkip);
        YourScore = (TextView)findViewById(R.id.TotalScore);

        YES = (Button)findViewById(R.id.Yes);
        NO = (Button)findViewById(R.id.No);
    }


    @Override
    public void onClick(View view) {

    }
}

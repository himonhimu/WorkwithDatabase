package bd.himu.himon.workwithdatabase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Design on 4/29/2018.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {

    public Activity a;
    public Dialog d;
   public Button Regular, RandoM, Exit, Custom, Go;
   public LinearLayout layout;
   public EditText myEditText;



    public CustomDialog(Activity c) {
        super(c);
        this.a = c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.customdialog);



        myEditText = (EditText) findViewById(R.id.myNumText);
        layout = (LinearLayout)findViewById(R.id.CustomL);
        Regular = (Button)findViewById(R.id.Regular);
        RandoM  = (Button)findViewById(R.id.Random);
        Custom = (Button)findViewById(R.id.Custom);
        Exit = (Button)findViewById(R.id.Exit);
        Go = (Button)findViewById(R.id.Go);
    }

    @Override
    public void onClick(View view) {

    }
}

package bd.himu.himon.workwithdatabase.SubjectiveClass;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import bd.himu.himon.workwithdatabase.CustomDialog;
import bd.himu.himon.workwithdatabase.MyCusting;
import bd.himu.himon.workwithdatabase.Qbank;
import bd.himu.himon.workwithdatabase.R;

public class SubjectiveList extends AppCompatActivity {


    Button Bangla, English, BAffairs, IAffairs, Geography, GenaralScience, Computer, Math, MentalAbility, GGovernance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjective_list);
        Bangla = (Button) findViewById(R.id.Bangla);
        English = (Button) findViewById(R.id.English);
        BAffairs = (Button) findViewById(R.id.BAffairs);
        IAffairs = (Button) findViewById(R.id.IAffairs);
        Geography = (Button) findViewById(R.id.Geography);
        GenaralScience = (Button) findViewById(R.id.GS);
        Computer = (Button) findViewById(R.id.Computer);
        Math = (Button) findViewById(R.id.Math);
        MentalAbility = (Button) findViewById(R.id.MentalA);
        GGovernance = (Button) findViewById(R.id.Sushashon);

        Onclick();

    }

    public void Onclick() {
        Bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("বাংলা");
                DialogC();
            }
        });
        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("English");
                DialogC();
            }
        });
        BAffairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("বাংলাদেশ বিষয়াবলী");
                DialogC();
                // Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        IAffairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("আন্তর্জাতিক বিষয়াবলী");
                DialogC();
                // Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        Geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("ভূগোল");
                DialogC();
                // Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        GenaralScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("সাধারণ বিজ্ঞান");
                DialogC();
                // Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        Computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("কম্পিউটার ও তথ্যপ্রযুক্তি");
                DialogC();
                // Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        Math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("গণিত");
                DialogC();
                //Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        MentalAbility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("মানসিক দক্ষতা");
                DialogC();

                //Toast.makeText(SubjectiveList.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        GGovernance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qbank.setAllText("মূল্যবোধ এবং সুশাসন");
                DialogC();
            }
        });

    }

    private void DialogC() {
        final CustomDialog myDialog = new CustomDialog(SubjectiveList.this);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.setCancelable(true);
        myDialog.show();
        myDialog.Regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SujectiveAll.setMyInt(1);
                Intent himon = new Intent(SubjectiveList.this, SujectiveAll.class);
                startActivity(himon);
                myDialog.cancel();
            }
        });
        myDialog.Custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!myDialog.layout.isShown()){
                    myDialog.layout.setVisibility(View.VISIBLE);
                }else{
                    myDialog.layout.setVisibility(View.GONE);
                }

                myDialog.Go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (myDialog.myEditText.getText().toString().isEmpty()){
                            SujectiveAll.setMyQint(0);

                            SujectiveAll.setMyInt(3);

                            Intent himon = new Intent(SubjectiveList.this, SujectiveAll.class);
                            startActivity(himon);
                            myDialog.cancel();

                            //Toast.makeText(SubjectiveList.this, "OK ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            int MyNumber = Integer.parseInt(myDialog.myEditText.getText().toString());

                            SujectiveAll.setMyQint(MyNumber);

                            SujectiveAll.setMyInt(3);

                            Intent himon = new Intent(SubjectiveList.this, SujectiveAll.class);
                            startActivity(himon);
                            myDialog.cancel();
                        }



                    }
                });
                //Toast.makeText(SubjectiveList.this, "OK ", Toast.LENGTH_SHORT).show();

            }
        });

        myDialog.RandoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SujectiveAll.setMyInt(2);
                Intent himon = new Intent(SubjectiveList.this, SujectiveAll.class);
                startActivity(himon);
                myDialog.cancel();

            }
        });
    }


}

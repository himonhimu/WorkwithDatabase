package bd.himu.himon.workwithdatabase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import bd.himu.himon.workwithdatabase.BcsClass.BcsQuestionList;
import bd.himu.himon.workwithdatabase.SubjectiveClass.SubjectiveList;

public class MainFunction extends AppCompatActivity {

    GridLayout mainGrid;
    ArrayAdapter OkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_function);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mainGrid = (GridLayout)findViewById(R.id.mainGrid);

       CatagoryClick();

    }

    public void CatagoryClick(){


        for (int i=0; i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int Position = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Position == 0){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainFunction.this);
                        builder.setTitle("Select One To start");
                        builder.setItems(new CharSequence[]
                                        {"বিসিএস প্রশ্ন ও সমাধান", "বিষয় ভিত্তিক প্রশ্ন ও সমাধান", "বাতিল"},
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // The 'which' argument contains the index position
                                        // of the selected item
                                        switch (which) {
                                            case 0:
                                                Intent himon =  new Intent(MainFunction.this, BcsQuestionList.class);
                                                startActivity(himon);
                                                //Toast.makeText(MainFunction.this, "clicked 1", Toast.LENGTH_SHORT).show();
                                                break;
                                            case 1:
                                                himon =  new Intent(MainFunction.this, SubjectiveList.class);
                                                startActivity(himon);
                                               // Toast.makeText(MainFunction.this, "clicked 2", Toast.LENGTH_SHORT).show();
                                                break;
                                            case 2:
                                                Toast.makeText(MainFunction.this, "Come Back Soon", Toast.LENGTH_LONG).show();
                                                break;
                                        }
                                    }
                                });
                        builder.create().show();

                    }
                    //about us function goes here
                    else if (Position ==1){


                        Toast.makeText(MainFunction.this, "You Select "+Position, Toast.LENGTH_SHORT).show();

                    }
                    //Share function goes here
                    else if (Position ==2){
                        Toast.makeText(MainFunction.this, "You Select "+Position, Toast.LENGTH_SHORT).show();

                    }
                    //Rate Us function goes here
                    else if (Position ==3){
                        Toast.makeText(MainFunction.this, "You Select "+Position, Toast.LENGTH_SHORT).show();

                    }
                }
            });

            }
        }
    }


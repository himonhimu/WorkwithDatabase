package bd.himu.himon.workwithdatabase.BcsClass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import bd.himu.himon.workwithdatabase.Qbank;
import bd.himu.himon.workwithdatabase.R;

public class BcsQuestionList extends AppCompatActivity {
    GridLayout myGrid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcs_question_list);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        myGrid = (GridLayout)findViewById(R.id.BCSList);

        BCS_click();
    }
    public void BCS_click(){
        //declare int Variable as H

        for (int H = 0; H<myGrid.getChildCount(); H++) {
            CardView myCard = (CardView) myGrid.getChildAt(H);
            final int Position = H;
            myCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Position ==0){
                        Qbank.setAllText("38th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();
                    }
                    else if (Position == 1){
                        Qbank.setAllText("37th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 2){
                        Qbank.setAllText("36th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 3){
                        Qbank.setAllText("35th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                      //  Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 4){
                        Qbank.setAllText("34th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 5){
                        Qbank.setAllText("33th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 6){
                        Qbank.setAllText("32th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 7){
                        Qbank.setAllText("31th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 8){
                        Qbank.setAllText("30th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 9){
                        Qbank.setAllText("29th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 10){
                        Qbank.setAllText("28th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 11){
                        Qbank.setAllText("27th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 12){
                        Qbank.setAllText("26th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 13){
                        Qbank.setAllText("25th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 14){
                        Qbank.setAllText("24th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 15){
                        Qbank.setAllText("24th BCS (Canceled)");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 16){
                        Qbank.setAllText("23th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                      //  Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 17){
                        Qbank.setAllText("22th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 18){
                        Qbank.setAllText("21th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 19){
                        Qbank.setAllText("20th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 20){
                        Qbank.setAllText("19th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 21){
                        Qbank.setAllText("18th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 22){
                        Qbank.setAllText("17th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 23){
                        Qbank.setAllText("16th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 24){
                        Qbank.setAllText("15th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 25){
                        Qbank.setAllText("14th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 26){
                        Qbank.setAllText("13th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                       // Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 27){
                        Qbank.setAllText("12th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 28){
                        Qbank.setAllText("11th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }
                    else if (Position == 29){
                        Qbank.setAllText("10th BCS");
                        Intent himon = new Intent(BcsQuestionList.this, BcsAll.class);
                        startActivity(himon);
                        //Toast.makeText(BcsQuestionList.this,"You Clicked" + Position, Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }
    }
}

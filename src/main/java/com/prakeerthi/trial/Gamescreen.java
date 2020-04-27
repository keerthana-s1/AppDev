package com.prakeerthi.trial;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Gamescreen extends AppCompatActivity {
    private EditText edit;
    private TextView tex;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView result;
    public int fact;
    private TextView scor;
    private TextView high;
    final int[] score = {0};
    int K1;
    int H1;
    public RelativeLayout bck;
    Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        edit =(EditText) findViewById(R.id.editText);
        result=(TextView) findViewById(R.id.textView3) ;
        scor=(TextView) findViewById(R.id.textView5);
        high=(TextView) findViewById(R.id.textView6);
        bck=(RelativeLayout) findViewById(R.id.actgame);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_APPEND);
        final int h = sharedPreferences.getInt("score", 0);
        score[0]=sharedPreferences.getInt("cscore", 0);
        high.setText(String.valueOf(h));
        scor.setText(String.valueOf(score[0]));
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k;
                int[] numb={0,0,0};
                button.setText("Play");
                result.setText("");

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_APPEND);
                final int h = sharedPreferences.getInt("score", 0);
                high.setText(String.valueOf(h));
                bck.setBackgroundColor(Color.parseColor("#ffffff"));

                if (edit.getText().toString().length() == 0) {
                    Toast toast=Toast. makeText(getApplicationContext(),"Enter a number first",Toast. LENGTH_SHORT);
                    toast.show();
                    k=0;

                }
                else if(Integer.parseInt(edit.getText().toString()) <15)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Enter a number greater than 15",Toast.LENGTH_SHORT);
                    toast.show();
                    edit.setText("");
                }

                else {
                    k = Integer.parseInt(edit.getText().toString());
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                    int n, flag = 0, c = 0;
                    n = (int) Math.floor((Math.random() * k)+1);
                    numb[0]=n;
                    if (k % n == 0) {
                        flag++;
                        fact = n;
                    }


                    while (flag == 1) {
                        n = (int) Math.floor((Math.random() * k)+1);
                        if (k % n != 0) {
                            numb[1]=n;
                            break;
                        }

                    }
                    if (flag == 0) {
                        n = (int) Math.floor((Math.random() * k)+1);
                        numb[1]=n;
                        if (k % n == 0) {
                            flag = 1;
                            fact = n;
                        }
                    }
                    while (flag == 0) {
                        n = (int) Math.floor((Math.random() * k)+1);
                        if (k % n == 0) {
                            numb[2]=n;
                            fact = n;
                            break;
                        }
                    }
                    if (flag == 1) {
                        n = (int) Math.floor((Math.random() * k)+1);
                        if (k % n != 0) {
                            numb[2]=n;
                        }
                    }
                    int check=1,ran;
                    while(check==1)
                    {
                        ran=(int) Math.floor(Math.random()*3);
                        if(numb[ran]!=0)
                        {
                            button2.setText(String.valueOf(numb[ran]));
                            numb[ran]=0;
                            check=0;
                        }
                    }
                    check=1;
                    while(check==1)
                    {
                        ran=(int) Math.floor(Math.random()*3);
                        if(numb[ran]!=0)
                        {
                            button3.setText(String.valueOf(numb[ran]));
                            numb[ran]=0;
                            check=0;
                        }
                    }
                    check=1;
                    while(check==1)
                    {
                        ran=(int) Math.floor(Math.random()*3);
                        if(numb[ran]!=0)
                        {
                            button4.setText(String.valueOf(numb[ran]));
                            numb[ran]=0;
                            check=0;
                        }
                    }

                    K1 = k;
                    H1=h;
                }



            }
                });
              button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = "Wrong Answer. Correct answer is ";
                String b = String.valueOf(fact);
                String co;


                int m = Integer.parseInt(button2.getText().toString());
                if (K1 % m == 0) {
                    result.setText("CORRECT!!");
                    bck.setBackgroundColor(Color.parseColor("#81bd4f"));
                    score[0]++;
                    savesc(score[0]);
                    scor.setText(String.valueOf(score[0]));
                    button.setText("Next round");
                } else {
                    result.setText(a + b);
                    bck.setBackgroundColor(Color.parseColor("#bd604f"));
                    button.setText("New Game");

                        savedata(score[0]);


                }

                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                edit.setText("");
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setText("Play Again");
                String a = "Wrong Answer. Correct answer is ";
                String b = String.valueOf(fact);
                String co;

                int m = Integer.parseInt(button3.getText().toString());
                if (K1 % m == 0) {
                    result.setText("CORRECT!!");
                    bck.setBackgroundColor(Color.parseColor("#81bd4f"));
                    score[0]++;
                    savesc(score[0]);
                    scor.setText(String.valueOf(score[0]));
                    button.setText("Next round");
                } else {
                    result.setText(a + b);
                    bck.setBackgroundColor(Color.parseColor("#bd604f"));
                    button.setText("New Game");

                        savedata(score[0]);
                }
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                edit.setText("");
            }
        });



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setText("Play Again");
                String a = "Wrong Answer. Correct answer is ";
                String b = String.valueOf(fact);
                String co;

                int m = Integer.parseInt(button4.getText().toString());
                if (K1 % m == 0) {
                    result.setText("CORRECT!!");
                    bck.setBackgroundColor(Color.parseColor("#81bd4f"));
                    score[0]++;
                    savesc(score[0]);
                    scor.setText(String.valueOf(score[0]));
                    button.setText("Next round");
                } else {
                    result.setText(a + b);
                    bck.setBackgroundColor(Color.parseColor("#bd604f"));
                    button.setText("New Game");

                        savedata(score[0]);
                }
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                edit.setText("");
            }
        });





    }
    public void savesc (int a)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("cscore",a);

        if (a > H1)
        {high.setText(String.valueOf(a));
            myEdit.putInt("score",a);}
        myEdit.commit();


    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void savedata(int a)
    {   SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        if (score[0] > H1)
        myEdit.putInt("score",a);
        score[0]=0;
        myEdit.putInt("cscore",0);
        vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vib.vibrate(VibrationEffect.createOneShot(250,VibrationEffect.DEFAULT_AMPLITUDE));
        scor.setText(String.valueOf(0));
        high.setText(String.valueOf(a));
        myEdit.commit();

    }
}

package com.example.vcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Quiz2 extends AppCompatActivity {

    FirebaseFirestore fStore;
    public boolean completed;
    TextView textView,textView1;
    Button buton1,buton2;
    RadioButton radioButton;
    RadioGroup radioGroup;

    RadioButton rb1,rb2,rb3,rb4;
    String questions[]={
            "1) What is the 16-bit compiler allowable range for integer constants?",
            "2) Study the following program:\n" +
                    "main()  \n" +
                    "{printf(\"javatpoint\");  \n" +
                    "main();}  \n" +
                    "What will be the output of this program?",
            "3) What is required in each C program?",
            "4) What is a lint?",
            "5) What is the output of this statement \"printf(\"%d\", (a++))\"?",
            "6) Study the following program:\n" +
                    "main()  " +
                    "{  \n" +
                    "  int a = 1, b = 2, c = 3:  \n" +
                    "  printf(\"%d\", a + = (a + = 3, 5, a))  \n" +
                    "}  \n" +
                    "What will be the output of this program?",
            "7) What does this declaration mean?\n" +
                    "\n" +
                    "int x : 4; ",
            "8) Why is a macro used in place of a function?",
            "9) In the C language, the constant is defined _______.",
            "13) How many times will the following loop execute?\n" +
                    "\n" +
                    "for(j = 1; j <= 10; j = j-1)  "
    };
    String answers[]={
            "d)-32768 to 32767","b)It will keep on printing javatpoint","a)The program must have at least one function.","c)Analyzing tool","b)The current value of a",
            "d)8","c)X is a four-bit integer.","d)It increases code size.","c)Anywhere, but starting on a new line.","a)Forever"
    };
    String options[]={
            "a)-3.4e38 to 3.4e38\n",
            "b)-32767 to 32768",
            "c)-32668 to 32667",
            "d)-32768 to 32767",
            "a)Wrong statement",
            "b)It will keep on printing javatpoint",
            "c)It will Print javatpoint once",
            "d)None of the these",
            "a)The program must have at least one function.",
            "b)The program does not require any function.",
            "c)Input data",
            "d)Output data",
            "a)C compiler",
            "b)Interactive debugger",
            "c)Analyzing tool",
            "d)C interpreter",
            "a)The value of (a + 1)",
            "b)The current value of a",
            "c)Error message",
            "d)Garbage",
            "a)6",
            "b)9",
            "c)12",
            "d)8",
            "a)X is a four-digit integer.",
            "b)X cannot be greater than a four-digit integer.",
            "c)X is a four-bit integer.",
            "d)None of the these",
            "a)It reduces execution time.",
            "b)It reduces code size.",
            "c)It increases execution time.",
            "d)It increases code size.",
            "a)Before main",
            "b)After main",
            "c)Anywhere, but starting on a new line.",
            "d)None of the these.",
            "a)Forever",
            "b)Never",
            "c)0",
            "d)1",
    };

    int count=0;
    int correct=0;
    int wrong=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        fStore=FirebaseFirestore.getInstance();
        textView=findViewById(R.id.text1);
        textView1=findViewById(R.id.text3);
        buton1=findViewById(R.id.butn1);
        buton2=findViewById(R.id.butn2);
        radioGroup=findViewById(R.id.rdGroup);
        rb1=findViewById(R.id.rd1);
        rb2=findViewById(R.id.rd2);
        rb3=findViewById(R.id.rd3);
        rb4=findViewById(R.id.rd4);
        textView1.setText(questions[count]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);
        buton1.setOnClickListener((new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(radioGroup.getCheckedRadioButtonId()==-1){
                            Toast.makeText(Quiz2.this, "please select a radio button", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int radioId=radioGroup.getCheckedRadioButtonId();
                        radioButton=findViewById(radioId);
                        String ans=radioButton.getText().toString();
                        if(ans==answers[count])
                        {
                            correct++;
                            Toast.makeText(Quiz2.this, "correct answer", Toast.LENGTH_SHORT).show();

                        }else{
                            wrong++;
                            Toast.makeText(Quiz2.this, "wrong answer", Toast.LENGTH_SHORT).show();
                        }
                        count++;
                        if(count<questions.length){
                            textView1.setText(questions[count]);
                            rb1.setText(options[count*4]);
                            rb2.setText(options[count*4+1]);
                            rb3.setText(options[count*4+2]);
                            rb4.setText(options[count*4+3]);
                        }else{
                            DocumentReference documentReference=fStore.collection("score").document("Quiz1");
                            Map<String,Object> user=new HashMap<>();
                            user.put("correct",correct);
                            user.put("wrong",wrong);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            });
                            Toast.makeText(Quiz2.this, "correct answer : "+correct+"\nwrong answer"+wrong, Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        radioGroup.clearCheck();
                    }

                })
        );
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Editor.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
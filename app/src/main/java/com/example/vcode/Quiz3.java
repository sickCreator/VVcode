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

public class Quiz3 extends AppCompatActivity {
    FirebaseFirestore fStore;
    public boolean completed;
    TextView textView, textView1;
    Button buton1, buton2;
    RadioButton radioButton;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;
    String questions[] = {
            "1. How many keywords are there in c ?",
            "2. Which of the following is true for variable names in C?",
            "3. Which of the following cannot be a variable name in C?",
            "4. What is the output of this program?              " +
                    "void main()" +
                    "{\n" +
                    "int x = 10;\n" +
                    "float x = 10;\n" +
                    "printf(\"%d\", x)\n" +
                    "}",
            "5. What is the output of this program?\n" +
                    "    #include <stdio.h>\n" +
                    "    int main()" +
                    "    {\n" +
                    "        int i;\n" +
                    "        for (i = 0;i < 5; i++)\n" +
                    "        int a = i;\n" +
                    "        printf(\"%d\", a);\n" +
                    "    }",
            "6. What is the output of this program?\n" +
                    "\n" +
                    "void main()\n" +
                    "{\n" +
                    "   printf(\"%x\",-1<<4);\n" +
                    "}",
            "7. What is the output of this program?\n" +
                    "#include <stdio.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "   int a=1, b=2, c=3, d;\n" +
                    "   d = (a=c, b+=a, c=a+b+c);\n" +
                    "   printf(\"%d %d %d %d\", d, a, b, c);\n" +
                    "}",
            "8. What is the output of this program?\n" +

                    "void main()" +
                    "{\n" +
                    "   int a, b = 5, c;\n" +
                    "   a = 5 * (b++);\n" +
                    "   c = 5 * (++b);\n" +
                    "   printf(\"%d %d\",a,c);\n" +
                    "}",
            "9. Which is not a valid C variable name?",
            "10.Which of the following is true for variable names in C?"
    };
    String answers[] = {
            "b)32", "a)Variable names cannot start with a digit", "d)volatile", "a)compilation error", "a)Syntax error in declaration of a",
            "a)fff0", "a)11 3 5 11", "d)25 35", "c) Variable names can’t start with a digit", "d)int $main"
    };
    String options[] = {
            "a)31", "b)32", "c)64", "d)63",
            "a)Variable names cannot start with a digit",
            "b)Variable can be of any length",
            "c)They can contain alphanumeric characters as well as special characters",
            "d)Reserved Word can be used as variable name",
            "a)true", "b)friend", "c)export", "d)volatile",
            "a)compilation error", "b)10", "c)10", "d)10.1",
            "a)Syntax error in declaration of a",
            "b)No errors, program will show the output 5",
            "c)Redeclaration of a in same scope throws error",
            "d)a is out of scope when printf is called",
            "a)ff0", "b)fff1", "c)fff2", "d)fff3",
            "a)11 3 5 11", "b)11 1 5 11", "c)11 3 2 11", "d)11 3 3 11",
            "a)30 35", "b)30 30", "c)25 30", "d)25 35",
            "a)int number;", "b)float rate;", "c)int variable_count;", "d)int $main",
            "a) They can contain alphanumeric characters as well as special characters",
            "b) It is not an error to declare a variable to be one of the keywords(like goto, static)",
            "c) Variable names can’t start with a digit",
            "d) Variable can be of any length",
    };

    int count = 0;
    int correct = 0;
    int wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        fStore=FirebaseFirestore.getInstance();
        textView = findViewById(R.id.text1);
        textView1 = findViewById(R.id.text3);
        buton1 = findViewById(R.id.butn1);
        buton2 = findViewById(R.id.butn2);
        radioGroup = findViewById(R.id.rdGroup);
        rb1 = findViewById(R.id.rd1);
        rb2 = findViewById(R.id.rd2);
        rb3 = findViewById(R.id.rd3);
        rb4 = findViewById(R.id.rd4);
        textView1.setText(questions[count]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);
        buton1.setOnClickListener((new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (radioGroup.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(Quiz3.this, "please select a radio button", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int radioId = radioGroup.getCheckedRadioButtonId();
                        radioButton = findViewById(radioId);
                        String ans = radioButton.getText().toString();
                        if (ans == answers[count]) {
                            correct++;
                            Toast.makeText(Quiz3.this, "correct answer", Toast.LENGTH_SHORT).show();

                        } else {
                            wrong++;
                            Toast.makeText(Quiz3.this, "wrong answer", Toast.LENGTH_SHORT).show();
                        }
                        count++;
                        if (count < questions.length) {
                            textView1.setText(questions[count]);
                            rb1.setText(options[count * 4]);
                            rb2.setText(options[count * 4 + 1]);
                            rb3.setText(options[count * 4 + 2]);
                            rb4.setText(options[count * 4 + 3]);
                        } else {
                            DocumentReference documentReference=fStore.collection("score").document("Quiz2");
                            Map<String,Object> user=new HashMap<>();
                            user.put("correct",correct);
                            user.put("wrong",wrong);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            });
                            Toast.makeText(Quiz3.this, "correct answer : " + correct + "\nwrong answer" + wrong, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
                Intent intent = new Intent(getApplicationContext(),Editor.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
package com.example.android.mathsquiz1stgrade;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Restart app.
     */
    public void restart(View view) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    /**
     * Check quiz.
     */
    public void submit(View view) {
        // Number Question
        int numberQuestion = 7;
        // Number Correct Answers
        int correctAnswers = 0;
        // Get Name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        if (name.equals("")) {
            name = getString(R.string.unknown);
        }
        // Question 01
        TextView q01_lable = (TextView)findViewById(R.id.q01_lable);
        EditText q04_field = (EditText) findViewById(R.id.q01);
        String q04 = q04_field.getText().toString();
        if (q04.equals("9")) {
            correctAnswers++;
            q01_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q01_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Question 02
        TextView q02_lable = (TextView)findViewById(R.id.q02_lable);
        RadioGroup rg_q02 = (RadioGroup) findViewById(R.id.rg_q02);
        RadioButton q02_2 = (RadioButton) findViewById(R.id.q02_2);
        int q02_selectedId = rg_q02.getCheckedRadioButtonId();
        if (q02_selectedId == q02_2.getId()) {
            correctAnswers++;
            q02_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q02_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Question 03
        TextView q03_lable = (TextView)findViewById(R.id.q03_lable);
        CheckBox q03_1_Checkbox = (CheckBox) findViewById(R.id.q03_1);
        boolean q03_1 = q03_1_Checkbox.isChecked();
        CheckBox q03_2_Checkbox = (CheckBox) findViewById(R.id.q03_2);
        boolean q03_2 = q03_2_Checkbox.isChecked();
        CheckBox q03_3_Checkbox = (CheckBox) findViewById(R.id.q03_3);
        boolean q03_3 = q03_3_Checkbox.isChecked();
        CheckBox q03_4_Checkbox = (CheckBox) findViewById(R.id.q03_4);
        boolean q03_4 = q03_4_Checkbox.isChecked();
        if (!q03_1 && q03_2 && q03_3 && !q03_4) {
            correctAnswers++;
            q03_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q03_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Question 04
        TextView q04_lable = (TextView)findViewById(R.id.q04_lable);
        RadioGroup rg_q04 = (RadioGroup) findViewById(R.id.rg_q04);
        RadioButton q04_3 = (RadioButton) findViewById(R.id.q04_3);
        int q04_selectedId = rg_q04.getCheckedRadioButtonId();
        if (q04_selectedId == q04_3.getId()) {
            correctAnswers++;
            q04_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q04_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Question 05
        TextView q05_lable = (TextView)findViewById(R.id.q05_lable);
        RadioGroup rg_q05 = (RadioGroup) findViewById(R.id.rg_q05);
        RadioButton q05_3 = (RadioButton) findViewById(R.id.q05_3);
        int q05_selectedId = rg_q05.getCheckedRadioButtonId();
        if (q05_selectedId == q05_3.getId()) {
            correctAnswers++;
            q05_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q05_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Question 06
        TextView q06_lable = (TextView)findViewById(R.id.q06_lable);
        RadioGroup rg_q06 = (RadioGroup) findViewById(R.id.rg_q06);
        RadioButton q06_1 = (RadioButton) findViewById(R.id.q06_1);
        int q06_selectedId = rg_q06.getCheckedRadioButtonId();
        if (q06_selectedId == q06_1.getId()) {
            correctAnswers++;
            q06_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q06_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Question 07
        TextView q07_lable = (TextView)findViewById(R.id.q07_lable);
        CheckBox q07_1_Checkbox = (CheckBox) findViewById(R.id.q07_1);
        boolean q07_1 = q07_1_Checkbox.isChecked();
        CheckBox q07_2_Checkbox = (CheckBox) findViewById(R.id.q07_2);
        boolean q07_2 = q07_2_Checkbox.isChecked();
        CheckBox q07_3_Checkbox = (CheckBox) findViewById(R.id.q07_3);
        boolean q07_3 = q07_3_Checkbox.isChecked();
        CheckBox q07_4_Checkbox = (CheckBox) findViewById(R.id.q07_4);
        boolean q07_4 = q07_4_Checkbox.isChecked();
        if (q07_1 && !q07_2 && q07_3 && !q07_4) {
            correctAnswers++;
            q07_lable.setBackgroundResource(R.color.greenTransparent);
        } else {
            q07_lable.setBackgroundResource(R.color.redTransparent);
        }
        // Create Result Message
        String complete_message = "";
        complete_message += getString(R.string.hi, name);
        complete_message += "\n" + getString(R.string.score) + "\n \n";
        if (correctAnswers == numberQuestion) {
            complete_message += getString(R.string.perfect);
        }
        complete_message += correctAnswers + " / " + numberQuestion;
        complete_message += "\n \n" + getString(R.string.thanks);
        // Go top
        ScrollView quiz_scroll = (ScrollView)findViewById(R.id.quiz_scroll);
        quiz_scroll.fullScroll(ScrollView.FOCUS_UP);
        // Hidde Submit Buttom
        Button submit_btn = (Button) findViewById(R.id.submit_btn);
        submit_btn.setVisibility(View.GONE);
        // Display Try Again Buttom
        Button try_again = (Button) findViewById(R.id.try_again);
        try_again.setVisibility(View.VISIBLE);
        // Display Custom Toast with resolts
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_result_message, (ViewGroup) findViewById(R.id.toast_result_message));
        TextView message_box = (TextView) layout.findViewById(R.id.message_box);
        message_box.setText(complete_message);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}

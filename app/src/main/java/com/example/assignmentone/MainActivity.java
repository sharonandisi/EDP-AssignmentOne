package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();
                editText.removeTextChangedListener(this);
                if(text.length() > 0 && text.charAt(text.length() -1) == ' ') {
                    String newText = text.substring(0, text.length()-1) + '-';
                    editText.setText(newText);
                }
                if(text.length() > 0 && text.charAt(text.length() -1) == '-') {
                    String newText = text.substring(0, text.length()-1) + '*';
                    editText.setText(newText);
                }
                editText.setSelection(text.length());
                editText.addTextChangedListener(this);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                String med = text.replaceAll("-", " ");
                text = "";
                for(int i = 0; i < med.length(); i++) {
                    if(med.charAt(i) == '-') {
                        text+=" ";
                    } else if (med.charAt(i) == '*'){
                        text+="-";
                    } else {
                        text+=med.charAt(i);
                    }
                }

                textView.setText(text);
            }
        });
    }

}


package com.t127.lab_6_lists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    private int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String note = i.getStringExtra("note");

        pos= i.getIntExtra("position",-1);

        EditText etitle = findViewById(R.id.editTitle);
        EditText eNote = findViewById(R.id.editNote);
        etitle.setText(title);
        eNote.setText(note);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                EditText etitle = findViewById(R.id.editTitle);
                EditText eNote = findViewById(R.id.editNote);

                String title  = etitle.getText().toString();
                String note = eNote.getText().toString();

                i.putExtra("title",title);
                i.putExtra("note",note);
                i.putExtra("position",pos);

                setResult(RESULT_OK);
                finish();

            }
        });

    }
}

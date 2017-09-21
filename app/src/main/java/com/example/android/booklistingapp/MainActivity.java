package com.example.android.booklistingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_WORD = "com.example.android.booklistingapp.KEY_WORD";
    public static final String EXTRA_BOOLEAN = "false";

    public static String qSearchWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout resultView = (RelativeLayout) findViewById(R.id.result_view);
        resultView.setVisibility(View.GONE);

        final EditText searchWord = (EditText) findViewById(R.id.search_edit_text);

        Button searchButton = (Button) findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qSearchWord = searchWord.getText().toString();
                if (qSearchWord.isEmpty()) {
                    Toast.makeText(getApplicationContext(),R.string.missing_search_word,Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                    intent.putExtra(EXTRA_KEY_WORD, qSearchWord);
                    intent.putExtra(EXTRA_BOOLEAN, "true");
                    startActivity(intent);
                }
            }
        });


    }
}

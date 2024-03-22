package com.example.adjective_cheker_app;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adjective_cheker_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.checkBtn.setOnClickListener(v -> {

            if (!binding.wordEd.getText().toString().isEmpty()){

                checkWord(binding.wordEd.getText().toString());
            }
        });
        binding.wordEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().contains(" ")) {
                    binding.checkBtn.setEnabled(false);
                    binding.wordEd.setError("Error: Please enter only one word without spaces.");
                }else {
                    binding.checkBtn.setEnabled(true);
                }

            }
        });
    }
    private void checkWord(String word){
        String message;
        if (word.endsWith("ish") || word.endsWith("ful") ||
                word.endsWith("less") || word.endsWith("en") ||
                word.endsWith("some") || word.endsWith("ous") ||
                word.endsWith("fold") || word.endsWith("al") ||
                word.endsWith("ic") || word.endsWith("lye") ||
                word.endsWith("able") || word.endsWith("ble")){
            message = String.format("The Word %s is an Adjective!", word);
        }
        else {
            message = String.format("The Word %s is not an Adjective!", word);
        }
        binding.showResult.setText(message);
    }
}
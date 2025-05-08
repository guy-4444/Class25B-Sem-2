package com.guyi.class25b_sem_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.guyi.class25b_sem_2.databinding.ActivityMainBinding;
import com.guyi.validatorclass.Validator;
import com.guyi.validatorclass.Watcher;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("My Validator");

        Validator valMail = Validator.Builder
                .with(binding.edtEmail)
                .addWatcher(new Watcher.NotBlank("Field cannot be empty"))
                .addWatcher(new Watcher.Email("Must be a valid email"))        // you already have this
                .addWatcher(new Watcher.Phone("Must be a valid phone number")) // new!
                .addWatcher(new Watcher.ExactLength("Must be exactly 10 digits", 10))
                .addWatcher(new Watcher.LengthRange("Length must be 5–20 chars", 5, 20))
                .build();

    }


}
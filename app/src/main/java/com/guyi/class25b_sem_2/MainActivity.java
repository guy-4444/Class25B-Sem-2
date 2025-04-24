package com.guyi.class25b_sem_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.guyi.class25b_sem_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("My Validator");


//        ValidatorOld valMail = new ValidatorOld(binding.edtEmail,
//                new Watcher.Email("invalid email"),
//                new Watcher.MaxLength("too long", 20));


        Validator valMail = Validator.Builder.make(binding.edtEmail)
                .addWatcher(new Validator.Watcher_Email("invalid email"))
                .addWatcher(new Validator.Watcher_MaximumOfLetter("too many '-' letters", '-',2))
                .build();

        Validator valPhone = Validator.Builder.make(binding.edtPhone)
                .addWatcher(new Validator.Watcher_LessThan("too big", 100))
                .build();


    }


}
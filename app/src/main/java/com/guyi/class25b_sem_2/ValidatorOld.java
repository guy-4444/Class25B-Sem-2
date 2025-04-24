package com.guyi.class25b_sem_2;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

public class ValidatorOld {

    private Watcher[] watchers;
    private TextInputLayout edt;
    private boolean isAllOk = false;

    public ValidatorOld(TextInputLayout edt, Watcher... watchers) {
        this.edt = edt;
        this.watchers = watchers;

        edt.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validate(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public boolean isAllOk() {
        return isAllOk;
    }

    private void validate(String s) {
        isAllOk = false;
        for (Watcher watcher : watchers) {
            boolean isOk = watcher.valid(s);
            if (!isOk) {
                String errorMessage = watcher.error != null ? watcher.error : "invalid input";
                edt.setError(errorMessage);
                return;
            }
        }

        edt.setError(null);
        isAllOk = true;
    }


}

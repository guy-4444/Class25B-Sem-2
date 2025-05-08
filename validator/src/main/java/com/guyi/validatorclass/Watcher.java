package com.guyi.validatorclass;

import android.util.Patterns;

public abstract class Watcher {

    public String error = null;

    public Watcher(String error) {
        this.error = error;
    }

    public abstract boolean valid(String input);

    public static class Email extends Watcher {
        public Email(String error) {
            super(error);
        }

        @Override
        public boolean valid(String input) {
            return Patterns.EMAIL_ADDRESS.matcher(input).matches();
        }
    }

    public static class Phone extends Watcher {
        public Phone(String error) {
            super(error);
        }

        @Override
        public boolean valid(String input) {
            return Patterns.EMAIL_ADDRESS.matcher(input).matches();
        }
    }

    public static class MaxLength extends Watcher {

        private int length;

        public MaxLength(String error, int length) {
            super(error);
            this.length = length;
        }

        @Override
        public boolean valid(String input) {
            return input.length() <= length;
        }
    }

    public static class MinLength extends Watcher {

        private int length;

        public MinLength(String error, int length) {
            super(error);
            this.length = length;
        }

        @Override
        public boolean valid(String input) {
            return input.length() >= length;
        }
    }

    // not empty - length > 0
    public static class NotEmpty extends Watcher {

        public NotEmpty(String error) {
            super(error);
        }

        @Override
        public boolean valid(String input) {
            return !input.isEmpty();
        }
    }

    // not blank - no whitespaces
    public static class NotBlank extends Watcher {

        public NotBlank(String error) {
            super(error);
        }

        @Override
        public boolean valid(String input) {
            return !input.isBlank();
        }
    }

}



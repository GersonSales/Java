package com.cursoandroid.firebaseapp.exercicioaula09;

/**
 * Created by gersonsales at Embedded Enterprise on 06/01/18.
 */

public enum ActivityCode {
    SUB_ACTIVITY_REQUEST_CODE;

    public int getCode() {
        switch (this) {
            case SUB_ACTIVITY_REQUEST_CODE:
                return 100;
            default:return 0;
        }

    }
}

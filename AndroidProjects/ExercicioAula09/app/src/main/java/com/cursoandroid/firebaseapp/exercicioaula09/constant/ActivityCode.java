package com.cursoandroid.firebaseapp.exercicioaula09.constant;

/**
 * Created by gersonsales at Embedded Enterprise on 06/01/18.
 */

public enum ActivityCode {
    SUB_ACTIVITY_REQUEST_CODE(0),
    CANCELED_CODE(1);

     public  int  code;


    ActivityCode(final int activityCode) {
        code = activityCode;
    }

}

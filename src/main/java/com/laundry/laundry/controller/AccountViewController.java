package com.laundry.laundry.controller;

import com.laundry.laundry.helper.session.sessionClass.EmployeeSession;

public class AccountViewController implements Runnable {

    @Override
    public void run() {
        if(!EmployeeSession.isSession()){
            //todo send back to the login view for proper processing
        }
    }
}

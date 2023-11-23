package com.laundry.laundry.controller;

import com.laundry.laundry.helper.session.sessionClass.EmployeeSession;

public class AccountViewController implements Runnable {
    EmployeeSession employeeSession = EmployeeSession.getInstace();
    @Override
    public void run() {
        if(!EmployeeSession.isSession()){
            //empty the session
            employeeSession.cleanUserSession();
            //todo send back to the login view for proper processing
        }
    }
}

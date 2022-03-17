package com.nttdata.som.demo.ifaces;

import com.uber.cadence.workflow.QueryMethod;
import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.WorkflowMethod;

public interface WorkflowDemo {

    @WorkflowMethod
    public void execute (String url);

    @QueryMethod
    public String getStatus();

    @SignalMethod
    public void updateFile(String param);

}

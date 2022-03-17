package com.nttdata.som.demo.service.impl;

import com.nttdata.som.demo.ifaces.ActivityManageFile;
import com.nttdata.som.demo.ifaces.WorkflowDemo;
import com.uber.cadence.activity.ActivityOptions;
import com.uber.cadence.workflow.Workflow;

import java.time.Duration;

public class WorkflowDemoImpl implements WorkflowDemo {

    @Override
    public void execute(String url) {

        ActivityOptions options = new ActivityOptions.Builder()
                .setScheduleToCloseTimeout(Duration.ofHours(10000))
                .build();

        ActivityManageFile activities = Workflow.newActivityStub(ActivityManageFile.class, options);
        String content = activities.readJson(url);
        activities.saveFile(content);
    }

    @Override
    public String getStatus() {
        System.out.println("llegó a get Status");
        return null;
    }

    @Override
    public void updateFile(String param) {
        System.out.println("llegó a get updateFile");
    }
}

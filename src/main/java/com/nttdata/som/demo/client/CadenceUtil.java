package com.nttdata.som.demo.client;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowOptions;
import com.uber.cadence.client.WorkflowStub;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CadenceUtil {

    public static void main(String[] args) {
        WorkflowClient workflowClient = WorkflowClient.newInstance("localhost", 7933, "simple-domain");
        WorkflowStub catalogDriverClient = workflowClient.newUntypedWorkflowStub("WorkflowDemo::execute",
                new WorkflowOptions.Builder()
                        .setExecutionStartToCloseTimeout(Duration.ofDays(1000))
                        .setTaskList("loadFlow")
                        .build());
        String url = "C:\\Users\\drobayov\\OneDrive - NTT DATA EMEAL\\Documentos\\Squad de Integración\\India KT\\Demo\\JSON";
        /*
        Map<String, String> cadenceMap = new HashMap<>();
        cadenceMap.put("id", "169");
        cadenceMap.put("Category", "BSA");
        cadenceMap.put("Operation", "ServiceOrder");
        cadenceMap.put("CFS", "CFS: CPE;CFS: Access");
        cadenceMap.put("Action", "add;add");
        cadenceMap.put("BaseFlow", "1234");
        cadenceMap.put("serviceOrderItem.size", "2");

         */
        catalogDriverClient.start(url);// Synchronous start
    }
}

package com.nttdata.som.demo.service.impl;

import com.nttdata.som.demo.ifaces.ActivityManageFile;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;

public class ActivityManageFileImpl implements ActivityManageFile {


    @Override
    public String readJson(String url) {
        System.out.println("Llegó a readJson: " + url);

        //String content = client.executeClient();

        OkHttpClient client = new OkHttpClient();
        Response response = null;
        String responseBody = null;

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            response = call.execute();
            responseBody = response.body().string();
            //System.out.println(("Response Body=>" + responseBody));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Errrror: "+ e.getMessage());
        }
        return responseBody;
       // return content;
    }

    @Override
    public File saveFile(String content) throws FileNotFoundException {

        System.out.println("Llegó a saveFile");

        String encoding = "UTF-8";
        String path = "src/main/resources/files";

        File jsonFile = new File(path, "File.txt");
        System.out.println(jsonFile.getAbsolutePath());

        try {
            FileWriter fw = new FileWriter(jsonFile.getAbsolutePath(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return jsonFile;
    }
}

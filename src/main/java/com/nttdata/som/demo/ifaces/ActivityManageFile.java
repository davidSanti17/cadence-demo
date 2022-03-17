package com.nttdata.som.demo.ifaces;

import com.uber.cadence.activity.ActivityMethod;

import java.io.File;
import java.io.FileNotFoundException;

public interface ActivityManageFile {

    @ActivityMethod
    public String readJson(String url);


    @ActivityMethod
    public File saveFile(String content) throws FileNotFoundException;
}

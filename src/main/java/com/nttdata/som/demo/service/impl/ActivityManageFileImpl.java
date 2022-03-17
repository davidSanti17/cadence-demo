package com.nttdata.som.demo.service.impl;

import com.nttdata.som.demo.ifaces.ActivityManageFile;

import java.io.File;

public class ActivityManageFileImpl implements ActivityManageFile {

    @Override
    public String readJson(String url) {
        System.out.println("Llegó a readJson");
        return null;
    }

    @Override
    public File saveFile(String content) {
        System.out.println("Llegó a saveFile");
        return null;
    }
}

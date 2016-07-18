package com.chf.dropwizard.service;

import java.io.PrintWriter;

import com.google.common.collect.ImmutableMultimap;

import io.dropwizard.servlets.tasks.Task;

public class AppTask extends Task {

    public AppTask(String name) {
        super(name);
    }

    @Override
    public void execute(ImmutableMultimap<String, String> arg0,
            PrintWriter arg1) throws Exception {
        System.out.println("task");
    }

}

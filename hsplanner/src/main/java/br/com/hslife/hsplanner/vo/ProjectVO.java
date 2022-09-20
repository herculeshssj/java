package br.com.hslife.hsplanner.vo;

import java.io.Serializable;

public class ProjectVO implements Serializable {
    private String title;

    public ProjectVO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

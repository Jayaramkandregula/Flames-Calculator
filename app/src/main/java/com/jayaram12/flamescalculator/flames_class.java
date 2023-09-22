package com.jayaram12.flamescalculator;

public class flames_class {
    private int id,img_id;
    private String p1_name,p2_name,flames_result;

    public flames_class() {
    }

    public flames_class(String p1_name, String p2_name, String flames_result,int img_id) {

        this.p1_name = p1_name;
        this.p2_name = p2_name;
        this.flames_result = flames_result;
        this.img_id=img_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP1_name() {
        return p1_name;
    }

    public void setP1_name(String p1_name) {
        this.p1_name = p1_name;
    }

    public String getP2_name() {
        return p2_name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public void setP2_name(String p2_name) {
        this.p2_name = p2_name;
    }

    public String getFlames_result() {
        return flames_result;
    }

    public void setFlames_result(String flames_result) {
        this.flames_result = flames_result;
    }
}


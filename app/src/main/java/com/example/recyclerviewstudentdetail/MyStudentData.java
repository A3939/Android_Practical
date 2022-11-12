package com.example.recyclerviewstudentdetail;

public class MyStudentData {
    private String stuName;
    private String stuAdd;
    private Integer stuImg;
    private Boolean softdelete;

    public MyStudentData(String stuName, String stuAdd, Integer stuImg, Boolean delete) {
        this.stuName = stuName;
        this.stuAdd = stuAdd;
        this.stuImg = stuImg;
        this.softdelete = delete;
    }

    public void getSoftdelete(Boolean softdelete){ this.softdelete = softdelete; }

    public Boolean getSoftdelete() { return softdelete; }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAdd() {
        return stuAdd;
    }

    public void setStuAdd(String stuAdd) {
        this.stuAdd = stuAdd;
    }

    public Integer getStuImg() {
        return stuImg;
    }

    public void setStuImg(Integer stuImg) {
        this.stuImg = stuImg;
    }
}

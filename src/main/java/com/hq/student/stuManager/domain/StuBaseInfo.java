package com.hq.student.stuManager.domain;

public class StuBaseInfo {
    private Integer id;

    private String name;

    private Integer sex;

    private Integer age;

    private String householdregister;

    private Integer reporttime;

    private Integer level;

    private Integer majorid;

    private String stuid;

    private Integer statu;

    private String majorname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHouseholdregister() {
        return householdregister;
    }

    public void setHouseholdregister(String householdregister) {
        this.householdregister = householdregister == null ? null : householdregister.trim();
    }

    public Integer getReporttime() {
        return reporttime;
    }

    public void setReporttime(Integer reporttime) {
        this.reporttime = reporttime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }
}
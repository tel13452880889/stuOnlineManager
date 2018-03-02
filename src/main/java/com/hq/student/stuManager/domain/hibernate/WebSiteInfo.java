package com.hq.student.stuManager.domain.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hu.qiao on 2018/2/24.
 */
@Entity
public class WebSiteInfo implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String site_name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = true)
    private Integer status;

    @Column(nullable = false)
    private String create_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}

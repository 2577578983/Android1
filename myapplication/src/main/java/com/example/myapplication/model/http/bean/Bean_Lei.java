package com.example.myapplication.model.http.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean_Lei {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String title;
    @Property
    private String name;
    @Property
    private String gongong;
    @Property
    private String shijian;
    @Generated(hash = 449146679)
    public Bean_Lei(Long id, String title, String name, String gongong,
            String shijian) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.gongong = gongong;
        this.shijian = shijian;
    }
    @Generated(hash = 1440392391)
    public Bean_Lei() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGongong() {
        return this.gongong;
    }
    public void setGongong(String gongong) {
        this.gongong = gongong;
    }
    public String getShijian() {
        return this.shijian;
    }
    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

}

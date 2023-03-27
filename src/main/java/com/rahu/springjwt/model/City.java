package com.rahu.springjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ikrama on 3/16/2017.
 */

@Entity
@Table(name = "cities")
public class City extends BaseEntity {
    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


}

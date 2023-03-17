package com.example.countrynameapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CountryResult {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("result")
    @Expose
    private List<CountryModel> countryModels;
    @SerializedName("extra")
    @Expose
    private List<Object> extra;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<CountryModel> getResult() {
        return countryModels;
    }

    public void setResult(List<CountryModel> countryModels) {
        this.countryModels = countryModels;
    }

    public List<Object> getExtra() {
        return extra;
    }

    public void setExtra(List<Object> extra) {
        this.extra = extra;
    }

}

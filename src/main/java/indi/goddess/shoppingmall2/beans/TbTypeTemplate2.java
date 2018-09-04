package indi.goddess.shoppingmall2.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TbTypeTemplate2 implements Serializable{
    private Long id;

    private String name;

    private List<Map<String,String>> specIds;

    private List<Map<String,String>> brandIds;

    private List<Map<String,String>> customAttributeItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, String>> getSpecIds() {
        return specIds;
    }

    public void setSpecIds(List<Map<String, String>> specIds) {
        this.specIds = specIds;
    }

    public List<Map<String, String>> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Map<String, String>> brandIds) {
        this.brandIds = brandIds;
    }

    public List<Map<String, String>> getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(List<Map<String, String>> customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }
}
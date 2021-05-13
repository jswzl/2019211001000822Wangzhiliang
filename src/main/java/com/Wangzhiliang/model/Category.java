package com.Wangzhiliang.model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Category  implements java.io.Serializable{
    private Integer CategoryId;
    private String CategoryName;
    private String Description;
    private Integer Active;

    QueryRunner qr = new QueryRunner();
    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + CategoryId +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", Active=" + Active +
                '}';
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getActive() {
        return Active;
    }

    public void setActive(Integer active) {
        Active = active;
    }

    public Category() {
    }

    public static List<Category> findAllCategory(Connection con){
        QueryRunner qr = new QueryRunner();
        try {
            return qr.query(con,"select * from Category",new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findByCategoryId(Connection con,int categoryId){
        QueryRunner qr = new QueryRunner();
        try {
            Category query = qr.query(con, "select CategoryName from Category where CategoryID = " + categoryId, new BeanHandler<>(Category.class));
            return query.getCategoryName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

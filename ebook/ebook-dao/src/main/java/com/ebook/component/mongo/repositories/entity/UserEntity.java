package com.ibook.component.mongo.repositories.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-08-25 17:59
 */
@Document(collection = "T_User")
public class UserEntity {

    @Id
    private String id;
    @Indexed
    @Field("username")
    private String username;
    @Field("age")
    private Integer age;
    @Field("address")
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("UserEntity{").append("username='").append(username).append('\'').append(", age=").append(age).append(", address='").append(address).append('\'').append('}').toString();
    }
}

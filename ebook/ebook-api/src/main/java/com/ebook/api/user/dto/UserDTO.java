package com.ebook.api.user.dto;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-08-24 15:09
 */
public class UserDTO {
    private String userName;
    private Short age;
    private String address;

    public UserDTO() {

    }

    public UserDTO(String userName, Short age, String address) {
        this.userName = userName;
        this.age = age;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
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
        return String.format("UserDTO{userName='%s', age='%s', address='%s'}", userName, age, address);
    }
}

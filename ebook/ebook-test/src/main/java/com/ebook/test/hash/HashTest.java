package com.ebook.test.hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-23 13:02
 */
public class HashTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("TestA");
        User user2 = new User();
        user2.setName("TestC");

        Set<User> set = new HashSet<>();
        set.add(user);
        set.add(user2);

        System.out.println(user.hashCode());
        System.out.println(set.contains(user));
        System.out.println(set.size());

        user.setName("TestB");
        System.out.println(user.hashCode());
        System.out.println(set.contains(user));
        System.out.println(set.remove(user));
        System.out.println(set.size());

        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            System.out.println(next);
            if (next.getName().equals("TestB"))
                iterator.remove();
        }

        System.out.println(set.size());

    }
}
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

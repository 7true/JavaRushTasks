package com.javarush.task.task21.task2107;

import jdk.internal.HotSpotIntrinsicCandidate;

import java.net.UnknownServiceException;
import java.util.*;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution.toString());
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(users);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution sol = (Solution) super.clone();
        sol.users = new LinkedHashMap<>();
        sol.users = Collections.synchronizedMap(this.users);
        return sol;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }
}

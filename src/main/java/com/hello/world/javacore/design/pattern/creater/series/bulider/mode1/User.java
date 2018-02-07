package com.hello.world.javacore.design.pattern.creater.series.bulider.mode1;

/**
 * @author xing
 */
public class User {
    private String name;
    private String password;
    private String nickName;
    private int age;

    private User(String name,String password,String nickName,int age){
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.age = age ;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String name;
        private String password;
        private String nickName;
        private int age;

        private UserBuilder(){
        }

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public UserBuilder password(String password){
            this.password = password;
            return this;
        }
        public UserBuilder nickName(String nickName){
            this.nickName = nickName;
            return this;
        }

        public User bulid(){
            return new User(name,password,nickName,age);
        }
    }
}

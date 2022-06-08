package com.example.demoex;

public class User {
        private String name;
        private String gender;
        private String birthday;
        private String email;
        private String phone;
        private String password;

        public User(String name, String gender, String birthday, String email, String phone, String password) {
                this.name = name;
                this.gender = gender;
                this.birthday = birthday;
                this.email = email;
                this.phone = phone;
                this.password = password;
        }

        public User(){

        }

        public String getName() {
                return name;
        }

        public String getGender() {
                return gender;
        }

        public String getBirthday() {
                return birthday;
        }

        public String getEmail() {
                return email;
        }

        public String getPhone() {
                return phone;
        }

        public String getPassword() {
                return password;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public void setBirthday(String birthday) {
                this.birthday = birthday;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}

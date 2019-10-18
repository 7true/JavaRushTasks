package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("/home/ya/in2", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("San");
            user.setLastName("fsd");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            user.setBirthDate(df.parse("23/08/1988 23:22:22"));
            user.setCountry(User.Country.valueOf("Russia".toUpperCase()));
            user.setMale(true);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream pw = new PrintStream(outputStream);
            String hasUsers = this.users.size() > 0 ? "yes" : "no";
            pw.println(hasUsers);
            if (hasUsers.equals("yes")){
                for (User user : this.users) {
                    pw.println(user.getFirstName());
                    pw.println(user.getLastName());
                    pw.println(user.getBirthDate().getTime());
                    pw.println(user.getCountry());
                    pw.println(user.isMale());
                }
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String hasUsers = br.readLine();
            if (hasUsers .equals("yes")) {
                String user;
                while ((user = br.readLine()) != null ) {
                    User userLoaded = new User();
                    userLoaded.setFirstName(user);
                    userLoaded.setLastName(br.readLine());
                    userLoaded.setBirthDate(new Date( Long.parseLong(br.readLine())));
                    userLoaded.setCountry(User.Country.valueOf(br.readLine().toUpperCase()));
                    userLoaded.setMale(Boolean.parseBoolean(br.readLine()));
                    this.users.add(userLoaded);
                }
            }
            br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

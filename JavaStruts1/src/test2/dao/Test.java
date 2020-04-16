package test2.dao;

import test2.bean.Usr;

public class Test {
    public static void main(String[] args) {
        UsrDao usrDao = new UsrDao();
        Usr user=usrDao.checkUsr("xxx","123456");
//        System.out.println(usrDao.checkUsr("xxx", "123456"));

        System.out.println(user.getUid());
        System.out.println(user.getUsername());
    }
}

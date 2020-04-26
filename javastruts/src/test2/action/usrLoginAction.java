package test2.action;

import test2.dao.UsrDao;

public class usrLoginAction {

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() {
        UsrDao usrDao = new UsrDao();
        if (getUsername().equals("ckg") && getPassword().equals("0304180216")) {
            //我为管理员 其他为注册用户
            return "admin";
        } else {
            if (usrDao.checkUsr(getUsername(), getPassword())) {
                return "register";
            }
            return "error";
        }


//       if(usrDao.checkUsr(getUsername(),getPassword())!=null){
//           return "success";
//       }
//       else{
////      Usr user=usrDao.checkUsr(username,password);
////        String name1=user.getUsername();
////        String password1=user.getUpassword();
////
//           return "error";
////        if(getUsername().equals(name1)&& getPassword().equals(password1)){
//       }

    }

}

package test2.czw;

public class UsrLoginAction {
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
        /*
         * 0232陈志威
         */
        UsrDAO dao = new UsrDAO();
        if (dao.checkUsr(username, password) != null) {
            return "register";
        }
        if (dao.checkAdmin(username, password) != null) {
            return "admin";
        }
        return "error";
    }
}

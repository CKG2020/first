public class LoginAction {
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
    public String execute(){
        if(getUsername().equals("ckg")&& getPassword().equals("0304180216")){
            String a=getUsername();
            String b=getPassword();
            System.out.println("------------");
            System.out.println(a);
            System.out.println(b);
            System.out.println("==================");
            return "success";
        }
        return "error";
    }
}
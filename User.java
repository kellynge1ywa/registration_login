public class User {
    private String Email;
    private String Fullname;
    private String Password;

    public User(String email,String fullname, String password) {
        this.Email=email;
        this.Fullname=fullname;
        this.Password=password;

    }

    public String getEmail()
    {
        return Email;
    }

    public String getFullname()
    {
        return Fullname;
    }

    public String getPassword()
    {
        return Password;
    }

    
}

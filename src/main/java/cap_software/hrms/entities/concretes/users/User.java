package cap_software.hrms.entities.concretes.users;




import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int id;




    @Column(name="UserNumber", nullable = false,unique = true,length = 12)
    private int userNumber;


    @Column(name="Email", nullable = false,unique = true,length = 50)
    private String email;


    @Column(name="Password", nullable = false,length = 250)
    private String password;


    @OneToOne(mappedBy = "userId")
    private Admin admin;


    @OneToOne(mappedBy = "userId")
    private JopSeeker jobSeeker;

    @OneToOne(mappedBy = "userId")
    private Emplooyer emplooyer;

    public User() {
    }

    public User(int userNumber, String email, String password) {
        this.userNumber = userNumber;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package crawley.james.spring.domain;

import javax.persistence.*;

/**
 * Created by jamescrawley on 10/26/16.
 */

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    User () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        StringBuilder value = new StringBuilder("{");
        value.append("\"username\": ");
        value.append("\"" + username + "\"");
        value.append(",\"password\": ");
        value.append("\"" + password + "\"");
        value.append("},");
        return value.toString();
    }

}
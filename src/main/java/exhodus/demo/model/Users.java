package exhodus.demo.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Users {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="userName",nullable = false)
    private String _userName;

    @Column(name="mail",nullable = false, unique = true)
    private String _mail;

    @Column(name="pass",nullable = false)
    private String _pass;

    @OneToMany(mappedBy = "patronUser")
    private List<Patrons> patrons;
    //Constructors
    public Users() {
    }

    public Users(int _id, String _userName, String _mail, String _pass) {
        this.id = _id;
        this._userName = _userName;
        this._mail = _mail;
        this._pass = _pass;
    }

    public Users( String _userName, String _pass) {
        this._userName = _userName;
        this._pass = _pass;
    }

    public int get_id() {
        return id;
    }

    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public String get_mail() {
        return _mail;
    }

    public void set_mail(String _mail) {
        this._mail = _mail;
    }

    public String get_pass() {
        return _pass;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }

    //Methods

    @Override
    public String toString() {
        return "Users{" +
                "_id=" + id +
                ", _userName='" + _userName + '\'' +
                ", _mail='" + _mail + '\'' +
                ", _pass='" + _pass + '\'' +
                '}';
    }
}

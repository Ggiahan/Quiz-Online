/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblUser;

/**
 *
 * @author DELL
 */
public class tblUserDTO {
    private String email;
    private String name;
    private String password;
    private String role;
    private String Status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public tblUserDTO(String email, String name, String password, String role, String Status) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.Status = Status;
    }

    public tblUserDTO() {
    }
}

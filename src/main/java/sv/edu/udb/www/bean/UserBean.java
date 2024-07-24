package sv.edu.udb.www.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import sv.edu.udb.www.dao.UserDAO;
import sv.edu.udb.www.model.User;

import java.util.List;

@Named //Definir el namespace que ejecutara el servlet
@RequestScoped //Define que el scope de solicitud es un request
                //y que el que se encargue de las peticiones es JSF
public class UserBean {
    private UserDAO userDAO = new UserDAO();
    private User newUser = new User();

    public List<User> getUsers() {
        return userDAO.getAllUsers();
    }

    public String insertUser() {
        userDAO.insertUser(newUser);
        return "users?faces-redirect=true";
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
}

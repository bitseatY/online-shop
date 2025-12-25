package Entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="carts")
public class Cart {
    private long id;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="cart",orphanRemoval = true)
    List<CartItem> items;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String status;
    public Cart(User user){
        this.user=user;
        status="";
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

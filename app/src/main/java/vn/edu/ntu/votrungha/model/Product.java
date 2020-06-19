package vn.edu.ntu.votrungha.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    long id;
    @NonNull
    String name;
    @NonNull
    String desc;
    @NonNull
    int price;

    public Product( @NonNull String name, @NonNull String desc, int price) {

        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

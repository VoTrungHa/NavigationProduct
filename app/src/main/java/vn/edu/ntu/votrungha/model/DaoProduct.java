package vn.edu.ntu.votrungha.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoProduct {
    @Insert
    public void insertProduct(Product...products);
    @Update
    public void UpdateProduct(Product...products);
    @Delete
    public void DeleteProduct(Product products);

    @Query("Select * from Product")// lấy danh sách product
    List<Product> getListProducts();

    @Query("Select * from Product where id=:id")//  lấy sản phẩm product theo id.
    public Product getProductById(long id);
}

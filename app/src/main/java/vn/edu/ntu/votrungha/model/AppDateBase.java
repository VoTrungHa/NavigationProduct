package vn.edu.ntu.votrungha.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class},version = 1)// muốn sửa dụng dữ liệu của bản nào thì entities đến class đó.
public abstract class AppDateBase extends RoomDatabase {
    public abstract DaoProduct getProductDao();
}

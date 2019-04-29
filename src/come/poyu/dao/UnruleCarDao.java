package come.poyu.dao;

import come.poyu.entity.UnruleCar;

import java.util.List;

public interface UnruleCarDao {
    List<UnruleCar> getAll();
    int del(UnruleCar unruleCar,int id);
}

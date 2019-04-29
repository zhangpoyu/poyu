package come.poyu.dao.impl;

import come.poyu.entity.Car;
import come.poyu.entity.UnruleCar;

import java.util.List;
import come.poyu.dao.UnruleCarDao;
import come.poyu.util.JDBCHelper;

public class UnruleCarDaoImpl implements UnruleCarDao {
    @Override
    public List<UnruleCar> getAll(){
        return JDBCHelper.executeQuery("SELECT * FROM T_UNRULE",UnruleCar.class);
    }
    @Override
    public int del(UnruleCar unruleCar, int id){return  JDBCHelper.executeUpdate("DELETE FROM T_UNRULE WHERE id=?",id);}
}

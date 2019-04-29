package come.poyu.dao;

import come.poyu.entity.Photo;

import java.util.List;
import java.util.Map;

public interface PhotoDao {
    int add(Photo photo);
    List<Map<String, Object>> sel(String sql, String unrule_record);
    String GetNumber(String path);
}

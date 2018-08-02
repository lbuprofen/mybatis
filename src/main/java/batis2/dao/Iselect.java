package batis2.dao;
import batis2.entity.Role;
import java.util.List;

public interface Iselect {
    public List<Role> getUserListByUserName(String name);

    public int add(Role role);

    public List<Role> provider(String name);

    public List<Role> providee(int id);


}

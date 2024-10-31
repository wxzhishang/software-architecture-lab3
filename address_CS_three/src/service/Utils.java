package service;

import database.DB_Druid;
import entity.Address;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void add(Address address, JdbcTemplate jdbcTemplate) {
        String sql = "insert into list value(?,?,?,?)";
        jdbcTemplate.update(sql, address.getName(), address.getAddress(), address.getPhone(), address.getId());
    }

    public static void delete(int id, JdbcTemplate jdbcTemplate) {
        String sql = "delete from list where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public static void update(Address address, JdbcTemplate jdbcTemplate) {
        String sql = "update list set name = ? , address = ?, phone = ? where id = ?";
        Object[] args = {address.getName(), address.getAddress(), address.getPhone(), address.getId()};
        jdbcTemplate.update(sql, args);
    }

    public static List<Address> findAll(JdbcTemplate jdbcTemplate) {
        String sql = "select * from list";
        List<Address> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Address>(Address.class));
        return list;
    }

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DB_Druid.getDataSource());
        List<Address> all = Utils.findAll(jdbcTemplate);
        String[] strArray = new String[all.size()];
        ArrayList[] arrayLists = new ArrayList[all.size()];
        for (int i = 0; i < all.size(); i++) {
            strArray[i] = all.get(i).toString();
        }
        for (int i = 0; i < strArray.length; i++) {
            String[] arr = strArray[i].split("\\s+");
            ArrayList<String> arrayList = new ArrayList();
            for (String ss : arr) {
                arrayList.add(ss);
            }
            arrayLists[i] = arrayList;
        }
        System.out.println(arrayLists[1].get(3).toString());
    }
}

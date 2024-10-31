package app;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
public class Controller {

    public static void add(Address addressList, JdbcTemplate jdbcTemplate) {
        String sql = "INSERT INTO addressList( name, address, phone,id) VALUE(?,?,?,?)";
        jdbcTemplate.update(sql, addressList.getName(), addressList.getAddress(), addressList.getPhone(), addressList.getId());
    }

    public static void delete(int id, JdbcTemplate jdbcTemplate) {
        String sql = "DELETE FROM addressList WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public static void update(Address addressList, JdbcTemplate jdbcTemplate) {
        String sql = "UPDATE addressList SET name = ? , address = ?, phone = ? WHERE id = ?";
        Object[] args = {addressList.getName(), addressList.getAddress(), addressList.getPhone(), addressList.getId()};
        jdbcTemplate.update(sql, args);
    }

    public static List<Address> findAll(JdbcTemplate jdbcTemplate) {
        String sql = "SELECT id, name, address, phone FROM addressList";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
    }
}

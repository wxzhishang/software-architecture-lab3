package app;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import database.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(MysqlxDatatypes.Scalar.String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("通讯录 - 二层C/S结构：");
            System.out.println("1.查看详情 \t2.新增联系人 \t 3.删除联系人 \t4.修改联系人 \t5.关闭通讯录");
            System.out.println("请输入操作码:");
            int choice = scan.nextInt();
            Integer id = -1;
            String name = "";
            String address = "";
            switch (choice) {
                case 1:
                    List<Address> all = Controller.findAll(jdbcTemplate);
                    for (Address item : all) {
                        System.out.println(item);
                    }
                    break;
                case 2:
                    System.out.println("输入联系人编号：");
                    id = scan.nextInt();
                    System.out.println("输入联系人姓名：");
                    name = scan.next();
                    System.out.println("输入联系人居住地址：");
                    address = scan.next();
                    System.out.println("输入联系人电话号码：");
                    String phone = scan.next();
                    Controller.add(new Address(id, name, address, phone), jdbcTemplate);
                    System.out.println("操作成功");
                    break;
                case 3:
                    System.out.println("请输入删除联系人编号：");
                    id = scan.nextInt();
                    Controller.delete(id, jdbcTemplate);
                    System.out.println("删除成功");
                    break;
                case 4:
                    System.out.println("请输入待修改联系人编号：");
                    id = scan.nextInt();
                    System.out.println("新姓名：");
                    name = scan.next();
                    System.out.println("新地址：");
                    address = scan.next();
                    System.out.println("新号码：");
                    phone = scan.next();
                    Controller.update(new Address(id, name, address, phone), jdbcTemplate);
                    System.out.println("修改成功");
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}

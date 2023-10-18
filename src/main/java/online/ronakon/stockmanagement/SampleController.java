package online.ronakon.stockmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.DriverManager;
import java.util.Date;
import java.util.LinkedList;

@RestController
public class SampleController {

    @RequestMapping("/sample")
    String showSample(Model model){
        model.addAttribute("serverTime", new Date());
        return "sample";
    }

    @RequestMapping("/api/m1")
    LinkedList method1(){
        LinkedList result = new LinkedList();
        String sql = "select * from product";
        String source = "jdbc:mysql://127.0.0.1" +
                "/sep2023?user=green&password=C200";

        try {
            // 1. Ask for connection
            var cn = DriverManager.getConnection(source);
            // 2. Prepare statement (Statement = SQL Statement)
            var ps = cn.prepareStatement(sql);
            // 3. Query
            var rs = ps.executeQuery();
            // 4. Read each row one by one
            while (rs.next()) {
                String w = rs.getString("name");
                String s = rs.getString("size");
                double p = rs.getDouble("price");
//                double a = s.toCharArray();
//                var r = new Product(w, a[0], p);
//                var r = new Product(w,s,p);
                var r = "FAKE";
                result.add(r);
            }
            // 5. Close all resources
            rs.close(); ps.close(); cn.close();
        } catch (Exception e) {
            result.add(e);
        }
        return result;


    }

}

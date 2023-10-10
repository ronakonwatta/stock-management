package online.ronakon.stockmanagement;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class FirstPageController {

    Environment environment;
    @RequestMapping(value = "/firstpage", method = RequestMethod.GET)
    String firstpage(Model model) throws UnknownHostException {
        model.addAttribute("serverTime", new java.util.Date());
        model.addAttribute("serverName", InetAddress.getLocalHost().getHostName());
        return "firstpage";
    }

}

package online.ronakon.stockmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class SampleController {

    @RequestMapping("/sample")
    String showSample(Model model){
        model.addAttribute("serverTime", new Date());
        return "sample";
    }

}

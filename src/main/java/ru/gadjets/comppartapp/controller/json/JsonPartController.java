package ru.gadjets.comppartapp.controller.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gadjets.comppartapp.entity.Part;
import ru.gadjets.comppartapp.service.PartPagerService;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/json/")
public class JsonPartController {

    @Autowired
    public PartPagerService partPagerService;

    @GetMapping("/")
    public List<Part> greeting() {
        return partPagerService.findAll(new Properties());
    }
//    @RequestParam(value="id", defaultValue="1") int id
}

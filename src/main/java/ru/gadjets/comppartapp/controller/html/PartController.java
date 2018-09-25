package ru.gadjets.comppartapp.controller.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gadjets.comppartapp.entity.Part;
import ru.gadjets.comppartapp.service.PartPagerService;

import java.util.Properties;

@Controller
@RequestMapping("/part/")
public class PartController {
    @Autowired
    public PartPagerService partService;

    @GetMapping("/")
    public String index() {
        return "redirect:/part/part_list/page/1";
    }

    @GetMapping("/edit/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("part", partService.getById(id));
        return "partEdit";
    }

    @GetMapping("/add")
    public String add() {
        return "partAdd";
    }

    @PostMapping("/add")
    public String addPart(@ModelAttribute("part") Part part) {
        partService.add(part);
        return "redirect:/part/edit/"+part.getPartId();
    }

    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable("id") int id, Model model) {
        partService.delete(id);
        return "redirect:/part/part_list/page/1";
    }


    @PostMapping("/edit")
    public String updatePart(@ModelAttribute("part") Part part) {
        partService.update(part);
        return "redirect:/part/edit/" + part.getPartId();
    }

    @GetMapping(value={"/part_list", "/part_list/page/"})
    public String getCompParts(Model model){
        return "redirect:/part/part_list/page/1";
    }

    @GetMapping("/part_list/page/{id}")
    public String getCompPartsPager(
            @PathVariable("id") String sId,
            @RequestParam(value="description_ru", required=false) String descriptionRu,
            @RequestParam(value="required", required=false) String required,
            Model model
    ){
        if(!isInteger(sId)){
            return "redirect:/part/part_list/page/1";
        }
        Integer pid =  Integer.parseInt(sId);
        Properties properties = new Properties();
        properties.put("page", pid);
        if(descriptionRu != null && !descriptionRu.isEmpty()){
            properties.put("description_ru", descriptionRu);
        }
        if(required != null && !required.isEmpty()){
            properties.put("required", required);
        }

        model.addAttribute("partList", partService.findAll(properties));
        model.addAttribute("pager", partService.getPager());
        return "partList";
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}

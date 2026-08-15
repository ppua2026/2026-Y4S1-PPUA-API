package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.dto.StudentDto;
import kh.edu.ppua.api.form.StudentForm;
import kh.edu.ppua.api.model.CategoryEntity;
import kh.edu.ppua.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Value("${ppua.api.env.profile}")
    String environmentProfile;

    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String home(Model model) {

        List<String> products = new ArrayList<>();
        for (int i =0; i<10;i++){
            products.add("Product Items "+i);
        }

        List<CategoryEntity> categoryEntities = categoryService.findAllWithPaginate("", 0 , 100).getContent();
        model.addAttribute("products", products);
        model.addAttribute("categories",categoryEntities);
        model.addAttribute("message","Hi, Welcome to PPUA");
        //        String ok = "Hi, PPUA \n Environment Profile : " + environmentProfile;
        //        return ResponseEntity.ok(ok);
        return  "index";
    }

    @GetMapping("/student")
    String studentListView(Model model){
        List<StudentDto> studentDtos = new ArrayList<>();
        for (int i =0; i<10;i++){
            StudentDto  s = new StudentDto();
            s.setId((long) i);
            s.setName("Name");
            s.setEmail("ABC@ppua.edu.kh");
            s.setPhoneNumber("012345678");
            studentDtos.add(s);
        }
        model.addAttribute("students", studentDtos);
        return  "student";
    }

    @GetMapping("/student/detail")
    String studentDetailView(Model model){
        return "student-detail";
    }

    @GetMapping("/student/new")
    String studentNewView(Model model){
        return "student-create";
    }

    @PostMapping("/student/create")
    String studentCreateView(@ModelAttribute StudentForm studentForm){
            System.out.println(studentForm.getName());

        return "redirect:student";
    }
}

package com.example.CsvFileUploader.Controller;

import com.example.CsvFileUploader.Entity.User;
import com.example.CsvFileUploader.Repository.UserRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/list")
    public ModelAndView uploadCSVFile(@RequestParam("file")MultipartFile file, Model model) throws IOException {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(User.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<User> users = csvToBean.parse();
                System.out.println(users);

                // TODO: save users in DB
                userRepository.saveAll(users);

                // save users list on model
                model.addAttribute("users", users);
                model.addAttribute("status", true);
            } catch (Exception exception) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return getAllUsers();
    }

    @GetMapping("/list")
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView("list-users");
        mav.addObject("users", userRepository.findAll());
        return mav;
    }
}

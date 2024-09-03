package uz.pdp.randomnumbers_mvc.controller;


import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.randomnumbers_mvc.util.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller



public class RandomNumbersController {

    @GetMapping("/generate")
    public String generateRandomNumbers(Model model,
                                        @RequestParam("rows") int rows,
                                        @RequestParam("columns") int columns) {
        model.addAttribute("randomNumbers", Utils.generateRandomNumbers(rows, columns));
        model.addAttribute("rows", rows);
        model.addAttribute("columns", columns);
        return "index";
    }

    @PostMapping("/sort")
    public String sortRandomNumbers(@RequestParam("rows") int rows, @RequestParam("columns") int columns, @RequestParam("randomNumbers") String randomNumbers, Model model) {
        List<Integer> numbers = Utils.mapStringToList(randomNumbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        model.addAttribute("randomNumbers", numbers);
        Collections.sort(sortedNumbers);
        model.addAttribute("sortedNumbers", sortedNumbers);
        List<Integer> lowest5 = numbers.subList(0, 5);
        List<Integer> highest5 = numbers.subList(numbers.size()-5, numbers.size());
        model.addAttribute("lowest5", lowest5);
        model.addAttribute("highest5", highest5);
        model.addAttribute("rows", rows);
        model.addAttribute("columns", columns);
        return "index";
    }



}

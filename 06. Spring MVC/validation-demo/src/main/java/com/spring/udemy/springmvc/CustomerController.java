package com.spring.udemy.springmvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    /** Add initbinder to convert trim input strings */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        // Remove leading and trailing whitespace
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // Resolve issues for our validation
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customerForm";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        System.out.println("Last name: |" + customer.getLastName() + "|");

        // Show binding results
        System.out.println("Binding result: " + bindingResult);

        if (bindingResult.hasErrors()) {
            return "customerForm";
        } else {
            return "customerConfirmation";
        }
    }
}

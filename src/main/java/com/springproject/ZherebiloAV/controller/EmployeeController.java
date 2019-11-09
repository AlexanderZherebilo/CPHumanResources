package com.springproject.ZherebiloAV.controller;

import com.springproject.ZherebiloAV.domain.Employee;
import com.springproject.ZherebiloAV.domain.User;
import com.springproject.ZherebiloAV.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employeeProfile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        Employee employee = employeeService.getByPersonnel(user.getEmployee().getPersonnelNumber());
        model.addAttribute("currentEmployee", employee);
        return "employeeProfile";
    }

    @GetMapping("editLearning")
    public String getEditLearning(Model model, @AuthenticationPrincipal User user) {
        List<String> types = new ArrayList<>();
        types.add("Базовое");
        types.add("Общее среднее");
        types.add("Среднее специальное");
        types.add("Неоконченное высшее");
        types.add("Высшее");
        model.addAttribute("types", types);
        List<String> forms = new ArrayList<>();
        forms.add("Дневная");
        forms.add("Заочная");
        forms.add("Вечерняя");
        model.addAttribute("forms", forms);
        Employee employee = employeeService.getByPersonnel(user.getEmployee().getPersonnelNumber());
        model.addAttribute("currentType", employee.getEducation());
        model.addAttribute("institution", employee.getLearning().getInstitution());
        model.addAttribute("currentForm", employee.getLearning().getForm());
        model.addAttribute("faculty", employee.getLearning().getFaculty());
        model.addAttribute("speciality", employee.getLearning().getSpeciality());
        model.addAttribute("qualification", employee.getLearning().getQualification());
        model.addAttribute("start", employee.getLearning().getStart().toLocalDate());
        model.addAttribute("finish", employee.getLearning().getFinish().toLocalDate());
        return "editLearning";
    }

    @PostMapping("editLearning")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String education,
            @RequestParam String institution,
            @RequestParam String form,
            @RequestParam String faculty,
            @RequestParam String speciality,
            @RequestParam String qualification,
            @RequestParam Date start,
            @RequestParam Date finish
            ) {
        employeeService.updateLearning(user.getEmployee(), education, institution, form, faculty,
                                speciality, qualification, start, finish);
        return "redirect:/employee/employeeProfile";
    }

    @GetMapping("editEmployee")
    public String getEditEmployee(Model model, @AuthenticationPrincipal User user) {
        Employee employee = employeeService.getByPersonnel(user.getEmployee().getPersonnelNumber());
        model.addAttribute("employee", employee);
        List<String> genders = new ArrayList<>();
        genders.add("Мужской");
        genders.add("Женский");
        model.addAttribute("genders", genders);
        model.addAttribute("birthday", employee.getPassport().getBirthday().toLocalDate());
        List<String> marriges = new ArrayList<>();
        marriges.add("Холост/Не замужем");
        marriges.add("Женат/Замужем");
        model.addAttribute("marriges", marriges);
        model.addAttribute("passnum", employee.getPassport().getNumber().toString());
        model.addAttribute("issueDate", employee.getPassport().getDateOfIssue().toLocalDate());
        return "editEmployee";
    }

    @PostMapping("editEmployee")
    public String updateData(
            @AuthenticationPrincipal User user,
            @RequestParam String surname,
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam Date birthday,
            @RequestParam String gender,
            @RequestParam String marital,
            @RequestParam String address,
            @RequestParam String telephone,
            @RequestParam String series,
            @RequestParam String number,
            @RequestParam String issuedBy,
            @RequestParam Date issueDate
    ) {
        employeeService.updateEmployee(user.getEmployee(), surname, name, lastname, birthday,
                gender, marital, address, telephone, series, Integer.parseInt(number), issuedBy, issueDate);
        return "redirect:/employee/employeeProfile";
    }

    @GetMapping("employeeList")
    public String getUserList(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employeeList";
    }

    @GetMapping("{employee}")
    public String getEmployeeProfile(@PathVariable Employee employee, Model model) {
        model.addAttribute("currentEmployee", employee);
        return "employeeProfile";
    }
}

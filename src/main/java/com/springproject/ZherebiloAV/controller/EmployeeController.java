package com.springproject.ZherebiloAV.controller;

import com.springproject.ZherebiloAV.domain.Employee;
import com.springproject.ZherebiloAV.domain.FamilyMember;
import com.springproject.ZherebiloAV.domain.Passport;
import com.springproject.ZherebiloAV.domain.User;
import com.springproject.ZherebiloAV.repos.FamilyMemberRepo;
import com.springproject.ZherebiloAV.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @Value("${upload.path}")
    private String uploadPath;

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
        if (employee.getLearning() != null) {
            model.addAttribute("currentType", employee.getEducation());
            model.addAttribute("institution", employee.getLearning().getInstitution());
            model.addAttribute("currentForm", employee.getLearning().getForm());
            model.addAttribute("faculty", employee.getLearning().getFaculty());
            model.addAttribute("speciality", employee.getLearning().getSpeciality());
            model.addAttribute("qualification", employee.getLearning().getQualification());
            model.addAttribute("start", employee.getLearning().getStart().toLocalDate());
            model.addAttribute("finish", employee.getLearning().getFinish().toLocalDate());
        }
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
        employeeService.updateLearning(user.getEmployee().getPersonnelNumber(), education, institution, form, faculty,
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("addEmployee")
    public String getAddingPage(Model model) {
        List<String> genders = new ArrayList<>();
        genders.add("Мужской");
        genders.add("Женский");
        model.addAttribute("genders", genders);
        List<String> marriges = new ArrayList<>();
        marriges.add("Холост/Не замужем");
        marriges.add("Женат/Замужем");
        model.addAttribute("marriges", marriges);
        List<String> types = new ArrayList<>();
        types.add("Базовое");
        types.add("Общее среднее");
        types.add("Среднее специальное");
        types.add("Неоконченное высшее");
        types.add("Высшее");
        model.addAttribute("types", types);
        return "addEmployee";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("addEmployee")
    public String saveEmployee(
            @RequestParam String surname,
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam Date birthday,
            @RequestParam String gender,
            @RequestParam String maritalStatus,
            @RequestParam String education,
            @RequestParam String address,
            @RequestParam String telephone,
            @RequestParam Integer retirementCode,
            @RequestParam Integer personnelNumber,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam String series,
            @RequestParam Integer number,
            @RequestParam String issuedBy,
            @RequestParam Date dateOfIssue

    ) throws IOException {
        Passport passport = new Passport(surname, name, lastname, birthday, gender, series, number, issuedBy, dateOfIssue);
        Employee employee = new Employee(personnelNumber, retirementCode, education, maritalStatus, address, telephone, passport);
        passport.setEmployee(employee);
        if (photo != null && !photo.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "," + photo.getOriginalFilename();

            photo.transferTo(new File(uploadPath + "/" + resultFilename));

            employee.setPhoto(resultFilename);
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employee/employeeList";
    }

    @GetMapping("family/{employee}")
    public String familyMembersList(@PathVariable Employee employee, Model model) {
        model.addAttribute("Employee", employee);
        return "employeeFamilyList";
    }

    @PostMapping("family/{employee}")
    public String addFamilyMember(
            @AuthenticationPrincipal User user,
            @RequestParam String relation,
            @RequestParam String surname,
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam Date birthday,
            @RequestParam String workPlace,
            @RequestParam String address
    ) {
        FamilyMember familyMember = new FamilyMember(relation, address, workPlace, surname, name, lastname, birthday);
        employeeService.addMember(user, familyMember);
        return "redirect:/employee/employeeProfile";
    }

    @GetMapping("family/deleting/{member}")
    public String deleteMember(
            @PathVariable Integer member
    ) {
        FamilyMember familyMember = familyMemberRepo.findById(member);
        employeeService.deleteMember(familyMember);
        return "redirect:/employee/employeeProfile";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("employeeList/deleting")
    public String getDeletingList(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employeeDeletingList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("employeeList/deleting/{employee}")
    public String deleteEmployee(
            @PathVariable Employee employee
    ) {
        employeeService.deleteEmloyee(employee);
        return "redirect:/employee/employeeList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("employeeProfile/setSalary/{employee}")
    public String setSalary(@PathVariable Employee employee, Model model) {
        List<String> types = new ArrayList<>();
        types.add("Индивидуальная");
        types.add("Коллективная");
        model.addAttribute("types", types);
        List<String> currencies = new ArrayList<>();
        currencies.add("BYN");
        currencies.add("USD");
        currencies.add("EUR");
        currencies.add("RUB");
        model.addAttribute("currencies", currencies);
        if (employee.getSalary() != null) {
            model.addAttribute("currentType", employee.getSalary().getType());
            model.addAttribute("currentCur", employee.getSalary().getCurrency());
            model.addAttribute("value", employee.getSalary().getValue());
            model.addAttribute("start", employee.getSalary().getStart().toLocalDate());
            model.addAttribute("orderNumber", employee.getSalary().getOrderNumber());
            model.addAttribute("dateOfOrder", employee.getSalary().getDateOfOrder().toLocalDate());
        }
        return "setSalary";
    }
}

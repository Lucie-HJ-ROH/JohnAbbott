package com.example.teacher.controller;

import com.example.teacher.model.Book;
import com.example.teacher.model.Subject;
import com.example.teacher.model.Teacher;
import com.example.teacher.service.BookService;
import com.example.teacher.service.SubjectService;
import com.example.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {
  
  @Autowired
  private TeacherService teacherService;
  
  @Autowired
  private BookService bookService;
  
  @Autowired
  private SubjectService subjectService;
  
  public void initList(Model model) {
    
    List<Teacher> teacherList = teacherService.listAll();
    model.addAttribute("teacherList", teacherList);
  
    List<Book> bookList = bookService.listAll();
    model.addAttribute("bookList", bookList);
    
    List<Subject> subjectList = subjectService.listAll();
    model.addAttribute("subjectList", subjectList);
  }
  
  @RequestMapping("/")
  public String home() {
    return "home";
  }
  
  @RequestMapping("/register_teacher")
  public String registerTeacher(Model model) {
    
    Teacher teacher = new Teacher();
    model.addAttribute("teacher", teacher);
    
    return "register_teacher";
  }
  
  @RequestMapping(value = "/save_teacher", method = RequestMethod.POST)
  public String saveTeacher(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult, Model model) {
    
    if (bindingResult.hasErrors()) {
      model.addAttribute("teacher", teacher);
      return "register_teacher";
    }
    
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(teacher.getPassword());
    teacher.setPassword(encodedPassword);
    
    teacherService.save(teacher);
    
    return "redirect:/login";
  }
  
  @RequestMapping("/login")
  public String signin() {
    return "signin";
  }
  
  @RequestMapping("/show_teacher")
  public String welcome(Model model) {
    
    initList(model);
    
    return "teacher";
  }
  
  @RequestMapping("/edit_teacher/{id}")
  public ModelAndView editTeacher(@PathVariable(name = "id") String id) {
    ModelAndView mav = new ModelAndView("edit_teacher");
    Teacher teacher = teacherService.get(id);
    mav.addObject("teacher", teacher);
    
    return mav;
  }
  
  @RequestMapping("/add_teacher")
  public String addTeacher(Model model) {
    
    Teacher teacher = new Teacher();
    model.addAttribute("teacher", teacher);
    
    return "add_teacher";
  }
  
  @RequestMapping(value = "/add_save_teacher", method = RequestMethod.POST)
  public String addSaveTeacher(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult, Model model) {
    
    if (bindingResult.hasErrors()) {
      model.addAttribute("teacher", teacher);
      return "add_teacher";
    }
    
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(teacher.getPassword());
    teacher.setPassword(encodedPassword);
    
    teacherService.save(teacher);
    initList(model);
    
    return "teacher";
  }
  
  @RequestMapping("/delete_teacher/{id}")
  public String deleteTeacher(@PathVariable(name = "id") String id) {
    teacherService.delete(id);
    return "redirect:/";
  }
  
  @RequestMapping("/register_book")
  public String registerBook(Model model) {
    Book book = new Book();
    model.addAttribute("book", book);
    
    return "register_book";
  }
  
  @RequestMapping(value = "/save_book", method = RequestMethod.POST)
  public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
    
    if (bindingResult.hasErrors()) {
      model.addAttribute("book", book);
      return "register_book";
    }
    
    bookService.save(book);
    initList(model);
    
    return "teacher";
  }
  
  @RequestMapping("/edit_book/{isbn}")
  public ModelAndView editBook(@PathVariable(name = "isbn") String isbn) {
    ModelAndView mav = new ModelAndView("edit_book");
    Book book = bookService.get(isbn);
    mav.addObject("book", book);
    
    return mav;
  }
  
  @RequestMapping("/delete_book/{isbn}")
  public String deleteBook(@PathVariable(name = "isbn") String isbn, Model model) {
    bookService.delete(isbn);
    initList(model);
    return "teacher";
  }
  
  @RequestMapping("/register_subject")
  public String registerSubject(Model model) {
    Subject subject = new Subject();
    model.addAttribute("subject", subject);
    
    return "register_subject";
  }
  
  @RequestMapping(value = "/save_subject", method = RequestMethod.POST)
  public String saveSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult, Model model) {
    
    if (bindingResult.hasErrors()) {
      model.addAttribute("subject", subject);
      return "register_subject";
    }
    
    subjectService.save(subject);
    initList(model);
    
    return "teacher";
  }
  
  @RequestMapping("/edit_subject/{code}")
  public ModelAndView editSubject(@PathVariable(name = "code") String code) {
    ModelAndView mav = new ModelAndView("edit_subject");
    Subject subject = subjectService.get(code);
    mav.addObject("subject", subject);
    
    return mav;
  }
  
  @RequestMapping("/delete_subject/{code}")
  public String deleteSubject(@PathVariable(name = "code") String code, Model model) {
    subjectService.delete(code);
    initList(model);
    return "teacher";
  }
}

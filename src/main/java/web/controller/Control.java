package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.PersonDAO;
import web.Persons.Person;


@Controller
@RequestMapping("/")
public class Control {
    private final PersonDAO personDAO;
    @Autowired
    public Control(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }



    @GetMapping("/allUsers")
    public String allUsers(Model model){
        model.addAttribute("person",personDAO.allUsers());
        return "allUsers";
    }
    @GetMapping("/{id}")
    public String oneUser(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDAO.oneUser(id));
        return "oneUser";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("person",new Person());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/allUsers";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDAO.oneUser(id));
        return "edit";
    }
    @PatchMapping("/edit/{id}")
    public String update(@ModelAttribute("person")Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/allUsers";
    }
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/allUsers";
    }
}

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



    @GetMapping
    public String allUsers(Model model){
        model.addAttribute("people",personDAO.allUsers());
        return "allUsers";
    }
    @GetMapping("/{id}")
    public String oneUser(@PathVariable("id") int id, Model model){
        model.addAttribute("people",personDAO.oneUser(id));
        return "oneUser";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("people",new Person());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("people") Person person){
        personDAO.save(person);
        return "redirect:/allUsers";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("people",personDAO.oneUser(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("people")Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/allUsers";
    }
}

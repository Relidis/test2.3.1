package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.PersonDAO;
import web.Persons.Person;


@Controller
@RequestMapping("/users")
public class Control {
    private final PersonDAO personDAO;
    @Autowired
    public Control(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }



    @GetMapping("/hello")
    public String allUsers(Model model){
        model.addAttribute("persons",personDAO.allUsers());
        return "people/allUsers";
    }
    @GetMapping("/{id}")
    public String oneUser(@PathVariable("id") int id, Model model){
        model.addAttribute("persons",personDAO.oneUser(id));
        return "people/oneUser";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/allUsers";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("person",personDAO.oneUser(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person")Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/allUsers";
    }
}

package hh.backend.bookstore.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.backend.bookstore.bookstore.domain.Book;
import hh.backend.bookstore.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; 
    }

    @GetMapping("/addbook")
    public String showAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @PostMapping("/addbook")
    public String addBook(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
    
    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("message", "Welcome to the Bookstore!");
        return "index";  
    }
}

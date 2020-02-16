package com.kozlovskaya.web.controller;

import com.kozlovskaya.web.entities.Customer;
import com.kozlovskaya.web.entities.Message;
import com.kozlovskaya.web.entities.Request;
import com.kozlovskaya.web.entities.Review;
import com.kozlovskaya.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"customer", "message", "review"})
public class CustomerController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private GruppaService gruppaService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private LangService langService;

    @RequestMapping(value = {"/", "/school"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/authorization";
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public String contact(@ModelAttribute("customer") Customer customer, Model m){
        Message message = new Message();
        message.setAccept((short) 0);
        message.setSender(customer);
        message.setTaker(customerService.getAdministrator());
        System.out.println(message);
        m.addAttribute("message", message);
        return "sendMessage";
    }

    @RequestMapping(value = "/addrequest", method = RequestMethod.GET)
    public String addrequest(@ModelAttribute("customer") Customer custom, Model model){
        Request request = new Request();
        model.addAttribute("tempRequest", request);
        return "addRequest";
    }

    @RequestMapping(value = "/addrequest", method = RequestMethod.POST)
    public String addrequest(@ModelAttribute("customer") Customer customer,
                             @ModelAttribute("tempRequest") Request request){
        request.setAccept((short) 0);
        request.setCustomer(customer);
        System.out.println(request);
        requestService.saveOrUpdate(request);
        System.out.println(request);
        return "redirect:/home";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String authorization(Model m) {
        m.addAttribute("customer", new Customer());
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model m) {
        m.addAttribute("newCustomer", new Customer());
        return "register";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String regUser(@ModelAttribute("newCustomer") Customer customer) {
        customer.setUserRole("customer");
        customerService.saveOrUpdate(customer);
        return "redirect:/authorization";
    }

    @RequestMapping(value = "/mycourses/{courseid}", method = RequestMethod.GET)
    public String review(@ModelAttribute("customer") Customer customer,
                         @PathVariable("courseid") Integer id,
                         Model m){
        Review review = new Review();
        review.setLang(gruppaService.findById(id).getLang());
        review.setCustomer(customer);
        m.addAttribute("review", review);
        return "addReview";
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public String review(@ModelAttribute("review") Review review, Model m) {
        reviewService.saveOrUpdate(review);
        return "redirect:/home";
    }

    @RequestMapping(value = "/review/{courid}", method = RequestMethod.GET)
    public String review(@PathVariable("courid") Integer id, Model m) {
        m.addAttribute("reviews", langService.findById(id).getReviewList());
        return "allReviews";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String courses(Model m) {
        m.addAttribute("courses", langService.findAll());
        return "allCourses";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model m) {
        return "home";
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute("message") Message message, Model m) {
        System.out.println(message);
        messageService.saveOrUpdate(message);
        return "redirect:/home";
    }

    @RequestMapping(value = "/mymessages", method = RequestMethod.GET)
    public String mymessages(@ModelAttribute("customer") Customer customer, Model m){
        m.addAttribute("messes", customer.getMessageList1());
        return "mymessages";
    }

    @RequestMapping(value = "/mycourses", method = RequestMethod.GET)
    public String mycour(@ModelAttribute("customer") Customer customer, Model m){
        m.addAttribute("mycourses", customer.getGruppaList());
        return "myCourses";
    }




    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String checkAuthorization(@ModelAttribute("customer") Customer customer,
                                     Model m) {
        System.out.println(customer);

        Customer authorizeCustomer = customerService.findByLoginAndPass(customer.getLogin(), customer.getPass());

        System.out.println(customer.getId() + customer.getLogin() + customer.getPass());

        if (authorizeCustomer == null) {
            return "redirect:/authorization";
        }


        m.addAttribute("customer", authorizeCustomer);


        if (authorizeCustomer.getUserRole().equals("admin")){
            return "redirect:/man";
        }

        if (authorizeCustomer.getUserRole().equals("customer")){
            return "redirect:/home";
        }

        return "redirect:/authorization";
    }
}

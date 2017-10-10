package com.example;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ContentController {




    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }



    //HTML
    /*@RequestMapping(value = "/hello" ,produces = "text/html", method = RequestMethod.GET)
    //@RequestBody JsonQuestionGroup questionGroup, HttpServletResponse response)
    public @ResponseBody
    String getGreating(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        return "<div><h1>Hello!</h1></div>";

    }*/


    /*


    //THIS IS A BEST EXAMPLES

     <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"
        p:prefix="/WEB-INF/jsp/" p:suffix=".jsp" />

    And tried to return fromthe controller the full path to the resource.

    @Controller
    public class LandingPageController {

        protected static Logger logger = Logger.getLogger(LandingPageController.class);

        @RequestMapping({"/","/home"})
        public String showHomePage(Map<String, Object> model) {
            return "/WEB-INF/jsp/main.html";
        }
    }









    @RequestMapping(value="html", method = RequestMethod.GET )
    public String startHtml(){
        return "/test.html";
    }







    JSP page cart.jsp:

    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!-- custom html for your cart representation, just an example -->
    <div>
        <h1>${cart.headline}</h1>
        <p>${cart.otherProperty}</p>
    </div>

    Controller:

    @RequestMapping(value="/addtocart{id}")
    public String addToCart(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart, Model model) {
        doSomethingWithCart(cart);

        model.addAttribute("cart", cart); // add cart to model after doing some custom operations
    return "cart"; // resolved to cart.jsp by your view resolver
    }


     */





}

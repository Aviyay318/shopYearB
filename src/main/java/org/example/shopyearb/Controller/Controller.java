package org.example.shopyearb.Controller;

import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.*;
import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Response.BasicResponse;
import org.example.shopyearb.Response.LoginResponse;
import org.example.shopyearb.Utils.Constant;
import org.example.shopyearb.Utils.PasswordHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
public class Controller {



    @Autowired
    private DBManager dbManager;



    @GetMapping("/get-all-categories")
    public List<Category> getAllCategories(){
        return this.dbManager.getAllCategories2();
    }













    @RequestMapping("/hello")
    public String sayHello1(){
        return "sayHello";
    }

    @GetMapping("/get-categories")
    public List<Category> getCategories(){
        return this.dbManager.getAllCategories();
    }

    @GetMapping("/get-products-by-category-id")
    public List<Product> getProductByCategory(int categoryId){
      return this.dbManager.getProductsByCategoryId(categoryId);
    }

  @PostMapping("/add-product")
  public BasicResponse addProduct(@RequestBody Product product){
      boolean successes = false;
      Integer errorCode = Constant.ERROR_ADD_PRODUCT;

      if (product!=null && product.getName()!=null && !product.getName().isEmpty()){
            if (!this.dbManager.isProductExist(product.getName())){
                if (this.dbManager.addProduct(product)){
                    successes = true;
                    errorCode = null;
                }
            }
        }
        return new BasicResponse(successes,errorCode);
  }


@PostMapping("/add-author")
public BasicResponse addAuthor(@RequestBody Author author){
     boolean successes = false;
     Integer errorCode = Constant.ADD_AUTHOR;
        if (author!=null){
            if (!this.dbManager.isAuthorExist(author.getId())){
                author.setPassword(PasswordHashUtil.hashPassword(author.getName()+author.getPassword()));
               if (this.dbManager.addAuthor(author)){
                   successes = true;
                   errorCode = null;
               }

            }
        }
        return new BasicResponse(successes,errorCode);

}



//@PostMapping("/add-book")
//public BasicResponse addBook(@RequestHeader("Authorization") String token
//        ,@RequestBody Book book) {
//   BasicResponse basicResponse = new BasicResponse(false,null);
//    Author author = this.dbManager.getAuthorByToken(token);
//    if (author!=null&&author.getId().equals(book.getAuthorId())){
//        if (checkRules(book)){
//            if (this.dbManager.addBook(book)){
//               basicResponse.setSuccesses(true);
//            }
//        }
//    }
//return basicResponse;
//}

//בדיקות של חוקים מכרז ->
//הספר לפחות באורך של 130 דפים
//    השם של הספר מכיל את אחד מהתווים הבאים ABG
//    העלות להשכרה של הספר לא עולה על 30 שקלים
//    ואין לו יותר מ5 ספרים בספרייה
//3)	ובדיקה שהספר לא קיים


    private boolean checkRules(Book book) {
      boolean isValidate = false;

      if (book.getLength()>=130&& Pattern.compile("ABG").matcher(book.getName()).find()
      &&book.getCost()<=30&&this.dbManager.getAmountOfBooks(book.getAuthorId())<5){
       isValidate = true;
      }
        return isValidate;
    }


    @PostConstruct
    //הפונקציה תקרא אוטומטית שהתוכנית עולה בלי שנזמן אותה
    public void init(){

    }

    @RequestMapping("/say-hello")
    public String  sayHello(){
       return "Hello";
    }



    @PostMapping ("/register-user")
    public BasicResponse register(@RequestBody User user){
        boolean successes = false;
        Integer errorCode = Constant.ERROR_REGISTER;
       if (user!=null && user.getUsername()!=null){
           if (!this.dbManager.isUserExist(user.getUsername())){
                user.setPassword(PasswordHashUtil.hashPassword(user.getPassword()+user.getUsername()));
                if (this.dbManager.addUser(user)){
                    successes = true;
                    errorCode = null;
                }
           }
       }
       return new BasicResponse(successes,errorCode);
    }

    @PostMapping("/login")
    public LoginResponse login(String username, String password){
        boolean successes = false;
        Integer errorCode = Constant.ERROR_LOGIN;
        String token = PasswordHashUtil.hashPassword(password + username);
        if (this.dbManager.getUserByUsernameAndPassword(username,token)){
            successes  = true;
            errorCode = null;
        }
        return new LoginResponse(successes,errorCode,token);
    }





}

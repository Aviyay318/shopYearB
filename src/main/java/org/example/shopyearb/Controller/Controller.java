package org.example.shopyearb.Controller;

import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.Category;
import org.example.shopyearb.Entity.Product;
import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Entity.User;
import org.example.shopyearb.Response.BasicResponse;
import org.example.shopyearb.Response.LoginResponse;
import org.example.shopyearb.Utils.Constant;
import org.example.shopyearb.Utils.PasswordHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

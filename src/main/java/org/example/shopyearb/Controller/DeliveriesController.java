package org.example.shopyearb.Controller;


import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.Product1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveriesController {

    @Autowired
    private DBManager dbManager;


    @GetMapping("/get-products")
    public List<Product1> getProducts(){
        return this.dbManager.getAllProducts();
    }
//
//    במחלקה DeliveriesController עליכם להוסיף מתודה שמאזינה לבקשת ה-API הבאה:
//    deliveries-history. המתודה תקבל פרמטר יחיד בשם int clientId,
//    שהוא המזהה הייחודי של הלקוח ששלח את הבקשה ב-API. המתודה תפנה אל מסד הנתונים ותחזיר את רשימת כל
//    המשלוחים (אובייקטים מסוג Delivery) ששייכים ללקוח עם ה-clientId הרלוונטי.

//    @GetMapping("/deliveries-history")

}

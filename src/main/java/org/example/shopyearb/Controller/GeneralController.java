package org.example.shopyearb.Controller;

import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.Book;
import org.example.shopyearb.Entity.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    DBManager dbManager;

    @PostMapping ("/checkIceCream")
    public boolean checkIceCream(@RequestBody UserRequest user){
        boolean isAccepted = false;
//        הלקוח צריך להיות מעל גיל 7
//        הוא צריך לאכול לפחות פעמיים גלידה בשבוע
//        הוא צריך בבחירת הטעם שלו לבחור לפחות 2 טעמים פירות מתוך הרשימה (תפוח , בננה, מלון , תות )
//        הוא צריך לבחור תוספת שוקולד אחת מבין הבאים (שוקולד לבן , שוקולד פרה , שוקולד מריר, השחר , נוטלה )
//        הוא צריך לענות תשובה של האם הוא אוהב גלידה (כן או לא)
//        והשם שלו כולל את התו A
if (user!=null){
    if (user.getAge()>7&&user.getDayesOfIceCream()>=2&&
            user.getFlavors().size()>=2&&!user.getUserChocolate().isEmpty()
            &&user.isLikesIceCream()&&user.getName().contains("A")){
        isAccepted = true;
    }
}
   return isAccepted;
    }

    @PostMapping ("/register")
    public boolean register(@RequestBody UserRequest user){
        boolean successes = false;
        if (user!=null){
            if (!this.dbManager.isUserIceCreamExist(user)){
                if (this.dbManager.addUserIceCream(user)){
                    successes  =true;
                }
            }
        }
        return successes;
    }



//    public boolean getBooks(String id,String token){
//     return this.dbManager.getBooksById(id);
//    }


}

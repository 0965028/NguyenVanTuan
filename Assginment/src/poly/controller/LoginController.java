package poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Users;

@Transactional
@Controller
@RequestMapping("home/index/")
public class LoginController {
	@Autowired
	SessionFactory factory;
	  @RequestMapping("login")
	    public String login(ModelMap model) {
	        return "home/index/login";
	  }
	  @RequestMapping("loginuser")
	  public String login(HttpServletRequest rq, ModelMap model) {
		  String user = rq.getParameter("txtUser");
		  String pass = rq.getParameter("txtPass");
		  System.out.println(""+user);
		  System.out.println(""+pass);
		  Session session = factory.getCurrentSession();
		  String sql = "From Users where Username = :user ";
		  Query query = session.createQuery(sql);
		  query.setParameter("user",user);
		  Users users = (Users) query.uniqueResult();
		  if(users == null) {
			  model.addAttribute("message", "Tài Khoản Không Tồn Tại");
				return "home/index/login";
		  }else {

				if (pass.equals(users.getPassword())) {
					
				} else {
					
					model.addAttribute("message", "Sai password");
					return"home/index/login";
				}
			}
		  return"redirect:/admin/top10/showtop10.htm";
		  
	  }
}

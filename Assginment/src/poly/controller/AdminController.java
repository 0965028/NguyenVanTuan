package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Users;

@Transactional
@Controller
@RequestMapping("admin/user/")
public class AdminController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("show")
	public String index(ModelMap model) {
		model.addAttribute("user", new Users());
		model.addAttribute("users", getUser());
		return "admin/user/show-user";
	}
	
	@SuppressWarnings("unchecked")
	public List<Users> getUser() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Users";
		Query query = session.createQuery(hql);
		List<Users> list = query.list();
		return list;
	}
	
	@RequestMapping("adduser")
	public String InsertUser(ModelMap model) {
		model.addAttribute("user", new Users());
		return "admin/user/add-user";
	}
	
	@RequestMapping("insert")
	public String insert(ModelMap model, @ModelAttribute("user") Users user) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
			model.addAttribute("message", "Thêm Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			model.addAttribute("message", "Thêm Thất Bại");
		} finally {
			session.close();
		}
		model.addAttribute("user", user);
		return "admin/user/add-user";
	}
	@RequestMapping("delete/{u}")
	public String delete(ModelMap model, @PathVariable("u") String Username) {
		Session session = factory.getCurrentSession();
		Users user = (Users) session.get(Users.class, Username);
		session.delete(user);
		model.addAttribute("message", "Xóa Thành Công");
		model.addAttribute("users", new Users());
		model.addAttribute("users", getUser());
		return "admin/user/show-user";
	}
	@RequestMapping("update/{u}")
	public String update(ModelMap model, @PathVariable("u") String Username) {
		Session session = factory.getCurrentSession();
		Users user = (Users) session.get(Users.class, Username);
		model.addAttribute("user", user);
		model.addAttribute("users", getUser());
		return "admin/user/update-user";
	}
	@RequestMapping("update")
	public String update(ModelMap model, @ModelAttribute("user") Users user) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(user);
			session.getTransaction().commit();
			model.addAttribute("message", "Update Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			model.addAttribute("message", "Update Thất Bại");
		} finally {
			session.close();
		}
		model.addAttribute("user", user);
		return "admin/user/update-user";
	}
}

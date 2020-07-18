package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Staffs;

@Transactional
@Controller
@RequestMapping("admin/top10")
public class Top10Controller {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("showtop10")
	public String index(ModelMap model) {
		model.addAttribute("staff", new Staffs());
		model.addAttribute("staffs", getStaff());
		return "admin/top10/index";
	}
	
	@SuppressWarnings("unchecked")
	public List<Staffs> getStaff() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staffs";
		Query query = session.createQuery(hql);
		List<Staffs> list = query.list();
		return list;
	}
}

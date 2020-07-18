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

import poly.entity.Departs;

@Transactional
@Controller
@RequestMapping("admin/depart/")
public class DepartController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("adddepart")
	public String InsertUser(ModelMap model) {
		model.addAttribute("depart", new Departs());
		return "admin/depart/add-depart";
	}
	
	@RequestMapping("insertdepart")
	public String insert(ModelMap model, @ModelAttribute("depart") Departs de) {
                Session session = factory.openSession();
                try{                   
                    session.getTransaction().begin();
                    session.save(de);
                    session.getTransaction().commit();
                    model.addAttribute("message", "Thêm thành công");
                }catch(Exception e){
                    e.printStackTrace();
                    session.getTransaction().rollback();
                    model.addAttribute("message", "Thêm thất bại");
                }finally {
                    session.close();
                }
		return "admin/depart/add-depart";     
	}
	
	@RequestMapping("showdepart")
	public String index1(ModelMap model) {
		model.addAttribute("departs", getDeparts());
		return "admin/depart/show-depart";
	}
	public List<Departs> getDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Departs";
		Query query = session.createQuery(hql);
		List<Departs> list = query.list();
		return list;
	}
	
	@RequestMapping("deletedepart/{d}")
	public String delete(ModelMap model, @PathVariable("d") int Id) {
		Session session = factory.getCurrentSession();
		Departs depart = (Departs) session.get(Departs.class, Id);
		session.delete(depart);
		model.addAttribute("message", "Xóa thàng công !");
		model.addAttribute("departs", new Departs());
		model.addAttribute("departs", getDeparts());
		return "admin/depart/show-depart";
	}
	
	@RequestMapping("updatedepart/{i}")
	public String updatede(ModelMap model, @PathVariable("i") int Id) {
		Session session = factory.getCurrentSession();
		Departs depart = (Departs) session.get(Departs.class, Id);
		model.addAttribute("depart", depart);
		model.addAttribute("departs", getDeparts());
		return "admin/depart/update-depart";
	}
	
	@RequestMapping("updatedepart")
	public String updatede(ModelMap model, @ModelAttribute("depart") Departs depart) {
                Session session = factory.openSession();
                try{                   
                    session.getTransaction().begin();
                    session.update(depart);
                    session.getTransaction().commit();
                    model.addAttribute("message", "Update thanh cong");
                }catch(Exception e){
                    e.printStackTrace();
                    session.getTransaction().rollback();
                    model.addAttribute("message", "Update that bai");
                }finally {
                    session.close();
                }
                model.addAttribute("depart", depart);
		return "admin/depart/update-depart";     
	}
}	

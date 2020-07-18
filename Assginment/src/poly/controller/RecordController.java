package poly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Departs;
import poly.entity.Records;
import poly.entity.Staffs;

@Transactional
@Controller
@RequestMapping("admin/record/")
public class RecordController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("showrecord")
	public String index(ModelMap model) {
		model.addAttribute("record", new Records());
		model.addAttribute("records", getRecord());
		return "admin/record/show-record";
	}
	
	@SuppressWarnings("unchecked")
	public List<Records> getRecord() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Records";
		Query query = session.createQuery(hql);
		List<Records> list = query.list();
		return list;
	}
	
	@RequestMapping("addrecord")
	public String InsertStaff(ModelMap model) {
		model.addAttribute("record", new Records());
		return "admin/record/add-record";
	}
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
	
	@RequestMapping("insertRecord")
	public String insert(ModelMap model, @ModelAttribute("record") Records record) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.save(record);
			session.getTransaction().commit();
			model.addAttribute("message", "Thêm Thành công");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			model.addAttribute("message", "Thêm thất bại");
		} finally {
			session.close();
		}
		return "admin/record/add-record";
	}
	
	@ModelAttribute("listStaff")
	@SuppressWarnings("unchecked")
	public List<Staffs> listStaff(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staffs";
		Query query = session.createQuery(hql);
		List<Staffs> list = query.list();
		return list;
	}
	
	
	@RequestMapping("delete/{r}")
	public String delete(ModelMap model, @PathVariable("r") int Id) {
		Session session = factory.getCurrentSession();
		Records record = (Records) session.get(Records.class, Id);
		session.delete(record);
		model.addAttribute("message", "xóa thành công");
		model.addAttribute("records", new Records());
		model.addAttribute("records", getRecord());
		return "admin/record/show-record";
	}
	
	@RequestMapping("updaterecord/{r}")
	public String update(ModelMap model, @PathVariable("r") int Id) {
		Session session = factory.getCurrentSession();
		Records record = (Records) session.get(Records.class, Id);
		model.addAttribute("record", record);
		model.addAttribute("records", getRecord());
		return "admin/record/update-record";
	}
	@RequestMapping("updaterecord")
	public String update(ModelMap model, @ModelAttribute("record") Records record) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(record);
			session.getTransaction().commit();
			model.addAttribute("message", "update thành công");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			model.addAttribute("message", "update thất bại");
		} finally {
			session.close();
		}
		model.addAttribute("record", record);
		return "admin/record/update-record";
	}
}

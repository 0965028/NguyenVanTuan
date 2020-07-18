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

@Transactional
@Controller
@RequestMapping("admin/thongke/")
public class ThongKeController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("CaNhan")
	public String report(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT r.staff.Name," + " SUM(case when r.Type=1 then 1 else 0 end),"
				+ " SUM(case when r.Type=0 then 1 else 0 end)" + " FROM Records r GROUP BY r.staff.Name";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		model.addAttribute("arrays", list);
		return "admin/thongke/CaNhan";
	}
	
	@RequestMapping("CaPhong")
	public String reportCP(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT r.depart.Name," + " SUM(case when r.Type=1 then 1 else 0 end),"
				+ " SUM(case when r.Type=0 then 1 else 0 end)" + "FROM Staffs r GROUP BY r.depart.Name";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> listCP = query.list();
		model.addAttribute("cp", listCP);
		return "admin/thongke/CaPhong";
	}
}

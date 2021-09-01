import java.util.ArrayList;
import java.util.List;

public class EmpManager {

	private List<Emp> list = new ArrayList<>();

	public void insert(Emp e) {
		list.add(e);
	}

	
public List<Emp> getList() {
	// TODO Auto-generated method stub
	return list;
}

public void update(Emp t) {
	for (Emp emp : list) {
		if (emp.getEmpno() == t.getEmpno()) {
			emp.setEname(t.getEname());
			emp.setSalary(t.getSalary());
			break;
		}
	}
}

public static void main(String[] args) {
	EmpManager mgr =new EmpManager();
	for (int i =1;i < 10;i+=1){
		Emp d= new Emp();
		d.setEmpno(i);
		d.setEname("Nameof"+i);
		d.setSalary(i*1000);
		mgr.insert(d);
	}
	mgr.getList().forEach(System.out::println);
	System.out.println("\n\n");
	Emp d= new Emp();
	d.setEmpno(1);
	d.setEname("Vaishali" );
	d.setSalary(10000);
	mgr.update(d);
	mgr.getList().forEach(System.out::println);
}	
}
package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class EPListDTO implements Serializable {
	private ArrayList<EPBean> list;
	
	public EPListDTO() {
		list = new ArrayList<>();
	}
	
	public void add(EPBean bean) {
		list.add(bean);
	}
	public EPBean get(int i) {
		return list.get(i);
	}
	public int size() {
		return list.size();
	}
}

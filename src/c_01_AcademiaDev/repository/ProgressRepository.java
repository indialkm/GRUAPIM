package c_01_AcademiaDev.repository;

import java.util.ArrayList;
import java.util.List;

import c_01_AcademiaDev.model.Progress;


public class ProgressRepository {
	
	private List<Progress> prog = new ArrayList<>();
	private int nextId = 1;
	
	public void save(Progress p) {
			
			if(p.getId() == 0) {
				p.setId(nextId++);
			}
			
			prog.add(p);
	}

}

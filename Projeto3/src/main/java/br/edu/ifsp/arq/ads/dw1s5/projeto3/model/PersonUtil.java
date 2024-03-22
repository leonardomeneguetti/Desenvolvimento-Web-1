package br.edu.ifsp.arq.ads.dw1s5.projeto3.model;

import java.util.List;
import java.util.ArrayList;

public class PersonUtil {
	public List<Person> getPersonList(String persons){
		List<Person> personList = new ArrayList<>();
		if(persons.length() > 0) {
			String lines[] = persons.split("\n");
			for(int i=0;i<lines.length;i++) {
				String data[] = lines[i].split("\\s*;\\s*");
				if(data.length == 3) {
					Person person = new Person(data[0], data[1], data[2]);
					personList.add(person);
				}
			}
		}
		return personList;
	}
}

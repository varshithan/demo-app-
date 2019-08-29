package qapitol.demo.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Blogger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String content;
	public String author;
	public String title;

}

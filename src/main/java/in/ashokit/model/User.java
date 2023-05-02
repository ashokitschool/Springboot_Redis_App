package in.ashokit.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	
	private Integer id;
	private String name;
	private String email;

}

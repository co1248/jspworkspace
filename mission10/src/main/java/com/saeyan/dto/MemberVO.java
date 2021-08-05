package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private Integer code;
	private String title;
	private Integer price;
	private String director;
	private String actor;
	private String poster;
	private String synopsis;
}

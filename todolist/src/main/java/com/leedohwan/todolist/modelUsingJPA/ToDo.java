package com.leedohwan.todolist.modelUsingJPA;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity(name = "todo2") 
@Data
public class ToDo {
	@Id @GeneratedValue(generator = "todoSeqGenerator")
    @SequenceGenerator(name = "todoSeqGenerator", sequenceName = "todo2_seq", allocationSize = 1) // 실제 시퀀스 이름: todo2_seq
	private int id;
	private String username;
	private String description;
	private boolean done;
	@Column(name =  "target_date") // 오라클에서 컬럼네임
	private ZonedDateTime targetDate; // 카멜식으로 해야 jpa 제공함수 사용할 때 문제 안생김
	
}

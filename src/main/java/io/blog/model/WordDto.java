package io.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_SEARCH_WORD")
public class WordDto {

	@Column(name = "NUM")
	private Integer num;

	@Id
	@Column(name = "POPULAR_WORD")
	private String popularWord;

	@Column(name = "SEARCH_COUNT")
	private Integer searchCount;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String getPopularWord() {
		return popularWord;
	}

	public void setPopularWord(String popularWord) {
		this.popularWord = popularWord;
	}

	public Integer getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}
}

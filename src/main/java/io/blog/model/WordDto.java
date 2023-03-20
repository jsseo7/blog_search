package io.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_SEARCH_WORD")
public class WordDto {

	@ApiModelProperty(value="순위", example = "1", required = true)
	@Column(name = "NUM")
	private Integer num;

	@ApiModelProperty(value="인기검색어", example = "카카오톡", required = true)
	@Id
	@Column(name = "POPULAR_WORD")
	private String popularWord;

	@ApiModelProperty(value="검색횟수", example = "1", required = true)		
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

package io.blog.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.blog.model.WordDto;


public interface WordRepository extends JpaRepository<WordDto, Long> {
	
	
	static final String MYSQL_QUERY = "set mode MySQL";
    
	static final String SET_QUERY = 
			 "	INSERT INTO TB_SEARCH_WORD             "
			+ "	(                                      "
			+ "			POPULAR_WORD                   "
			+ "		,	SEARCH_COUNT                   "
			+ "	)                                      "
			+ "	VALUES                                 "
			+ "	(                                      "
			+ "			:word                          "
			+ "		,	1                              "
			+ "	)                                      "
			+ "	ON DUPLICATE KEY UPDATE                "
			+ "		SEARCH_COUNT = SEARCH_COUNT + 1;   ";
	
	static final String SEARCH_QUERY = 
		"		SELECT                                                "
		+"				TOP 10                                        "
		+"				rank() over(order by SEARCH_COUNT DESC) NUM   "
		+"			,	POPULAR_WORD                                  "
		+"			,	SEARCH_COUNT                                  "
		+"		FROM	TB_SEARCH_WORD                                "
		+"		ORDER BY SEARCH_COUNT DESC;                           ";
	
	@Transactional
	@Modifying
	@Query(value = MYSQL_QUERY, nativeQuery = true)	
	public int runMysql();
	
	@Transactional
	@Modifying
	@Query(value = SET_QUERY, nativeQuery = true)
	public int setPopularWord(@Param("word") String word);

	@Transactional
	@Query(value = SEARCH_QUERY, nativeQuery = true)	
	public List<WordDto> getSearchWordTop10();	
}

package at.bit.controller;

import java.util.List;

/**
 * Interface class to be used together with the pagination composite component.
 * 
 * @author pbayer
 * @param <T>
 */
public interface PaginationController<T> {

	void prevPage();

	void nextPage();

	long pages();

	List<T> fetchCurrentPage();

	long getCurrentPage();

	void setCurrentPage(long currentPage);

}
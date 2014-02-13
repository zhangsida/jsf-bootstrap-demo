package at.bit.controller;

import java.util.List;

public interface PaginationController<T> {

	void prevPage();

	void nextPage();

	long pages();

	List<T> fetchCurrentPage();

	long getCurrentPage();

	void setCurrentPage(long currentPage);

}
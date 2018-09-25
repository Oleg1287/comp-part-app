package ru.gadjets.comppartapp.dao.utils;

public class Pager {
    private int page;
    private int rowPerPage;
    private int countRows;
    private int countPage;

    public Pager(int page) {
        this.page = page;
        rowPerPage = 10;
    }

    public void setRowPerPage(int rowPerPage) {
        this.rowPerPage = rowPerPage;
    }

    public String pageToSqlLimit(){
        return page > 0 ? (" LIMIT " + (page-1)*rowPerPage + ", " + rowPerPage) : "";
    }

    public void setCountRows(int countRows) {
        this.countRows = countRows;
        countPage = countRows / rowPerPage;
        countPage += countRows % rowPerPage > 0 ? 1 : 0;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "page=" + page +
                ", rowPerPage=" + rowPerPage +
                ", countRows=" + countRows +
                ", countPage=" + countPage +
                '}';
    }

    public int getPage() {
        return page;
    }

    public int getRowPerPage() {
        return rowPerPage;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPage() {
        return countPage;
    }
}

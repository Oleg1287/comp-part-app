package ru.gadjets.comppartapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gadjets.comppartapp.dao.PartDao;


import ru.gadjets.comppartapp.dao.utils.Pager;
import ru.gadjets.comppartapp.entity.Part;

import java.util.*;

@Service
public class PartPagerServiceImpl implements PartPagerService {
    @Autowired
    public PartDao part;

    private Pager pager;

    @Override
    public Part getById(int id) {
        return part.getById(id);
    }

    @Override
    public void update(Part p) {
        System.out.println(p);
        part.update(p);
        System.out.println(p);
    }

    @Override
    public void delete(int p) {
        Part partObj = getById(p);
        part.delete(partObj);
    }

    @Override
    public List<Part> findAll(Properties prop) {
        Integer page = prop.get("page") == null ? 0 : (Integer) prop.get("page");
        pager = new Pager(page);
        pager.setRowPerPage(10);

        StringBuilder sql = new StringBuilder("SELECT SQL_CALC_FOUND_ROWS * FROM part");

//        prop = new Properties();
//        prop.put("description_ru", "USB");
//        prop.put("required", "no");

        List<String> where = new ArrayList<>();

        if(prop.getProperty("description_ru") != null && ! prop.getProperty("description_ru").isEmpty() ){
            where.add("description_ru LIKE CONCAT('%', :description_ru, '%')");
        }
        if(prop.getProperty("required") != null && ! prop.getProperty("required").isEmpty()){
            where.add("required = :required");
        }
        // add where
        sql.append(where.size() > 0 ? (" WHERE " + String.join(" AND ", where)) : "");
        // add pager

        sql.append(pager.pageToSqlLimit());
        System.out.println(pager.pageToSqlLimit());
        List<Part> partList = part.findAll(sql.toString(), prop);

        pager.setCountRows(part.getFoundRows());

        System.out.println(pager.toString());
        return partList;
    }

    public Pager getPager() {
        return pager;
    }

    @Override
    public void add(Part part) {
        this.part.add(part);
    }


    //    private class Pager {
//
//    }
}

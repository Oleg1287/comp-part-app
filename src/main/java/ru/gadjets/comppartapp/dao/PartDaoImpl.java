package ru.gadjets.comppartapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gadjets.comppartapp.entity.Part;

import java.util.List;
import java.util.Properties;

@Repository
@Transactional
public class PartDaoImpl implements PartDao {
    @Autowired
    public SessionFactory sessionFactory;

    private Integer foundRows; // for partList

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Part> findAll(String sql) {

        List<Part> partList = getSession().createSQLQuery(sql).addEntity(Part.class).list();
        calcFoundRows();

        return partList;
    }

    @Override
    public List<Part> findAll(String sql, Properties prop) {
        NativeQuery query = getSession().createSQLQuery(sql);
        if(prop.getProperty("description_ru") !=  null && !prop.getProperty("description_ru").isEmpty()){
            query.setParameter("description_ru", prop.getProperty("description_ru"));
        }

        if(prop.getProperty("required") !=  null && !prop.getProperty("required").isEmpty()){
            Boolean required = (prop.getProperty("required").equals("yes") ? true : false);
            query.setParameter("required",  required);
        }

        List<Part> partList = query.addEntity(Part.class).list();
        calcFoundRows();
        return partList;
    }

    private void calcFoundRows() {
        setFoundRows(getSession()
                .createSQLQuery("SELECT FOUND_ROWS();")
                .uniqueResult().toString()
        );
        System.out.println(getFoundRows());
    }

    private void setPartId(Part part) {
        Integer id = Integer.valueOf(getSession()
                .createSQLQuery("SELECT (max(part_id)+1) FROM part")
                .uniqueResult().toString());
        System.out.println("part_id:" + id);
        part.setPartId(id);
    }


//

    @Override
    public Integer getFoundRows(){
        return foundRows;
    }

    private void setFoundRows(String foundRows) {
        this.foundRows = Integer.parseInt(foundRows);
    }


    @Override
    public Part getById(int id) {
        return getSession().get(Part.class, id);
    }

    @Override
    public void update(Part part) {
        getSession().update(part);
    }

    @Override
    public void delete(Part p) {
        getSession().delete(p);
    }

    @Override
    public void add(Part part) {
        setPartId(part);
        getSession().save(part);
    }

//    @Override
//    public List<Stock> findAll() {
//        List<Stock> stockList = getSession().createSQLQuery("SELECT * FROM stock").addEntity(Stock.class).list();
//        return stockList;
//    }

}

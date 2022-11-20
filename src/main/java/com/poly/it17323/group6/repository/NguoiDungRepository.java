/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17323.group6.repository;

import com.poly.it17323.group6.domainmodel.NguoiDung;
import com.poly.it17323.group6.hibernateconfig.Hibernate_Util;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class NguoiDungRepository {

    private Session session = Hibernate_Util.getFACTORY().openSession();

    private String fromTable = "From NguoiDung";

    public List<NguoiDung> getAll() {
        Query query = session.createQuery(fromTable, NguoiDung.class);
        List<NguoiDung> lists = query.getResultList();
        return lists;
    }

    public NguoiDung getOne(String id) {
        String sql = fromTable + " WHERE id = :id";
        Query query = session.createQuery(sql, NguoiDung.class);
        query.setParameter("id", id);
        NguoiDung nguoidung = (NguoiDung) query.getSingleResult();
        return nguoidung;
    }
//    public Boolean add(NguoiDung nguoidung) {
//        Transaction transaction = null;
//        try ( Session session = Hibernate_Util.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(nguoidung);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }

    public Boolean update(NguoiDung nd) {
        Transaction transaction = null;
        try ( Session session = Hibernate_Util.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query q = session.createQuery("UPDATE NguoiDung SET MatKhau = :mk WHERE Email = :email");
            q.setParameter("mk", nd.getMatKhau());
            q.setParameter("email", nd.getEmail());
            q.executeUpdate();
            transaction.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
        return null;
    }

    public static void main(String[] args) {
//        NguoiDungRepository ndr = (NguoiDungRepository) new NguoiDungRepository().getAll();
        for (NguoiDung arg : new NguoiDungRepository().getAll()) {
            System.out.println(arg.toString());
        }
    }

//    public Boolean delete(NguoiDung nguoidung) {
//        Transaction transaction = null;
//        try ( Session session = Hibernate_Util.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.delete(nguoidung);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
//    public static void main(String[] args) {
//        List<NguoiDung> list = new NguoiDungRepository().getAll();
//        for (NguoiDung nguoidung : list){
//            System.out.println(nguoidung.toString());
//        }
//    }
}

package com.poly.it17323.group6.repository;

import com.poly.it17323.group6.domainmodel.HoaDon;
import com.poly.it17323.group6.domainmodel.KhachHang;
import com.poly.it17323.group6.hibernateconfig.Hibernate_Util;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pdanh
 */
public class HoaDonRepository {

    private Session session;
    private String fromTable = "From HoaDon";

    public List<HoaDon> getAll() {
        session = Hibernate_Util.getFACTORY().openSession();
        Query query = session.createQuery(fromTable + " order by MaHD desc", HoaDon.class);
        List<HoaDon> list = query.getResultList();
        return list;
    }
    public List<HoaDon> getAll2() {
        session = Hibernate_Util.getFACTORY().openSession();
        Query query = session.createQuery(fromTable + " a where a.tinhTrang = 1 order by MaHD desc", HoaDon.class);
        List<HoaDon> list = query.getResultList();
        return list;
    }
    public static void main(String[] args) {
        HoaDonRepository hd = new HoaDonRepository();
        for (HoaDon hoaDon : hd.getAll()) {
            System.out.println(hoaDon);
        }
    }

    public List<HoaDon> getAll_ByTT(int tt) {
        session = Hibernate_Util.getFACTORY().openSession();
        Query query = session.createQuery(fromTable + " a where a.tinhTrang = :tt ", HoaDon.class);
        query.setParameter("tt", tt);
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public HoaDon getOne(UUID id) {
        session = Hibernate_Util.getFACTORY().openSession();
        String sql = fromTable + "Where id =: id";
        Query query = session.createQuery(fromTable, HoaDon.class);
        query.setParameter("id", id);
        HoaDon hoaDon = (HoaDon) query.getSingleResult();
        return hoaDon;
    }

    public HoaDon getOne_ByMa(String ma) {
        session = Hibernate_Util.getFACTORY().openSession();
        Query query = session.createQuery(fromTable + " a where a.maHD LIKE :ma", HoaDon.class);
        query.setParameter("ma", ma);
        HoaDon hoaDon = (HoaDon) query.getSingleResult();
        return hoaDon;
    }

    public List<HoaDon> DoanhThu() {
        session = Hibernate_Util.getFACTORY().openSession();
        String hql = "select SUM(tongTien) FROM HoaDon where tinhTrang = 1";
        Query query = session.createQuery(hql);
        List<HoaDon> result = query.getResultList();
        return result;
    }

    public Boolean add(HoaDon hoaDon) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(HoaDon hoaDon) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(UUID idHD) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            String querString = "DELETE FROM HoaDon a where a.idHD = :idHD";
            Query query = session.createQuery(querString);
            query.setParameter("idHD", idHD);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(UUID idHD, BigDecimal ttien, int tt, int pttt, BigDecimal tship) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            String sql = "UPDATE HoaDon a SET a.tongTien = :ttien,a.tinhTrang = :tt,a.pttt = :pttt,a.tienShip = :tship WHERE a.idHD = :idHD";
            Query query = session.createQuery(sql);
            query.setParameter("idHD", idHD);
            query.setParameter("ttien", ttien);
            query.setParameter("tt", tt);
            query.setParameter("pttt", pttt);
            query.setParameter("tship", tship);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(UUID idHD, KhachHang KH) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            String sql = "UPDATE HoaDon a SET a.khachHang = :KH WHERE a.idHD = :idHD";
            Query query = session.createQuery(sql);
            query.setParameter("idHD", idHD);
            query.setParameter("KH", KH);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}

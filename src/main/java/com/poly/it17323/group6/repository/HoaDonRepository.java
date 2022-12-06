package com.poly.it17323.group6.repository;

import com.poly.it17323.group6.domainmodel.HoaDon;
import com.poly.it17323.group6.domainmodel.KhachHang;
import com.poly.it17323.group6.hibernateconfig.Hibernate_Util;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
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

    public Boolean update(UUID idHD, int pttt, BigDecimal ttienMat, BigDecimal ttienCk, int tt) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            String sql = "UPDATE HoaDon a "
                    + "SET a.pttt = :pttt,a.tongTienMat = :ttienMat,a.tongTienCK = :ttienCk,a.tinhTrang = :tt"
                    + " WHERE a.idHD = :idHD";
            Query query = session.createQuery(sql);
            query.setParameter("idHD", idHD);
            query.setParameter("ttienMat", ttienMat);
            query.setParameter("ttienCk", ttienCk);
            query.setParameter("tt", tt);
            query.setParameter("pttt", pttt);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(UUID idHD, int pttt, BigDecimal ttienMat, BigDecimal ttienCK, int tt, Date ngayTT, int tttt, Date ngayMuonNhan, Date ngayGui, Date ngayNhan, BigDecimal tship) {
        Transaction transaction = null;
        session = Hibernate_Util.getFACTORY().openSession();
        try {
            transaction = session.beginTransaction();
            String sql = "UPDATE HoaDon a "
                    + "SET a.pttt = :pttt,a.tongTienMat = :ttienMat,a.tongTienCK = :ttienCK,a.tinhTrang = :tt,"
                    + "a.ngayTT = :ngayTT, a.tttt = :tttt,a.ngayMuonNhan = :ngayMuonNhan,"
                    + "a.ngayGui = :ngayGui,a.ngayNhan = :ngayNhan,a.tienShip = :tship "
                    + " WHERE a.idHD = :idHD";
            Query query = session.createQuery(sql);
            query.setParameter("pttt", pttt);
            query.setParameter("ttienMat", ttienMat);
            query.setParameter("ttienCK", ttienCK);
            query.setParameter("tt", tt);
            query.setParameter("ngayTT", ngayTT);
            query.setParameter("tttt", tttt);
            query.setParameter("ngayMuonNhan", ngayMuonNhan);
            query.setParameter("ngayGui", ngayGui);
            query.setParameter("ngayNhan", ngayNhan);
            query.setParameter("tship", tship);
            query.setParameter("idHD", idHD);
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

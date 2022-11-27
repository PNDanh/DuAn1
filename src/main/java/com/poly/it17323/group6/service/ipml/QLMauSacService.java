/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17323.group6.service.ipml;

import com.poly.it17323.group6.domainmodel.MauSac;
import com.poly.it17323.group6.repository.MauSacRepository;
import com.poly.it17323.group6.response.QLSanPhamResponse;
import com.poly.it17323.group6.service.IQLMauSacService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class QLMauSacService implements IQLMauSacService {

    private MauSacRepository repo = new MauSacRepository();

    @Override
    public List<QLSanPhamResponse> getAllQLMauSac() {
        List<MauSac> list = repo.getAll();
        List<QLSanPhamResponse> respon = new ArrayList<>();
        for (MauSac mausac : list) {
            QLSanPhamResponse ms = new QLSanPhamResponse(mausac);
            respon.add(ms);
        }
        return respon;
    }

    @Override
    public QLSanPhamResponse getOneQLMauSac(UUID id) {
        MauSac ms = repo.getOne(id);
        if (ms == null) {
            return null;
        } else {
            return new QLSanPhamResponse(ms);
        }
    }

    @Override
    public boolean addQLMauSac(QLSanPhamResponse qlMauSac) {
        qlMauSac.setIdMauSac(null);
        var ms = repo.add(new MauSac(null, qlMauSac.getMaMauSac(), qlMauSac.getTenMauSac()));
        return ms;
    }

    @Override
    public boolean updateQLMauSac(QLSanPhamResponse qlMauSac) {
        var ms = repo.update(new MauSac(qlMauSac.getIdMauSac(), qlMauSac.getMaMauSac(), qlMauSac.getTenMauSac()));
        return ms;
    }

    @Override
    public boolean deleteQLMauSac(QLSanPhamResponse qlMauSac) {
        MauSac sp = new MauSac();
        sp.setIdMS(qlMauSac.getIdMauSac());
       return repo.delete(sp);
    }

}
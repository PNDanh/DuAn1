/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17323.group6.service;

import com.poly.it17323.group6.response.QLSanPhamResponse;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public interface ISanPhamChiTietService {
    
    List<QLSanPhamResponse> getAllQLChiTietSP();
    
    QLSanPhamResponse getOneQLChiTietSP(UUID id);
    
    boolean addQLChiTietSP(QLSanPhamResponse qlCTSP);
    
    boolean updateQLChiTietSP(QLSanPhamResponse qlCTSP);
    
    boolean deleteQLChiTietSP(QLSanPhamResponse qlCTSP);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17323.group6.service;

import com.poly.it17323.group6.domainmodel.ChucVu;
import java.util.List;

/**
 *
 * @author ThanhNam
 */
public interface IChucVuService {

    List<ChucVu> getAll();

    boolean add(ChucVu CV);

    boolean update(ChucVu CV);

    boolean delete(ChucVu CV);
}

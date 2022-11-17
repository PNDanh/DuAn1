package com.poly.it17323.group6.domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author pdanh
 */
@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham implements Serializable {

    @Id
    @Column(name = "IdSP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idSP;

    @Column(name = "MaSP")
    private String maSP;

    @Column(name = "TenSP")
    private String tenSP;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

}
package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.entities.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminDaoTest {

    @Test
    void getAdminByEmail() {
        AdminDao adminDao = new AdminDao();
        assertEquals(null, adminDao.getAdminByEmail("heeelo@hi.com"));
        assertEquals(null, adminDao.getAdminByEmail(""));
        assertEquals(null, adminDao.getAdminByEmail("NoEmail"));
        assertEquals(1, adminDao.getAdminByEmail("nemli@gmail.com").getId());
        assertEquals("Nemli", adminDao.getAdminByEmail("nemli@gmail.com").getNom());
        assertEquals("Younes", adminDao.getAdminByEmail("nemli@gmail.com").getPrenom());
    }

}
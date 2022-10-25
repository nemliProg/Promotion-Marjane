import com.marjane.promotionmarjane.dao.daoImp.AdminDao;
import com.marjane.promotionmarjane.dao.daoImp.CentreDao;
import com.marjane.promotionmarjane.dao.daoImp.SubAdminDao;
import com.marjane.promotionmarjane.entities.Centre;
import com.marjane.promotionmarjane.entities.SubAdmin;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) throws Exception {
        CentreDao centreDao = new CentreDao();
        ArrayList<Centre> centres = centreDao.getAllCentersThatDontHaveAdmin();
        centres.stream().forEach(centre -> {
            System.out.println(centre.getId());
            System.out.println(centre.getNom());
            System.out.println(centre.getVille());
            System.out.println("*************");
        });
    }
}

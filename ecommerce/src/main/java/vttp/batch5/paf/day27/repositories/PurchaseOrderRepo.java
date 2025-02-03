package vttp.batch5.paf.day27.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day27.Utils;
import vttp.batch5.paf.day27.models.PurchaseOrder;

@Repository
public class PurchaseOrderRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean insertPO(PurchaseOrder po) {
        return ( jdbcTemplate.update(Utils.SQL_INSERT_ORDER, po.getPoId(), po.getName(), po.getAddress(), po.getDeliveryDate()) ) > 0;
    }
}

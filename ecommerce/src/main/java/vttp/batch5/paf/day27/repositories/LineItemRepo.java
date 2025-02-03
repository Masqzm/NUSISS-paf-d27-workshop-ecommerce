package vttp.batch5.paf.day27.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day27.Utils;
import vttp.batch5.paf.day27.models.LineItem;

@Repository
public class LineItemRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertLineItems(List<LineItem> lineItems, String orderID) {
        List<Object[]> data = lineItems.stream()
                            .map(li -> {
                                Object[] obj = new Object[4];
                                obj[0] = li.getName();
                                obj[1] = li.getQuantity();
                                obj[2] =  li.getUnitPrice();
                                obj[3] =  orderID;
                                return obj;
                            })
                            .toList();

        jdbcTemplate.batchUpdate(Utils.SQL_INSERT_LINE_ITEMS, data);
    }
}

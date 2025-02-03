package vttp.batch5.paf.day27.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day27.models.PurchaseOrder;
import vttp.batch5.paf.day27.repositories.LineItemRepo;
import vttp.batch5.paf.day27.repositories.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
  @Autowired
  private PurchaseOrderRepo poRepo;
  @Autowired
  private LineItemRepo liRepo;

  public String createPurchaseOrder(PurchaseOrder po) {
    String poId = UUID.randomUUID().toString().substring(0, 8);

    po.setPoId(poId);

    poRepo.insertPO(po);
    liRepo.insertLineItems(po.getLineItems(), poId);

    return poId;
  }
}

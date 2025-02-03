package vttp.batch5.paf.day27.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day27.models.Event;
import vttp.batch5.paf.day27.models.PurchaseOrder;
import vttp.batch5.paf.day27.repositories.EventRepo;
import vttp.batch5.paf.day27.repositories.LineItemRepo;
import vttp.batch5.paf.day27.repositories.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
  @Autowired
  private PurchaseOrderRepo poRepo;
  @Autowired
  private LineItemRepo liRepo;
  @Autowired
  private EventRepo eventRepo;

  public String createPurchaseOrder(PurchaseOrder po) {
    String poId = UUID.randomUUID().toString().substring(0, 8);

    po.setPoId(poId);

    // Updating main state (main db)
    poRepo.insertPO(po);
    liRepo.insertLineItems(po.getLineItems(), poId);

    // Saving state changes (PO)
    String eventId = UUID.randomUUID().toString().substring(0, 8);
    Event event = new Event();
    
    // Add to event

    eventRepo.saveEvent(eventId, event.toJSON());

    // Saving state changes (LI)
    // eventId = UUID.randomUUID().toString().substring(0, 8);
    // event = new Event();
    
    // // Add to event

    // eventRepo.saveEvent(eventId, event.toJSON());

    return poId;
  }
}
